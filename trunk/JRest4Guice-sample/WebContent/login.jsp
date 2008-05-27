<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.jrest4guice.core.guice.GuiceContext"%>
<%@page import="org.jrest4guice.sample.resources.SecurityResource"%>
<%@page import="java.util.List"%>
<%@page import="org.jrest4guice.core.security.Role"%>
<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.util.ArrayList"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JRest4Guice安全测试</title>
		<script language="JavaScript" type="text/javascript" src="javascript/lib/user-ext.js"></script>
		<%
			String isRelogin = request.getParameter("isRelogin");
			if(isRelogin != null && isRelogin.equalsIgnoreCase("true")){
				session.invalidate();
			}
			if(request.getUserPrincipal()!=null){
				out.println("<script type=\"text/javascript\">");
				out.println("  IFrameUtil.publishEvent(\"onLogin\",null,window.top);");
				out.println("</script>");
			}
		%>
	</head>
	<body style="background-color:#EAF6FD;">
		<form name="loginform" id="loginform" method="post" action="j_security_check">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td valign="top" style="text-align: center;">
						<div style="clear: both;height: 25px;"><div style="float: left;line-height: 25px">用户名：</div><div style="float: left;"><input name="j_username" type="text" class="hr" size="15" value="cnoss" /></div></div>
						<div style="clear: both;height: 25px;"><div style="float: left;line-height: 25px">密　码：</div><div style="float: left;"><input name="j_password" type="password" class="hr" size="15" value="123" /></div></div>
						<div style="clear: both;height: 25px;"><div style="float: left;line-height: 25px;margin-right: 45px;">&nbsp;</div><div style="float: left;"><input name="Submit" type="button" class="style7" value="登  录" onclick="loginform.submit();" style=" cursor:pointer" /></div></div>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
