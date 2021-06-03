<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
  <div class="container d-flex justify-content-center ">
        <h1>Admin View</h1>
        <button id="addEntityBtn">Add New Measurement</button>
        <table class='table'>
            <thead>
                <tr>
                    <th>Measurement</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td><a href="showRecipe.html">Measurement 1</td>
                    <td><button onclick="alert('You deleted this entity....Well not really but you will soon! Under Construction!')"><i class="fas fa-trash"></i></button></td>
                    <td><button onclick="alert('You deleted this entity....Well not really but you will soon! Under Construction!')"><i class="fas fa-trash"></i></button></td>
                </tr>
                <tr>
                    <td>Nutrient 2</td>
                    <td><button onclick="alert('You deleted this entity....Well not really but you will soon! Under Construction!')"><i class="fas fa-trash"></i></button></td>
                	<td><button onclick="alert('You deleted this entity....Well not really but you will soon! Under Construction!')"><i class="fas fa-trash"></i></button></td>
                </tr>

            </tbody>
        </table>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</body>
</html>