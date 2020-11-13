/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2020-11-11 06:17:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.landing;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class manage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"/lib/datepicker/css/bootstrap-datepicker.min.css\"/>\n");
      out.write("<script src=\"/lib/datepicker/js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("<script src=\"/lib/datepicker/js/bootstrap-datepicker.ko.min.js\"></script>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css\"/>\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.datatables.net/select/1.3.1/css/select.dataTables.min.css\"/>\n");
      out.write("\n");
      out.write("<script src=\"https://cdn.datatables.net/select/1.3.1/js/select.bootstrap4.js\"></script>\n");
      out.write("<script src=\"/lib/bootstrap/vendor/datatables/jquery.dataTables.min.js\"></script>\n");
      out.write("<script src=\"/lib/bootstrap/vendor/datatables/dataTables.bootstrap4.min.js\"></script>\n");
      out.write("\n");
      out.write("<script type=\"text/JavaScript\">\n");
      out.write("let size = 15;\n");
      out.write("let page = 0;\n");
      out.write("let totalPages;\n");
      out.write("let grid;\n");
      out.write("let datatable_grid;\n");
      out.write("let selected_row;\n");
      out.write("let ord_prm = 'id,desc';\n");
      out.write("let search_type;\n");
      out.write("let search_text;\n");
      out.write("let from_date;\n");
      out.write("let to_date;\n");
      out.write("\n");
      out.write("$(document).ready(function() {\n");
      out.write("\n");
      out.write("  datatable_grid = $(\"#landingGrid\").DataTable({\n");
      out.write("    columns : [\n");
      out.write("        { \"name\" : \"acpt_chk\", \"data\" : \"acpt_chk\"},\n");
      out.write("        { \"name\" : \"id\", \"data\" : \"id\"},\n");
      out.write("        { \"name\" : \"userNm\", \"data\" : \"userNm\"},\n");
      out.write("        { \"name\" : \"mutual\", \"data\" : \"mutual\"},\n");
      out.write("        { \"name\" : \"telNo\", \"data\" : \"telNo\", \"render\"  : function (data, type, row) {\n");
      out.write("              return data.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,\"$1-$2-$3\");\n");
      out.write("           }\n");
      out.write("        },\n");
      out.write("        { \"name\" : \"businessNo\", \"data\" : \"businessNo\" , \"render\" : function (data, type, row) {\n");
      out.write("              return data.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{5})/,\"$1-$2-$3\");\n");
      out.write("           }\n");
      out.write("        },\n");
      out.write("        { \"name\" : \"address\", \"data\" : \"address\" },\n");
      out.write("        { \"name\" : \"visitDt\", \"data\" : \"visitAt\" , \"render\" : function(data, type, row) {\n");
      out.write("                return data.replace(/(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})/, '$1-$2-$3 $4:$5');\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        { \"name\" : \"acptDt\", \"data\" : \"acptAt\" , \"render\" : function(data, type, row) {\n");
      out.write("                return data.replace(\"T\", ' ');\n");
      out.write("            }\n");
      out.write("        },\n");
      out.write("        { \"name\" : \"opinionDesc\", \"data\" : \"opinionDesc\" , \"render\" : function (data, type, row) {\n");
      out.write("            selected_row = row;\n");
      out.write("            return \"<i class='fa fa-comment-dots'> </i>\";\n");
      out.write("          },\n");
      out.write("          \"className\" : \"detail-desc\"\n");
      out.write("        }\n");
      out.write("    ],\n");
      out.write("    'columnDefs': [{\n");
      out.write("       'targets': 0,\n");
      out.write("       'searchable':false,\n");
      out.write("       'orderable':false,\n");
      out.write("       'className': 'dt-body-center',\n");
      out.write("       'render': function (data, type, full, meta){\n");
      out.write("           return '<input type=\"checkbox\" class=\"row-check\" name=\"acpt-chk\" >';\n");
      out.write("       }\n");
      out.write("    }],\n");
      out.write("    scrollX : false,\n");
      out.write("    scrollY : '600px',\n");
      out.write("    scrollCollapse: true,\n");
      out.write("    ordering : false,\n");
      out.write("    searching: false,\n");
      out.write("    lengthChange: false,\n");
      out.write("    paging : false,\n");
      out.write("    info : false\n");
      out.write("  });\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   $('.dataTables_scrollBody').on('scroll',function(ev) {\n");
      out.write("        let tbody = $(\".dataTables_scrollBody tbody\").height();\n");
      out.write("        let scrollBody = $(\".dataTables_scrollBody\").height();\n");
      out.write("        let scrollTop = $(\".dataTables_scrollBody\").scrollTop();\n");
      out.write("\n");
      out.write("        if( scrollTop != 0 ) {\n");
      out.write("            if( (scrollBody + scrollTop) - tbody >= 0 && (totalPages != page)) {\n");
      out.write("                createRows();\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#landingGrid tbody').on('click','td.detail-desc', function () {\n");
      out.write("        let tr = $(this).closest('tr');\n");
      out.write("        let row = datatable_grid.row(tr);\n");
      out.write("\n");
      out.write("         if ( row.child.isShown() ) {\n");
      out.write("            // This row is already open - close it\n");
      out.write("            row.child.hide();\n");
      out.write("            tr.removeClass('shown');\n");
      out.write("        }\n");
      out.write("        else {\n");
      out.write("            // Open this row\n");
      out.write("            row.child( format(row.data()) ).show();\n");
      out.write("            tr.addClass('shown');\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $('#example-select-all').on('click', function(){\n");
      out.write("       // Check/uncheck checkboxes for all rows in the table\n");
      out.write("       $('.dataTables_scrollBody input[type=\"checkbox\"]').prop('checked', this.checked);\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\".fa-sort-down, .fa-sort-up\").on('click', function() {\n");
      out.write("        let obj = $(this);\n");
      out.write("        let ord_id = obj.data('id');\n");
      out.write("        if(obj.hasClass('fa-sort-down')) {\n");
      out.write("            $(\".fa-sort-up\").removeClass('fa-sort-up').addClass('fa-sort-down');\n");
      out.write("            if(obj.hasClass(\"sort-enabled\")) {\n");
      out.write("                obj.removeClass('fa-sort-down').addClass('fa-sort-up');\n");
      out.write("                ord_prm = ord_id+\",asc\";\n");
      out.write("            } else {\n");
      out.write("                $(\".sort-enabled\").removeClass('sort-enabled');\n");
      out.write("                obj.addClass('sort-enabled');\n");
      out.write("                ord_prm = ord_id+\",desc\";\n");
      out.write("            }\n");
      out.write("        } else if (obj.hasClass('fa-sort-up')) {\n");
      out.write("            if(obj.hasClass(\"sort-enabled\")) {\n");
      out.write("                obj.removeClass('fa-sort-up').addClass('fa-sort-down');\n");
      out.write("                ord_prm = ord_id+\",desc\";\n");
      out.write("            } else {\n");
      out.write("                $(\".sort-enabled\").removeClass('sort-enabled');\n");
      out.write("                obj.addClass('sort-enabled');\n");
      out.write("                ord_prm = ord_id+\",asc\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        //page reset\n");
      out.write("        page = 0;\n");
      out.write("        datatable_grid.clear().draw();\n");
      out.write("        createRows();\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    $(\"#submit_btn\").on('click', function(){ reSearch();});\n");
      out.write("    $(\"#excel_down\").on('click', function(){\n");
      out.write("        getExcel();\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    createRows();\n");
      out.write("    //datepicker\n");
      out.write("\n");
      out.write("    $('#from_date, #to_date').datepicker({\n");
      out.write("        format: \"yyyy-mm-dd\",\t//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )\n");
      out.write("        autoclose : true,\t//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션\n");
      out.write("        disableTouchKeyboard : false,\t//모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.\n");
      out.write("        templates : {\n");
      out.write("            leftArrow: '&laquo;',\n");
      out.write("            rightArrow: '&raquo;'\n");
      out.write("        }, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징\n");
      out.write("        todayHighlight : true ,\t//오늘 날짜에 하이라이팅 기능 기본값 :false\n");
      out.write("        toggleActive : true,\t//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제\n");
      out.write("        weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일\n");
      out.write("        language : \"ko\"\t//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.\n");
      out.write("    });\n");
      out.write("    //datepicker end\n");
      out.write("\n");
      out.write("});\n");
      out.write("\n");
      out.write("\n");
      out.write("/* Formatting function for row details - modify as you need */\n");
      out.write("function format ( d ) {\n");
      out.write("    // `d` is the original data object for the row\n");
      out.write("    return '<table cellpadding=\"8\" cellspacing=\"0\" border=\"0\" style=\"padding:20px;\" class=\"detail-desc\">'+\n");
      out.write("        '<tr>'+\n");
      out.write("            '<th>이름 : </th>'+\n");
      out.write("            '<td>'+d.userNm+'</td>'+\n");
      out.write("            '<th>연락처 : </th>'+\n");
      out.write("            '<td colspan=\"2\">'+d.telNo.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{4})/,\"$1-$2-$3\")+'</td>'+\n");
      out.write("        '</tr>'+\n");
      out.write("        '<tr>'+\n");
      out.write("            '<th>상호 : </th>'+\n");
      out.write("            '<td>'+d.mutual+'</td>'+\n");
      out.write("            '<th>사업자 번호 : </th>'+\n");
      out.write("            '<td colspan=\"2>'+d.businessNo.replace(/(^02.{0}|^01.{1}|[0-9]{3})([0-9]+)([0-9]{5})/,\"$1-$2-$3\")+'</td>'+\n");
      out.write("        '</tr>'+\n");
      out.write("        '<tr>'+\n");
      out.write("            '<th>주소:</th>'+\n");
      out.write("            '<td colspan=\"5\">'+d.address+'</td>'+\n");
      out.write("        '</tr>'+\n");
      out.write("        '<tr>'+\n");
      out.write("            '<th>희망방문일:</th>'+\n");
      out.write("            '<td>'+d.visitAt.replace(/(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})/, '$1-$2-$3 $4:$5:$6')+'</td>'+\n");
      out.write("            '<th>접수일:</th>'+\n");
      out.write("            '<td>'+d.acptAt.replace('T', ' ')+'</td>'+\n");
      out.write("        '</tr>'+\n");
      out.write("        '<tr>'+\n");
      out.write("            '<th>희망사항:</th>'+\n");
      out.write("            '<td colspan=\"5\">'+d.opinionDesc+'</td>'+\n");
      out.write("        '</tr>'+\n");
      out.write("    '</table>';\n");
      out.write("}\n");
      out.write("\n");
      out.write("function reSearch() {\n");
      out.write("    page=0;\n");
      out.write("    datatable_grid.clear().draw();\n");
      out.write("    createRows();\n");
      out.write("}\n");
      out.write("\n");
      out.write("function createRows() {\n");
      out.write("  let rows;\n");
      out.write("\n");
      out.write("  let data  = {\n");
      out.write("         'size': size,\n");
      out.write("         'page' : page,\n");
      out.write("         'sort' : ord_prm\n");
      out.write("       };\n");
      out.write("\n");
      out.write("  search_type = $(\"#search_type\").val();\n");
      out.write("  search_text = $(\"#search_text\").val();\n");
      out.write("  from_date = $(\"#from_date\").val().replace(/-/gi,'');\n");
      out.write("  to_date = $(\"#to_date\").val().replace(/-/gi, '');\n");
      out.write("\n");
      out.write("  if(search_type != \"\" && search_type != \"\") {\n");
      out.write("    data[search_type] = search_text;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  if(from_date != '' && to_date != '') {\n");
      out.write("    data.acptAt = from_date+'000000,'+to_date+'235959';\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  $.ajax({\n");
      out.write("    url: 'http://localhost:8080/manage/posts',\n");
      out.write("    method: 'POST',\n");
      out.write("    data: data,\n");
      out.write("    dataType: 'json',\n");
      out.write("    success: function(res) {\n");
      out.write("        totalPages = res.totalPages;\n");
      out.write("      if(page <= (totalPages - 1)) {\n");
      out.write("        page += 1;\n");
      out.write("\n");
      out.write("        rows = res.content;\n");
      out.write("        rows.forEach(function(data) {\n");
      out.write("            data[\"acpt_chk\"] = null;\n");
      out.write("            datatable_grid.row.add(data).draw();\n");
      out.write("        });\n");
      out.write("      } else {\n");
      out.write("\n");
      out.write("      }\n");
      out.write("    },\n");
      out.write("    error: function(res) {\n");
      out.write("    }\n");
      out.write("  });\n");
      out.write("}\n");
      out.write("\n");
      out.write("function getExcel() {\n");
      out.write("\n");
      out.write("  let param = \"\";\n");
      out.write("\n");
      out.write("  if(search_type != \"\" && search_type != \"\") {\n");
      out.write("    param += search_type + \"=\" + search_text;\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  if(from_date != '' && to_date != '') {\n");
      out.write("    param += \"&acptAt=\"+from_date+'000000,'+to_date+'235959'\n");
      out.write("  }\n");
      out.write("\n");
      out.write("  location.href = \"http://localhost:8080/manage/excel?\"+param;\n");
      out.write("\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("<!-- Begin Page Content -->\n");
      out.write("<style>\n");
      out.write(".page-header {\n");
      out.write("    height: 173px;\n");
      out.write("    top: 0px;\n");
      out.write("    background: radial-gradient(100% 100% at 100% 100%, #002470 0%, #005EC0 100%);\n");
      out.write("    mix-blend-mode: normal;\n");
      out.write("    opacity: 0.84;\n");
      out.write("    position:relative;\n");
      out.write("}\n");
      out.write(".page-header-main {\n");
      out.write("    position:relative;\n");
      out.write("    height:67px;\n");
      out.write("    top: 40%;\n");
      out.write("    left: 4%;\n");
      out.write("    display:inline-block;\n");
      out.write("    margin-right:10%\n");
      out.write("}\n");
      out.write("\n");
      out.write(".page-header-sub {\n");
      out.write("    position:relative;\n");
      out.write("    height:67px;\n");
      out.write("    top: 40%;\n");
      out.write("    display:inline-block;\n");
      out.write("    min-width:110px;\n");
      out.write("    margin-right:10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".page-header-title {\n");
      out.write("    font-family: Apple SD Gothic Neo;\n");
      out.write("    font-style:normal;\n");
      out.write("    font-weight: 100;\n");
      out.write("    font-size: 56px;\n");
      out.write("    line-height:67px;\n");
      out.write("    letter-spacing: -3px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".page-header-sub-title {\n");
      out.write("    text-align:right;\n");
      out.write("    border-left: 2px solid #EEEEEE;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dataTables_wrapper {\n");
      out.write("    font-family: Apple SD Gothic Neo;\n");
      out.write("    font-size: 15px;\n");
      out.write("    font-style: normal;\n");
      out.write("    font-weight: 300;\n");
      out.write("    color : #000000\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write(".dataTables_wrapper.no-footer .dataTables_scrollBody {\n");
      out.write("    border-bottom : none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.dataTable {\n");
      out.write("    border-collapse: separate;\n");
      out.write("    border-spacing: 0 7px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.dataTable thead th {\n");
      out.write("    text-align : center;\n");
      out.write("    padding: 10px 18px;\n");
      out.write("    border-bottom : none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.dataTable tbody td {\n");
      out.write("    text-align : center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("table.detail-desc tbody td {\n");
      out.write("    text-align : left;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".sort-enabled {\n");
      out.write("    color: blue;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".search-option {\n");
      out.write("    justify-content: left;\n");
      out.write("    align-items: center;\n");
      out.write("}\n");
      out.write("\n");
      out.write("span.input-title {\n");
      out.write("    color: #000;\n");
      out.write("    min-width:35px\n");
      out.write("}\n");
      out.write(".input-group-title, .input-group-body, input-group-body.input {\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: row;\n");
      out.write("    align-items:center;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".input-group-body input, input-group-body select {\n");
      out.write("    margin: 0 10px 0 10px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-search {\n");
      out.write("    width: 100%;\n");
      out.write("    height: calc(1.5em + .75rem + 2px);\n");
      out.write("    padding: .375rem .75rem;\n");
      out.write("    font-size: 1rem;\n");
      out.write("    font-weight: 400;\n");
      out.write("    line-height: 1.5;\n");
      out.write("    background: #FFFFFF;\n");
      out.write("    border: 1px solid #32B8D3;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    border-radius: 2px;\n");
      out.write("    color: #32B8D3;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".form-acpt {\n");
      out.write("    width: 100%;\n");
      out.write("    height: calc(1.5em + .75rem + 2px);\n");
      out.write("    padding: .375rem .75rem;\n");
      out.write("    font-size: 1rem;\n");
      out.write("    font-weight: 400;\n");
      out.write("    line-height: 1.5;\n");
      out.write("    background: #32B8D3;\n");
      out.write("    border: 1px solid #32B8D3;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("    border-radius: 2px;\n");
      out.write("    color: #FFFFFF;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".input-group-body.right {\n");
      out.write("    justify-content:flex-end;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<!-- Page Heading -->\n");
      out.write("<div class=\"page-header\">\n");
      out.write("  <div class=\"page-header-main\">\n");
      out.write("    <div class=\"page-header-title text-white\">\n");
      out.write("      랜딩DB 배정\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"page-header-sub\">\n");
      out.write("    <div class=\"page-header-sub-title text-white\">\n");
      out.write("      미배정 <br /><span id=\"none-recept\">0</span> 명\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"page-header-sub\">\n");
      out.write("    <div class=\"page-header-sub-title text-white\">\n");
      out.write("      금일 접수량<br /> <span id=\"today-accept\">0</span> 명\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Begin Page Content -->\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("  <!-- DataTales Example -->\n");
      out.write("  <div class=\"card shadow mb-4\">\n");
      out.write("    <div class=\"card-header py-3\">\n");
      out.write("        <div class=\"input-group search-option\">\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("                <div class=\"input-group-body\">\n");
      out.write("                    <span class=\"input-title\"> 조건 </span>\n");
      out.write("                    <select class=\"custom-select\" id=\"search_type\" style=\"margin: 0 10px 0 10px\">\n");
      out.write("                        <option value=\"\" selected>선택</option>\n");
      out.write("                        <option value=\"userNm\">이름</option>\n");
      out.write("                        <option value=\"mutual\">상호</option>\n");
      out.write("                        <option value=\"telNo\">연락처</option>\n");
      out.write("                        <option value=\"businessNo\">사업자번호</option>\n");
      out.write("                        <option value=\"address\">주소</option>\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"search_text\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-3\">\n");
      out.write("                <div class=\"input-group-body\">\n");
      out.write("                    <span class=\"input-title\"> 기간 </span>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"from_date\"/>\n");
      out.write("                    ~\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"to_date\"/>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-2\">\n");
      out.write("                <div class=\"input-group-body\">\n");
      out.write("                    <input type=\"button\" class=\"form-search\" id=\"submit_btn\" value=\"조회\"/>\n");
      out.write("                    <input type=\"button\" class=\"form-acpt\" id=\"actp_btn\" value=\"배정\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4\">\n");
      out.write("                <div class=\"input-group-body right\" style=\"text-align:right\">\n");
      out.write("                    <span style=\"color:#000; margin-right:10px\"> 다운로드 </span>\n");
      out.write("                    <a href=\"javascript:void(0)\" id=\"excel_down\">\n");
      out.write("                        <img src=\"/img/excel_down.png\" style=\"height:40px\"/>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"card-header\">\n");
      out.write("\n");
      out.write("      <table id=\"landingGrid\">\n");
      out.write("        <thead>\n");
      out.write("            <th><input type=\"checkbox\" name=\"select_all\" value=\"1\" id=\"example-select-all\"></th>\n");
      out.write("            <th>번호 <i class=\"fas fa-sort-down sort-enabled\" data-id=\"id\" ></i></th>\n");
      out.write("            <th>이름 <i class=\"fas fa-sort-down sort-enabled\" data-id=\"userNm\" ></i></th>\n");
      out.write("            <th>상호 <i class=\"fas fa-sort-down\" data-id=\"mutual\" ></i></th>\n");
      out.write("            <th>연락처 <i class=\"fas fa-sort-down\" data-id=\"telNo\" ></i></th>\n");
      out.write("            <th>사업자번호 <i class=\"fas fa-sort-down\" data-id=\"businessNo\" ></i></th>\n");
      out.write("            <th>주소 <i class=\"fas fa-sort-down\" data-id=\"address\" ></i></th>\n");
      out.write("            <th>희망방문일 <i class=\"fas fa-sort-down\" data-id=\"visitAt\" ></i></th>\n");
      out.write("            <th>접수일 <i class=\"fas fa-sort-down\" data-id=\"id\" ></i></th>\n");
      out.write("            <th>비고</t\n");
      out.write("        </thead>\n");
      out.write("      </table>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("<!-- /.container-fluid -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}