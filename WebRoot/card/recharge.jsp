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
  	活动：每满${activeDetail.rechargePrice}元  送${activeDetail.sendIntegral}积分
  		<table>
  			<tr>
  				<td>
  					卡号
  				</td>
  				<td>
  					<input type="text" name="card.cardId" id="cardId"/>
  				</td>
  			</tr>
  			<tr>
  				<td>
  					充值金额
  				</td>
  				<td>
  					<input type="text" name="rechargeRecord.rechargePrice" id="rechargePrice"/>
  				</td>
  			</tr>
  			<tr>
  				<td>
  				
  				</td>
  				<td>
  					<input type="button" value="充值" onclick="recharge();"/>
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
	
	function recharge(){
		//创建核心对象
		//alert('1');
		createXMLHttpRequest();
		//alert('1');
		var cardId = document.getElementById("cardId").value;
		var rechargePrice = document.getElementById("rechargePrice").value;
		//alert(rechargePrice);
		var url = "recharge";
		var demo = {
			"cardId":cardId,
			"rechargePrice":rechargePrice
		};
		var demoStr = "demo="+JSON.stringify(demo);
				
		//alert(v);
		xmlHttp.onreadystatechange=handlerReadyStateChange;
		xmlHttp.open("post", url,true);
		
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlHttp.send(demoStr);
	}
	
	function handlerReadyStateChange(){
		//alert(xmlHttp.readyState);
		//alert(xmlHttp.status);
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var info=xmlHttp.responseText;
				alert(info);
				window.location.href="/welcome.jsp";
			}
		}
	}
</script>
</html>
