<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <!-- external -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <!-- internal css style-->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style3.css">
    <!-- External Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Oswald&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:wght@300;400;700&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<form:form  method="POST" modelAttribute="ingredient" class='container'>
    <div class="mb-3">
        <label for="name" class='form-label'>Ingredient Name</label>
        <form:input id="name" type="text" class='form-control' placeholder="Ingredient Name" path="name"/>
        <form:errors path="name" class='form-error' />
    </div>
    <div class="mb-3">
        <label for="serving"  class='form-label'>Serving Size</label>
        <form:input id="serving" class='form-control' path="servingSize" type="number" placeholder="Serving Size" />
        <form:errors path="servingSize" class='form-error' />
    </div>

    <div class='form-check form-check-inline mb-3'>
<%--    <form:radiobuttons path="measurement.id" items="${measurements}" var="measurement" itemLabel="${measurement.name}" />--%>
        <c:forEach items="${measurements}" var="measurement">
         <form:radiobutton path="measurement.id" value="${measurement.id}" label="${measurement.name}" />
         </c:forEach>
        <%--            <label class='form-label'>${measurement.name}</label>--%><%--


            --%><%--<input type="radio" id="serving"  name="measurement" value="${measurement.id}" placeholder="Serving Size" />--%><%--
        --%>
    </div>
    <div class="mb-3">
                <label for="calories"  class='form-label'>Calories per Serving</label>
                <form:input id="calories" class='form-control' path="calories" type="number" placeholder="Calories" />
                <form:errors path="calories" class='form-error' />
    </div>
    <div class="mb-3">

    <%--<!-- HARDEST THING I had to DO ALL ASSIGNMENT SO FAR 6/4/21 -6/6/21 2 FULL DAYS -->
        Why not a list of IngredientNutrients? maybe but this works if there's time try this

    --%>
         <c:forEach items="${ingredient.ingredientNutrients}" var="currentItem" varStatus="currentIN">
        <div>
            <label>${currentItem.nutrient.name} (${currentItem.nutrient.measurement.name})</label>
            <form:input class='form-control' path="ingredientNutrients[${currentIN.index}].amount" placeholder="value"/>
            <form:hidden path="ingredientNutrients[${currentIN.index}].nutrient.id" value="${currentItem.nutrient.id}" />
            <%--<form:input class='form-control' path="nutrientAmounts[${currentNutrientIndex.index}].second" placeholder="value"/>
             <form:errors path="nutrientAmounts[${currentNutrientIndex.index}].second" class='form-error' />
            <form:hidden path="nutrientAmounts[${currentNutrientIndex.index}].first" value="${currentNutrient.first.id}" />--%>
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