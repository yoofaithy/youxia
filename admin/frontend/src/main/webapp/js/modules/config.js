/*var Common = angular.module('Common', ['ngDialog', 'ngAria', 'ui.router', 'angular-loading-bar', 'ngAnimate', 'ngSanitize']);
var App = angular.module("App", ['Common', 'ui.sortable', 'ui.select']);*/

var myCommon = angular.module('myCommon', [ 'ui.router']);
var myApp = angular.module("myApp", ['myCommon']);

myCommon.config(function($stateProvider, $urlRouterProvider,$locationProvider){
	$locationProvider.hashPrefix('');

    $stateProvider
    .state('admin',{
        url:"/",
        views:{
        	"viewA": {template:"This is admin page"},
            "viewB": {template:"This is admin page"}
        }
    })
    .state('pageA',{
        url:"/pageA",
        views:{
        	"viewA": {templateUrl:"html/pageA.html"},
            "viewB": {templateUrl:"html/pageA.html"}
        }
        
    })
    .state('pageB',{
        url:"/pageB",
        views:{
        	"viewA": {templateUrl:"html/pageB.html"},
            "viewB": {templateUrl:"html/pageB.html"}
        }
    })
    .state('pageC',{
        url:"/pageC",
        views:{
        	"viewA": {templateUrl:"html/pageC.html"},
            "viewB": {templateUrl:"html/pageC.html"}
        }
    });
});


/*myCommon.factory('apiService', function ($http, wbService) {
    var callAPICount = 0;

    function defaultAPIErrorHandler(error) {
        if (error.status == 500)
            wbService.goParams("error", { status: error.status, errorID: error.data.ErrorID });
        else if (error.status == 400)//call any API session expired then show the legacy session expiration within the iframe
            wbService.goWBPages("/workbench/Common/SessionExpired.htm", false, null, null);
        else
            wbService.goParams("error", { status: error.status });           

        callAPICount = 0;
        ngDialogHandle.close();            
        return false;
    }
    
    $http.get("/api/header/sessiontimeout").then(function (resp) {
    })

});*/

