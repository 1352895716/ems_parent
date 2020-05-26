 //控制层 
app.controller('trainController' ,function($scope,$controller,$location,trainService,satService){
	
	$controller('basee2Controller',{$scope:$scope});//继承


	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){
		//alert(JSON.stringify($scope.entity));
		trainService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
    //查询实体
    $scope.findOne=function(id){
        trainService.findOne(id).success(
            function(response){
                $scope.entity= response;
                if(new Date()>new Date($scope.entity.endTime)){
                	alert("时间已截止，无法报名！");
				}if(response.count==response.currentCount){
                	alert("人数已满无法报名");
				}else{
                    $scope.signUp();
				}

            }
        );
    }
    $scope.sat = {staffId:"",trainId:""};
	$scope.signUp=function () {
        $scope.sat.staffId = $location.search()['id'];
        $scope.sat.trainId=$scope.entity.id;
        //alert(JSON.stringify($scope.sat));
        satService.add($scope.sat).success(
        	function (response) {

				if(response.success){
					alert("报名成功！请耐心等待审核");
				}else {
					alert(response.message);
				}
            }
		)
    }
    
});	
