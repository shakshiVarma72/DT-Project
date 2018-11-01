myApp.controller("jobController",function($scope,$http, $window,$location,$rootScope,$cookieStore){
	
	$scope.job={jobDesignation:'',jobDesc:'',comapny:'',location:'',salary:'',lastDateApply:''};
	
	$scope.addJob=function(){
		console.log('Enter into addJob function ');
		
		
		$http({
		    url : "http://localhost:8088/Middleware1/addJob",
		    method : 'POST',
		    data: $scope.Job,
		    transformResponse: [
		        function (data) {
		        	$window.location.reload();
		        	alert('Job Added Succesfully');
		            return data;
		            
		        }
		    ]
		}) 
	};
});
