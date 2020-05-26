 //控制层 
app.controller('rapController' ,function($scope,$controller   ,rapService){	
	
	$controller('baseeController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		rapService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		rapService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		rapService.findOne(id).success(
			function(response){
				$scope.rap= response;
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var object;//服务层对象
		if($scope.rap.id!=null){//如果有ID
			object=rapService.update( $scope.rap ); //修改
		}else{
			object=rapService.add( $scope.rap  );//增加
		}				
		object.success(
			function(response){
				if(response.success){
					//重新查询
                    alert(response.message);
		        	$scope.findAll();//重新加载
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
                rapService.dele( $scope.selectIds ).success(
                    function(response){
                        alert(response.message);
                        if(response.success){
                            $scope.findAll();//刷新列表,并清空数组
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
		rapService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
