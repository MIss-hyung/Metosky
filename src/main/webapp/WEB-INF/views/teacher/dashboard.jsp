<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8");%>
<jsp:include page="../include/header.jsp"/>
  <!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			대시보드 <small>Version 0.1</small>
      	</h1>
      	<ol class="breadcrumb">
        	<li><a href="#"><i class="fa fa-dashboard"></i> 한 눈에 보기</a></li>
        	<li class="active">대시보드</li>
      	</ol>
	</section>
	<!--</section content header> -->

    <!-- Main content -->
    <section class="content">
    
		<div class="row">
        	<div class="col-xs-12">
  				<div class="box">
  					<a href="students/studentsList.jsp">
	  					<div class="box-header">
	  						<h3 class="box-title">학생 목록</h3>
	  					</div>
  					</a>
  	
				  	<div class="box-body">
				  		<table id="students_list" class="table table-boardered table-hover table-responsive">
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
  
  
  				<div class="box">
		  			<div class="box-header">
		    			<h3 class="box-title">최다 오답 <small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;한 명이라도 틀린 문제를 보여줍니다.</small></h3>
		    		</div>
		            <!-- /.box-header -->
		            <div class="box-body">
		                <table id="example2" class="table table-bordered table-striped table-responsive">
			                <thead>
			                <tr>
			                  <th>문제 코드</th>
			                  <th>문제 소스</th>
			                  <th>과목</th>
			                  <th>단원</th>
			                  <th>난이도</th>
			                  <th>오답률</th>
			                  <th></th>
			                </tr>
			                </thead>
			                <tbody>
		                <tr>
		                  <td>2018_ssen_su1_log</td>
		                  <td>쎈</td>
		                  <td>수1</td>
		                  <td>지수와 로그</td>
		                  <td>상</td>
		                  <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-primary" style="width: 55%"></div>
			                </div>
		                  </td>
		                  <td><span class="badge bg-blue">55%</span></td>
		                </tr>
			            <tr>
			              <td>2018_black_su1_log</td>
			              <td>블랙라벨</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-yellow">70%</span></td>
			            </tr>
		                <tr>
			            	<td>2018_jeong_su1_log</td>
			                <td>수학의 정석</td>
			                <td>수2</td>
			                <td>삼각함수</td>
			                <td>중</td>
			                <td>
			                	<div class="progress progress-xs progress-striped active">
			                    	<div class="progress-bar progress-bar-success" style="width: 30%"></div>
			                	</div>
			                </td>
			              <td><span class="badge bg-green">30%</span></td>
			            </tr>
			            <tr>
			              <td>2018_ssen_su1_log</td>
			              <td>쎈</td>
			              <td>수1</td>
			              <td>순열과 조합</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs progress-striped active">
			                  <div class="progress-bar progress-bar-success" style="width: 45%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-green">45%</span></td>
			            </tr>
			           <tr>
		                  <td>2018_ssen_su1_log</td>
		                  <td>쎈</td>
		                  <td>수2</td>
		                  <td>함수</td>
		                  <td>중</td>
		                  <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-primary" style="width: 55%"></div>
			                </div>
		                  </td>
		                  <td><span class="badge bg-blue">55%</span></td>
		                </tr>
			            <tr>
			              <td>2018_black_su1_log</td>
			              <td>블랙라벨</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-yellow">70%</span></td>
			            </tr>
		                <tr>
			            	<td>2018_jeong_su1_log</td>
			                <td>수학의 정석</td>
			                <td>수1</td>
			                <td>지수와 로그</td>
			                <td>중</td>
			                <td>
			                	<div class="progress progress-xs progress-striped active">
			                    	<div class="progress-bar progress-bar-success" style="width: 30%"></div>
			                	</div>
			                </td>
			              <td><span class="badge bg-green">30%</span></td>
			            </tr>
			            <tr>
			              <td>2018_ssen_su1_log</td>
			              <td>쎈</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs progress-striped active">
			                  <div class="progress-bar progress-bar-danger" style="width: 90%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-red">90%</span></td>
			            </tr>
			            <tr>
		                  <td>2018_ssen_su1_log</td>
		                  <td>쎈</td>
		                  <td>수1</td>
		                  <td>지수와 로그</td>
		                  <td>상</td>
		                  <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-primary" style="width: 55%"></div>
			                </div>
		                  </td>
		                  <td><span class="badge bg-blue">55%</span></td>
		                </tr>
			            <tr>
			              <td>2018_black_su1_log</td>
			              <td>블랙라벨</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-yellow">70%</span></td>
			            </tr>
		                <tr>
			            	<td>2018_jeong_su1_log</td>
			                <td>수학의 정석</td>
			                <td>수1</td>
			                <td>지수와 로그</td>
			                <td>중</td>
			                <td>
			                	<div class="progress progress-xs progress-striped active">
			                    	<div class="progress-bar progress-bar-success" style="width: 30%"></div>
			                	</div>
			                </td>
			              <td><span class="badge bg-green">30%</span></td>
			            </tr>
			            <tr>
			              <td>2018_ssen_su1_log</td>
			              <td>쎈</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs progress-striped active">
			                  <div class="progress-bar progress-bar-danger" style="width: 90%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-red">90%</span></td>
			            </tr>
			            <tr>
		                  <td>2018_ssen_su1_log</td>
		                  <td>쎈</td>
		                  <td>수1</td>
		                  <td>지수와 로그</td>
		                  <td>상</td>
		                  <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-primary" style="width: 55%"></div>
			                </div>
		                  </td>
		                  <td><span class="badge bg-blue">55%</span></td>
		                </tr>
			            <tr>
			              <td>2018_black_su1_log</td>
			              <td>블랙라벨</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs">
			                    <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-yellow">70%</span></td>
			            </tr>
		                <tr>
			            	<td>2018_jeong_su1_log</td>
			                <td>수학의 정석</td>
			                <td>수1</td>
			                <td>지수와 로그</td>
			                <td>중</td>
			                <td>
			                	<div class="progress progress-xs progress-striped active">
			                    	<div class="progress-bar progress-bar-success" style="width: 30%"></div>
			                	</div>
			                </td>
			              <td><span class="badge bg-green">30%</span></td>
			            </tr>
			            <tr>
			              <td>2018_ssen_su1_log</td>
			              <td>쎈</td>
			              <td>수1</td>
			              <td>지수와 로그</td>
			              <td>상</td>
			              <td>
			                <div class="progress progress-xs progress-striped active">
			                  <div class="progress-bar progress-bar-danger" style="width: 90%"></div>
			                </div>
			              </td>
			              <td><span class="badge bg-red">90%</span></td>
			            </tr>
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
    $('#example2').DataTable()
    $('#students_list').DataTable()    
  })
</script> 
  
<jsp:include page="../include/footer.jsp"/>