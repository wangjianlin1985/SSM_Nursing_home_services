<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>智慧养老服务系统</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<%@include file="common.jsp"%>

<link rel="stylesheet" type="text/css" href="css/style-home.css">
<script type="text/javascript" src="plugins/echart/echarts-all.js"></script>
<style type="text/css">
			

body {
	
 	background-color:white !important;;
   height:100%;
}

</style>

</head>
<body >
<!--cantainer-fluid  开始 -->
<div class = "cantainer">

	<div class="col-md-6" style="  ">
	
     <div id="chartmain" style="width:600px; height: 400px; margin-top:10%;"></div>
  
		
	</div>
	<div class="col-md-6">
		<table class="table table-striped">
  <caption>园丁护理评价排名</caption>
  <thead>
    <tr>
      <th>姓名</th>
      <th>优秀</th>
      <th>良好</th>
       <th>一般</th>
      <th>较差</th>
    </tr>
  </thead>
  <tbody class="myGuardians">
  
  </tbody>
</table>
	</div>


					<div class="clearfix"></div>
				<!-- </div> -->	
	<!-- </div> -->
	<!-- row-fluid  第一个结束 -->
	



</div>
<!--cantainer-fluid  结束 -->

<script type="text/javascript">
var myChart = echarts.init(document.getElementById('chartmain'));

$.post("TOld/findStatistical.htm",function(data){
	var obj = eval('('+data+')');
	getChart(obj)
})

function getChart(obj){


option = {
    title : {
        text: '智慧养老院健康占比',       //大标题
        subtext: '希望老人都健康',                //类似于副标题
        x:'left'                 //标题位置   居中
    },
    tooltip : {
        trigger: 'item',           //数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
        formatter: "{a} <br/>{b} : {c} ({d}%)"   //{a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）用于鼠标悬浮时对应的显示格式和内容
    },
    legend: {                           //图例组件。
        orient: 'vertical',             //图例列表的布局朝向
        left: 'left',
        data: ['健康','良好','需要陪护','重点监护']
    },
    series : [              //系列列表。每个系列通过 type 决定自己的图表类型
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:obj
                /* {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'} */
            ,
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};

myChart.setOption(option);
}



$(function(){
	
	$.post("TGardener/findOrderby.htm",function(data){
		var obj = eval('('+data+')');
		var html="";
		for(var i=0;i<obj.length;i++){
			html+='<tr>';
			html+='   <td>'+obj[i].gardenerName+'</td>';
			html+='   <td>'+obj[i].num1+'</td>';
			html+='  <td>'+obj[i].num2+'</td>';
			html+='  <td>'+obj[i].num3+'</td>';
			html+='  <td>'+obj[i].num4+'</td>';
			
			html+=' </tr>';
		}
		$(".myGuardians").html(html);
		
	})
	
})


    </script>

</body>
</html>

