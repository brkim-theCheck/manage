package com.thecheck.manage.controller;

import com.thecheck.manage.model.LandingInfoEntity;
import com.thecheck.manage.service.LandingManageService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Controller
public class LandingManageController {

    @Autowired
    LandingManageService landingManageService;

    @RequestMapping(value = "/manage")
    public String main(HttpServletResponse res, HttpServletRequest req,
                       Model model) {
        return "landing/manage";
    }


    @RequestMapping(value = "/manage/posts")
    public ResponseEntity getLandingList(final Pageable pageable, @RequestParam Map<String, Object> param) {

        // page param remove
        if(param.containsKey("size")) {
            param.remove("size");
        }
        if(param.containsKey("page")) {
            param.remove("page");
        }
        if(param.containsKey("sort")) {
            param.remove("sort");
        }

        ResponseEntity ret = landingManageService.getLandingInfo(pageable, param);

        return ret;
    }

    @CrossOrigin(maxAge = 3600L)
    @RequestMapping(value = "/manage/api/save")
    public ResponseEntity saveLandingInfo(@RequestParam Map<String, Object> landingInfoEntity) throws Exception {
        LandingInfoEntity param = new LandingInfoEntity();
        param.setUserNm(landingInfoEntity.get("userNm").toString());
        param.setTelNo(landingInfoEntity.get("telNo").toString());
        param.setMutual(landingInfoEntity.get("mutual").toString());
        param.setBusinessNo(landingInfoEntity.get("businessNo").toString());
        param.setAddress(landingInfoEntity.get("address").toString());
        param.setVisitAt(landingInfoEntity.get("visitAt").toString());
        param.setOpinionDesc(landingInfoEntity.get("opinionDesc").toString());
        param.setChannel(landingInfoEntity.get("channel").toString());

        try {
            ResponseEntity ret = landingManageService.saveLandingInfo(param);
            return ret;
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/manage/excel")
    public void LandingPostExcel(HttpServletResponse response, HttpServletRequest request, @RequestParam Map<String, Object> param) throws Exception{
        List<LandingInfoEntity> page =  landingManageService.findAll(param);

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(xssfWorkbook, 100);

        Sheet objSheet = null;
        Row objRow = null;
        Cell objCell = null;

        objSheet = sxssfWorkbook.createSheet("사용자 랜딩 정보");
        objRow = objSheet.createRow(0);

        objCell = objRow.createCell(0);
        objCell.setCellValue("번호");

        objCell = objRow.createCell(1);
        objCell.setCellValue("상호");

        objCell = objRow.createCell(2);
        objCell.setCellValue("연락처");

        objCell = objRow.createCell(3);
        objCell.setCellValue("사업자번호");

        objCell = objRow.createCell(4);
        objCell.setCellValue("주소");

        objCell = objRow.createCell(5);
        objCell.setCellValue("희망방문일자");

        objCell = objRow.createCell(6);
        objCell.setCellValue("접수일");

        objCell = objRow.createCell(7);
        objCell.setCellValue("희망사항");

        int i = 1;
        for(LandingInfoEntity entity : page) {
            objRow = objSheet.createRow(i++);

            objCell = objRow.createCell(0);
            objCell.setCellValue(entity.getId());

            objCell = objRow.createCell(1);
            objCell.setCellValue(entity.getMutual());

            objCell = objRow.createCell(2);
            objCell.setCellValue(entity.getTelNo());

            objCell = objRow.createCell(3);
            objCell.setCellValue(entity.getBusinessNo());

            objCell = objRow.createCell(4);
            objCell.setCellValue(entity.getBusinessNo());

            objCell = objRow.createCell(5);
            objCell.setCellValue(entity.getVisitAt());

            objCell = objRow.createCell(6);
            objCell.setCellValue(entity.getAcptAt().toString());

            objCell = objRow.createCell(7);
            objCell.setCellValue(entity.getOpinionDesc());
        }

        response.setContentType("Application/Msexcel");
        response.setHeader("Content-Disposition", "ATTachment; Filename=" + URLEncoder.encode("사용자 랜딩 정보", "UTF-8") + ".xlsx");

        OutputStream fileOut = response.getOutputStream();
        sxssfWorkbook.write(fileOut);
        fileOut.close();

        response.getOutputStream().flush();
        response.getOutputStream().close();

        sxssfWorkbook.dispose();
    }

}
