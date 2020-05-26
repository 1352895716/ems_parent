 //控制层                                             //此处注入控制器服务，才可以使用继承
app.controller('staffController' ,function($scope,$controller,staffService,sectionService){

    $controller('baseeController',{$scope:$scope});//继承
    //分页全部和模糊查询
    $scope.searchEntity={};//初始化一个对象，但是内容为空
    $scope.search=function (page,rows) {
        if($scope.selectedSection!=null){
            for (var i=0;i<$scope.sectionList.length;i++){
                if($scope.selectedSection==$scope.sectionList[i]){
                    $scope.searchEntity.secitonId=i;
                }
            }
        }
        //alert(JSON.stringify($scope.searchEntity));
        staffService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        )
    };

    //查询全部部门信息
    $scope.sectionList=[];
    $scope.findAllSection=function () {
        sectionService.findAll().success(
            function (response) {
                for (var i=0;i<response.length;i++){
                    $scope.sectionList[response[i].id]=response[i].name;
                }
                $scope.sectionList[0]="";
                //alert(JSON.stringify( $scope.sectionList));
            }
        );
    };


    $scope.selectedSection=null;
    //查询单个员工信息
    $scope.findOne=function (id) {
        staffService.findOne(id).success(
            function (response) {
                $scope.staff=response;
                $scope.selectedSection=$scope.sectionList[response.secitonId];
            }
        )
    }


    //更改和新建
    $scope.save=function () {
        for (var i=0;i<$scope.sectionList.length;i++){
            if($scope.selectedSection==$scope.sectionList[i]){
                $scope.staff.secitonId=i;
            }
        }
        var object;
        if($scope.staff.id==null){
            object=staffService.add($scope.staff);
        }else{
            object=staffService.update($scope.staff)
        }

        object.success(
            function (response) {
                alert(response.message);
                $scope.selectedSection=null;
                if(response.success){
                    $scope.reloadList();//重新加载
                }

            }
        )
    }

   /* $scope.sectionList2={data:[]};//部门列表

    //读取部门列表
    $scope.findSectionList=function(){
        sectionService.selectSectionList().success(
            function(response){
                $scope.sectionList2={data:response};
            }
        );
    }*/

   //删除
    $scope.dele=function () {
        if(confirm('您确定要删除吗？')) {
            if($scope.selectIds.length==0){
                alert("请选中要删除的数据！");
            }else {
                staffService.dele($scope.selectIds).success(
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
