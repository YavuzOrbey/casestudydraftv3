<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form  method="POST" modelAttribute="ingredient" class='container'>
    <div class="mb-3">
        <label for="name" class='form-label'>Ingredient Name</label>
        <input id="name" name="name" type="text" class='form-control' placeholder="Ingredient Name" />
    </div>
    <div class="mb-3">
        <label for="serving"  class='form-label'>Serving Size</label>
        <input id="serving" class='form-control' name="servingSize" type="number" placeholder="Serving Size" />
    </div>
    <div class='form-check form-check-inline'>
        <c:forEach items="${measurements}" var="measurement">
            <label class='form-label'>${measurement.name}</label>
            <input type="radio" class='form-control' name="measurement" value="${measurement.id}" />
        </c:forEach>
    </div>
    <div class="mb-3">
        <c:forEach items="${nutrients}" var="nutrient" varStatus="currentNutrient">
        <div>
            <label  class='form-label'>${nutrient.name } (${nutrient.measurement.name}) </label>
            <form:input class='form-control' path="nutrients[${currentNutrient.index}].id" type="text" placeholder="value"/>
        </div>
        </c:forEach>
    </div>
    <button>Submit</button>
</form:form>
</body>
</html>

 <%--<label for="serving">Serving Size</label>
        <input id="serving" name="servingSize" type="number" placeholder="Serving Size" />
        <label>Count</label>
        <input type="radio"  name="measurement" value="count">
        <label>Grams</label>
        <input type="radio" name="measurement" value="g">
        <label>Tsp</label>
        <input type="radio"  name="measurement" value="tsp">
        <label>Tbsp</label>
        <input type="radio"  name="measurement" value="tbsp">
        <label>Cups</label>
        <input type="radio"  name="measurement" value="cups">
        <label>Other</label>
        <input type="radio" name="measurement" value="other">--%>


         <%-- <div class="field">
                <label for="calories">Calories Per Serving</label>
                <input id="calories" name="calories" type="number" placeholder="Serving Size" />
            </div>
            <hr>
            <div class="field">
                <label for="total_fat">Total Fat (g)</label>
                <input id="total_fat" name="total_fat" type="number" placeholder="Total Fat" step=".5"/>
            </div>
            <div class="field">
                <label for="saturated_fat">Saturated Fat (g)</label>
                <input id="saturated_fat" name="saturated_fat" type="number" placeholder="Saturated Fat" step=".5"/>
            </div>
            <div class="field">
                <label for="trans_fat">Trans Fat</label>
                <input id="trans_fat" name="trans_fat" type="number" placeholder="Trans Fat" step=".5"/>
            </div>

            <div class="field">
                <label for="cholesterol">Cholesterol (mg)</label>
                <input id="cholesterol" name="cholesterol" type="number" placeholder="Cholesterol" step=".5" />
            </div>

            <div class="field">
                <label for="sodium">Sodium (mg)</label>
                <input id="sodium" name="sodium" type="number" placeholder="Sodium" step=".5" />
            </div>

            <div class="field">
                <label for="total_carbs">Total Carbohydrates (g)</label>
                <input id="total_carbs" name="total_carbs" type="number" placeholder="Total Carbs" step=".5"/>
            </div>
            <div class="field">
                <label for="fiber">Dietary Fiber (g)</label>
                <input id="fiber" name="fiber" type="number" placeholder="Dietary Fiber" step=".5"/>
            </div>
            <div class="field">
                <label for="sugar">Total Sugars (g)</label>
                <input id="sugar" name="sugar" type="number" placeholder="Total Sugars" step=".5"/>
            </div>
            <div class="field">
                <label for="protein">Protein (g)</label>
                <input id="protein" name="protein" type="number" placeholder="Protein" step=".5"/>
            </div>
            <div class="btn">
                <input id="sub" name="submit" type="submit" value="Submit Name" />
            </div>--%>