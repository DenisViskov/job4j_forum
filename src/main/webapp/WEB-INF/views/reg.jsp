<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vda-it
  Date: 26.10.2020
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.js"
            integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body class="container">
<form id="form">
    <div class="form-group">
        <label for="login">Login:</label>
        <input type="text" class="form-control" name="name" id="login" required aria-describedby="nameHelp"
               placeholder="Enter name">
        <small id="nameHelp" class="form-text text-muted">Enter please your name</small>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" required class="form-control" name="password" id="password" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="confirmPassword">Confirm Password</label>
        <input type="password" required class="form-control" id="confirmPassword" placeholder="Confirm">
    </div>
    <input type="submit" class="btn btn-primary"/>
</form>
</body>
</html>

<script>
    $('#form').submit(function (e) {
        e.preventDefault()
        if (validate()) {
            const name = document.getElementById('login').value
            const password = document.getElementById('password').value
            $.ajax({
                type: 'POST',
                url: "<c:url value='/createUser'/>",
                data: {
                    name: name,
                    password: password
                },
                success: function (data) {
                    console.log('done');
                    document.location.href = '/'
                }
            })
        }
    })

    function validate() {
        const password = document.getElementById('password').value
        const confirm = document.getElementById('confirmPassword').value
        if (password != confirm) {
            alert('passwords not same')
            return false
        }
        return true
    }
</script>