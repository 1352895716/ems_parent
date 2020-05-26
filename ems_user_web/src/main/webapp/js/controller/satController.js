 //控制层 
app.controller('satController' ,function($scope,$controller,$location,satService,trainService){
	
	$controller('basee2Controller',{$scope:$scope});//继承

    //查询实体
    $scope.findOne=function(id){
        satService.findOne(id).success(
            function(response){
                $scope.entity= response;
            }
        );
    }
	//批量删除
	$scope.dele=function(){			
		//获取选中的复选框
		if($scope.selectIds.length==0){
			alert("请选中要删除的数据！");
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
    $scope.trainName=null;
	$scope.search=function(page,rows){
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
		satService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
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
    $scope.name = $location.search()['name'];
    $scope.searchEntity.staffId= $location.search()['id'];
});	
