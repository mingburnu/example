<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.starbooks.model.*"
    import="java.util.*"
%>

<jsp:useBean id="publisherList" class="java.util.ArrayList" scope="request" />

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Publishers</title>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css" />
</head>

<body>
    <h1>Publishers</h1>
    
    <hr />
    
    <form name="pForm" method="post" action="publisherController">

<div class="jmesa"> 
    <table border="0" cellpadding="0" cellspacing="0" class="table"  width="80%" >
        <caption>Publishers</caption> 
    
        <thead> 
            <tr class="header" > 
                <td width="4%">出版社代號</td> 
                <td>出版社名稱</td> 
            </tr> 
        </thead>
     
        <tbody class="tbody" >
<%             
    for (int i = 0 ; i < publisherList.size() ; i++)
    {    
        Publisher publisher = (Publisher) publisherList.get(i);
        String pId = publisher.getPublisherId();
        out.println((i%2==1) ? "<tr class='even'>" : "<tr class='odd'>"); 
%>    
    <td width="4%" >
        <a href="publisherController?operation=edit&publisherId=<%= pId %>">
            <%= pId %>
        </a>
    </td> 
    <td><%= publisher.getPublisherName() %></td> 
</tr>
<%
    }
%>                    
        </tbody> 
    </table> 
</div> 

<div class="jmesa">        
    <table width="80%" class="table" border="0" cellpadding="0" cellspacing="0">
        <tbody>
            <tr class="statusBar">
                <td colspan="2">
                    <input type="submit" name="operation" value="新增" 
                        onclick='document.pForm.operation.value="edit"'>
                </td>
            </tr>
        </tbody>                
    </table>
</div>

    </form>                

    <h2>Going <a href="index.html">home</a>!</h2>
</body>

</html>
