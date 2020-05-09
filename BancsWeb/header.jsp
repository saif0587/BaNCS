<%String name=(String)session.getAttribute("firstname");%>

<div id="header">
<img src="common/images/logo.jpg"/>

</div>

	<div id="navigation">
		<ul>
                    
			<li><a href="index.jsp">Home</a></li>
						<%
                        if(name!=null)
                        {%>
                        <li> <a href="home.jsp">My Account</a></li>
                        <%}%>
                        
                       	
                        
			<li><a href="about.jsp">About</a></li>
			<li><a href="contact.jsp">Contact</a></li>
                        <%
                        if(name!=null)
                        {%>
                        <li> <a href="logout.jsp">Logout</a></li>
                        <%}%>
		</ul>
    
        
            	</div>
