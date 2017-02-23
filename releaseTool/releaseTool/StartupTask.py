# Add your code here to run in your startup task

####################      example 1     #####################
#
#import subprocess 
#cmd="cmd.exe" 
#begin=101 
#end=105 
#while begin<end:      
#    p=subprocess.popen(cmd,shell=true,stdout=subprocess.pipe, stdin=subprocess.pipe,stderr=subprocess.pipe)     
#    p.stdin.write("ping 192.168.1."+str(begin)+"\n") 
#    begin = begin + 1
#    if begin==105:
#        continue;    
#    p.stdin.close()     
#    p.wait()
#    print "execution result: %s"%p.stdout.read()
#else:
#    print "else function";
#print "final";


####################      example 2     #####################
#coding=utf-8 
#def printme( str ):
#   "Print any input string"
#   print str;
#   return;
# 
#printme("我 want to call the function");
#printme("call it again");

####################      example 3     #####################
str = raw_input("Please input the file list here:");
print "the content you input is:", str