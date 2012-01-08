<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Info</title>
</head>
<body>
     <h1>HTTP Request Headers Received</h1>
      <table border="1" cellpadding="4" cellspacing="0">
      <%
         Enumeration names = request.getHeaderNames();
         while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            Enumeration values = request.getHeaders(name);
            String value = "";
            while (values.hasMoreElements()) {
            	value += (String) values.nextElement()+"<br />";
            }
      %>
         <tr><td><%= name %></td><td><%= value %></td></tr>
      <%
         }
      %>
      </table>

</body>
</html>
