<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>

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
									<input type="number" min="2" max="1024" class="form-control" id="total_prob">
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
										<th style="text-align:center;">보기 유무</th>
										<th style="text-align:center; background-color:white; border:none;">&nbsp;</th>
										<th style="text-align:center;">비율</th>
									</tr>
									<tr>
										<td>
											<select name="p_subject" id="p_subject" class="form-control">
												<option value="su-sang">수학 상</option>
												<option value="su-ha">수학 하</option>
												<option value="su1">수학 1</option>
												<option value="su2">수학 2</option>
											</select>
										</td>
										<td>
											<select name="p_source" id="p_source" class="form-control">
												<option value="ssen">쎈</option>
												<option value="black">블랙라벨</option>
												<option value="jeong">수학의 정석</option>
											</select>
										</td>
										<td>
											<select name="p_unit" id="p_unit" class="form-control">
												<option value="jisulog">지수와 로그함수</option>
												<option value="odd">경우의수</option>
												<option value="suyeolhap">수열의합</option>
											</select>
										</td>
										<td>
											<select name="p_difficulty" id="p_difficulty" class="form-control">
												<option value="2points">2점</option>
												<option value="3points">3점</option>
												<option value="n21">21번</option>
												<option value="sang">상</option>
												<option value="ha">하</option>
											</select>
										</td>
										<td>
											<input class="form-control" type="number" min="1" max="1024">
										</td>
										<td>
											<select name="p_choice" id="p_choice" class="form-control">
												<option value="1">있음</option>
												<option value="0">없음</option>
											</select>
										</td>
										<td id="button_row" style="border:none;">
											<button id="row_add" type="button" class="btn btn-primary btn-sm" style="border-radius:50%;">
											  <span class="glyphicon glyphicon-plus"></span>
											</button> 
										</td>
										<td></td>
									</tr>
								</table>
							</div>
							
							
							
						</div>
						<!-- box-body -->
					</form>
				</div>
				<!-- box -->
			</div>
			<!-- col -->
		</div>
		<!-- row -->
	</section>
	
	
	
<script>
	$( function() {
		
		$(document).on("click", "#row_add", function() {
			var $last_tr = $("table[id=prob_cond] tr").last();
			var $cloneHtml= $($("table[id=prob_cond] tr:last").clone());
			
			$cloneHtml.find("select").each(function(i) {
				this.selectedIndex = $last_tr.find("select")[i].selectedIndex;
			});
		
			$("table[id=prob_cond] tr").last().find("td").eq(6).html("<button id=\"row_minus\" type=\"button\" class=\"btn btn-primary btn-sm\" style=\"border-radius:50%;\"><span class=\"glyphicon glyphicon-minus\"></span></button>");
			$("table[id=prob_cond] tbody:last").append($cloneHtml);
		});
		
		$(document).on("click", "#row_minus", function() {
			var $row = $(this).closest("tr")
			$row.remove();
		});
		
	 });

</script>


<jsp:include page="../include/footer.jsp"/>

