package com.ibm.ff.dbfactory;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.cloudant.client.api.*;
import com.cloudant.client.api.model.Response;
import com.cloudant.http.interceptors.BasicAuthInterceptor;
import com.cloudant.http.interceptors.CookieInterceptor;
import com.ibm.ff.rest.entity.mapping.JobRoleMapping;

public class cloudant {
	private String cloudantUsername;
	private String cloudantPassword;
	private String cloudantDBName;
	private CloudantClient myclient;
	private BasicAuthInterceptor dbAuth;
	private static Database db = null;
	private String getCloudantUsername() {
		return cloudantUsername;
	}


	private void setCloudantUsername(String cloudantUsername) {
		this.cloudantUsername = cloudantUsername;
	}


	private String getCloudantPassword() {
		return cloudantPassword;
	}


	private void setCloudantPassword(String cloudantPassword) {
		this.cloudantPassword = cloudantPassword;
	}


	private String getCloudantDBName() {
		return cloudantDBName;
	}


	private void setCloudantDBName(String cloudantDBName) {
		this.cloudantDBName = cloudantDBName;
	}

	public cloudant() {
		
		try {
			setCloudantUsername(new InitialContext().lookup("cloudantUsername").toString());
			setCloudantPassword(new InitialContext().lookup("cloudantPassword").toString());
			setCloudantDBName(new InitialContext().lookup("cloudantDBName").toString());
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public cloudant(String DBName) {
		
		try {
			setCloudantUsername(new InitialContext().lookup("cloudantUsername").toString());
			setCloudantPassword(new InitialContext().lookup("cloudantPassword").toString());
			setCloudantDBName(DBName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public cloudant(String Username, String Password, String DBName) {

		setCloudantUsername(Username);
		setCloudantPassword(Password);
		setCloudantDBName(DBName);
	}
	
	public boolean login()
	{
		try{			
			
			if (db == null) {				
				
				myclient =  ClientBuilder.url(new URL(String.format("https://%s.cloudant.com", getCloudantUsername())))
			              .username(getCloudantUsername())
			              .password(getCloudantPassword())
			              .build(); 
			}
			return true;
		} catch (Exception e){

			System.out.println(e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return false;
		   }
	}
	
	public boolean login(String Username, String Password)
	{
		setCloudantDBName(Username);
		setCloudantPassword(Password);
		return login();
	}

/*	public BasicAuthInterceptor askForToken()
	{
		try {
			
			dbAuth=new BasicAuthInterceptor(getCloudantUsername()+":" +getCloudantPassword());
			
			return dbAuth;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public boolean loginWithToken(BasicAuthInterceptor dbAuth)
	{
		
		try {
			myclient = ClientBuilder.account(getCloudantUsername())
				      .interceptors(dbAuth)
				      .build();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}*/
	
	public boolean connectDB(String DBName)
	{
		try{
			if (getCloudantDBName() != DBName)
				setCloudantDBName(DBName);
			db = myclient.database(this.getCloudantDBName(), false);
			return true;
		} catch (Exception e){

			System.out.println( e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return false;
		}
	}
	
	public boolean createDB(String DBName){
		try{
			myclient.createDB(DBName);
			connectDB(DBName);
			return true;
		} catch (Exception e){

			System.out.println( e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return false;
		}
	}
	public Response createDocument(String DBName, Object document){
		try{
			if (getCloudantDBName() != DBName)
				connectDB(DBName);
			Response resp=db.post(document);
			return resp;
		} catch (Exception e){

			System.out.println(e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return null;
		}
	}
	public List<?> findByFieldName(String DBName, String findByName, String find, String returnObjectType){
		try{
			Class<?> returnClass=Class.forName("com.ibm.ff.rest.entity.cloudant." + returnObjectType);
			
			if (getCloudantDBName() != DBName)
				connectDB(DBName);
			String selectorJson="\"selector\":{\""+ findByName +"\":\""+find+"\"}";
			return db.findByIndex(selectorJson, returnClass);
		} catch (Exception e){
			System.out.println(e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return null;
		}
	}
	
	public List<Object> regexFindByFieldName(String DBName, String findByName, String regex, String returnObjectType){
		try{
			List<?> cloudantReturn;
			List<Object> responselist = new ArrayList<Object>();
			Object response;
			Class<?> cloudantClass=Class.forName("com.ibm.ff.rest.entity.cloudant." + returnObjectType);
			Class<?> returnClass=Class.forName("com.ibm.ff.rest.entity.response." + returnObjectType);

	    	HashMap<String, String> jobrolemap = new JobRoleMapping().getJobRoleMap();	
	    	
			if (getCloudantDBName() != DBName)
				connectDB(DBName);
			String selectorJson="\"selector\":{\""+ findByName +"\":{\"$regex\":\""+regex+"\"}}";
			cloudantReturn = db.findByIndex(selectorJson, cloudantClass);
			for (Object object: cloudantReturn)
			{
				response = returnClass.newInstance();
				for (Field field: response.getClass().getDeclaredFields())
				{
					try {
						String cloudantfieldname = jobrolemap.get(field.getName());
						String[] cloudantfields = cloudantfieldname.split(".");
						if (cloudantfields.length>0)
						{
							Class<?> cloudantSubClass=Class.forName("com.ibm.ff.rest.entity.cloudant." + cloudantfields[0]);
							field.set(response, cloudantSubClass.getDeclaredField(cloudantfields[1]).get(cloudantSubClass));
						}
						else
							field.set(response, object.getClass().getDeclaredField(cloudantfieldname).get(object));
					} catch (Exception e) {
						continue;
					}
				}

				responselist.add(response);
/*				for (Map.Entry<String, String> entry : jobrolemap.entrySet())
				{					
					response = returnClass.newInstance();
					response.getClass().getDeclaredField(entry.getKey()).set(cloudantReturn, object.getClass().getDeclaredField(entry.getValue()));
					responselist.add(response);
				}*/
			}
			return responselist;
		} catch (Exception e){
			System.out.println(e.getStackTrace() ); 	
			System.out.println(e.getMessage() ); 
			return null;
		}
	}
}
