package com.brain.earthcitizenclub.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.brain.earthcitizenclub.mapper.UserMapper;
import com.brain.earthcitizenclub.util.FileUpload;
import com.brain.earthcitizenclub.util.MailDTO;
import com.brain.earthcitizenclub.util.MailService;
import com.brain.jjan.mapper.EmotionMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserMapper userMapper;

	@Autowired
	MailService mailService;
	


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}

	@RequestMapping("/admin/test")
	public String admin() {
		MailDTO mailDTO = new MailDTO();
		List<String> recieverList = new ArrayList<String>();
		recieverList.add("hiter00@naver.com");
		mailDTO.setSubject("테스트 제목");
		mailDTO.setToUser(recieverList);
		mailDTO.setText("테스트 매일");
		mailService.sendMail(mailDTO);
		return "home";
	}

	@RequestMapping("/fileUpload")
	public String fileUpload(@RequestParam MultipartFile attachFile, HttpServletRequest req) {
		FileUpload FileUpload = new FileUpload();
		String path = req.getSession().getServletContext().getRealPath("");
		FileUpload.writeFile(attachFile, path, attachFile.getOriginalFilename());
		return "home";
	}

	@RequestMapping("/downloadFile")
	public ModelAndView fileDownload(HttpServletRequest request,HttpServletResponse response,  ModelMap model ) throws Exception {
	 
	    /** 첨부파일 상세정보 가져오기 */
		String rootPath = request.getSession().getServletContext().getRealPath("");
	    /** 첨부 파일 정보 */
	    Map<String, Object> fileInfo = new HashMap<String, Object>();
	 
	    fileInfo.put("fileUploadPath", rootPath);
	    fileInfo.put("fileLogicName", "001.jpg");
	    fileInfo.put("filePhysicName", "001.jpg");
  
	    return new ModelAndView("fileDownloadView", "downloadFile", fileInfo);
	}
	
	
	@RequestMapping("/excelDownLoad")
	protected ModelAndView excelDownLoad(Model model){
		
		String labels[] = { "번호", "게시판 구분", "아이콘 구분", "제목", "작성자 아이디","게시일", "등록일", "조회수", "댓글수", "첨부파일","공개여부"};
		int columnWidth[] = { 10, 10, 10, 40, 20, 15, 15, 10, 10 ,10, 10};// 셀크기
		HashMap<String, Object> row = new HashMap<String, Object>();
		model.addAttribute("columnWidth", columnWidth);
		model.addAttribute("sheetName", "게시물 리스트");// 시트명
		model.addAttribute("labels", labels);// 셀타이틀
		row.put("dataList", this.settingsExcelData());// 데이터목록
		row.put("dataLength", labels.length);// 엑셀셀갯
		model.addAttribute("dataMap", row);
		
		return new ModelAndView("downloadXlsView", "excelDownLoad", model);
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main() {
		logger.info("메인");
		return "contetns.t";
	}	
	
	@RequestMapping("/admin/user/userList")
	protected String adminUserList(){
		
		return "user/userList.at";
	}
	
	
	
	private List<Map<String, String>> settingsExcelData(){
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();
		Map<String, String> cell = null;
		int rowName = 1;
		for(int i = 0; i < 10; i++){
			cell = new HashMap<String, String>();
			cell.put("row" + rowName + "_cell1", String.valueOf(i));

			result.add(cell);
			rowName++;
		}
		return result;
	}
}
