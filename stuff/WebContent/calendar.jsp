<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hours submission</title>
</head>
<body>
<%
	for(int i = 0; i < 7; i++){
		String name = request.getParameter( i + " day" );
		try{
		if(name != null && Integer.parseInt(name) >= 0 && Integer.parseInt(name) <= 24)
   			session.setAttribute( i+" day", name );
		else
			session.setAttribute( i+" day", "0");
		}catch(NumberFormatException e){
			session.setAttribute( i+" day", "0");
		}
	}
%>
<form name="input" action="calendar.jsp" method="post">
	<table border="3" width="850">
		<tr>
			<td colspan="7" align="center">December</td>
		</tr>
		<tr>
			<td colspan="7" align="center">The year is 2013</td>
		</tr>
		<tr>
			<td align="center">Sun</td>
			<td align="center">Mon</td>
			<td align="center">Tues</td>
			<td align="center">Wed</td>
			<td align="center">Thurs</td>
			<td align="center">Fri</td>
			<td align="center">Sat</td>
		</tr>
		<tr>
			<% for(int i = 0; i < 7; i++){%>
				<td><input type="text" name="<%=i + " day" %>" size="1" value=<%= session.getAttribute( i + " day" ) %>> hours</td>
			<%} %>
		</tr>
		<tr>
			<td colspan="7" align="right">
				<input type="submit" value="Submit" size="30"></input>
			</td>
		</tr>
	</table>
</form>
</body>
</html>