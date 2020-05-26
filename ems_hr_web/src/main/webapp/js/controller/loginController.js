//控制层
app.controller('loginController' ,function($scope,$controller,loginService){


    $scope.showName=function () {
        loginService.showName().success(
            function (response) {
                $scope.loginName = response.loginName;

            }
        )
    }



});
