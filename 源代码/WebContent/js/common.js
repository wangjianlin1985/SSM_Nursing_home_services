
/**
 * 将form表单元素的值序列化成对象
 * 调用方法例  formSerializeObject($('#formId'))
 * @param form
 */
function formSerializeObject(formId){
	var o={};
	$.each(form.serializeArray(),function(index){
		if(o[this['name']]){
			o[this['name']]=o[this['name']]+","+this['value'];
		}else{
			o[this['name']]=this['value'];
		}
	});
	return o;
}

/**
 * 向表单里面赋值
 * @param formId   '#id' 
 * @param jsonValue
 * @returns
 */
function setForm (formId,jsonValue) {   
    var obj=$(formId);  
    $.each(jsonValue, function (name, ival) {  
        var $oinput = obj.find("input[name=" + name + "]");   
        if ($oinput.attr("type")== "radio" || $oinput.attr("type")== "checkbox"){  
             $oinput.each(function(){  
                 if(Object.prototype.toString.apply(ival) == '[object Array]'){// 是复选框，并且是数组
                      for(var i=0;i<ival.length;i++){  
                          if($(this).val()==ival[i])  
                             $(this).attr("checked", "checked");  
                      }  
                 }else{  
                     if($(this).val()==ival)  
                        $(this).attr("checked", "checked");  
                 }  
             });  
        }else if($oinput.attr("type")== "textarea"){// 多行文本框
            obj.find("[name="+name+"]").html(ival);  
        }else{  
             obj.find("[name="+name+"]").val(ival);   
        }  
    });
}



// 如：{Name:'摘取天上星',position:'IT技术'}
// ps:注意将同名的放在一个数组里
function getFormJson(formId) {
	var o = {};
	var a = $("#"+formId).serializeArray();
	$.each(a, function () {
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}



//easyui 表格里面时间格式化 ：年-月-日
function formatTimeYMD (time) {
    var unixtime = time;
    var unixTimestamp = new Date(time );
    var Y = unixTimestamp.getFullYear();
    var M = ((unixTimestamp.getMonth() + 1) > 9 ? (unixTimestamp.getMonth() + 1) :  + (unixTimestamp.getMonth() + 1));
    var D = (unixTimestamp.getDate() > 9 ? unixTimestamp.getDate() : '0' + unixTimestamp.getDate());
    var toDay = Y + '-' + M + '-' + D;
    return toDay;
}
//easyui 表格里面时间格式化 ：年-月-日  时：分：秒
function formatTimeYMDhms (time) {
	  var unixtime = time;
	    var unixTimestamp = new Date(time );
	    var Y = unixTimestamp.getFullYear();
	    var M = ((unixTimestamp.getMonth() + 1) > 9 ? (unixTimestamp.getMonth() + 1) :  + (unixTimestamp.getMonth() + 1));
	    var D = (unixTimestamp.getDate() > 9 ? unixTimestamp.getDate() : '0' + unixTimestamp.getDate());
	    var h = (unixTimestamp.getHours() > 9 ? unixTimestamp.getHours() : '0' + unixTimestamp.getHours());
	    var m = (unixTimestamp.getMinutes() > 9 ? unixTimestamp.getMinutes() : '0' + unixTimestamp.getMinutes());
	    var s = (unixTimestamp.getSeconds() > 9 ? unixTimestamp.getSeconds() : '0' + unixTimestamp.getSeconds());
	    var toDay = Y + '-' + M + '-' + D +' '+h+":"+m+":"+s;
	    return toDay;
}



var formObj = {
		/**
		 * 实现添加修改按钮的 隐藏和显示相互切换
		 * @param addId   添加按钮Id
		 * @param editId  修改按钮id
		 * @param flag   如果flag 为0 ，则添加按钮隐藏，编辑按钮开启
		 *   如果flag 为1 ，则编辑按钮隐藏，添加按钮开启
		 */
		 setBtnIsShow :function(addId,editId,flag){
			if(flag==0){
				$('#'+addId).hide();
				$('#'+editId).show();
			}
			if(flag==1){
				$('#'+editId).hide();
				$('#'+addId).show();
			}
			
		},
		/**
		 *  window弹框设置
		 * @param windowId windowid   
		 * @param title    标题
		 * @param width    宽度
		 * @param height   高度
		 */
		/*getWindow  :function (windowId,title,width,height){
			$('#'+windowId).window({
				title : title,
				width : width,
				height : height,
				modal : true,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				closable : false,
				closed : false,
			});
			
		},*/
		/**
		 * 关闭窗口
		 */
		/*closeWindow :function(windowId){
			$('#'+windowId).window('close');
		},*/
		/**
		 * 快捷表单提交
		 * formId  表单id
		 * formUrl 表单提交url
		 * tableId 提交完表单需要刷新的列表
		 * windowId  提交完表单，需要关闭的弹框
		 */
		/*submitForm : function(formId,formUrl,tableId,windowId){
			$('#'+formId).form('submit', {    
			    url:formUrl,    
			    onSubmit: function(){
			    },    
			    success:function(data){
			    	var obj = eval('('+data+')');
			    	if(obj.isSuccess == 1){
			    		$.messager.alert("提示",obj.showInfo);
			    		$('#'+tableId).datagrid("load");
			    	}else{
			    		$.messager.alert("提示",obj.showInfo);
			    	}
			    	//关闭弹窗
			    	formObj.closeWindow(windowId);
			    }    
			});
			
		},*/
		
}
/**
 * 消息提示信息
 */
var message= {
		alert:function(message){
			bootbox.alert({
				size:"small",
				title:"提示",
				message:message
				
			});
		}
}



