<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@include file="../inc/messages.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container ">
    <div  class="p-5 ">
      <form method="POST">
        <h3>Create New Nutrient</h3>
        <div class="mb-3">
          <label for="nutrient_name" class="form-label">Nutrient Name</label>
          <input type="text" name="nutrient" class="form-control" id="nutrient_name">
        </div>
        <div class="mb-3">
            <label>Measured in: </label>
            <c:forEach items="${measurements}" var="measurement">
            <fieldset>
                <label>${measurement.name}</label>
                <input type="radio"  name="measurement" value="${measurement.id}" />
            </fieldset>
            </c:forEach>
        </div>
        <div class='row justify-content-between mb-3'>
          <div class="btn col-md-6"><a href='/nutrient'>Cancel</a> </div>
          <button type="submit" style="background: #4B042B; color: white" class="btn col-md-6">Create!</button>

        </div>
      </form>
  </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>