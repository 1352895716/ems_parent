 //控制层 
app.controller('documentController' ,function($scope,$controller,$location,$interval,$http,staffService,documentService,thingService){

    $scope.staff={};
    $scope.findEntity=function () {
        staffService.findEntity().success(
            function(response) {
                $scope.staff=response;
                $scope.getLangDate();
                $interval($scope.getLangDate,1000);
                $scope.findAllThing();
            });
    };
	$controller('basee2Controller',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		documentService.findAll().success(
			function(response){

				for (var i=0;i<response.length;i++) {
					response[i].time = response[i].time.substring(5,10);
				}
				$scope.list=response;
                $scope.findEntity();
			}			
		);
	};

	
	//查询实体 
	$scope.findOne=function(id){
		documentService.findOne(id).success(
			function(response){
				$scope.entity= response;
				//alert(JSON.stringify(response));
			}
		);				
	};

    //获取系统时间

    //值小于10时，在前面补0
    dateFilter=function(date){
        if(date < 10){return "0"+date;}
        return date;
    };
    $scope.getLangDate=function(){
        var newDate = '';
        var dateObj = new Date(); //表示当前系统时间的Date对象
        var year = dateObj.getFullYear(); //当前系统时间的完整年份值
        var month = dateObj.getMonth()+1; //当前系统时间的月份值
        var date = dateObj.getDate(); //当前系统时间的月份中的日
        var day = dateObj.getDay(); //当前系统时间中的星期值
        var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
        var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
        var hour = dateObj.getHours(); //当前系统时间的小时值
        var minute = dateObj.getMinutes(); //当前系统时间的分钟值
        var second = dateObj.getSeconds(); //当前系统时间的秒钟值
        var timeValue = "" +((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午" ); //当前时间属于上午、晚上还是下午
        newDate = dateFilter(year)+"年"+dateFilter(month)+"月"+dateFilter(date)+"日 "+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
        $scope.timeString = "亲爱的"+ $scope.staff.name+"，"+timeValue+"好！ 欢迎使用 管理系统-员工端。当前时间为： "+newDate+"　"+week;
        //setTimeout($scope.getLangDate(),1000);
    };




    //待办事项的操作
    //查询该员工的所有待办事项
    $scope.findAllThing=function () {
        //alert("$scope.staff.id："+$scope.staff.id)
        thingService.findAll($scope.staff.id).success(
            function (response) {
                $scope.thingList=response;
                //alert(JSON.stringify(response))
            }
        )
    }
    //添加
    $scope.saveThing=function () {
        $scope.thing.staffId=$scope.staff.id;
        thingService.add($scope.thing).success(
            function (response) {
                alert(response.message);//先打印消息
                if(response.success){//如果成功就刷新
                    window.location.reload();
                }
            }
        )
    }
    //删除
    $scope.deleThing=function (id) {
        if(confirm('您确定要删除吗？')) {
            $scope.selectIds.push(id);
            thingService.dele($scope.selectIds).success(
                function (response) {
                    alert(response.message);
                    if(response.success){//如果成功就刷新
                        window.location.reload();
                    }
                }
            )
        }
    }
    $scope.city='郑州';
    $scope.cha=function () {
        /*documentService.cha($scope.city).success(
            function (response) {
                // 请求回的数据放到模型上
                $scope.currentCity = data.results[0].currentCity;
                $scope.weatherData = data.results[0].weather_data;
                alert("111111111"+JSON.stringify($scope.weatherData));
                console.log(response);
            }
        )*/
        $http({
            method: 'jsonp', // 支持jsonp,
            url: 'http://api.map.baidu.com/telematics/v3/weather?callback=JSON_CALLBACK',
            params: { // 请求的参数
                location: $scope.city,
                output: 'json',
                ak: '1eA9cqrkIrrToj5iF4cnQlyvd5glGNgX'
            }
        }).success(function (data) {
            // 请求回的数据放到模型上
            $scope.currentCity = data.results[0].currentCity;
            $scope.weatherData = data.results[0].weather_data;
            alert("222222223333")
        });

    }
});	
