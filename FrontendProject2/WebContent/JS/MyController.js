var myApp = angular.module("myApp", ["ngRoute",,'ngCookies']);
myApp.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "NavImage.html"
    })
    .when("/Login", {
        templateUrl : "user/Login.html"
    })
    .when("/GetContactPage", {
        templateUrl : "Contact.html"
    })
    .when("/About", {
        templateUrl : "About.html"
    })
    .when("/Registration", {
        templateUrl : "user/Registration.html"
    })
    .when("/UserHome", {
        templateUrl : "user/UserHome.html"
    })
    .when("/AddBlog", {
        templateUrl : "blog/AddBlog.html"
    })
    .when("/AddForum", {
        templateUrl : "user/AddForum.html"
    })
    .when("/logout", {
        templateUrl : "user/Logout.html"
    })
    .when("/viewBlogsToUser", {
        templateUrl : "blog/ViewAllBlogsByUser.html"
    })
    ;
});
myApp.run(function($rootScope,$cookieStore){
	console.log('I m m in run function');
	console.log($rootScope.currentUser);
	
	if($rootScope.currentUser==undefined){
		console.log('I m in if of run function');
		$rootScope.currentUser=$cookieStore.get('userDetails');
		$rootScope.currentBlog=$cookieStore.get('blogDetails');
		$rootScope.currentForum=$cookieStore.get('forumDetails');
	}
	else {
		console.log('I m in else of run function');
		console.log($rootScope.currentUser.userName);
		console.log($rootScope.currentUser.role);
	}
});