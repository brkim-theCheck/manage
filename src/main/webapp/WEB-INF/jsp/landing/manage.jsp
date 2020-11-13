<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="/lib/datepicker/css/bootstrap-datepicker.min.css"/>
<script src="/lib/datepicker/js/bootstrap-datepicker.min.js"></script>
<script src="/lib/datepicker/js/bootstrap-datepicker.ko.min.js"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css"/>

<script src="https://cdn.datatables.net/select/1.3.1/js/select.bootstrap4.js"></script>
<script src="/lib/bootstrap/vendor/datatables/jquery.dataTables.min.js"></script>
<script src="/lib/bootstrap/vendor/datatables/dataTables.bootstrap4.min.js"></script>

<script type="text/JavaScript">
let size = 15;
let page = 0;
let totalPages;
let grid;
let datatable_grid;
let selected_row;
let ord_prm = 'id,desc';
let search_type;
let search_text;
let from_date;
let to_date;

$(document).ready(function() {

  datatable_grid = $("#landingGrid").DataTable({
    columns : [
        { "name" : "acpt_chk", "data" : "acpt_chk"},
        { "name" : "id", "data" : "id"},
        { "name" : "userNm", "data" : "userNm"},
        { "name" : "mutual", "data" : "mutual"},
        { "name" : "telNo", "data" : "telNo", "render"  : function (data, type, row) {
              return data.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3");
           }
        },
        { "name" : "businessNo", "data" : "businessNo" , "render" : function (data, type, row) {
              return data.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{5})/,"$1-$2-$3");
           }
        },
        { "name" : "address", "data" : "address" },
        { "name" : "visitDt", "data" : "visitAt" , "render" : function(data, type, row) {
                return data.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5');
            }
        },
        { "name" : "acptDt", "data" : "acptAt" , "render" : function(data, type, row) {
                return data.replace("T", ' ');
            }
        },
        { "name" : "opinionDesc", "data" : "opinionDesc" , "render" : function (data, type, row) {
            selected_row = row;
            return "<i class='fa fa-comment-dots'> </i>";
          },
          "className" : "detail-desc"
        }
    ],
    'columnDefs': [{
       'targets': 0,
       'searchable':false,
       'orderable':false,
       'className': 'dt-body-center',
       'render': function (data, type, full, meta){
           return '<input type="checkbox" class="row-check" name="acpt-chk" >';
       }
    }],
    scrollX : false,
    scrollY : '600px',
    scrollCollapse: true,
    ordering : false,
    searching: false,
    lengthChange: false,
    paging : false,
    info : false
  });



   $('.dataTables_scrollBody').on('scroll',function(ev) {
        let tbody = $(".dataTables_scrollBody tbody").height();
        let scrollBody = $(".dataTables_scrollBody").height();
        let scrollTop = $(".dataTables_scrollBody").scrollTop();

        if( scrollTop != 0 ) {
            if( (scrollBody + scrollTop) - tbody >= 0 && (totalPages != page)) {
                createRows();
            }
        }
    });

    $('#landingGrid tbody').on('click','td.detail-desc', function () {
        let tr = $(this).closest('tr');
        let row = datatable_grid.row(tr);

         if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    });

    $('#example-select-all').on('click', function(){
       // Check/uncheck checkboxes for all rows in the table
       $('.dataTables_scrollBody input[type="checkbox"]').prop('checked', this.checked);
    });

    $(".fa-sort-down, .fa-sort-up").on('click', function() {
        let obj = $(this);
        let ord_id = obj.data('id');
        if(obj.hasClass('fa-sort-down')) {
            $(".fa-sort-up").removeClass('fa-sort-up').addClass('fa-sort-down');
            if(obj.hasClass("sort-enabled")) {
                obj.removeClass('fa-sort-down').addClass('fa-sort-up');
                ord_prm = ord_id+",asc";
            } else {
                $(".sort-enabled").removeClass('sort-enabled');
                obj.addClass('sort-enabled');
                ord_prm = ord_id+",desc";
            }
        } else if (obj.hasClass('fa-sort-up')) {
            if(obj.hasClass("sort-enabled")) {
                obj.removeClass('fa-sort-up').addClass('fa-sort-down');
                ord_prm = ord_id+",desc";
            } else {
                $(".sort-enabled").removeClass('sort-enabled');
                obj.addClass('sort-enabled');
                ord_prm = ord_id+",asc";
            }
        }

        //page reset
        page = 0;
        datatable_grid.clear().draw();
        createRows();
    });

    $("#submit_btn").on('click', function(){ reSearch();});
    $("#excel_down").on('click', function(){
        getExcel();
    });

    createRows();
    //datepicker

    $('#from_date, #to_date').datepicker({
        format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
        autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
        disableTouchKeyboard : false,	//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
        templates : {
            leftArrow: '&laquo;',
            rightArrow: '&raquo;'
        }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징
        todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false
        toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
        weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일
        language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
    });
    //datepicker end

});


