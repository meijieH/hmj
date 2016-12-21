<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="/css/style.css" type="text/css" rel="stylesheet">
	<script language="JavaScript" src="/js/ajax.js" type="text/javascript"></script>
	<script language="JavaScript" src="/js/common.js" type="text/javascript"></script>
	
  </head>
  
  <body>
    <table width="1000px" align="center" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="200px" valign="top">
				<table width="100%" align="center" border="1" cellpadding="2" cellspacing="2">
					<tr>
						<td height="50px" align="center" valign="middle" onclick="lasturl='/EuserAction_getAll.aspx';getAjax('/EuserAction_getAll.aspx', '_Ajaxspace')">用户管理</td>
					</tr>
				</table>
			</td>
			<td valign="top">
				<div id="_Ajaxspace"></div>
			</td>
		</tr>
	</table>
	<div style="display:none">
		<iframe id="Div_URL" name="Div_URL" src="#"></iframe>
	</div>


  </body>
</html>
