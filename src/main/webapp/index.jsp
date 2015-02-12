<%-- 
    Document   : index
    Created on : Feb 10, 2015, 12:53:22 PM
    Author     : eennis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Hotel Lab</title>
    <link href="content/bootstrap_cerulean.min.css" rel="stylesheet" />
    <link href="content/hotel_lab.css" rel="stylesheet" type="text/css"/>  
</head>
<body>
    
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="/HotelLabWeb/hotelweb" class="pad-left-sm navbar-brand">Hotel Lab (Web)</a>
            </div>
        </div>
    </nav>
    
    <div class="container">
        <div class="row">

            <div class="col-sm-4">
                <table class="table">
                    <th><h1>Hotels</h1></th>
                    <tr>
                        <div class="form-group">
                            <td>Hotel Id</td>
                            <td>Name</td>
                        </div>
                    </tr>
                    <% int i = 0; %>
                    <c:forEach var="hotel" items="${hotels}">
                    <tr>
                        <div class="form-group">
                            <td class="small_td">${hotel.hotelId}</td>
                            <td class="selectable notselected" id="${hotel.hotelId}" arraySpace="<%= i++ %>">${hotel.hotelName}</td>
                        </div>
                    </tr>
                    </c:forEach>
                    
                    
                </table>
            </div>
                    
            <div class="col-sm-2"></div>
            
            <div class="col-lg-6">

            <form id="hotelForm" class="hotelselected" action="${resetAction}" method="POST">
                <table class="table">
                    <th><h1>Hotel Info</h1></th>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="name">Hotel Name:</label></td>
                            <td><input type="text" name="name" id="name" value="${hotelName}" class="required"/></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="address">Address:</label></td>
                            <td><input type="text" name="address" id="address" value="${address}" class="required"/></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="city">City:</label></td>
                            <td><input type="text" name="city" id="city" value="${city}" class="required"/></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="state">State:</label></td>
                            <td><input type="text" name="state" id="state" value="${state}" class="required"/></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="postal">Postal Code:</label></td>
                            <td><input type="text" name="postal" id="postal" value="${postal}" class="required"/></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="notes">Notes:</label></td>
                            <td><input type="textarea" name="notes" id="notes" value="${notes}" class=""/></td>
                        </div>
                    </tr>
                    
                </table>
                <button type="button" class="btn btn-primary" id="insertBtn">Create New</button>
                <button type="button" class="btn btn-primary" id="updateBtn">Update</button>
                <button type="button" class="btn btn-danger" id="deleteBtn">Delete</button>
                <button type="button" class="btn btn-primary" id="clearBtn">Clear Form</button>
                
                <br><br>
                <p class="hidden" id="error">Hmm</p>    
            </form>
            
            </div>
        </div>
    </div>

    <script src="scripts/jquery-1.10.2.min.js"></script>
    <script src="scripts/jquery.validate.min.js"></script>
    <script src="scripts/hotel_lab_web.js" type="text/javascript"></script>
    <script src="scripts/bootstrap.min.js"></script>
    
</body>
</html>
