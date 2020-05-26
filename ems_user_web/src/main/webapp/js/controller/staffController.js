 //控制层 
app.controller('staffController' ,function($scope,$controller,staffService){



    //比较原密码
    $scope.oldPwd=null;
    $scope.compare=function () {
        if($scope.entity.password!=$scope.oldPwd){
            alert("密码输入有误")
        }
    }
    $scope.compare1=function (){
        if($scope.newPwd1!=$scope.newPwd2){
            alert("两次密码不一致");
        }
    };
    $scope.updpwd=function () {
        if($scope.entity.password!=$scope.oldPwd){
            alert("原密码输入有误")
        }else if($scope.newPwd1!=$scope.newPwd2){
            alert("两次密码不一致");
            //document.getElementById("newPwd2").focus(); //让新密码框获得焦点
        }else {
            $scope.entity.password=$scope.newPwd1;
            staffService.update( $scope.entity).success(
                function(response){
                    if(response.success){
                        alert("密码修改成功");
                        location.href="main.html"
                    }else{
                        alert(response.message);
                    }
                }
            );
        }
    }
	$scope.findEntity=function () {
		staffService.findEntity().success(
			function(response) {
				$scope.entity=response;
				//alert(JSON.stringify($scope.entity));
				if($scope.entity.sex==1){
					$scope.sex='男';
				}else {
                    $scope.sex='女';
				}
                if($scope.entity.isMarried=="1"){
                    $scope.married='已婚';
                }else {
                    $scope.married='未婚';
                }
                $scope.entity.workExperience = $scope.entity.workExperience.trim();
        });
    };

    //修改
    $scope.save=function(){
		serviceObject=staffService.update( $scope.entity ); //修改
        serviceObject.success(
            function(response){
                if(response.success){
                    alert(response.message);
                    location.href="main.html"
                }else{
                    alert(response.message);
                }
            }
        );
    }
    
});	
