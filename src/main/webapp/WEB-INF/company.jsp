<html>
<head>
<link rel="stylesheet" type="text/css" href="/miniservice/css/bootstrap.min.css"/>
<script src="/miniservice/js/angular.min.js"></script>
</head>
<body ng-app="Poc"  ng-controller="PocController">

<form>
<div class="row">
<div class="col-sm-8 offset-sm-2">
<div class="form-group row">
    <div class="col-sm-4 offset-sm-4" style="text-align:center;"><label><h2>Company</h2></label>
    </div>
  </div>
  <div class="form-group row">
    <label for="name" class="col-sm-2 col-form-label">Company Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" placeholder="Company Name" ng-model="name">
    </div>
  </div>
  <div class="form-group row">
    <label for="symbol" class="col-sm-2 col-form-label">Symbol</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="symbol" placeholder="Symbol" ng-model="symbol">
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
app.controller('PocController', function($scope, $http) {
	
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
</script>
</html>
