<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8");%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>미투스카이 문제 출제 시스템 | 로그인</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/theme/plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  <script>
  function checkForm() {	
     var
  			form = $('.form'),
  			t_name = $('#t_name').val(),
  			t_email = $('#t_email').val(),
  			t_pswd = $('#t_pswd').val(),
  			pswd_retype = $('#pswd_retype').val();
  
 	var emailck = 0;
	var field_chk = 0;
	
	var request = {	t_email : t_email }
	
  	if(t_name.length < 1 || t_email.length < 1 || t_pswd.length < 1 || pswd_retype.length < 1) {
  		if(t_name.length < 1) $(".name-form").addClass("has-error");
  		if(t_email.length < 1) $(".email-form").addClass("has-error");
		if(t_pswd.length < 1) $(".pswd-form").addClass("has-error");
		if(pswd_retype.length < 1) $(".repswd-form").addClass("has-error");
		alert("모든 필드를 입력해 주세요.");
  		return false;
  	}else{
  		$(".name-form").removeClass("has-error");
  		$(".email-form").removeClass("has-error");
  		$(".pswd-form").removeClass("has-error");
  		$("repswd-form").removeClass("has-error");
  		$(".name-form").addClass("has-success");
  		$(".pswd-form").addClass("has-success");
  		$(".repswd-form").addClass("has-success");
  		field_chk = 1;
  	}
	
	if(t_name.length == 1) {
		alert("올바른 이름을 입력해 주세요.");
		return false;
	}
	
   	$.ajax({
  		async: false,
  		type : 'POST',
  		data : JSON.stringify(request),
  		url	 : "./emailcheck",
  		dataType: "json",
  		contentType: "application/json; charset=UTF-8",
  		success : function(data) {
  			if(data.cnt > 0) {
  				 alert("이미 가입되어 있는 이메일입니다.");
  				 $(".email-form").removeClass("has-success")
  				 $(".email-form").addClass("has-error")
  				 $("#t_email").focus();
  				 return false;
  			}else {
  				$(".email-form").removeClass("has-error")
  				$(".email-form").addClass("has-success")
  				emailck = 1;
  			}
  		},
  		error : function(error) {
  			alert("error: " + error);
  			return false;
  		}
  	});
  	 
  	var pswd_field = 0;
  	
  	if(emailck == 1) {
  		
  		if(t_pswd.length < 4) {
  			alert("비밀번호는 4자 이상 되어야 합니다.");
  			$(".pswd-form").addClass("has-error");
  			$(".pswd-form").focus();
  			return false;
  		}
  		
        if(t_pswd==pswd_retype !== false) {
      		$(".pswd-form").removeClass("has-error");
      		$(".repswd-form").removeClass("has-error");
      	    pswd_field = 1;
        }else{
        	alert("비밀번호가 일치하지 않습니다.");
      		$(".pswd-form").addClass("has-error");
      		$(".repswd-form").addClass("has-error");
    	    return false;
        }
  	}

    if(emailck == 1 && field_chk == 1 && pswd_field == 1) {
      	var res = alert("회원가입이 완료되었습니다!");
		history.go(-1);
    }else{
    	return false;
    }
  };
  </script>
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <b>Meto</b>SKY
  </div>

  <div class="register-box-body">

  <form class="form" method="post" onsubmit="return checkForm();">
      <div class="form-group has-feedback name-form">
        <input type="text" class="form-control" placeholder="이름" name="t_name" id="t_name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback email-form">
        <input type="email" class="form-control" placeholder="이메일 (실제 존재하는 메일이어야 합니다.)" name="t_email" id="t_email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback pswd-form">
        <input type="password" class="form-control" placeholder="비밀번호" name="t_pswd" id="t_pswd">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback repswd-form">
        <input type="password" class="form-control" placeholder="비밀번호 재입력" name="pswd_retype" id="pswd_retype">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="row">
        <!-- /.col -->
        <div class="col-xs-4" style="float:right;">
          <button type="submit" class="btn btn-primary btn-block btn-flat">가입하기</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath}/resources/theme/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
