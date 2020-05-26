//控制层
app.controller('pwdController' ,function($scope,$interval,pwdService){
    $scope.send = false;
  $scope.checked=function () {
      if($scope.number==null || $scope.number==""){
          alert("请输入员工编号");
          return;
      }
      if($scope.phone==null || $scope.phone==""){
          alert("请输入手机号");
          return;
      }
      pwdService.checked($scope.phone,$scope.number).success(
          function (response) {
              alert(response.message);//先打印信息
              if(response.success){//如果成功，就调用验证码计时函数
                  $scope.timecd();
              }
          }
      );
  };

  $scope.timecd=function () {
      var cd = 60;
      var toDo = function() {
          $scope.send = true;
          cd--;
          if(cd < 0) {
              cd = "";
              $scope.send = false;
          }
          $scope.countDown = "重新获取 " + cd;
      };
      $interval(toDo, 1000, 60);
  }

  $scope.checkCode=function () {
      if($scope.code==null || $scope.code==""){
          alert("请输入验证码");
          return;
      }
      pwdService.checkCode($scope.phone,$scope.code).success(
          function (response) {
              alert(response.message);
              if(response.success){
                  window.location.href="upd_password.html#?number="+$scope.number;
              }

          }
      )
  }
});
