myApp.controller("userController",function($scope,$http, $window,$location,$rootScope,$cookieStore){
	
	$scope.user={loginName:'',firstName:'',lastName:'',password:'',email:'',role:'',onlineStatus:'',mobileNumber:''};
	
	$scope.Register=function(){
		console.log('Enter into Register function '+$scope.user.loginName+" "+$scope.user.firstName);
		
		
		$http({
		    url : "http://localhost:8088/Middleware1/register",
		    method : 'POST',
		    data: $scope.user,
		    transformResponse: [
		        function (data) {
		        	$window.location.reload();
		        	alert('User Registered Succesfully');
		            return data;
		            
		        }
		    ]
		}) 
	}
	
	
	$scope.login=function(){
		console.log('Enter into login Function '+$scope.user.email+" "+$scope.user.password);
		$http({
		    url : "http://localhost:8088/Middleware1/login",
		    method : 'POST',
		    data: $scope.user,
		
		}).then(function successCallback(response) {
				$scope.user=response.data;
				$rootScope.currentUser=response.data;
				$cookieStore.put('userDetails',response.data);
				
				if($rootScope.currentUser.role=='ROLE_USER'){
					console.log('Role is User')
				}
				if($rootScope.currentUser.role=='ROLE_ADMIN'){
					console.log('Role is Admin');
				}
				$location.path("UserHome")
				
		  }, function errorCallback(response) {
			  	alert('Username or password is incorrect. Try Again');
		});
	}
	
	
	$rootScope.logout=function(){
		console.log('Logout');
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("logout");
	}

});