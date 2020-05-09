<%@page import="com.tcs.bancs.core.JNDILookup"%>
<%@page import="java.sql.*"%>
<%String name = (String)session.getAttribute("firstname");


if(name==null)
{
    response.sendRedirect("index.jsp");
}

else
{
	int ISAdmin = (int)session.getAttribute("ISAdmin");
	String username = (String)session.getAttribute("username");
	
	try
	{
		Connection connection = JNDILookup.connectionManager();
		Statement statement = connection.createStatement();
		
		String updateQuery = "update Q_USER set CONNECTIONSTAT = 1 where USERID = '" + username + "'";
		System.out.println("Update Query " + updateQuery);
		int count = statement.executeUpdate(updateQuery);
	}
	catch(Exception e)
    {
    	
    }
	if(ISAdmin == 1)
	{
		response.sendRedirect("register.jsp");
	}
%>
<div id="container">
<link href="common/css/css.css" rel="stylesheet" type="text/css">
<jsp:include page="home-header.jsp"></jsp:include>

<div id="content-container">
<div id="content"><center>
<marquee><h2 style="color: red;"><i>- Welcome <%=name%> -</i></h2></marquee><br/><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img alt="home"  src="common/images/home.jpg" width="550" height="400px"/></center>
</div>

<div id="aside">
<p>* Online banking is the practice of making bank transactions or paying bills via the Internet.
<br/><br/>* Banking online allows a customer to make deposits, withdrawals, transfers with the click of a mouse.
<br/><br/>* Online banking also eliminates paper waste, which is a plus not only for those who have to handle all the paper work, but also for the environment.
<br/><br/>* Security is always an issue with Internet transactions. Although information is encrypted , and the chances of an account being hacked are slim, it happen.
</p>
</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</div>
<%}%>