package com.brain.earthcitizenclub.util;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

//2016-12-02
//java에서는 데이터 테이블이 없으므로 만들어 써야함.
public class DataTableUtil {
	
	HashMap<String,String> keyList = new HashMap<String,String>();
	List<HashMap<String, String>> dataTable = new ArrayList<HashMap<String,String>>();
	
	public void SetTable(String dataTable) {
		
		String tempRow = null;
		String startTable = "Table";
		String endTable = "</Table>";
		String[] rowDataList = null;
		String selectRowData = null;

		for(int i = 1; i < (i+1); i++){
			tempRow = startTable + String.valueOf(i);
			if(dataTable.indexOf(tempRow) < 0){
				break;
			}
			rowDataList = StringUtil.substringsBetween(dataTable, tempRow, endTable);
			if(rowDataList.length > 0){
				selectRowData = rowDataList[0];
				this.SettingsKeyList(StringUtil.substringsBetween(selectRowData, "<", ">"));
				this.SettingsDataRows(selectRowData);
			}
		}
	}	
	private void SettingsKeyList(String[] allTagName){
		for(int j = 0; j < allTagName.length; j++){
			if(allTagName[j].indexOf("/") == -1){
				this.keyList.put(allTagName[j], allTagName[j]);
			}	
		}
	}
	
	private void SettingsDataRows(String data){
		HashMap<String, String> rows = new HashMap<String, String>();	
		Object[] keyArr = this.keyList.keySet().toArray();
		for(int i = 0; i < keyArr.length; i++){
			rows.put(keyArr[i].toString(), StringUtil.substringBetween(data, "<"+keyArr[i]+">", "</"+keyArr[i]+">"));
		}
		this.dataTable.add(rows);
	}
	
	public HashMap<String, String> GetKeyList() {
		return this.keyList;
	}
	
	public List<HashMap<String, String>> GetDataList() {
		return this.dataTable;
	}
	
	public List<HashMap<String, String>> GetDataTable(String data) throws RemoteException{
		this.SetTable(data);
		return  this.GetDataList();
	}
	
	
}
