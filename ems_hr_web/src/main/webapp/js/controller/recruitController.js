 //控制层 
app.controller('recruitController' ,function($scope,$controller   ,recruitService){	
	
	$controller('baseeController',{$scope:$scope});//继承
	
	//查询实体 
	$scope.findOne=function(id){				
		recruitService.findOne(id).success(
			function(response){
				$scope.recruit= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.recruit.id!=null){//如果有ID
			//alert(JSON.stringify($scope.recruit));
			serviceObject=recruitService.update( $scope.recruit ); //修改
		}else{
			serviceObject=recruitService.add( $scope.recruit  );//增加
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询
					alert(response.message);
		        	$scope.reloadList();//重新加载
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){

        if(confirm('您确定要删除吗？')) {
            if($scope.selectIds.length==0){
                alert("请选中要删除的数据！");
            }else {
                //获取选中的复选框
                recruitService.dele( $scope.selectIds ).success(
                    function(response){
                    	alert(response.message);
                        if(response.success){
                            $scope.reloadList();//刷新列表，并清空数组
                            $scope.selectIds=[];
                        }
                    }
                );
            }

        }

	};
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){
		recruitService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
