package com.app.jarvis;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;


public class JdbcTemplateClass {  
private JdbcTemplate jdbcTemplate;  
SqlRowSetMetaData resultSetMetaData=null;
  
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
    this.jdbcTemplate = jdbcTemplate;  
}

public SqlRowSet selectdata(String query){  
    SqlRowSet rows = jdbcTemplate.queryForRowSet(query);
  System.out.println("SelectData"+rows);
    return  rows;  
 
}

public int InserUpdateCopyData(String query){   
	    int rows = jdbcTemplate.update(query);
	    return  rows;  
	 
	}

public String replaceParameters(StringBuffer stmt, HashMap paramMap)
{
		 int beginExprPos = 0;
			while((beginExprPos = stmt.indexOf("${")) != -1) 
			{	
			    int closingExprPos = stmt.indexOf("}", beginExprPos);
			    System.out.println("closingExprPos"+closingExprPos);
			    String theParam = stmt.substring(beginExprPos + 2, closingExprPos);
			    System.out.println("theParam"+theParam);
			    Object ssg = paramMap.get(theParam);
			    System.out.println("ssg"+ssg);
			    String replacedStr =ssg.toString();	 
			    System.out.println("replacedStr"+replacedStr);
			    stmt = stmt.replace(beginExprPos, closingExprPos + 1, replacedStr);
			    System.out.println("replacedStr"+stmt);
			} 
	return stmt.toString();
}

//Data retrieve
public HashMap dataretrive(HashMap hu,String hh) throws SQLException{
	
	String sqlScript="select SCRIPTS,MULTIPLE_ROWS,KEY_NAME from cnf_scripts inner join cnf_scripts_asstn on cnf_scripts.ASSTN_ID=cnf_scripts_asstn.ASSTN_ID  where ASSTN_NAME='childname' ";	
    String replaceString=sqlScript.replaceAll("childname",hh);
 	SqlRowSet status=selectdata(replaceString);   
 	while (status.next()) 
 	{
    	 String   sqlScriptt = status.getString("SCRIPTS");
    	 String   multiplerows = status.getString("MULTIPLE_ROWS");
    	 String   keyname=status.getString("KEY_NAME");
	     String   sqlString = replaceParameters(new StringBuffer(sqlScriptt), hu);
	SqlRowSet  retrieveDataResult=selectdata(sqlString);  
	if(multiplerows.equalsIgnoreCase("Y"))
	{	
		ArrayList<HashMap> dataList = new ArrayList<HashMap>();  
		while(retrieveDataResult.next()) 
		{
			resultSetMetaData = retrieveDataResult.getMetaData();
			HashMap childMap = new HashMap();
			int columnCount = resultSetMetaData.getColumnCount();
			for(int i=1;i<=columnCount; i++)
			{
				String columnLabel = resultSetMetaData.getColumnLabel(i);
				if(retrieveDataResult.getObject(columnLabel)!=null)
				{
					childMap.put(columnLabel, retrieveDataResult.getString(columnLabel));
				}
			}
		   dataList.add(childMap);
		}
		hu.put(keyname, dataList);
	}
	else
	{
	if(retrieveDataResult.next()) 
	{
		resultSetMetaData =  retrieveDataResult.getMetaData();
		int columnCount = resultSetMetaData.getColumnCount();
		for(int i=1;i<=columnCount; i++)
		{
			String columnLabel = resultSetMetaData.getColumnLabel(i);
			if(retrieveDataResult.getObject(columnLabel)!=null) 
			{
				hu.put(columnLabel, retrieveDataResult.getString(columnLabel));
			}
		}
	}
	}
	
 	}  
	return hu;
}

//Data Save and Update
public HashMap dataSaveUpdate(HashMap map,String keyword) throws SQLException{
	
	String sqlScript="select SCRIPTS,MULTIPLE_ROWS,KEY_NAME from cnf_scripts inner join cnf_scripts_asstn on cnf_scripts.ASSTN_ID=cnf_scripts_asstn.ASSTN_ID  where ASSTN_NAME='asstnName' ";	
  String replaceString=sqlScript.replaceAll("asstnName",keyword);
	SqlRowSet status=selectdata(replaceString);   
	while (status.next()) {
  	 String sqlScriptt = status.getString("SCRIPTS");
  	 String multiplerows = status.getString("MULTIPLE_ROWS");
  	 String keyname = status.getString("KEY_NAME");
  	 System.out.println("sqlScriptt"+sqlScriptt);
	     String sqlString = replaceParameters(new StringBuffer(sqlScriptt), map);
	     
	     int insertQueriesResult = InserUpdateCopyData(sqlString);  
	     System.out.println("dataSaveUpdate");
	
	map.put("result", "success");
	
	}  
	return map;
}

//Data copy
public HashMap dataCopy(HashMap map,String keyword) throws SQLException{
	
	String sqlScript="select SCRIPTS,MULTIPLE_ROWS,KEY_NAME from cnf_scripts inner join cnf_scripts_asstn on cnf_scripts.ASSTN_ID=cnf_scripts_asstn.ASSTN_ID  where ASSTN_NAME='asstnName' ";	
String replaceString=sqlScript.replaceAll("asstnName",keyword);
	SqlRowSet status=selectdata(replaceString);   
	while (status.next()) {
	 String sqlScriptt = status.getString("SCRIPTS");
	 String multiplerows = status.getString("MULTIPLE_ROWS");
	 String keyname = status.getString("KEY_NAME");
	 System.out.println("sqlScriptt"+sqlScriptt);
	     String sqlString = replaceParameters(new StringBuffer(sqlScriptt), map);
	     
	     int insertQueriesResult = InserUpdateCopyData(sqlString);  
	     System.out.println("dataSaveUpdate");
	
	map.put("result", "success");
	
	}  
	return map;
}

}
