package com.brain.earthcitizenclub.webService.smsService;

public class SMSServiceSoapProxy implements com.brain.earthcitizenclub.webService.smsService.SMSServiceSoap {
  private String _endpoint = null;
  private com.brain.earthcitizenclub.webService.smsService.SMSServiceSoap sMSServiceSoap = null;
  
  public SMSServiceSoapProxy() {
    _initSMSServiceSoapProxy();
  }
  
  public SMSServiceSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSMSServiceSoapProxy();
  }
  
  private void _initSMSServiceSoapProxy() {
    try {
      sMSServiceSoap = (new com.brain.earthcitizenclub.webService.smsService.SMSServiceLocator()).getSMSServiceSoap();
      if (sMSServiceSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sMSServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sMSServiceSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sMSServiceSoap != null)
      ((javax.xml.rpc.Stub)sMSServiceSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.brain.earthcitizenclub.webService.smsService.SMSServiceSoap getSMSServiceSoap() {
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap;
  }
  
  public int SMSInsert_Nation(java.lang.String nationCode, java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.SMSInsert_Nation(nationCode, signatureKey, siteCd, mode, receiverHp, receiverId, senderPhone, sender, message, sendTime);
  }
  
  public int SMSInsert(java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.SMSInsert(signatureKey, siteCd, mode, receiverHp, receiverId, senderPhone, sender, message, sendTime);
  }
  
  public int smsMmsDataSend(java.lang.String signatureKey, int siteCd, java.lang.String refKey, java.lang.String phone, java.lang.String callback, java.lang.String date, java.lang.String SMSMsg, java.lang.String etc1, java.lang.String etc2, java.lang.String etc3, java.lang.String etc5, java.lang.String etc6, int sendType, java.lang.String MMSSubJect, java.lang.String MMSMsg) throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.smsMmsDataSend(signatureKey, siteCd, refKey, phone, callback, date, SMSMsg, etc1, etc2, etc3, etc5, etc6, sendType, MMSSubJect, MMSMsg);
  }
  
  public int SMSInsertDirect(java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.SMSInsertDirect(signatureKey, siteCd, mode, receiverHp, receiverId, senderPhone, sender, message, sendTime);
  }
  
  public java.lang.String debug() throws java.rmi.RemoteException{
    if (sMSServiceSoap == null)
      _initSMSServiceSoapProxy();
    return sMSServiceSoap.debug();
  }
  
  
}