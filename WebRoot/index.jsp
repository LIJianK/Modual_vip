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
  	<table width="100%" height="100%">
  		<tr height="100%">
  			<td width="120" valign="top" align="center" bgcolor="#98EAF5">
  				<br/>
  				<a href="findRecharge" target="yqr">充值</a><br/><br/>
				<a href="card/reportTheLoss.jsp" target="yqr">挂失</a><br/><br/>
  				<a href="card/thaw.jsp" target="yqr">解冻</a><br/><br/>
  				<a href="enableCard" target="yqr">办卡</a><br/><br/>
  				<a href="card/cancellation.jsp" target="yqr">注销卡</a><br/><br/>
  				<a href="card/findCard.jsp" target="yqr">查询卡</a><br/><br/>
  				<a href="active/activeSet.jsp" target="yqr">活动设置</a><br/><br/>
  			</td>
  			<td>
  				<iframe src="welcome.jsp" width="100%" height="100%" name="yqr"></iframe>
  			</td>
  		</tr>
  	</table>  
  </body>
</html>
