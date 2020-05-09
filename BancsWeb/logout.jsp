<%@page import="com.tcs.bancs.core.JNDILookup"%>
<%@page import="java.sql.*"%>
<%String name=(String)session.getAttribute("firstname");

if(name==null)
{
    response.sendRedirect("index.jsp");
}
else
{
	String username = (String)session.getAttribute("username");
	
	try
	{
		Connection connection = JNDILookup.connectionManager();
		Statement statement = connection.createStatement();
		
		String updateQuery = "update Q_USER set CONNECTIONSTAT = 0 where USERID = '" + username + "'";
		System.out.println("Update Query " + updateQuery);
		int count = statement.executeUpdate(updateQuery);
	}
	catch(Exception e)
    {
    	
    }
%>
<div id="container">
<link href="common/css/css.css" rel="stylesheet" type="text/css"/>
 
 <%session.invalidate();%>
    
<jsp:include page="header.jsp"></jsp:include>

<div id="content-container">
<div id="content">
<center><marquee><h2 style="color: red;"><i>- Welcome Guest -</i></h2></marquee><br/><br/>
<h2 style="color: green;">You are logged out!!</h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img src="common/images/index.jpg" width="550" height="400px"/></center>
</div>

<div id="aside">
<h2>Login :-</h2>
<jsp:include page="login.jsp"></jsp:include>
</div>

</div>
<jsp:include page="footer.jsp"></jsp:include>

</div>
<%}%>