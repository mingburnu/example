<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<jsp:useBean id="book" class="com.starbooks.model.Book" scope="request" />

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Book</title>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css" />
</head>

<body>
    <form name="bForm" method="post" action="bookController">
    
        <div class="jmesa">
            <h1>Book</h1>        
            <table width="95%" class="table" border="0" cellpadding="0" cellspacing="0">
                <thead>
                    <tr class="header">              
                        <td width="4%" align="left">Id</td>
                        <td align="left">ISBN</td>
                        <td width="80%" align="left">Title</td>
                        <td align="left">PubId</td>
                        <td align="left">ReleaseDate</td>
                        <td align="left">ListPrice</td>
                    </tr>
                </thead>
                <tbody class="tbody">           
                    <tr class="odd">
                        <td>
                            <input type="text" name="bookId" size="4"
                                value="<%= book.getBookId() %>">
                        </td>
                        <td>
                            <input type="text" name="isbn" size="10"
                                value="<%= book.getIsbn() %>">
                        </td>
                        <td>
                            <input type="text" name="title" maxlength="100" size="80"
                                value="<%= book.getTitle() %>">
                        </td>
                        <td>
                            <input type="text" name="pubId" size="2"
                                value="<%= book.getPubId() %>">
                        </td>
                        <td>
                            <input type="text" name="releaseDate" size="20"
                                value="<%= book.getReleaseDate() %>">
                        </td>
                        <td>
                            <input type="text" name="listPrice" size="6"
                                value="<%= book.getListPrice() %>">
                        </td>
                    </tr>
                </tbody>
                <tbody>
                    <tr class="statusBar">
                        <td colspan="7">
                            <input type="submit" name="insert" value="新增" 
                                onclick='document.bForm.operation.value="insert"'>
                            <span>　　　　</span>                            
                            <input type="submit" name="update" value="修改"
                                onclick='document.bForm.operation.value="update"'>
                            <span>　　　　</span>
                            <input type="submit" name="delete" value="刪除"
                                onclick='document.bForm.operation.value="delete"'>
                            <span>　　　　</span>
                            <input type="submit" name="pdf" value="PDF"
                                onclick='document.bForm.operation.value="pdf"'>                        
                        </td>　　        
                    </tr>
                </tbody>                
            </table>
        </div>        

        <input type="hidden" name="operation">
    </form>

    <h2>Going <a href="bookController?operation=list">Books</a>!</h2>
</body>

</html>
