app.service('staffRapService',function ($http) {

   //分页查询奖惩记录
    this.search=function (page,rows,staffRap) {
        return $http.post('../staffRap/search.do?page='+page+"&rows="+rows,staffRap);
    }

    //查询单条记录
    this.findOne=function (id) {
        return $http.get('../staffRap/findOne.do?id='+id);
    }

    //增加
    this.add=function(entity){
        return  $http.post('../staffRap/add.do',entity );
    }
    //修改
    this.update=function(entity){
        return  $http.post('../staffRap/update.do',entity );
    }

    //删除
    this.dele=function (ids) {
        return $http.get('../staffRap/delete.do?ids='+ids);
    }
});