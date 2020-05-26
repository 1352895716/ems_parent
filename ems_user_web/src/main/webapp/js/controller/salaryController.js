 //控制层 
app.controller('salaryController' ,function($scope,$controller   ,salaryService,staffService){
	
	$controller('baseeController',{$scope:$scope});//继承
	//查询实体 
	$scope.findOne=function(id){				
		salaryService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象
	
	//搜索
	$scope.search=function(page,rows){
        salaryService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;
				for (var i=0;i<$scope.list.length;i++){
                    $scope.list[i].createTime = $scope.list[i].createTime.substring(0,10)
				}
				$scope.paginationConf.totalItems=response.total;//更新总记录数
                $scope.selectedStaff=null;
                //$scope.searchEntity={};//这个地方会连续调用两次，所以不要在此清空，
			}			
		);
	}

//保存
    $scope.save=function(){
        salaryService.update( $scope.entity ).success(
            function(response){
                if(response.success){
                    alert(response.message);
                    //重新查询
                    $scope.reloadList();//重新加载
                }else{
                    alert(response.message);
                }
            }
        );
    }

    
});	
