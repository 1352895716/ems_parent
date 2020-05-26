 //控制层 
app.controller('doController' ,function($scope,$controller,$location,documentService){



	
	//查询实体 
	$scope.findOne=function(id){
		documentService.findOne(id).success(
			function(response){
			    response.time=response.time.substring(0,10);
				$scope.entity= response;

				//alert(JSON.stringify(response));
			}
		);				
	};

    $scope.id1 = $location.search()['id'];
    $scope.find=function () {
        //alert($scope.id1);
        $scope.findOne($scope.id1);
    };

});	
