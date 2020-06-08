<%-- 
    Document   : edit
    Created on : 2020-6-3, 21:18:52
    Author     : Xuanhao Zhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update product</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    </head>

    <body>
        <% 
                String updateMessage = (String) session.getAttribute("updateMess");
        %>
        
    <div class="container">
        
        <h1>Update product <span class="massage"><%=(updateMessage != null ? updateMessage : "") %></h1>
       
        
        <form action="UpdateServlet" method="post">

             <div class="form-group">
                <label for="productID">Product ID</label>
                <div class="col-sm-10">
                    <input type="text" readonly class="form-control-plaintext" value="${editproduct.productID}">
                </div>
                <small class="text-muted">This product ID can not be change</small>
             </div> 
                
            <div class="form-group">
                <label for="productName">Product Name</label>
                <input type="text" name="proName" value="${editproduct.productName}" class="form-control">
            </div>
                
            <div class="form-group">
                <label for="brandName">Brand Name</label>
                <input type="text" name="bName" value="${editproduct.brandName}" class="form-control">
            </div>
            
                
               
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="desc" value="${editproduct.description}" class="form-control">
            </div>
                

            <div class="form-group">
                <label for="costPerUnit">Cost per unit</label>
                <input type="text" name="cpu" value="${editproduct.costPerUnit}" class="form-control">
            </div>
                
            <div class="form-group">
                <label for="stock">Stock:</label>
                <input type="text" name="s" value="${editproduct.stock}" class="form-control">
            </div>
             
            <div class="form-row">
                <div class="form-group col">
                        <a href="viewproduct.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                </div>
                
                <div class="form-group col">
                    <input class="btn btn-primary btn-lg btn-block" type="submit" value="Update">
                </div>
            </div>
            
        </form>
    </div>
    
    </body>
</html>
