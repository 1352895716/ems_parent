//控制层
app.controller('sectionController' ,function($scope,$controller,sectionService){

    $controller('baseeController',{$scope:$scope});//继承
    //查询全部
    $scope.findAll=function () {
        sectionService.findAll().success(
            function (response) {
                $scope.sectionList=response;
                //alert(JSON.stringify(response));
            }
        );
    };

    $scope.section={};
    //查询单个
    $scope.findOne=function (id) {
        sectionService.findOne(id).success(
            function (response) {
                $scope.section=response;

            }
        );
    };

    //插入或新建
    $scope.save=function () {
        var object;
        if($scope.section.id==null){
            object=sectionService.addSec($scope.section);
        }else {
            object=sectionService.updateSec($scope.section);
        }
        object.success(
            function (response) {
                if(response.success){
                    alert(response.message);
                    $scope.findAll();//重新加载列表
                }else{
                    alert(response.message);
                }
            }
        );
    };

    $scope.dele=function () {

        if(confirm('您确定要删除吗？')) {
            if($scope.selectIds.length==0){
                alert("请选中要删除的数据！");
            }else {
                sectionService.dele($scope.selectIds).success(
                    function (response) {
                        if (response.success) {
                            alert(response.message)
                            $scope.findAll();//如果删除成功,就重新加载
                            $scope.selectIds=[];//同时删除成功还要清空数组
                        } else {
                            alert(response.message);
                        }
                    }
                );
            }

        }
    }


});
