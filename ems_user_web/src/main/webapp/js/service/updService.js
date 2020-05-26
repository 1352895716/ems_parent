//服务层
app.service('updService',function($http){

    //修改密码
    this.updPwd=function(number,password){
        return $http.get('../staff/updPwd.do?number='+number+'&password='+password);
    }
});
