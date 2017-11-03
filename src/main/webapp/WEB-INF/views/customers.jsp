<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
  <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1"/>
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
  <title>Products</title>
</head>
<body>
  <section>
    <div class="jumbotron">
      <div class="container">
        <h1>Customers</h1>
        <p>All the customers in our store</p>
      </div>
    </div>
  </section>

  <section class="container">
    <div class="row">
      <c:forEach items="${customers}" var="customer">
        <div class="col-sm-6">
          <div class="thumbnail">
            <div class="caption">
              <h3>${customer.customerId}</h3>
              <p><span class="label label-success">name</span> ${customer.name}</p>
              <p><span class="label label-success">address</span> ${customer.address}</p>
              <p><span class="label label-success">no of orders made</span> ${customer.noOfOrdersMade}</p>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </section>

</body>
