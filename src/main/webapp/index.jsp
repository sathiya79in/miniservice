<html>
<head>
<link rel="stylesheet" type="text/css" href="/miniservice/css/bootstrap.min.css"/>
<script src="/miniservice/js/angular.min.js"></script>
</head>
<body ng-app="Poc"  ng-controller="PocController">

<form>
<div class="row">
<div class="col-sm-8 offset-sm-2" style="border:1px solid #ced4da;">
<div class="form-group row">
    <div class="col-sm-4 offset-sm-4" style="text-align:center;"><label><h2>Award</h2></label>
    </div>
  </div>
  <div class="form-group row">
    <label for="employeeId" class="col-sm-2 col-form-label">Employee</label>
    <div class="col-sm-10">
      <select ng-model="employeeId" id="employeeId" class="form-control">
      	<option value="">Select an Employee</option>
      	<option ng-repeat="emp in employee" value={{emp.id}}>{{emp.firstName +" " +emp.lastName}}</option>
      </select>
    </div>
  </div>
  <div class="form-group row">
    <label for="planId" class="col-sm-2 col-form-label">Plan</label>
    <div class="col-sm-10">
      <select ng-model="planId" id="planId" class="form-control">
      	<option value="">Select a Plan</option>
      	<option ng-repeat="p in plan" value={{p.planId}}>{{p.name}}</option>
      </select>
    </div>
  </div>
<div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Vesting Template</label>
    <div class="col-sm-10">
      <select  ng-model="templateId" id="templateId" class="form-control">
      	<option value="">Select a vesting template</option>
      	<option ng-repeat="t in template" value={{t.templateId}}>{{t.templateName}}</option>
      </select>
    </div>
  </div>  
  <div class="form-group row">
    <label for="number" class="col-sm-2 col-form-label">Grant Number</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="number" placeholder="Grant Number" ng-model="number">
    </div>
  </div>
  <div class="form-group row">
    <label for="date" class="col-sm-2 col-form-label">Award Date</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="date" placeholder="Award Date yyyy-mm-dd" ng-model="date">
    </div>
  </div>
  <div class="form-group row">
    <label for="marketValue" class="col-sm-2 col-form-label">Market Value</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="marketValue" placeholder="Market Value" ng-model="marketValue">
    </div>
  </div>
  <div class="form-group row">
    <label for="shares" class="col-sm-2 col-form-label">Shares</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="shares" placeholder="Shares" ng-model="shares">
    </div>
  </div>
  <div class="form-group row">
    <label for="price" class="col-sm-2 col-form-label">Price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="price" placeholder="Price" ng-model="price">
    </div>
  </div>
  <div class="form-group row">
    <div class="col-sm-2 offset-sm-5" style="text-align:center;">
  		<button type="button" class="btn btn-primary" ng-click="save()">Save</button>
    </div>
  </div>

    <div class="form-group row" id="output" ng-show="showOutput===true">
    <div class="col-sm-8 offset-sm-2" style="text-align:center;">
  		{{output}}
    </div>
  </div>
  
  </div>
  </div>
  </form>

</body>
<script>
var app = angular.module('Poc', []);
app.controller('PocController', function($scope, $http,$q) {
	
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
            employee: $http.get('/miniservice/employee/all'),
            plan: $http.get('/miniservice/plan/all'),
            template: $http.get('/miniservice/vesttemplate/all')
          }).then(function(results) {
          	$scope.employee=results.employee.data;
          	$scope.plan=results.plan.data;
          	$scope.template=results.template.data;
          });
	}
	init();
});
</script>
</html>
