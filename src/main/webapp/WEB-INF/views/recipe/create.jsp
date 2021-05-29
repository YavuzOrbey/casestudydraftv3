<%@include file="../inc/head.jsp" %>
<%@include file="../inc/nav.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1>New Recipe</h1>
<form:form  method="POST" modelattribute="recipe">
    <div class="field">
        <label for="name">Recipe</label>
        <input id="name" name="name" type="text" placeholder="Recipe Name" />
    </div>
    <button>Add New Ingredient</button>
    <div class="add-new-ingredient">
        <label>Name</label>
        <input name="ingredient1" type="text" placeholder="Ingredient Name />
    </div>
    <div class="add-new-ingredient">
        <label>Name</label>
        <input name="ingredient2" type="text" placeholder="Ingredient Name />
    </div>
    <div class="add-new-ingredient">
        <label>Name</label>
        <input name="ingredient3" type="text" placeholder="Ingredient Name />
    </div>
    <h3>Steps</h3>
    <button>Add New Step</button>
        <div class="add-new-step">
            <label>Name</label>
            <input name="step1" type="text" placeholder="Step 1" />
        </div>
        <div class="add-new-step">
            <label>Name</label>
            <input name="step2" type="text" placeholder="Step 2" />
        </div>
        <div class="add-new-step">
            <label>Name</label>
            <input name="step3" type="text" placeholder="Step 3" />
        </div>
    <div class="btn">
        <input id="sub" name="submit" type="submit" value="Submit Name" />
    </div>
</form:form>
</body>
</html>