/* Formatting function for row details - modify as you need */
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="8" cellspacing="0" border="0" style="padding:20px;" class="detail-desc">'+
        '<tr>'+
            '<th>이름 : </th>'+
            '<td>'+d.userNm+'</td>'+
            '<th>연락처 : </th>'+
            '<td colspan="2">'+d.telNo.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,"$1-$2-$3")+'</td>'+
        '</tr>'+
        '<tr>'+
            '<th>상호 : </th>'+
            '<td>'+d.mutual+'</td>'+
            '<th>사업자 번호 : </th>'+
            '<td colspan="2>'+d.businessNo.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{5})/,"$1-$2-$3")+'</td>'+
        '</tr>'+
        '<tr>'+
            '<th>주소:</th>'+
            '<td colspan="5">'+d.address+'</td>'+
        '</tr>'+
        '<tr>'+
            '<th>희망방문일:</th>'+
            '<td>'+d.visitAt.replace(/(\d{4})(\d{2})(\d{2})(\d{2})(\d{2})(\d{2})/, '$1-$2-$3 $4:$5:$6')+'</td>'+
            '<th>접수일:</th>'+
            '<td>'+d.acptAt.replace('T', ' ')+'</td>'+
        '</tr>'+
        '<tr>'+
            '<th>희망사항:</th>'+
            '<td colspan="5">'+d.opinionDesc+'</td>'+
        '</tr>'+
    '</table>';
}

function reSearch() {
    page=0;
    datatable_grid.clear().draw();
    createRows();
}

function createRows() {
  let rows;

  let data  = {
         'size': size,
         'page' : page,
         'sort' : ord_prm
       };

  search_type = $("#search_type").val();
  search_text = $("#search_text").val();
  from_date = $("#from_date").val().replace(/-/gi,'');
  to_date = $("#to_date").val().replace(/-/gi, '');

  if(search_type != "" && search_type != "") {
    data[search_type] = search_text;
  }

  if(from_date != '' && to_date != '') {
    data.acptAt = from_date+'000000,'+to_date+'235959';
  }

  $.ajax({
    url: 'http://localhost:8080/manage/posts',
    method: 'POST',
    data: data,
    dataType: 'json',
    success: function(res) {
        totalPages = res.totalPages;
      if(page <= (totalPages - 1)) {
        page += 1;

        rows = res.content;
        rows.forEach(function(data) {
            data["acpt_chk"] = null;
            datatable_grid.row.add(data).draw();
        });
      } else {

      }
    },
    error: function(res) {
    }
  });
}

