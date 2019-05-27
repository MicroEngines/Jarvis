package com.app.jarvis;
import java.text.SimpleDateFormat;



import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.io.*;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

public class HomeService
{

	ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
 	JdbcTemplateClass dao=(JdbcTemplateClass)ctx.getBean("edao"); 
 	
 	public HashMap setUserDetailsService(HashMap userDetails,String keyWord) throws SQLException{
 		 dao.dataSaveUpdate(userDetails,keyWord);
 		 return userDetails;
 	}
 	
 	public HashMap getEffectiveDateService(HashMap effDateDetails, String keyWord) throws SQLException{
 		 dao.dataretrive(effDateDetails,keyWord);
 		 return effDateDetails;
 	}
 	
 	public HashMap updateUserDetailsService(HashMap updateUserDetails,String keyWord) throws SQLException{
 		HashMap updateMap = new HashMap();
 		updateMap = dao.dataSaveUpdate(updateUserDetails,keyWord);
		 
		return updateUserDetails;
	}
	
 	public HashMap selectInserDetailsService(HashMap userDetails,String keyWord) throws SQLException{
 		 dao.dataCopy(userDetails,keyWord);
 		 return userDetails;
 	}
 	
}