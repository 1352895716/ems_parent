 //控制层 
app.controller('trainController' ,function($scope,$controller   ,trainService){	
	
	$controller('baseeController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		trainService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		trainService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    $scope.entity={beginTime:new Date()};
	
	//查询实体 
	$scope.findOne=function(id){				
		trainService.findOne(id).success(
			function(response){
				$scope.entity= response;
			}
		);				
	}
	
	//保存
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=trainService.update( $scope.entity ); //修改  
		}else{
			serviceObject=trainService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				alert(response.message);
				if(response.success){
					//重新查询 
		        	$scope.reloadList();//重新加载
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		trainService.dele( $scope.selectIds ).success(
			function(response){
				alert(response.message);
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		trainService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    
});	
