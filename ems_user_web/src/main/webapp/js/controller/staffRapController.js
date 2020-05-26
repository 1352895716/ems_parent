 //控制层                                             //此处注入控制器服务，才可以使用继承
app.controller('staffRapController' ,function($scope,$controller,staffRapService,rapService,staffService){

    $controller('baseeController',{$scope:$scope});//继承
    //分页全部和模糊查询
    $scope.searchEntity={};//初始化一个对象，但是内容为空

    $scope.findEntity2=function () {
        staffService.findEntity().success(
            function(response) {
                $scope.staff=response;
                $scope.findById($scope.staff.id);
            });
    };
   $scope.findById=function (id) {
     staffRapService.findById(id).success(
         function (response) {
             $scope.list=response;
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




});	
