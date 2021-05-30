<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form  method="POST" modelattribute="ingredient">
    <div class="field">
        <label for="name">Ingredient Name</label>
        <input id="name" name="name" type="text" placeholder="Ingredient Name" />
    </div>
    <div class="field">
    <label for="serving">Serving Size</label>
    <input id="serving" name="servingSize" type="number" placeholder="Serving Size" />
        <c:forEach items="${measurements}" var="measurement">
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
        <fieldset>
            <label>${measurement}</label>
            <input type="radio"  name="measurement" value="${measurement}" />
        </fieldset>
        </c:forEach>
    </div>
    <c:forEach items="${nutrients}" var="nutrient">
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
    <div class="field">
        <label>${nutrient}</label>
        <input name="${nutrient}" type="number" placeholder="${nutrient} />
    </div>
    </c:forEach>
</form:form>
</body>
</html>