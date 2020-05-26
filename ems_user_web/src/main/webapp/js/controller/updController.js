//控制层
app.controller('updController' ,function($scope,$location,updService){

  $scope.number = $location.search()['number'];
  $scope.updPwd=function () {
      if($scope.newPwd1==null||$scope.newPwd1==""){
          alert("密码不能为空");
          return;
      }
      if($scope.newPwd2==null||$scope.newPwd2==""){
          alert("密码不能为空");
          return;
      }
      if($scope.newPwd1!=$scope.newPwd2){
          alert("两次密码不一致，请重新输入")
      }
      updService.updPwd($scope.number,$scope.newPwd1).success(
          function (response) {
              alert(response.message);
              window.location.href="login.html";
          }
      )
  }

});
