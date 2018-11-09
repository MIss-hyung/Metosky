<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
  $( function() {
    $( "#popup_open" ).dialog({
      resizable: true,
      height: "auto",
      width: "auto",
      autoOpen:false,
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( "close" );
        }
      }
    });
    
    $( "#wrong_popup1").on("click", function() {
    	$("#popup_open").dialog("open");
    });
    $( "#wrong_popup2").on("click", function() {
    	$("#popup_open").dialog("open");
    });
    $( "#wrong_popup3").on("click", function() {
    	$("#popup_open").dialog("open");
    });
  } );
  </script>
  <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        	학생 정보
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 학생 관리</a></li>
        <li>학생 목록</li>
        <li class="active">학생 정보</li>
      </ol>
    </section>
    <!--</section content header> -->
    
    <!-- Main content -->
    <section class="content">
    	<div class="row">
    		<div class="col-xs-12">
    			<div class="box" style="border-top:none;">
    				<div class="box-body no-padding" style="overflow-x:auto;">
    					<table class="table table-condensed">
    						<tr>
    							<th class="bg-gray dsabled color-palette" style="width:120px; text-align:center;">학생 이름</th>
    							<td colspan="3" style="width:100px"></td>
    						</tr>
    						<tr>
    							<th class="bg-gray dsabled color-palette" style="width:120px; text-align:center;">학생 연락처</th>
    							<td></td>
    							<th class="bg-gray dsabled color-palette" style="width:120px; text-align:center;">학부모 연락처</th>
    							<td></td>
    						</tr>
    					</table>
    				</div>
    					<!-- /.box-body -->
    			</div>
    			<!-- /.box -->
    		</div>
    		<!-- /.col -->
    	</div>
    	<!-- /.row -->
    	<div class="row">
    		<div class="col-xs-12">
    			<div class="box">
    				<div class="box-header">
    					<h3 class="box-title">오답 목록</h3>
    				</div>
    				<!-- /.box-header -->
    				<div class="box-body">
    					<table id="wrong-list" class="table table-bordered table-hover" style="overflow-x: auto;">
    						<thead>
								<tr>
									<th>문제 코드</th>
									<th>문제 소스</th>
									<th>과목</th>
									<th>단원</th>
									<th>난이도</th>
								</tr>
    						</thead>
    						<tbody>
    							<tr id="wrong_popup1">
    								<td>2018_black_su1_log</td>
    								<td>블랙라벨</td>
    								<td>수1</td>
    								<td>지수와 로그</td>
    								<td>상</td>
    							</tr>
    							<tr id="wrong_popup2">
    								<td>2018_ssen_su1_log</td>
    								<td>블랙라벨</td>
    								<td>수1</td>
    								<td>지수와 로그</td>
    								<td>상</td>
    							</tr>
    							<tr id="wrong_popup3">
    								<td>2018_black_su1_log</td>
    								<td>블랙라벨</td>
    								<td>수1</td>
    								<td>지수와 로그</td>
    								<td>상</td>
    							</tr>
    						</tbody>
    					</table>
    				</div>
    			</div>
    			<!-- /.box -->
    		</div>
    		<!-- /.col -->
    	</div>
    	<!-- /.row -->

		<div id="popup_open" title="학생 오답 2018_ssen_su1_log">
			<img src="../../sources/QST0002357.png" width="450">
		</div>

	<jsp:include page="../include/footer.jsp"/>
</section>
