<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
<tr>
<th style="text-align:center;">SUBJECT</th>
			<th style="text-align:center;">BOOK_SOURCE</th>
			<th style="text-align:center;">CHAPTER</th>
			<th style="text-align:center;">SCORE</th>
			<th style="text-align:center; width:90px;">COUNT</th>
</tr>
<c:forEach var="eachP" items="${eachProblem}">
<tr>
<td>${eachP.p_subject}</td>
<td>${eachP.p_source}</td>
<td>${eachP.p_unit}</td>
<td>${eachP.p_difficulty}</td>
<td>${eachP.p_size}</td>
</tr>
</c:forEach>

</table>