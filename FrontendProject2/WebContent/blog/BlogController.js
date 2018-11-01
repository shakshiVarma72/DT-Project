myApp.controller("blogController",function($scope,$http, $window,$location,$rootScope,$cookieStore){
	
	$scope.blog={blogName:'',blogContent:'',createDate:'',likes:'',status:'',loginName:''};
	
	$scope.addBlog=function(){
		console.log('Enter into addBlog function ');
		
		
		$http({
		    url : "http://localhost:8088/Middleware1/addBlog",
		    method : 'POST',
		    data: $scope.blog,
		    transformResponse: [
		        function (data) {
		        	$window.location.reload();
		        	alert('Blog Added Succesfully');
		            return data;
		            
		        }
		    ]
		}) 
	};
	
	
	$scope.listAllBlogs=function(){
		console.log('Entered into listAllBlogs function');
		$http.get("http://localhost:8088/Middleware1/listBlogs")
		.then(function(response){
			console.log('Data found');
			$scope.allBlogs=response.data;
		},
		function(error){
			console.log('No Blogs found');
			$scope.allBlogs=[];
			$scope.viewMessage="No Blogs Found...!!!";
		});
	};	
});