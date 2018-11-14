/**
 * SMSServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.brain.earthcitizenclub.webService.smsService;

public interface SMSServiceSoap extends java.rmi.Remote {
    public int SMSInsert_Nation(java.lang.String nationCode, java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException;
    public int SMSInsert(java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException;
    public int smsMmsDataSend(java.lang.String signatureKey, int siteCd, java.lang.String refKey, java.lang.String phone, java.lang.String callback, java.lang.String date, java.lang.String SMSMsg, java.lang.String etc1, java.lang.String etc2, java.lang.String etc3, java.lang.String etc5, java.lang.String etc6, int sendType, java.lang.String MMSSubJect, java.lang.String MMSMsg) throws java.rmi.RemoteException;
    public int SMSInsertDirect(java.lang.String signatureKey, int siteCd, java.lang.String mode, java.lang.String receiverHp, java.lang.String receiverId, java.lang.String senderPhone, java.lang.String sender, java.lang.String message, java.lang.String sendTime) throws java.rmi.RemoteException;
    public java.lang.String debug() throws java.rmi.RemoteException;
}
