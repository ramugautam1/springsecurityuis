<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Edit Form</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div>
    <form action="user_update" method="post">
        <div>
            <label>ID</label> <input type="text" name="id" readonly="readonly" value="${user.id}">
        </div>
        <div>
            <label>User Name</label> <input type="text" name="userName" value="${user.userName}">
        </div>
        <div>
            <label>Password</label> <input type="password" name="password" value="${user.password}">
        </div>
        <div>
            <label>Email</label> <input type="email" name="email" value="${user.email}">
        </div>
        <div>
            <label>Mobile No</label> <input type="number" name="mobileNo" value="${user.mobileNo}">
        </div>


        <div>
            <label>DOB</label> <input type="date" name="dob" value="${user.dob}">
        </div>


        <div>
            <label>Gender</label> <input type="radio" name="gender" value="Male"${user.gender=='Male'?'checked':'' }>Male
            <input type="radio" name="gender" value="Female"${user.gender=='Female'?'checked':'' }>Female
        </div>
        <div>
            <label>Hobbies</label>
            <input type="checkbox" name="hobbies" value="Reading"
                   <c:if test="${fn:contains(user.hobbies,'Reading')}">checked</c:if>>Reading
            <input type="checkbox" name="hobbies" value="Playing"
                   <c:if test="${fn:contains(user.hobbies,'Playing')}">checked</c:if>>Playing
        </div>
        <div>
            <label>Nationality</label> <select name="nationality">
            <option value="Nepalese" ${user.nationality=='Nepalese'?'selected':'' }>Nepalese</option>
            <option value="American" ${user.nationality=='American'?'selected':'' }>American</option>
            <option value="Chinese" ${user.nationality=='Chinese'?'selected':'' }>Chinese</option>
        </select>
        </div>

        <div>
            <label style="font-weight: bold;">Address:</label>
            <div>
                <label>City Name</label> <input type="text" name="address.cityName" value="${user.address.cityName}">
            </div>
            <div>
                <label>Country Name</label> <input type="text"
                                                   name="address.countryName" value="${user.address.countryName}">
            </div>


        </div>

        <div>
            <label>Comments</label>
            <textarea rows="5" cols="25" name="comments"></textarea>
        </div>


        <div>
            <input type="submit" value="Submit">
        </div>


    </form>
</div>
</body>
</html>