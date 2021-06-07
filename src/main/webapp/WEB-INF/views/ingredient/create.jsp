<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form  method="POST" modelAttribute="form" class='container'>
    <div class="mb-3">
        <label for="name" class='form-label'>Ingredient Name</label>
        <form:input id="name" type="text" class='form-control' placeholder="Ingredient Name" path="ingredient.name"/>
        <form:errors path="ingredient.name" class='form-error' />
    </div>
    <div class="mb-3">
        <label for="serving"  class='form-label'>Serving Size</label>
        <form:input id="serving" class='form-control' path="ingredient.servingSize" type="number" placeholder="Serving Size" />
        <form:errors path="ingredient.servingSize" class='form-error' />
    </div>

    <div class='form-check form-check-inline mb-3'>
        <c:forEach items="${measurements}" var="measurement">
            <label class='form-label'>${measurement.name}</label>
            <input type="radio" id="serving"  name="measurement" value="${measurement.id}" placeholder="Serving Size" />
            <%--<input type="radio" class='' name="form.ingredient.measurement" value="${measurement.id}" />--%>
        </c:forEach>
    </div>
    <div class="mb-3">
                <label for="calories"  class='form-label'>Calories per Serving</label>
                <form:input id="calories" class='form-control' path="ingredient.calories" type="number" placeholder="Calories" />
                <%--<input id="calories" class='form-control' name="calories" type="number" placeholder="Calories" />--%>
    </div>
    <div class="mb-3">

    <%--<!-- HARDEST THING I had to DO ALL ASSIGNMENT SO FAR 6/4/21 -6/6/21 2 FULL DAYS -->--%>
         <c:forEach items="${form.nutrientList}" var="currentNutrient" varStatus="currentNutrientIndex">
        <div>
            <%--<label  class='form-label'>${nutrient.name } (${nutrient.measurement.name}) </label>
            <form:input class='form-control' path="nutrients[${currentNutrient.index}].id" type="text" placeholder="value"/>--%>
            <label>${currentNutrient.first.name} (${currentNutrient.first.measurement.name})</label>
            <form:input class='form-control' path="nutrientAmounts[${currentNutrientIndex.index}].second" placeholder="value"/>
            <form:hidden path="nutrientAmounts[${currentNutrientIndex.index}].first" value="${currentNutrient.first.id}" />
            <%--
              <label>${currentNutrient.key} - (${currentNutrient.value.first.measurement.name})</label>
              <form:input class='form-control' path="nutrientMap[${currentNutrient.key}].second" placeholder="value"/>
              <form:hidden  path="nutrientMap[${currentNutrient.key}].first" value="${currentNutrient.value.first}"/>--%>
              <%--<form:input class='form-control' path="nutrientMap[${currentNutrient.key}].second" placeholder="value"/>
              <form:hidden  path="nutrientMap[${currentNutrient.key}].first" value="${currentNutrient.value.first}"/>--%>
             <%-- <form:input class='form-control' path="nutrientMap[${nutrientMap.key}].value" placeholder="value"/>--%>
              <%-- <form:hidden  path="nutrientMap[${nutrientMap.key}].key" value="nutrientMap[${nutrientMap.key}].key"/>--%>
              <%--<form:input path="ingredientNutrients[${currentNutrientIndex.index}].amount"/>
              <form:hidden path = "ingredientNutrients[${currentNutrientIndex.index}].nutrient.id" value = "${currentNutrient.value.key}" />
              <form:hidden path = "ingredientNutrients[${currentNutrientIndex.index}].nutrient.name" value = "${currentNutrient.key}" />--%>

        </div>
        </c:forEach>
    </div>
    <button>Submit</button>
</form:form>
<%@include file="../inc/foot.jsp" %>

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