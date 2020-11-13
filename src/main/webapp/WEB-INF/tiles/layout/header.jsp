<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="/lib/bootstrap/js/jquery-3.5.1.min.js"></script>
<script>
  let usrNm = '${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}';
  let usrId = '${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.id}';
  $(document).ready(function () {
    var now = new Date();
    var year = now.getFullYear();
    var month = now.getMonth() + 1;    //1월이 0으로 되기때문에 +1을 함.
    var date = now.getDate();
    var week = new Array('일', '월', '화', '수', '목', '금', '토');

    if((month + "").length < 2){        //2자리가 아니면 0을 붙여줌.
        month = "0" + month;
    }else{
         // ""을 빼면 year + month (숫자+숫자) 됨.. ex) 2018 + 12 = 2030이 리턴됨.
        month = "" + month;
    }
    var today = year + "년 " + month + "월 " + date + "일 " + week[now.getDay()] + "요일";

    $(".toggle-title-date").text(today);
  });
</script>
<style>
  .sidebar-btn{
    color: white !important
  }


  .topbar-bg-custom {
    background: repeating-linear-gradient(360deg, #091a3f, rgb(0, 28, 203) 88.66%, #0073ea);
    mix-blend-mode: normal;
    opacity: 0.84;
  }

  .toggle-title {
    font-family: Apple SD Gothic Neo;
    font-style: normal;
    font-weight: normal;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */

    display: flex;
    align-items: center;
    letter-spacing: -0.0461538px;
  }

  .toggle-title-date {
    font-family: Apple SD Gothic Neo;
    font-style: normal;
    font-weight: normal;
    font-size: 24px;
    line-height: 29px;
    /* identical to box height */

    text-align: right;
    text-transform: uppercase;
  }
</style>
<!-- Topbar -->
<nav class="navbar navbar-expand navbar-light topbar-bg-custom topbar static-top shadow">

  <!-- Sidebar Toggle (Topbar) -->
  <form class="form-inline">
    <div id="sidebarToggle" class="btn btn-link sidebar-btn">
      <i class="fa fa-bars"></i>
    </div>
    <div class="mr-2">
      <span class="text-white toggle-title">랜딩페이지 배정 관리자</span>
    </div>
    <div class="topbar-divider d-none d-sm-block" style="height:calc(4.375rem - 3rem) !important;"></div>
    <div class="mr-2">
      <span class="text-white toggle-title-date"></span>
    </div>
  </form>

  <!-- Topbar Navbar -->
  <ul class="navbar-nav ml-auto">

    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
    <li class="nav-item dropdown no-arrow d-sm-none">
      <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-search fa-fw"></i>
      </a>
    </li>



    <!-- Nav Item - Messages -->
    <li class="nav-item dropdown no-arrow mx-1">
      <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-envelope fa-plus"></i>
      </a>
    </li>
    <li class="nav-item dropdown no-arrow mx-1">
      <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-envelope fa-fw"></i>
      </a>
    </li>
    <li class="nav-item dropdown no-arrow mx-1">
      <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="fas fa-envelope fa-fw"></i>
      </a>
    </li>

    <div class="topbar-divider d-none d-sm-block"></div>

    <!-- Nav Item - User Information -->
    <li class="nav-item dropdown no-arrow">
      <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="mr-2 d-none d-lg-inline text-white small"> ${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}</span>
        <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
      </a>
      <!-- Dropdown - User Information -->
      <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
          <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
          Logout
        </a>
      </div>
    </li>

  </ul>

</nav>
<!-- End of Topbar -->