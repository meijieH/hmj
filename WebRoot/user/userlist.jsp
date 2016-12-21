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
    
    <title>My JSP 'userlist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <s:form action="EuserAction_delete.aspx" target="Div_URL" method="post" name="frmOp" theme="simple">
		<table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td height="50px">
					<table width="100%" height="100%" align="center" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td>&nbsp;</td>
							<td width="100px" align="center" valign="middle" onclick="getAjax('/EuserAction_preAdd.aspx', '_Ajaxspace')">增加</td>
							<td width="100px" align="center" valign="middle" onclick="frmOp.submit()">删除</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" align="center" border="1" cellpadding="0" cellspacing="0">
						<tr>
							<td width="30" align="center">&nbsp;</td>
							<td height="30px" align="center" valign="middle">序号</td>
							<td height="30px" align="center" valign="middle">用户名</td>
							<td height="30px" align="center" valign="middle">密码</td>
							<td width="60" align="center" valign="middle">编辑</td>
						</tr>
						<s:if test="#request.C_INFO_LIST">
						<s:iterator value="#request.C_INFO_LIST" status="struts">
						<tr>
							<td align="center"><input type="checkbox" name="ids" value="<s:property value='id'/>"></td>
							<td height="30px" align="center" valign="middle"><s:property value="#struts.index + 1"/></td>
							<td height="30px" align="center" valign="middle"><s:property value="user"/></td>
							<td height="30px" align="center" valign="middle"><s:property value="password"/></td>
							<td width="60" align="center" valign="middle" onclick="getAjax('/EuserAction_preUpdate.aspx?id=<s:property value="id"/>', '_Ajaxspace')">修改</td>
						</tr>
						</s:iterator>
						</s:if>
					</table>
				</td>
			</tr>
			<tr>
				<td align="right"><s:property value="#request.C_PAGE_INFO" escape="false" /></td>
			</tr>
						
		</table>
	</s:form>

  </body>
</html>
