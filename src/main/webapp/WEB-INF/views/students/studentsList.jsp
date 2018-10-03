<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        	학생 목록
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-users"></i> 학생 관리</a></li>
        <li class="active">학생 목록</li>
      </ol>
    </section>
    
    <script>
	<c:choose>
	    <c:when test="${sessionScope.login.is_admin == 1 }">
			$(document).ready(function() {
				$('.sidebar-menu').children('.treeview').eq(1).addClass('active');
				$('.sidebar-menu').children('.treeview').eq(1).children('ul').children('li').eq(0).addClass('active');
			});
	    </c:when>    
	    <c:otherwise>
			$(document).ready(function() {
				$('.sidebar-menu').children('.treeview').eq(0).addClass('active');
				$('.sidebar-menu').children('.treeview').eq(0).children('ul').children('li').eq(0).addClass('active');
			});
	    </c:otherwise>
	</c:choose>
	</script>	
    
    <!-- Main content -->
    <section class="content">
		<div class="row">
        	<div class="col-xs-12">
				<div class="box">
				  	<div class="box-header">
				  		<h3 class="box-title">학생 목록</h3>
				  	</div>
				  	
				  	<div class="box-body">
				  		<table id="students_list" class="table table-boardered table-hover">
				  			<thead>
				  				<tr>
				  					<th>ID</th>
				  					<th>학생 이름</th>
				  					<th>학교</th>
				  					<th>학년</th>
				  					<th>계열</th>
				  				</tr>
				  			</thead>
				  			<tbody>
				  			  <c:forEach var="row" items="${list}">
				  			  	<tr id="row_${row.s_id}">
				  					<td>${row.s_id}</td>
				  					<td>${row.s_name}</td>
				  					<td>${row.s_school}</td>
				  					<td>${row.s_year}</td>
				  					<td>${row.major}</td>
				  				</tr>
				  			  </c:forEach>
				  			</tbody>
				  		</table>
				    </div>
				    <!-- /.box-body -->
				  </div>
			</div>
		</div>
	</section>
				  <!-- /.box -->
				  
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
  $(function () {
    $('#students_list').DataTable()    
  })
</script> 

<jsp:include page="../include/footer.jsp"/>

