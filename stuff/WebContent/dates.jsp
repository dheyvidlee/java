<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="utility.dateUtility" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	dateUtility dateCal = new dateUtility(true);  
	%>
	<TABLE BORDER=3 CELLSPACING=3 CELLPADDING=3> 
	<TR>
		<TD COLSPAN="7" ALIGN=center>
			<B><%=dateCal.getStringMonth() %></B>
		</TD> 
	</TR>
	<TR> 
		<TD ALIGN=center>Sun</TD>
		<TD ALIGN=center>Mon</TD>
		<TD ALIGN=center>Tue</TD>
		<TD ALIGN=center>Wed</TD>
		<TD ALIGN=center>Thu</TD>
		<TD ALIGN=center>Fri</TD>
		<TD ALIGN=center>Sat</TD>
	</TR>
	<% int maxDates = dateCal.getDaysInMonth();

		int maxDatesCounter = maxDates;
		int previousMonthMax = dateCal.getPreviousMonthMax();
		int startDate = dateCal.getFirstDay();
		boolean start = false;
		int daysInAWeek = 7;
		int output = 1;
		out.println("<TR>");
		for(int count = 1;count <= daysInAWeek; count++){
			String text = "";
			if(start){
				text = "<TD ALIGN=center>" + output + "</TD>";
				output++;
			}
			else{
				if(count == startDate){
					text="<TD ALIGN=center>" + output + "</TD>";
					start = true;
					output++;
				}
				else
					text = "<TD ALIGN=center>" + (previousMonthMax - startDate + count + 1) + "</TD>";
			}
			out.println(text);
		}
		out.println("</TR>");
		maxDates-=output;
		
		for(int i = 0; i < (maxDates/7); i++){
			out.println("<TR>");
			for(int j = 0; j < daysInAWeek;j++){
				out.println("<TD ALIGN=center>" + output + "</TD>");
				output++;
			}
			out.println("</TR>");
		}
		maxDates -= output;

		if(maxDates != 0){
			out.println("<TR>");
			int newMonthCounter = 1;
			for(int i = 0; i < daysInAWeek; i++){
				if(output > maxDatesCounter){
					out.println("<TD ALIGN=center>" + newMonthCounter + "</TD>");
					newMonthCounter++;
				}
				else{
					out.println("<TD ALIGN=center>" + output + "</TD>");
					output++;
				}
			}
			out.println("</TR>");
		}
	%>
	</TABLE>
</body>
</html>