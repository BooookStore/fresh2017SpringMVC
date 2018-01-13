<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Customer</h1>
            <p>Add customer</p>
        </div>
    </div>
</section>
<section>
    <form:form method="POST" modelAttribute="newCustomer" class="form-horizontal">
        <fieldset>
            <legend>Add new product</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">name</label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="address">address</label>
                <div class="col-lg-10">
                    <form:input id="address" path="address" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="customerId">customerId</label>
                <div class="col-lg-10">
                    <form:input id="customerId" path="customerId" type="text" class="form:input-large"/>
                </div>
            </div>
        </fieldset>
        <div class="form-group">
            <div class="col-lg-offset-2 col-lg-10">
                <input type="submit" id="btnAdd" class="btn btn-primary" value="Add"/>
            </div>
        </div>
    </form:form>
</section>
</body>
</html>

