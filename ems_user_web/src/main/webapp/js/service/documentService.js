//服务层
app.service('documentService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../document/findAll.do');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../document/findPage.do?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../document/findOne.do?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../document/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../document/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../document/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../document/search.do?page='+page+"&rows="+rows, searchEntity);
	}


	//查询天气
	this.cha=function (city) {
		return $http({
			method:'jsonp',
			url:'http://api.map.baidu.com/telematics/v3/weather',
			params: {
				callback:"JSON_CALLBACK",
                location: city,
                output: 'json',
                ak: '0A5bc3c4fb543c8f9bc54b77bc155724'
			}
		});
    }
});
