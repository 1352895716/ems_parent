 //控制层                                             //此处注入控制器服务，才可以使用继承
app.controller('staffRapController' ,function($scope,$controller,staffRapService,staffService,rapService){

    $controller('baseeController',{$scope:$scope});//继承
    //分页全部和模糊查询
    $scope.searchEntity={};//初始化一个对象，但是内容为空
    $scope.selectedStaff=null;
    $scope.selectedRap=null;
    $scope.search=function (page,rows) {
        if($scope.selectedStaff!=null){
            for(var i=0;i<$scope.staffList.length;i++){
                if($scope.selectedStaff==$scope.staffList[i]) {
                    $scope.searchEntity.staffId=i;
                }
            }
        }
        if($scope.selectedRap!=null){
            for(var i=0;i<$scope.rapList.length;i++){
                if($scope.selectedRap==$scope.rapList[i]) {
                    $scope.searchEntity.rapId=i;
                }
            }
        }
        //alert(JSON.stringify($scope.searchEntity));
        staffRapService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems=response.total;
                //查询完之后要清空，以免对下次查询产生影响
                $scope.selectedStaff=null;
                $scope.selectedRap=null;
            }
        )
    };
    //查询全部员工将姓名存到数组
    $scope.staffList=[];
    $scope.findAllStaff=function () {
        staffService.findAll().success(
            function (response) {
                for(var i=0;i<response.length;i++){
                    $scope.staffList[response[i].id] = response[i].name;
                }
            }
        )
    };
    //查询全部奖惩，并将名称存到数组
    $scope.rapList=[];
    $scope.findAllRap=function () {
        rapService.findAll().success(
            function (response) {
                for(var i=0;i<response.length;i++){
                    $scope.rapList[response[i].id] = response[i].name;
                }
            }
        )
    };
    //查询单条记录
    $scope.findOne=function (id) {
        staffRapService.findOne(id).success(
            function (response) {
                $scope.staffRap=response;
                $scope.selectedStaff2=$scope.staffList[response.staffId];
                $scope.selectedRap2=$scope.rapList[response.rapId];
            }
        )
    };






    //更改和新建
    $scope.save=function () {

        for (var i=0;i<$scope.staffList.length;i++){
            if($scope.selectedStaff2==$scope.staffList[i]){
                $scope.staffRap.staffId=i;
            }
        }
        for (var i=0;i<$scope.rapList.length;i++){
            if($scope.selectedRap2==$scope.rapList[i]){
                $scope.staffRap.rapId=i;
            }
        }
        var object;
        if($scope.staffRap.id==null){
            object=staffRapService.add($scope.staffRap);
        }else{
            object=staffRapService.update($scope.staffRap)
        }

        object.success(
            function (response) {
                alert(response.message);
                if(response.success){
                    $scope.reloadList();//重新加载
                }
            }
        )
    }



   //删除
    $scope.dele=function () {
        if(confirm('您确定要删除吗？')) {
            if($scope.selectIds.length==0){
                alert("请选中要删除的数据！");
            }else {
                staffRapService.dele($scope.selectIds).success(
                    function (response) {
                        alert(response.message);
                        if(response.success){
                            $scope.reloadList();//删除成功就重新加载，同时清空数组
                            $scope.selectIds=[];
                        }
                    }
                );
            }

        }

    };
});	
