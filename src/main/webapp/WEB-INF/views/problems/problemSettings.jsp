<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        	문제 조건 설정 <small>&nbsp;&nbsp;&nbsp;&nbsp;선택한 조건의 문제들을 시험지 형식으로 출력 합니다.</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-book"></i> 문제 출력</a></li>
        <li>시험지 출력</li>
        <li class="active">문제 조건 설정</li>
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
	<!--  Main Content -->
	<section class="content">
		<div class="row">
			<!--  left column -->
			<div class="col-xs-12">
				<div class="box box-info">
					<form class="form-horizontal">
						<div class="box-body">
							<div class="form-group col-lg-6">
								<label for="total_prob" class="col-sm-3 control-label" style="text-align:left;">총 문제 수</label>
								<div class="col-sm-3">
									<input type="text" min="2" max="1024" class="form-control" id="total_prob" value="0" disabled>
								</div>
							</div>
							<!-- form-group -->
							<div class="form-group col-lg-6">
								<label for="total_prob" class="col-sm-5 control-label" style="text-align:left;">한 페이지 당 문제 수</label>
								<div class="col-sm-4">
									<select class="form-control">
										<option>2문제</option>
										<option>4문제</option>
										<option>6문제</option>
										<option>8문제</option>
									</select>
								</div>
							</div>
							<!-- form-group -->


							<div class="col-xs-12">
								<table id="prob_cond" class="table table-striped" style="text-align:center;">
									<tr class="bg-gray" style="border-top:">
										<th style="text-align:center;">과목</th>
										<th style="text-align:center;">문제 소스</th>
										<th style="text-align:center;">단원</th>
										<th style="text-align:center;">난이도</th>
										<th style="text-align:center; width:90px;">문제 수</th>
										<th style="text-align:center;"> </th>
										<th style="text-align:center; background-color:white; border:none;">&nbsp;</th>
										<th style="text-align:center;">비율</th>
									</tr>
									<tr>
										<td>
											<select name="p_subject" id="p_subject" class="form-control getcha">
											<c:forEach items="${subjectlist}" var="row" >
				  			  					<option value="${row}"> ${row} </option>
				  			 			 	</c:forEach>
											</select>
										</td>
										<td>
											<select name="p_source" id="p_source" class="form-control getcha">
											<c:forEach var="row" items="${sourcelist}">
				  			  					<option value="${row}"> ${row} </option>
				  			 			 	</c:forEach>
											</select>
										</td>
										<td>
											<select name="p_unit" id="p_unit" class="form-control getcha">
											 <c:forEach var="row" items="${list}">
				  			  					<option id="row_${row.p_unit}"> </option>
				  			 			 	</c:forEach><!-- 
												<option value="jisulog">지수와 로그함수</option>
												<option value="odd">경우의수</option>
												<option value="suyeolhap">수열의합</option> -->
											</select>
										</td>
										<td>
											<select name="p_difficulty" id="p_difficulty" class="form-control getcha">
											<c:forEach var="row" items="${list}">
				  			  					<option id="row_${row.p_difficulty}"> </option>
				  			 			 	</c:forEach><!-- 
												<option value="2points">2점</option>
												<option value="3points">3점</option>
												<option value="n21">21번</option>
												<option value="sang">상</option>
												<option value="ha">하</option> -->
											</select>
										</td>
										<td>
											<input class="form-control EachPnum getcha" type="number" min="1" max="1024" >
										</td>

										<td id="button_row" style="border:none;">
											<button id="row_add" type="button" class="btn btn-primary btn-sm" style="border-radius:50%;">
											  <span class="glyphicon glyphicon-plus"></span>
											</button>
										</td>
									</tr>
								</table>
							</div>

							 <butten type="button" id="testbtn" class="btn btn-block btn-primary btn-lg" style="width:130px; float:right; margin-right: 18px">출력하기</button>

						</div>
						<!-- box-body -->
					</form>
				</div>
				<!-- box -->
			</div>
			<!-- col -->
		</div>
		<!-- row -->
		학생 : ${selected_students}
	</section>
	<div id="printProblems">
	
	</div>


<script>
	$( function() {

		$(document).on("click", "#row_add", function() {
			var $last_tr = $("table[id=prob_cond] tr").last();
			var $cloneHtml= $($("table[id=prob_cond] tr:last").clone());

			$cloneHtml.find("select").each(function(i) {
				this.selectedIndex = $last_tr.find("select")[i].selectedIndex;
			});

			$("table[id=prob_cond] tr").last().find("td").eq(5).html("<button id=\"row_minus\" type=\"button\" class=\"btn btn-primary btn-sm\" style=\"border-radius:50%;\"><span class=\"glyphicon glyphicon-minus\"></span></button>");
			$("table[id=prob_cond] tbody:last").append($cloneHtml);
			changePnum();
		});

		$(document).on("click", "#row_minus", function() {
			var $row = $(this).closest("tr")
			$row.remove();
			changePnum();
		});



		$(document).on("click", "#testbtn", function() {
			var ps="";
			$(".getcha").each(function(){
				ps+=$(this).val();
				ps+="$";
			})

			$.ajax({
		  		async: false,
		  		type : 'POST',
		  		data : {"ps":ps},
		  		url	 : "./downTest",
		  		success : function(data) {
		  			alert(data)
		  			$("#printProblems").append(data);
		  		},
		  		error : function(error) {
		  			alert("error: " + ps);
		  			return false;
		  		}
		  	});
		});

		$(document).on("click",".EachPnum",function(){
			changePnum();
		})


		$(document).on("keyup",".EachPnum",function(){
			changePnum();
		})

		function changePnum(){
			var totalnum=0;
			$(".EachPnum").each(function(){
				totalnum+=Number($(this).val());
			})
			$("#total_prob").val(totalnum);
			var ratio=1;
			ratio=Number($(this).val())/Number(total)*100+"%";

		}

	 });
	
	$(document).on("change", "#p_subject", function() {
		var p = $(this).val()
		
		$.ajax({
	  		async: false,
	  		type : 'POST',
	  		data : {"p":p},
	  		url	 : "./selectP",
	  		success : function(data) {
	  			alert(data);
	  			var callback = function (data) {

	  			    // Get select
	  			    var select = document.getElementById('sourcelist');

	  			    // Add options
	  			    for (var i in data) {
	  			        $(select).append('<option value=' + data[i] + '>' + data[i] + '</option>');
	  			    }

	  			    // Set selected value
	  			    $(select).val(data[1]);
	  			}
	  		},
	  		
	  		error:function(request,status,error){
	  	        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
	  	       },
	  	     complete : function(data) {
	  	                 //  실패했어도 완료가 되었을 때 처리
	  	        }

	  	});
	});

</script>


<jsp:include page="../include/footer.jsp"/>
