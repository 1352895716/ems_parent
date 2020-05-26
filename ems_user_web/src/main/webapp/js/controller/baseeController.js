 //控制层
app.controller('baseeController' ,function($scope,staffService){


    $scope.staff={};
    $scope.findEntity=function () {
        staffService.findEntity().success(
            function(response) {
                $scope.staff=response;
            });
    };
    //重新加载列表 数据
    $scope.reloadList=function(){
    	//切换页码
        $scope.searchEntity.staffId=$scope.staff.id;
    	$scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);	   	
    }
    
	//分页控件配置 
	$scope.paginationConf = {
         currentPage: 1,
         totalItems: 10,
         itemsPerPage: 10,
         perPageOptions: [3, 5, 10, 15, 20],
         onChange: function(){
        	 $scope.reloadList();//重新加载
     	 }
	};
    //更新复选
	$scope.selectIds=[];//选中的ID集合
	$scope.updateSelection = function($event, id) {		
		if($event.target.checked){//如果是被选中,则增加到数组
			$scope.selectIds.push( id);			
		}else{
			var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 
		}
	}
	
});	