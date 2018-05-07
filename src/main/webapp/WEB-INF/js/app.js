var app = angular.module('Poc', ["ngRoute","angular-json-tree"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "/miniservice/html/company.html"
    })
    .when("/company", {
        templateUrl : "/miniservice/html/company.html"
    })
    .when("/employee", {
        templateUrl : "/miniservice/html/employee.html"
    })
    .when("/template", {
        templateUrl : "/miniservice/html/template.html"
    })
	.when("/award", {
        templateUrl : "/miniservice/html/award.html"
    })    
    .when("/plan", {
        templateUrl : "/miniservice/html/plan.html"
    })
    .when("/view", {
        templateUrl : "/miniservice/html/view.html"
    })
    .when("otherwise", {
        templateUrl : "/miniservice/html/company.html"
    });
});

angular.module('Poc').controller('PageController', function($scope,$location) {
	var path = $location.path();
		path=path.replace('/','');
	$scope.currentTab=path!=''?path:'company';
	
	$scope.switch= function(tab){
		$scope.currentTab=tab;
	};
	
});

angular.module('Poc').controller('AwardController', function($scope, $http,$q) {
	
	$scope.showOutput=false;
	$scope.output="";
	$scope.employee=[];
	$scope.plan=[];
	$scope.template=[];
	
	$scope.save=function(){
		var req = {
			'method' : 'POST',
			'url' :'/miniservice/award',
			'data' : {
				'employeeId': $scope.employeeId,
				'planId': $scope.planId,
				'templateId': $scope.templateId,
				'number':$scope.number,
				'date': $scope.date,
				'marketValue':$scope.marketValue,
				'price':$scope.price,
				'shares':$scope.shares		
			}
		};
		
		$http(req).then(function(response) {
        	$scope.showOutput=true;
			$scope.output=response.data;
    	});
	};
	
	function init(){
	 $q.all({
            employee: $http.get('http://miniservice-miniservice.b9ad.pro-us-east-1.openshiftapps.com/miniservice/employee/all'),
            plan: $http.get('http://miniservice-miniservice.b9ad.pro-us-east-1.openshiftapps.com/miniservice/plan/all'),
            template: $http.get('http://miniservice-miniservice.b9ad.pro-us-east-1.openshiftapps.com/miniservice/vesttemplate/all')
          }).then(function(results) {
          	$scope.employee=results.employee.data;
          	$scope.plan=results.plan.data;
          	$scope.template=results.template.data;
          });
	}
	init();
});

angular.module('Poc').controller('CompanyController', function($scope, $http) {
	
	$scope.showOutput=false;
	$scope.output="";
	$scope.save=function(){
		var req = {
			'method' : 'POST',
			'url' :'/miniservice/company',
			'data' : {
				'name': $scope.name,
				'symbol': $scope.symbol
			}
		};
		
		$http(req).then(function(response) {
        	$scope.showOutput=true;
			$scope.output=response.data;
    	});
	};
});

angular.module('Poc').controller('EmployeeController', function($scope, $http,$q) {
	
	$scope.showOutput=false;
	$scope.output="";
	$scope.employee=[];
	$scope.plan=[];
	$scope.template=[];
	
	$scope.save=function(){
		var req = {
			'method' : 'POST',
			'url' :'/miniservice/employee',
			'data' : {
				'firstName': $scope.firstName,
				'lastName': $scope.lastName,
				'companyId':$scope.companyId		
			}
		};
		
		$http(req).then(function(response) {
        	$scope.showOutput=true;
			$scope.output=response.data;
    	});
	};
	
	function init(){
	 $q.all({
            company: $http.get('/miniservice/company/all')
          }).then(function(results) {
          	$scope.company=results.company.data;
          });
	}
	init();
});

angular.module('Poc').controller('PlanController', function($scope, $http) {
	
	$scope.showOutput=false;
	$scope.output="";
	$scope.save=function(){
		var req = {
			'method' : 'POST',
			'url' :'/miniservice/plan',
			'data' : {
				'name': $scope.name,
				'beginDate': $scope.beginDate,
				'expirationDate':$scope.expirationDate,
				'allocatedShares': $scope.allocatedShares
			}
		};
		
		$http(req).then(function(response) {
        	$scope.showOutput=true;
			$scope.output=response.data;
    	});
	};
});

angular.module('Poc').controller('TemplateController', function($scope, $http) {
	
	$scope.showOutput=false;
	$scope.output="";
	$scope.save=function(){
		var req = {
			'method' : 'POST',
			'url' :'/miniservice/vesttemplate',
			'data' : {
				'name': $scope.name,
				'months': $scope.months,
				'percent':$scope.percent,
				'vestType': $scope.vestType
			}
		};
		
		$http(req).then(function(response) {
        	$scope.showOutput=true;
			$scope.output=response.data;
    	});
	};
});


angular.module('Poc').controller('ViewController', function($scope, $http) {
	
	$scope.selectedDomain ='';
	
	
	$scope.switch=function(domain){
		var req = {
			'method' : 'GET',
			'url' :('/miniservice/'+domain+'/all')
		};
		$scope.selectedDomain=domain;
		$http(req).then(function(response) {
			$scope.jsonData=response.data;
    	});
	};
	
	
});

