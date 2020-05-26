//服务层
app.service('pwdService',function($http){

    //发送验证码
    this.checked=function(phone,number){
        return $http.get('../staff/checked.do?phone='+phone+'&number='+number);
    }
    //校验验证码
    this.checkCode=function(phone,code){
        return $http.get('../staff/checkCode.do?phone='+phone+'&code='+code);
    }
});
