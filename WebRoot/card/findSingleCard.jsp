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
  	<form action="findSingleCard" method="post">
  		<table>
	  		<tr>
	  			<td colspan="2">
	  				查单个卡号信息
	  			</td>
	  		</tr>
  			<tr>
  				<td>
  					卡号
  				</td>
  				<td>
  					<input type="text" name="card.cardId"/>
  				</td>
  			</tr>
  			<tr>
  				<td>
  				
  				</td>
  				<td>
  					<input type="submit" value="确认"/>
  				</td>
  			</tr>
  		</table>
  	</form>
  </body>
</html>
