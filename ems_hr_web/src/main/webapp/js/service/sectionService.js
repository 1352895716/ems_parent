app.service('sectionService',function ($http) {

    //查询全部部门信息
    this.findAll=function () {
        return $http.get('../section/findAll.do');
    };

    //查询单个部门信息
    this.findOne=function (id) {
        return $http.get('../section/findOne.do?id='+id);
    };
    //修改部门信息
    this.updateSec=function (section) {
        return $http.post('../section/updateSection.do',section);
    };
    //新建部门信息
    this.addSec=function (section) {
        return $http.post('../section/addSection.do',section);
    };
    //删除部门信息
    this.dele=function (ids) {
        return $http.get('../section/dele.do?ids='+ids);
    };

    //下拉列表数据
    this.selectSectionList=function(){
        return $http.get('../section/selectSectionList.do');
    }

});