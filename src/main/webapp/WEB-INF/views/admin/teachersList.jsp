<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>
	<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				강사 가입 목록 
	      	</h1>
	      	<ol class="breadcrumb">
	        	<li><a href="#"><i class="fa fa-lock"></i> 관리자 메뉴</a></li>
	        	<li class="active">강사 가입 목록</li>
	      	</ol>
		</section>
		<!--</section content header> -->
		<script>
		$(document).ready(function() {
			$('.sidebar-menu').children('.treeview').eq(0).addClass('active');
			$('.sidebar-menu').children('.treeview').eq(0).children('ul').children('li').eq(1).addClass('active');
		});
		
		function approve(obj) {
			var t_id = obj.id;
			var t_status = obj.value;
			var row_id = "#row_" + t_id;
			var cancel_id = ".cancel_" + t_id;
			var approve_admin = ".admin_" + t_id;
			if(t_status == 3) {
				var admin_cancel = 1;
			}
			if(t_status == 2) {
				var admin_approve = 1;
			}
			
			var request = {	t_id : t_id, t_status : t_status};
			
		   	$.ajax({
		  		async: false,
		  		type : 'POST',
		  		data : JSON.stringify(request),
		  		url	 : "signUpApprove",
		  		dataType: "json",
		  		contentType: "application/json; charset=UTF-8",
		  		success : function(data) {
		  			if(admin_cancel) {
		  				$(cancel_id).remove();
		  				$(approve_admin).add();
		  			}else if(admin_approve) {
		  				$(cancel_id).add();
		  				$(approve_admin).remove();
		  			}else{
		  				$(row_id).remove();
		  			}
		  			location.reload();
		  		},
		  		error : function(error) {
		  			alert("error: " + error);
		  			return false;
		  		}
		  	});
		}
		</script>	
		<!-- Main content -->
		<section class="content">
			
		<div class="row">
        	<div class="col-xs-12">
  				<div class="box">
  					<!-- <a href="students/studentsList.jsp"> -->
	  					<div class="box-header">
	  						<h3 class="box-title">승인 된 강사 목록</h3>
	  					</div>
  					<!-- </a> -->
  	
				  	<div class="box-body">
				  		<table id="students_list" class="table table-boardered table-hover table-responsive">
				  			<thead>
				  				<tr>
				  					<th>ID</th>
				  					<th>이름</th>
				  					<th>연락처</th>
				  					<th>이메일</th>
				  					<th>가입 신청일</th>
				  					<th>승인 취소</th>
				  					<th>관리자 지정</th>
				  				</tr>
				  			</thead>
				  			<tbody>
				  			  <c:forEach var="row" items="${list}">
				  			  	<tr id="row_${row.t_id}">
				  					<td>${row.t_id}</td>
				  					<td>${row.t_name}</td>
				  					<td>${row.t_phone}</td>
				  					<td>${row.t_email}</td>
				  					<td>${row.created_ko}</td>
				  					<td><button class="btn btn-danger" id="${row.t_id}" value="0" onclick="approve(this)">승인 취소</button></td>
				  					<c:if test="${row.is_admin == 1 }">
				  						<td><button class="btn btn-info cancel_${row.t_id}" name="cancel_${row.t_id}" id="${row.t_id}" value="3" onclick="approve(this)">관리자 취소</button></td>
				  					</c:if>
				  					<c:if test="${row.is_admin == 0 }">
				  						<td><button class="btn btn-warning admin_${row.t_id}" name="admin_${row.t_id}" id="${row.t_id}" value="2" onclick="approve(this)">관리자로 승인</button></td>
				  					</c:if>
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