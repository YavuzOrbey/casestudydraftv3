<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@include file="../inc/messages.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <div class="container d-flex justify-content-center ">
    <div  class="p-5 shadow">
      <form:form method="POST" modelAttribute="measurement">
        <h3>Edit Measurement</h3>
        <div class="mb-3">
          <label for="name" class="form-label">Measurement Name</label>
          <form:input type="text" path="name" class="form-control" id="measurement_name" value="${measurement.name}"/>
          <form:errors path="name" class='error'/>
        </div>
        <div class='row justify-content-between mb-3'>
          <div class="btn col-md-6"><a href='/measurement'>Cancel</a> </div>
          <button type="submit" style="background: #4B042B; color: white" class="btn col-md-6">Update!</button>

        </div>
      </form:form>
  </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>