package com.brain.earthcitizenclub.util;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.brain.earthcitizenclub.webService.smsService.SMSServiceSoapProxy;

public class SmsUtil {
	
	private void Send(String receiverPhoneNum, String senderPhoneNum, String SMSMsg, int SendType, String MMSMsg) throws RemoteException {
		
        Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        
		String signatureKey = "A23BAF36-2C2D-3A5F";
		String today = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
		
		int siteCd = 19;

		SMSServiceSoapProxy SMSServiceSoapProxy = new SMSServiceSoapProxy();
		SMSServiceSoapProxy.smsMmsDataSend(signatureKey, siteCd, "HISTORY", receiverPhoneNum, senderPhoneNum, today, SMSMsg, "", "", "", "", "비밀번호 변경", SendType, "[역사진단학회]", MMSMsg);
		          
	}
	
	//TODO
	//발송 전화번호 바꾸기
	public boolean sendSms(String receiverPhoneNum,String msg) {
		String SMSMsg = null;
        String MMSMsg = null;
		String senderPhoneNum = "02-0123-4567";
		String MsgStr = msg;
        boolean result = false;
		MsgStr = MsgStr.replace("\r\n", "\n");
        
        int SendType = 4;
		
        if (MsgStr.getBytes().length > 80) {
		    MMSMsg = MsgStr;
		    SendType = 6;
		}else {
		    SMSMsg = MsgStr;
		}
		
		try {
			this.Send(receiverPhoneNum, senderPhoneNum, SMSMsg, SendType, MMSMsg);
			result = true;
		} catch (RemoteException e) {
			System.out.println("reissuance error : "+ e.getMessage());
		}
		
		return result;
	}
}
