<%-- 
    Document   : add
    Created on : 2020-6-3, 21:15:07
    Author     : Xuanhao Zhou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add book</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        
    </head>

    <body>
        <%   
            
            String existErr = (String) session.getAttribute("existErr");
            String addMess = (String) session.getAttribute("addSucc");

        %>
        
        
        
    <div class="container">
        
        
        <h1>Add new product</h1>
        
        
        <form action="AddServlet" method="post">
            <div class="form-row">
             <div class="form-group col">
                <label for="productID">Product ID<span class="text-danger"> *</span></label>
                <small class="text-danger"><%=(existErr != null ? existErr : "")%></small>
                <input type="text" name="productID" class="form-control">
                <small class="text-muted">The product ID must be number</small>
             </div> 
                
            <div class="form-group col">
                <label for="productName">Product Name</label>
                <input type="text" name="productName" class="form-control">
            </div>
                
            <div class="form-group col">
                <label for="brandName">Brand Name</label>
                <input type="text" name="brandName" class="form-control">
            </div>
            
            </div>
                
               
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" name="description" class="form-control">
            </div>
                
            <div  class="form-row"> 
            <div class="form-group col">
                <label for="costPerUnit">Cost per unit</label>
                <input type="text" name="costPerUnit" class="form-control">
            </div>
                
            <div class="form-group col">
                <label for="stock">Stock:</label>
                <input type="text" name="stock" class="form-control">
            </div>
            </div>
             
            <div class="form-row">
                <div class="form-group col">
                        <a href="view.jsp"><button type="button" class="btn btn-secondary btn-lg btn-block">Back</button></a>
                </div>
                
                <div class="form-group col">
                    <input class="btn btn-primary btn-lg btn-block" type="submit" value="Save">
                </div>
            </div>
                      
        </form>
    
    </div>
    </body>
</html>
