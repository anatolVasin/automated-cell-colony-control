<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2><a href="${pageContext.servletContext.contextPath}/home">Home</a></h2>

2 + 2 = ${2 + 2}

<form action="${pageContext.servletContext.contextPath}/add" method="get">
<input type="text" name="a" value="${a}"/> + <input type="text" name="b" value="${b}"/> 
<input type="submit" value="=" /> <c:out value="${result}" />  
</form>
</body>
</html>
