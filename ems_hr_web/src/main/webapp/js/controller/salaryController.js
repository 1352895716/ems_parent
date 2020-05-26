 //控制层 
app.controller('salaryController' ,function($scope,$controller   ,salaryService,staffService){
	
	$controller('baseeController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		salaryService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		salaryService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		salaryService.findOne(id).success(
			function(response){
				$scope.entity= response;
                $scope.selectedStaff=$scope.staffList[response.staffId];
			}
		);				
	}
	
	//保存 
	$scope.save=function(){

        for (var i=0;i<$scope.staffList.length;i++){
            if($scope.selectedStaff==$scope.staffList[i]){
                $scope.entity.staffId=i;
            }
        }
        $scope.selectedStaff=null;
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=salaryService.update( $scope.entity ); //修改  
		}else{
			serviceObject=salaryService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
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
	
	 
	//批量删除 
	$scope.dele=function(){
        if(confirm('您确定要删除吗？')) {
            if($scope.selectIds.length==0){
                alert("请选中要删除的数据！");
            }else {
                //获取选中的复选框
                salaryService.dele( $scope.selectIds ).success(
                    function(response){
                        if(response.success){
                            alert(response.message);
                            $scope.reloadList();//刷新列表
                            $scope.selectIds=[];
                        }
                    }
                );
            }

        }

	};
	
	$scope.searchEntity={};//定义搜索对象
    $scope.selectedStaff=null;
	
	//搜索
	$scope.search=function(page,rows){
		if($scope.selectedStaff!=null){
			for(var i=0;i<$scope.staffList.length;i++){
				if($scope.selectedStaff==$scope.staffList[i]){
                    $scope.searchEntity.staffId=i;
				}
			}
		}

        //alert(JSON.stringify($scope.searchEntity));

        salaryService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
                $scope.selectedStaff=null;
                //$scope.searchEntity={};//这个地方会连续调用两次，所以不要在此清空，
			}			
		);
	}

	//查询全部员工,填充到员工姓名栏，避免多表查询
    $scope.staffList=[];
    $scope.findAllStaff=function () {
		staffService.findAll().success(
			function (response) {
				for(var i=0;i<response.length;i++){
                    $scope.staffList[response[i].id] = response[i].name;
				}
            }
		)
    }


    
});	
