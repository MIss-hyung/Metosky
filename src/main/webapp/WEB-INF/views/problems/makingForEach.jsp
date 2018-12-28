<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<option value="">--select--</option>
<c:forEach items="${sourcelist}" var="row">
	<option value="${row}"> ${row} </option>
</c:forEach>