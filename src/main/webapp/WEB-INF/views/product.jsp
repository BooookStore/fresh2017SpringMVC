<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
  <title>Products</title>
</head>
<body>
<section>
  <div class="jumbotron">
    <div class="container">
      <h1>Products</h1>
      <p>All the available products in our store</p>
    </div>
  </div>
</section>

<section class="container">
  <div class="row">
    <div class="col-sm-6 col-md-6">
      <img src="<c:url value="/img/${product.productId}.jpg"/>" style="width: 100%"/>
    </div>
    <div class="col-sm-6 col-md-6">
      <div class="thumbnail">
        <div class="caption">
          <h3>${product.name}</h3>
          <p>${product.description}</p>
          <p>
            <strong>Item Code : </strong><span>${product.productId}</span>
          </p>
          <p>${product.unitPrice}</p>
          <p>Available ${product.unitsInStock} units in stock</p>
          <p>
            <a href="<spring:url value="/market/products" /> " class="btn btn-default">
              <span class="glyphicon-hand-left glyphicon"></span>
            </a>
          </p>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>
