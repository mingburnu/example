<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.starbooks.model.*"
    import="java.util.*"
%>

<jsp:useBean id="bookList" class="java.util.ArrayList" scope="request" />

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css" />
</head>

<body>
    <form name="bForm" method="post" action="bookController">

<div class="jmesa"> 
    <table width="95%" class="table" border="0" cellpadding="0" cellspacing="0">
        <caption>Books</caption> 
    
        <thead> 
            <tr class="header" > 
                <td width="4%" align="left">Id</td>
                <td align="left">ISBN</td>
                <td width="80%" align="left">Title</td>
                <td align="left">PubId</td>
                <td align="left">ReleaseDate</td>
                <td align="left">ListPrice</td>
            </tr> 
        </thead>
     
        <tbody class="tbody" >
<%             
    for (int i = 0 ; i < bookList.size() ; i++)
    {    
        Book book = (Book) bookList.get(i);
        int bId = book.getBookId();
        out.println((i%2==1) ? "<tr class='even'>" : "<tr class='odd'>"); 
%>    
    <td width="4%">
        <a href="bookController?operation=edit&bookId=<%= bId %>">
            <%= bId %>
        </a>
    </td> 
    <td><%= book.getIsbn() %></td> 
    <td width="65%"><%= book.getTitle() %></td> 
    <td><%= book.getPubId() %></td> 
    <td width="10%"><%= book.getReleaseDate() %></td> 
    <td><%= book.getListPrice() %></td> 
</tr>
<%
    }
%>                    
        </tbody> 
    </table> 
</div> 

        <div class="jmesa">        
            <table width="95%" class="table" border="0" cellpadding="0" cellspacing="0">
                <tbody>
                     <tr class="statusBar">
                        <td colspan="6">
                            <input type="submit" name="edit" value="新增" 
                                onclick='document.bForm.operation.value="edit"'>
                            <span>　　　　</span>
                            <input type="submit" name="poi" value="POI"
                                onclick='document.bForm.operation.value="poi"'>
                            <span>　　　　</span>
                            <input type="submit" name="jexcelapi"
                                value="JExcelAPI" onclick=
                                'document.bForm.operation.value="jexcelapi"'>                        
                        </td>
                    </tr>
                </tbody>                
            </table>
        </div>

        <input type="hidden" name="operation">
    </form>                

    <h2>Going <a href="index.html">home</a>!</h2>
</body>

</html>
