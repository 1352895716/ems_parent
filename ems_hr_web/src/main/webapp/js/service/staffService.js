app.service('staffService',function ($http) {

    //查询全部员工
    this.findAll=function () {
        return  $http.get('../staff/findAll.do');
    };
    //分页查询
    this.search=function (page,rows,searchEntity) {
        return $http.post('../staff/search.do?page='+page+"&rows="+rows,searchEntity);
    }
    //查询单个员工信息
    this.findOne=function (id) {
        return $http.get('../staff/findOne.do?id='+id);
    }

    //增加
    this.add=function(entity){
        return  $http.post('../staff/add.do',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../staff/update.do',entity );
    }
    //删除
    this.dele=function (ids) {
        return $http.get('../staff/delete.do?ids='+ids);
    }
});