function getExcel() {

  let param = "";

  if(search_type != "" && search_type != "") {
    param += search_type + "=" + search_text;
  }

  if(from_date != '' && to_date != '') {
    param += "&acptAt="+from_date+'000000,'+to_date+'235959'
  }

  location.href = "http://localhost:8080/manage/excel?"+param;

}
</script>
<!-- Begin Page Content -->
<style>
.page-header {
    height: 173px;
    top: 0px;
    background: radial-gradient(100% 100% at 100% 100%, #002470 0%, #005EC0 100%);
    mix-blend-mode: normal;
    opacity: 0.84;
    position:relative;
}
.page-header-main {
    position:relative;
    height:67px;
    top: 40%;
    left: 4%;
    display:inline-block;
    margin-right:10%
}

.page-header-sub {
    position:relative;
    height:67px;
    top: 40%;
    display:inline-block;
    min-width:110px;
    margin-right:10px;
}

.page-header-title {
    font-family: Apple SD Gothic Neo;
    font-style:normal;
    font-weight: 100;
    font-size: 56px;
    line-height:67px;
    letter-spacing: -3px;
}

.page-header-sub-title {
    text-align:right;
    border-left: 2px solid #EEEEEE;
}

.dataTables_wrapper {
    font-family: Apple SD Gothic Neo;
    font-size: 15px;
    font-style: normal;
    font-weight: 300;
    color : #000000
}


.dataTables_wrapper.no-footer .dataTables_scrollBody {
    border-bottom : none;
}

table.dataTable {
    border-collapse: separate;
    border-spacing: 0 7px;
}

table.dataTable thead th {
    text-align : center;
    padding: 10px 18px;
    border-bottom : none;
}

table.dataTable tbody td {
    text-align : center;
}

table.detail-desc tbody td {
    text-align : left;
}

.sort-enabled {
    color: blue;
}

.search-option {
    justify-content: left;
    align-items: center;
}

span.input-title {
    color: #000;
    min-width:35px
}
.input-group-title, .input-group-body, input-group-body.input {
    display: flex;
    flex-direction: row;
    align-items:center;
}

.input-group-body input, input-group-body select {
    margin: 0 10px 0 10px;
}

.form-search {
    width: 100%;
    height: calc(1.5em + .75rem + 2px);
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    background: #FFFFFF;
    border: 1px solid #32B8D3;
    box-sizing: border-box;
    border-radius: 2px;
    color: #32B8D3;
}

.form-acpt {
    width: 100%;
    height: calc(1.5em + .75rem + 2px);
    padding: .375rem .75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    background: #32B8D3;
    border: 1px solid #32B8D3;
    box-sizing: border-box;
    border-radius: 2px;
    color: #FFFFFF;
}

.input-group-body.right {
    justify-content:flex-end;
}

</style>
<!-- Page Heading -->
<div class="page-header">
  <div class="page-header-main">
    <div class="page-header-title text-white">
      랜딩DB 배정
    </div>
  </div>
  <div class="page-header-sub">
    <div class="page-header-sub-title text-white">
      미배정 <br /><span id="none-recept">0</span> 명
    </div>
  </div>
  <div class="page-header-sub">
    <div class="page-header-sub-title text-white">
      금일 접수량<br /> <span id="today-accept">0</span> 명
    </div>
  </div>
</div>

<!-- Begin Page Content -->
<div class="container-fluid">
  <!-- DataTales Example -->
  <div class="card shadow mb-4">
    <div class="card-header py-3">
        <div class="input-group search-option">
            <div class="col-sm-3">
                <div class="input-group-body">
                    <span class="input-title"> 조건 </span>
                    <select class="custom-select" id="search_type" style="margin: 0 10px 0 10px">
                        <option value="" selected>선택</option>
                        <option value="userNm">이름</option>
                        <option value="mutual">상호</option>
                        <option value="telNo">연락처</option>
                        <option value="businessNo">사업자번호</option>
                        <option value="address">주소</option>
                    </select>
                    <input type="text" class="form-control" id="search_text"/>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="input-group-body">
                    <span class="input-title"> 기간 </span>
                    <input type="text" class="form-control" id="from_date"/>
                    ~
                    <input type="text" class="form-control" id="to_date"/>

                </div>
            </div>
            <div class="col-sm-2">
                <div class="input-group-body">
                    <input type="button" class="form-search" id="submit_btn" value="조회"/>
                    <input type="button" class="form-acpt" id="actp_btn" value="배정"/>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="input-group-body right" style="text-align:right">
                    <span style="color:#000; margin-right:10px"> 다운로드 </span>
                    <a href="javascript:void(0)" id="excel_down">
                        <img src="/img/excel_down.png" style="height:40px"/>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="card-header">

      <table id="landingGrid">
        <thead>
            <th><input type="checkbox" name="select_all" value="1" id="example-select-all"></th>
            <th>번호 <i class="fas fa-sort-down sort-enabled" data-id="id" ></i></th>
            <th>이름 <i class="fas fa-sort-down sort-enabled" data-id="userNm" ></i></th>
            <th>상호 <i class="fas fa-sort-down" data-id="mutual" ></i></th>
            <th>연락처 <i class="fas fa-sort-down" data-id="telNo" ></i></th>
            <th>사업자번호 <i class="fas fa-sort-down" data-id="businessNo" ></i></th>
            <th>주소 <i class="fas fa-sort-down" data-id="address" ></i></th>
            <th>희망방문일 <i class="fas fa-sort-down" data-id="visitAt" ></i></th>
            <th>접수일 <i class="fas fa-sort-down" data-id="id" ></i></th>
            <th>비고</t
        </thead>
      </table>

    </div>
  </div>

</div>
<!-- /.container-fluid -->