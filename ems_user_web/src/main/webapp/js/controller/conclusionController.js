 //控制层 
app.controller('conclusionController' ,function($scope,$controller,$location,conclusionService,trainingService){
	
	$controller('baseeController',{$scope:$scope});//继承

    $scope.selTrain=null;
	//查询实体 
	$scope.findOne=function(id){				
		conclusionService.findOne(id).success(
			function(response){
				$scope.entity= response;
                $scope.selTrain = $scope.trainList[$scope.entity.trainId];
                $scope.selTrainId = $scope.entity.trainId;

            }
		);				
	}


	
	//保存 
	$scope.save=function(){
        for (var i=0;i<$scope.trainList.length;i++){
            if($scope.selTrain==$scope.trainList[i]){
                $scope.entity.trainId=i;
                if( $scope.selTrainId!=null&&$scope.selTrainId!=i){
                	alert("培训名称不可修改")
					return;
				}
            }
        }
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=conclusionService.update( $scope.entity ); //修改  
		}else{
            $scope.entity.staffId=$scope.staff.id;
			serviceObject=conclusionService.add( $scope.entity  );//增加 
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
        if($scope.selectIds.length==0){//获取选中的复选框
            alert("请选中要删除的数据！");
        }else{
            conclusionService.dele( $scope.selectIds ).success(
                function(response){
                    alert(response.message)
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
	$scope.search=function(page,rows){
		conclusionService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}


    //查找所有培训
    $scope.trainList=[];//使用数组时，必须先初始化
    $scope.findTrain=function () {
        trainingService.findAll().success(
            function (response) {
                for(var i=0;i<response.length;i++){
                    $scope.trainList[response[i].id]=response[i].title;
                }
            }
        )
    };

});	
