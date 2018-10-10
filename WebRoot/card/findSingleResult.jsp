<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<form action="#" method="post">
  		<table>
	  		<tr>
	  			<td colspan="2">
	  				详情
	  			</td>
	  		</tr>
  			<tr>
  				<td>
  					卡号
  				</td>
  				<td>
  					${cd.cardId}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					姓名
  				</td>
  				<td>
  					${cd.customerName}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					状态
  				</td>
  				<td>
  					${cd.cardStatus.cardValue}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					余额
  				</td>
  				<td>
  					${cd.balance}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					积分
  				</td>
  				<td>
  					${cd.integral}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					开卡日期
  				</td>
  				<td>
  					${cd.createDate}
  				</td>
  			</tr>
  			<tr>
  				<td>
  					最后消费日期
  				</td>
  				<td>
  					${cd.endDate}
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2">
  					<input type="button" value="查看充值详情" onclick=""/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
 <script type="text/javascript">
	var xmlHttp;
	
	function createXMLHttpRequest(){
		if(window.ActiveXObject){
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}else{
			xmlHttp=new XMLHttpRequest();
		}
	 }
	
	function cancellation(){
		createXMLHttpRequest();
		//alert('1');
		var cardId = document.getElementById("cardId").value;
		var customerName = document.getElementById("customerName").value;
		//alert(customerName);
		var url = "cancellation";
		var cardIDAndName = {
			"cardId":cardId,
			"customerName":customerName
		};
		var cardIDAndNameStr = "cardIDAndName="+JSON.stringify(cardIDAndName);
				
		//alert(v);
		xmlHttp.onreadystatechange=handlerReadyStateChange;
		xmlHttp.open("post", url,true);
		
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttp.send(cardIDAndNameStr);
	}
	
	function handlerReadyStateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var info=xmlHttp.responseText;
				alert(info);
			}
		}
	}
</script>
</html>
