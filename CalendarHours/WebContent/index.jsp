<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>How long did you work?</title>
</head>
<body>
Hello! The time is now <%= new Date() %><br />
Exercise! <br />
The OS is <%= System.getProperty("os.name").toLowerCase()%><br />
The java version is <%=System.getProperty("java.version").toLowerCase() %><br />
The java home is <%=System.getProperty("java.home").toLowerCase() %><br />
The user name is <%=System.getProperty("user.name").toLowerCase() %><br />
The user home is <%=System.getProperty("user.home").toLowerCase() %><br />
The user directory is <%=System.getProperty("user.dir").toLowerCase() %><br />

<% 
	String output = "Hello! The time is now written by a sriptlet. It is ...";
	Date date = new Date();
	out.println(output);
	out.println(date);
	out.println("<BR>Your machine's address is ");
	out.println(request.getRemoteHost());
%>

<TABLE BORDER=2>
<%
	int n = 5;
    for ( int i = 0; i < n; i++ ) {
        %>
        <TR>
        <TD>Number</TD>
        <TD><%= i+1 %></TD>
        </TR>
        <%
    }
%>
</TABLE>

<%
	boolean hello = false;
    if ( hello ) {
        %>
        <P>Hello, world
        <%
    } else {
        %>
        <P>Goodbye, world
        <%
    }
%>
</body>
</html>