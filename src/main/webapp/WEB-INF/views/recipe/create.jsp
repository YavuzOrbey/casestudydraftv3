<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form  method="POST" modelAttribute="recipe" class='container'>
    <div class="mb-3">
        <label for="name" class='form-label'>Recipe Name</label>
        <form:input id="name" type="text" class='form-control' placeholder="Recipe Name" path="name"/>
        <form:errors path="name" class='form-error' />
    </div>
    <div class="mb-3">
            <label for="cuisine"  class='form-label'>Cuisine</label>
            <form:input id="cuisine" class='form-control' path="cuisine" type="text" placeholder="Cuisine" />
            <form:errors path="cuisine" class='form-error' />
    </div>
    <button onclick="()->console.log('clicked')">Add New Ingredient</button>
    <div class='new-ingredient' >
        <div class="mb-3">
                    <label  class='form-label'>Quanity</label>
                    <form:input class='form-control' path="recipe.recipeIngredients[]" type="text" placeholder="Ingredient Name" />
                    <form:errors path="recipe.recipeIngredients[]" class='form-error' />
        </div>
        <div class='form-check form-check-inline mb-3'>
            <c:forEach items="${measurements}" var="measurement">
             <form:radiobutton path="recipe.recipeIngredients[].measurement.id" value="${measurement.id}" label="${measurement.name}" />
             </c:forEach>
        </div>
    </div>
<button onclick="()->console.log('step clicked')">Add New Step</button>
    <div class='new-step' >
        <div class="mb-3">
                    <label  class='form-label'>Quanity</label>
                    <form:input class='form-control' path="recipe.recipeIngredients[]" type="text" placeholder="Ingredient Name" />
                    <form:errors path="recipe.recipeIngredients[]" class='form-error' />
        </div>
        <div class='form-check form-check-inline mb-3'>
            <c:forEach items="${measurements}" var="measurement">
             <form:radiobutton path="recipe.recipeIngredients[].measurement.id" value="${measurement.id}" label="${measurement.name}" />
             </c:forEach>
        </div>
    </div>


    <button>Submit</button>
</form:form>
<%@include file="../inc/foot.jsp" %>