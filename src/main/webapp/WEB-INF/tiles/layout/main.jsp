<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>랜딩페이지 배정 관리자</title>

  <!-- Custom fonts for this template-->
  <link href="/lib/bootstrap/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="/lib/bootstrap/css/sb-admin-2.min.css" rel="stylesheet">

   <!-- Bootstrap core JavaScript-->
  <script src="/lib/bootstrap/vendor/jquery/jquery.min.js"></script>
  <script src="/lib/bootstrap/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="/lib/bootstrap/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="/lib/bootstrap/js/sb-admin-2.min.js"></script>
</head>
<body id="page-top">
    <div id="wrapper">
        <tiles:insertAttribute name="menu"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <div id="content">
                <tiles:insertAttribute name="header"/>
                <tiles:insertAttribute name="body"/>
            </div>
            <!-- End of Main Content -->
            <tiles:insertAttribute name="footer"/>
        </div>
        <!-- End of Contents Wrapper -->

    </div>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

</body>
</html>