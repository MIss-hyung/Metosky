<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        	시험지 출력 <small>&nbsp;&nbsp;&nbsp;&nbsp;선택한 조건의 문제들을 시험지 형식으로 출력 합니다.</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-book"></i> 문제 출력</a></li>
        <li class="active">시험지 출력</li>
      </ol>
    </section>
    
    <script>
		<c:choose>
		    <c:when test="${sessionScope.login.is_admin == 1 }">
				$(document).ready(function() {
					$('.sidebar-menu').children('.treeview').eq(2).addClass('active');
					$('.sidebar-menu').children('.treeview').eq(2).children('ul').children('li').eq(0).addClass('active');
				});
		    </c:when>    
		    <c:otherwise>
				$(document).ready(function() {
					$('.sidebar-menu').children('.treeview').eq(1).addClass('active');
					$('.sidebar-menu').children('.treeview').eq(1).children('ul').children('li').eq(0).addClass('active');
				});
		    </c:otherwise>
		</c:choose>
	</script>	

	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
				  	<div class="box-header">
				  		<h3 class="box-title">학생 목록 <small>문제를 풀릴 학생들을 선택한 후 <i>'문제 설정'</i> 버튼을 클릭 해 주세요.</small></h3>
				  	</div>
				  	
				  	<div class="box-body">
				  		<table id="students_list" class="table table-boardered table-hover">
				  			<thead>
				  				<tr>
				  					<th width="50px">선택</th>
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
				  			  			<td><input type="checkbox" name="print_check_${row.s_id}" value="${row.s_id}"></td>
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
				  <!-- /.box -->
			</div>
			
			<a href="./3030">
				<button type="button" class="btn btn-block btn-primary btn-lg" style="width:130px; float:right; margin-right: 18px">문제 설정</button>
			</a>
		</div>
	</section>
	
<script src="../../bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="../../bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
  $(function () {
    $('#example2').DataTable()
    $('#students_list').DataTable()    
  })
</script> 

<jsp:include page="../include/footer.jsp"/>

