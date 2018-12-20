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
									<select id="page_in_problems" class="form-control">
										<option value = "2">2문제</option>
										<option value = "4">4문제</option>
										<option value = "6">6문제</option>
										<option value = "8">8문제</option>
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
											<select name="p_subject" id="p_subject" class="p_subject form-control getcha">
											<c:forEach items="${subjectlist}" var="row" >
				  			  					<option value="${row}"> ${row} </option>
				  			 			 	</c:forEach>
											</select>
										</td>
										<td>
											<select name="p_source" id="p_source" class="p_source form-control getcha">
											<c:forEach items="${sourcelist}" var="row">
				  			  					<option value="${row}"> ${row} </option>
				  			 			 	</c:forEach>
											</select>
										</td> 
										<td>
											<select name="p_unit" id="p_unit" class="p_unit form-control getcha">
											 <c:forEach items="${unitlist}" var="row" >
				  			  					<option value="${row}"> ${row} </option>
				  			 			 	</c:forEach>
				  			 			 	</select>
										</td>
										<td>
											<select name="p_difficulty" id="p_difficulty" class="p_difficulty form-control getcha">
											<c:forEach items="${difficultylist}" var="row" >
				  			  					<option value="${row}"> ${row}</option>
				  			 			 	</c:forEach>
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
		학생 : ${selected_students} <br>
		
		</select>
		
		</div>
	</section>
	<div id="printProblems">
	
	</div>

<script>
	var sourcelist;

	$( function() {
		var id= 0;
		$(document).on("click", "#row_add", function() {
			 var table = document.getElementById("prob_cond");
			    var row = table.insertRow(-1);
			    var cell1 = row.insertCell(0);
			    var cell2 = row.insertCell(1);
			    var cell3 = row.insertCell(2);
			    var cell4 = row.insertCell(3);
			    var cell5 = row.insertCell(4);
			    var cell6 = row.insertCell(5);
			    cell1.innerHTML = "<select id="+id+"_subject"+" name='p_subject' class='p_subject form-control getcha'><c:forEach items='${subjectlist}' var='row' ><option value='${row}'> ${row} </option></c:forEach></select>";
			    cell2.innerHTML = "<select id="+id+"_source"+" name='p_source' class='p_source form-control getcha'><c:forEach items='${sourcelist}' var='row' ><option value='${row}'> ${row} </option></c:forEach></select>";
			    cell3.innerHTML = "<select id="+id+"_unit"+" name='p_unit' class='p_unit form-control getcha'><c:forEach items='${unitlist}' var='row' ><option value='${row}'> ${row} </option></c:forEach></select>";
			    cell4.innerHTML = "<select id="+id+"_difficulty"+" name='p_difficulty' class='p_difficulty form-control getcha'><c:forEach items='${difficultylist}' var='row' ><option value='${row}'> ${row} </option></c:forEach></select>";
			    cell5.innerHTML = "<input class='form-control EachPnum getcha' type='number' min='1' max='1024' >";
			    id= id+1;
			    /*
			var $last_tr = $("table[id=prob_cond] tr").last();
			var $cloneHtml= $($("table[id=prob_cond] tr:last").clone());
 
			$cloneHtml.find("select").each(function(i) {
				this.selectedIndex = $last_tr.find("select")[i].selectedIndex;
			});
			*/
			$("table[id=prob_cond] tr").last().find("td").eq(5).html("<button id=\"row_minus\" type=\"button\" class=\"btn btn-primary btn-sm\" style=\"border-radius:50%;\"><span class=\"glyphicon glyphicon-minus\"></span></button>");
			/*
			$("table[id=prob_cond] tbody:last").append($cloneHtml);
			changePnum(); */
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
			var page_in_problems = $("#page_in_problems").val();
			$.ajax({
		  		async: false,
		  		type : 'POST',
		  		data : {"ps":ps , "page_in_problems":page_in_problems},
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

		/* $(document).on("click",".EachPnum",function(){
			changePnum();
		})


		$(document).on("keyup",".EachPnum",function(){
			changePnum();
		}) */
/* 
		function changePnum(){
			var totalnum=0;
			$(".EachPnum").each(function(){
				totalnum+=Number($(this).val());
			})
			$("#total_prob").val(totalnum);
			var ratio=1;
			ratio=Number($(this).val())/Number(total)*100+"%";

		} */

	 });
	
	$(document).on("change", ".p_subject", function() {
		var p = $(this).val();
		var index = $(this).attr('id');
		var index_char = index.split("_")[0];
		var target_source = index_char + "_source";

		$.ajax({
	  		async: false,
	  		type : 'POST',
	  		data : {"p":p},
	  		url	 : "./selectP",
	  		success : function(data) {
	  				$("#"+target_source).html(data);
	  			},
	  
	  		error:function(request,status,error){
	  	        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
	  	       },
	  	     complete : function(data) {
	  	                 //  실패했어도 완료가 되었을 때 처리
	  	        }
			
		});
	});
	
	$(document).on("change", ".p_source", function() {
		var pa = $(this).val();
		var psource = $(this).val();
		var index = $(this).attr('id');
		var index_char = index.split("_")[0];
		var target_unit = index_char + "_unit";
		
		$.ajax({
	  		async: false,
	  		type : 'POST',
	  		data : {"pa":pa, "psource":psource},
	  		url	 : "./selectPa",
	  		success : function(data) {
	  			alert(data);
	  			$("#"+target_unit).html(data);
	  		},
	  		
	  		error:function(request,status,error){
	  	        alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
	  	       },
	  	     complete : function(data) {
	  	                 //  실패했어도 완료가 되었을 때 처리
	  	        }

	  	});
	});
	
	$(document).on("change", ".p_unit", function() {
		var pa = $(this).val();
		var psource = $(this).val();
		var punit = $(this).val();
		
		var index = $(this).attr('id');
		var index_char = index.split("_")[0];
		var target_unit = index_char + "_unit";
		
		$.ajax({
	  		async: false,
	  		type : 'POST',
	  		data : {"pap":pap, "psource":psource, "punit":punit},
	  		url	 : "./selectPaP",
	  		success : function(data) {
	  			alert(data);
	  			$("#"+target_unit).html(data);
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
