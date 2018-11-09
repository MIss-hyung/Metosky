<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Content Header (Page header) -->
      <section class="content-header">
      <h1>
        	오답노트 출력
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-book"></i> 문제 출력</a></li>
        <li class="active">오답노트 출력</li>
      </ol>
    </section>

    <script>
		<c:choose>
		    <c:when test="${sessionScope.login.is_admin == 1 }">
				$(document).ready(function() {
					$('.sidebar-menu').children('.treeview').eq(2).addClass('active');
					$('.sidebar-menu').children('.treeview').eq(2).children('ul').children('li').eq(1).addClass('active');
				});
		    </c:when> 
		    <c:otherwise>
				$(document).ready(function() {
					$('.sidebar-menu').children('.treeview').eq(1).addClass('active');
					$('.sidebar-menu').children('.treeview').eq(1).children('ul').children('li').eq(1).addClass('active');
				});
		    </c:otherwise>
		</c:choose>
	</script>

<jsp:include page="../include/footer.jsp"/>

