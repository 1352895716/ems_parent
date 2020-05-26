 //控制层 
app.controller('satController' ,function($scope,$controller ,satService,staffService,trainService){
	
	$controller('baseeController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		satService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	//查找所有员工
	$scope.staffList=[];
	$scope.findStaff=function () {
		staffService.findAll().success(
			function (response) {
				for(var i=0;i<response.length;i++){
                    $scope.staffList[response[i].id]=response[i].name;
				}
			}
		)
    };
	//查找所有培训
    $scope.trainList=[];//使用数组时，必须先初始化
    $scope.findTrain=function () {
        trainService.findAll().success(
            function (response) {
                for(var i=0;i<response.length;i++){
                    $scope.trainList[response[i].id]=response[i].name;
                }
            }
        )
    };
	//所有状态
	$scope.statusList=['未审核','审核通过','审核未通过'];
	//分页
	$scope.findPage=function(page,rows){			
		satService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		satService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=satService.update( $scope.entity ); //修改  
		}else{
			serviceObject=satService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
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
		//获取选中的复选框
		if($scope.selectIds.length==0){

		}else{
            satService.dele( $scope.selectIds ).success(
                function(response){
                    alert(response.message);
                    if(response.success){
                        $scope.reloadList();//刷新列表
                        $scope.selectIds=[];
                    }
                }
            );
        }
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
    $scope.staffName=null;
    $scope.trainName=null;
	$scope.search=function(page,rows){
        //alert($scope.staffName+"----"+$scope.trainName);
		if($scope.staffName!=null){
			if($scope.staffName==''){
                $scope.searchEntity.staffId=null;
			}
			for(var i=0;i<$scope.staffList.length;i++){
				if($scope.staffName==$scope.staffList[i]){
					$scope.searchEntity.staffId=i;
				}
			}
		}
		if($scope.trainName!=null){
			if($scope.trainName==''){
                $scope.searchEntity.trainId=null;
			}
            for(var i=0;i<$scope.trainList.length;i++){
                if($scope.trainName==$scope.trainList[i]){
                    $scope.searchEntity.trainId=i;
                }
            }
		}
		//alert(JSON.stringify($scope.searchEntity));
		satService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
				//$scope.searchEntity={};此处不能清空，应为这里会连续调用两次，导致第二次调用时，会出来全部数组
			}			
		);
	};

	//审核,一次可以审核多个，但是不便于判断人数
    $scope.updateStatus=function (status) {
    	if($scope.selectIds.length==0){
    		alert("请选择要审核的数据");
		}else {
            satService.updateStatus($scope.selectIds,status).success(
                function (response) {
                    alert(response.message);
                    $scope.selectIds=[];//使用完毕后，立即清空数组，
                    $scope.reloadList();//审核后刷新列表
                }
            )
		}

    }
    //审核，故采用此种方案
    $scope.updStatus=function (status) {
        $scope.selectIds.push($scope.entity.id);
		satService.updateStatus($scope.selectIds,status).success(
			function (response) {
				alert(response.message);
				$scope.selectIds=[];//使用完毕后，立即清空数组，
				if(response.success){
                    $scope.reloadList();//审核后刷新列表
				}

			}
		)
	}
});	
