<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<form action="findSingleCard" method="post">
  		<table width="100%">
  			<tr width="100%">
  				<td>
  					卡号
  				</td>
  				<td>
  					姓名
  				</td>
  				<td>
  					状态
  				</td>
  				<td>
  					余额
  				</td>
  				<td>
  					积分
  				</td>
  				<td>
  					开卡日期
  				</td>
  				<td>
  					最后消费日期
  				</td>
  			</tr width="100%">
  			<c:forEach items="${cardList}" var="cd">
	  			<tr>
	  				<td>
  						${cd.cardId}
	  				</td>
	  				<td>
	  					${cd.customerName}
	  				</td>
	  				<td>
	  					${cd.cardStatus.cardValue}
	  				</td>
	  				<td>
	  					${cd.balance}
	  				</td>
	  				<td>
	  					${cd.integral}
	  				</td>
	  				<td>
	  					${cd.createDate}
	  				</td>
	  				<td>
	  					${cd.endDate}
	  				</td>
	  			</tr>
  			</c:forEach>
  		</table>
  	</form>
  </body>
</html>
