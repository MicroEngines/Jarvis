/*var app = angular.module("app", [ 'ngRoute', 'ngResource' ]);

app.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/hello', {
	//controller : 'NewUserCtrl',
	templateUrl : 'jsp/hello.jsp'
	}).when('/hello', {
	//controller : 'UsersCtrl',
	templateUrl : 'jsp/hello1.html'
	}).otherwise({redirectTo: '/hello'});
	}]);*/


function validate() {
	alert("kjhfdkj");
	var name1 = document.getElementById("name").value;
	if (name1 == '') {
		alert('Please enter a valid name.');
		return false;
	} else {
		return name1;
	}
}