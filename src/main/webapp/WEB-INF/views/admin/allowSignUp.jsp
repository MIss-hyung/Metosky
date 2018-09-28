<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>
	<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				강사 가입 승인 
	      	</h1>
	      	<ol class="breadcrumb">
	        	<li><a href="#"><i class="fa fa-lock"></i> 관리자 메뉴</a></li>
	        	<li class="active">강사 가입 승인</li>
	      	</ol>
		</section>
		<!--</section content header> -->
		<script>
		$(document).ready(function() {
			$('.sidebar-menu').children('.treeview').eq(0).addClass('active');
			$('.sidebar-menu').children('.treeview').eq(0).children('ul').children('li').eq(0).addClass('active');
		});
		</script>	
		<!-- Main content -->
		<section class="content">
			
		<div class="row">
        	<div class="col-xs-12">
  				<div class="box">
  					<a href="students/studentsList.jsp">
	  					<div class="box-header">
	  						<h3 class="box-title">가입 승인 대기 목록</h3>
	  					</div>
  					</a>
  	
				  	<div class="box-body">
				  		<table id="students_list" class="table table-boardered table-hover table-responsive">
				  			<thead>
				  				<tr>
				  					<th>ID</th>
				  					<th>이름</th>
				  					<th>연락처</th>
				  					<th>이메일</th>
				  					<th>가입일</th>
				  					<th>승인</th>
				  				</tr>
				  			</thead>
				  			<tbody>
				  			  <c:forEach var="row" items="${list}">
				  			  	<tr>
				  					<td>${row.t_id}</td>
				  					<td>${row.t_name}</td>
				  					<td>${row.t_phone}</td>
				  					<td>${row.t_email}</td>
				  					<td>${row.created_ko}</td>
				  					<td></td>
				  				</tr>
				  			  </c:forEach>
				  			</tbody>
				  		</table>
				    </div>
				    <!-- /.box-body -->
				</div>
				<!-- /.box -->
  
         	</div>
         	<!-- /.col-->
  		</div>
  		<!-- /.row-->
  		
  		
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
  $(function () {
    $('#example2').DataTable()
    $('#students_list').DataTable()    
  })
</script> 
  
<jsp:include page="../include/footer.jsp"/>	