<%@ 
    page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<jsp:useBean id="publisher" class="com.starbooks.model.Publisher" scope="request" />

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Publisher</title>
    <link rel="stylesheet" type="text/css" href="css/jmesa.css"> 
</head>

<body>
    <h1>Publisher</h1>

    <hr />    

    <form name="pForm" method="post" action="publisherController">
        <div class="jmesa">        
            <table width="80%" class="table" border="0" cellpadding="0" cellspacing="0">
                <caption>Publisher</caption>
                <thead>
                    <tr class="header">              
                        <td width="4%" align="left">出版社代號</td>
                        <td align="left">出版社名稱</td>
                    </tr>
                </thead>
                <tbody class="tbody">           
                    <tr class="odd">
                        <td>
                            <input type="text" name="publisherId" size="2"
                                value="<%= publisher.getPublisherId() %>">
                        </td>
                        <td>
                            <input type="text" name="publisherName" size="50"
                                value="<%= publisher.getPublisherName() %>">
                        </td>
                    </tr>
                </tbody>
                <tbody>
                    <tr class="statusBar">
                        <td>
                            <input type="submit" name="insert" value="新增" 
                                onclick='document.pForm.operation.value="insert"'>
                        </td>
                        <td>
                            <input type="submit" name="update" value="修改"
                                onclick='document.pForm.operation.value="update"'>
                            <span>　　　　</span>
                            <input type="submit" name="delete" value="刪除"
                                onclick='document.pForm.operation.value="delete"'>
                        </td>　　        
                    </tr>
                </tbody>                
            </table>
        </div>        

        <input type="hidden" name="operation">
    </form>

    <h2>Going <a href="publisherController?operation=list">Publishers</a>!</h2>
</body>

</html>
