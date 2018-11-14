package com.brain.earthcitizenclub.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerUtil {
	
//	@Autowired
//    private MailServiceImpl mailService;
	
//	@Autowired
//	SqlSessionTemplate sqlSession;

	// up_deleteAdminLog 5년마다 관리자 로그 삭제
	// up_deleteUserLog 6개월 지나면 개인정보 접근 로그 삭제
	// up_deleteInquire 문의하기 내역 삭제
	// up_updateStautsD 휴면계정 처리
	

	@Scheduled(cron = "0 12 13 * * * ")
	private void runSchedulerUtil() {		 
//		Date date = new Date();
//		SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");		
//		System.out.println(dFormat.format(date) + " : runSchedulerUtil called ");
//		try {
//			List<HashMap<String, String>> userList = sqlSession.selectList("schedul.fireUserList");
//			sqlSession.update("schedul.runScheduler");
////			this.sendEmail(userList);			
//		} catch (Exception e) {
//			System.out.println("runSchedulerUtil error :" + e.getMessage());
//		}
	}		
//	private void sendEmail(List<HashMap<String, String>> userList){
//		HashMap<String, String> temp = null;
//		MailDTO mail = new MailDTO();
//		MainController mc = new MainController();
//		FileReaderUtil fu = new FileReaderUtil();
//		String title = "[역사진단학회] 미이용처리 안내.";
//		String folderPath = mc.getFolderPath();
//		String emailPath = 	folderPath+ File.separator + "WEB-INF" + File.separator + "views" + File.separator + "common" + 
//							File.separator + "mail" + File.separator + "mailExpiryDate.html";		
//		
//		
//		String contents = null;
//		for(int i = 0; i <userList.size(); i++){
//			List<String> recieverList = new ArrayList<String>();
//			temp = userList.get(i);
//			contents = fu.getEmailHTMLForSleepUser(emailPath, temp.get("userNm"), temp.get("fireDtm"));
//			recieverList.add(temp.get("email"));
//			mail.setSubject(title);
//			mail.setToUser(recieverList);
//			mail.setText(contents);
//			mailService.sendMail(mail);
//			try{
//				sqlSession.update("schedul.updateSendFireEmailUser",temp.get("userId"));
//			} catch (Exception e) {
//				System.out.println("updateSendFireEmailUser error :" + e.getMessage());
//			}
//		}
//	}
}
