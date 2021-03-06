<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../include/header.jsp"/>
	<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				승인 거절 목록
	      	</h1>
	      	<ol class="breadcrumb">
	        	<li><a href="#"><i class="fa fa-lock"></i> 관리자 메뉴</a></li>
	        	<li class="active">승인 거절 목록</li>
	      	</ol>
		</section>
		<!--</section content header> -->
		<script>
		$(document).ready(function() {
			$('.sidebar-menu').children('.treeview').eq(0).addClass('active');
			$('.sidebar-menu').children('.treeview').eq(0).children('ul').children('li').eq(2).addClass('active');
		});
		
		function approve(obj) {
			var t_id = obj.id;
			var t_status = obj.value;
			var row_id = "#row_" + t_id;
			
			var request = {	t_id : t_id, t_status : t_status};
			
		   	$.ajax({
		  		async: false,
		  		type : 'POST',
		  		data : JSON.stringify(request),
		  		url	 : "signUpApprove",
		  		dataType: "json",
		  		contentType: "application/json; charset=UTF-8",
		  		success : function(data) {
		  			$(row_id).remove();
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
	  						<h3 class="box-title">승인 거절 목록</h3>
	  					</div>
  					<!-- </a> -->
  	
				  	<div class="box-body">
				  		<table id="teachers_list" class="table table-boardered table-hover table-responsive">
				  			<thead>
				  				<tr>
				  					<th>ID</th>
				  					<th>이름</th>
				  					<th>연락처</th>
				  					<th>이메일</th>
				  					<th>가입 신청일</th>
				  					<th>거절 취소</th>
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
				  					<td><button class="btn btn-success" id="${row.t_id}" value="0" onclick="approve(this)">거절 취소</button></td>
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
  		</section>
  		
<!-- DataTables -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
  $(function () {
	  $('#teachers_list').DataTable({
	    	"lengthMenu": [[10, 25, 50, -1], ["All", 10, 25, 50, ]]
	    }) 
  })
</script> 
  
<jsp:include page="../include/footer.jsp"/>	