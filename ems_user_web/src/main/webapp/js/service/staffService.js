app.service('staffService',function ($http) {


    this.findEntity=function () {
        return $http.get('../login/findEntity.do');
    }

    //修改
    this.update=function(entity){
        return  $http.post('../staff/update.do',entity );
    }
    //查询所有部门
    this.findAllSection=function () {
        return $http.get('../section/findAll.do');
    }
})