 //控制层 
app.controller('trainingController' ,function($scope,$controller,trainingService){
	
	$controller('basee2Controller',{$scope:$scope});//继承

	
	//查询实体 
	$scope.findOne=function(id){				
		trainingService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}


    //搜索
	$scope.searchEntity={};//定义搜索对象
	$scope.search=function(page,rows){			
		trainingService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
