<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
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
		$(document).ready(function() {
			$('.sidebar-menu').children('.treeview').eq(1).addClass('active');
			$('.sidebar-menu').children('.treeview').eq(1).children('ul').children('li').eq(0).addClass('active');
		});
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
				  				<tr>
				  					<td>12</td>
				  					<td>김학생</td>
				  					<td>숙명여고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>13</td>
				  					<td>박학생</td>
				  					<td>은광여고</td>
				  					<td>2</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>14</td>
				  					<td>이학생</td>
				  					<td>휘문고</td>
				  					<td>1</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>15</td>
				  					<td>김가나</td>
				  					<td>중대부고</td>
				  					<td>1</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>16</td>
				  					<td>박가나</td>
				  					<td>중동고</td>
				  					<td>2</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>17</td>
				  					<td>이가나</td>
				  					<td>개포고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>18</td>
				  					<td>송가나</td>
				  					<td>숙명여고</td>
				  					<td>2</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>19</td>
				  					<td>최학생</td>
				  					<td>정신여고</td>
				  					<td>3</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>20</td>
				  					<td>최가나</td>
				  					<td>숙명여고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>21</td>
				  					<td>송학생</td>
				  					<td>숙명여고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>22</td>
				  					<td>조학생</td>
				  					<td>휘문고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>23</td>
				  					<td>조가나</td>
				  					<td>은광여고</td>
				  					<td>3</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>24</td>
				  					<td>심학생</td>
				  					<td>휘문고</td>
				  					<td>2</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>28</td>
				  					<td>김이박</td>
				  					<td>중동고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>30</td>
				  					<td>최박이</td>
				  					<td>휘문고</td>
				  					<td>2</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>31</td>
				  					<td>최나다</td>
				  					<td>숙명여고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>32</td>
				  					<td>주학생</td>
				  					<td>휘문고</td>
				  					<td>2</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>33</td>
				  					<td>주가다</td>
				  					<td>휘문고</td>
				  					<td>1</td>
				  					<td>문과</td>
				  				</tr>
				  				<tr>
				  					<td>34</td>
				  					<td>정가나</td>
				  					<td>숙명여고</td>
				  					<td>1</td>
				  					<td>이과</td>
				  				</tr>
				  				<tr>
				  					<td>35</td>
				  					<td>이이학</td>
				  					<td>중동고</td>
				  					<td>2</td>
				  					<td>이과</td>
				  				</tr>
				  			</tbody>
				  		</table>
				    </div>
				    <!-- /.box-body -->
				  </div>
				  <!-- /.box -->
				  
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script>
  $(function () {
    //$('#example2').DataTable()
    $('#students_list').DataTable()    
  })
</script> 

<jsp:include page="../include/footer.jsp"/>

