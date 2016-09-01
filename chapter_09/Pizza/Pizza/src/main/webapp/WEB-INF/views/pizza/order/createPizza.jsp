<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored ="false"%>
<html>
    <head></head>
    <body>
        <div>
            <h2>Create Pizza</h2>
            <form:form commandName="pizza">
                <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
                <b>Size:</b><br/>
                <form:radiobutton path="size" label="Small (12 inch)" value="SMALL"/> <br/>
                <form:radiobutton path="size" label="Small (14 inch)" value="MEDIUM"/> <br/>
                <form:radiobutton path="size" label="Small (16 inch)" value="LARGE"/> <br/>
                <form:radiobutton path="size" label="Small (20 inch)" value="GINORMOUS"/> <br/>
                <br/>
                <b>Toppings:</b> <br/>

                <form:checkboxes items="${toppingList}" path="toppings" />
                <br/> <br/>
                <input type="submit" class="button" name="_eventId_addPizza" value="Continue"/>
                <input type="button" class="button" name="_eventId_cancel" value="Cancel"/>

            </form:form>
        </div>
    </body>
</html>