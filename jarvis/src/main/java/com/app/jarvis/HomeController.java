
package com.app.jarvis;

import java.text.SimpleDateFormat;



import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import java.io.*;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import com.app.jarvis.HomeService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

@RestController
public class HomeController
    {
	//ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
 	//HomeService service=(HomeService)ctx.getBean("service"); 
 	HomeService service = new HomeService();
        @RequestMapping(value="/hello")
        public ModelAndView hello()
        {
        	System.out.println("dsjgfvdhj");
            return new ModelAndView("hello");
        }
        
    
        
        @RequestMapping(value="/effectiveDate")
	    public HashMap Enabledeffectivedate() throws SQLException
	    {
        	  HashMap map=new HashMap();
	  /*   	SqlRowSet status=dao.selectdata();  
	     	if (status.next()) {
	     	 int   i = status.getInt("EFFECTIVE_DAYS");
			// 	System.out.println("camein3"+sfq);
	        System.out.println(status); 
	    	   Calendar now = Calendar.getInstance();
	    	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	   String currentDate = simpleDateFormat.format(now.getTime());
	    	   now.add(Calendar.DATE,i);
	    	   String effectiveDate = simpleDateFormat.format(now.getTime());
	    	   System.out.println("CurrentDate"+currentDate);
	    	   System.out.println("EffectiveDate"+effectiveDate); } */
	  //  	   hu.put("currentDate",currentDate);
	   //	   hu.put("effectiveDate",effectiveDate);
	    	   map.put("jarco",1);
	    	   map.put("jatto","kk");
	    	   map.put("luke","mm");
	    	//   String querytrr="querytr";
	    	   service.getEffectiveDateService(map,"querytrr");
	    	  System.out.println("hashmap"+map);

	     	return map;
	    }
        
       /* @RequestMapping(value="/SetEffectiveDays")
	    public HashMap setEffectiveDays() throws SQLException{
	    	
	    	HashMap userDetMap = new HashMap();
	    	userDetMap.put("traEffectiveDaysId", 4);
	    	userDetMap.put("effectiveDays", "80");
	    	userDetMap.put("startDate", "2019-05-13");
	    	
	    	//Call date save and update function to store userdetails
	    	service.setUserDetailsService(userDetMap,"userDetails");
	    	  
	    	   System.out.println("hashmap"+userDetMap);
	    	   return userDetMap;
	     	
	    }*/
        
        @RequestMapping(value="/SetUserDetails")
	    public HashMap setUserDetails() throws SQLException{
	    	
	    	HashMap userDetMap = new HashMap();
	    	//userDetMap.put("userId", 5);
	    	userDetMap.put("firstName", "ArunKumar");
	    	userDetMap.put("lastName", "Veluraj");
	    	userDetMap.put("emailId", "arun@jarvis.com");
	    	userDetMap.put("contactNumber", "9876543210");
	    	

	    	// convert to XML
	    	XStream xStream = new XStream(new DomDriver());
	    	xStream.alias("map", java.util.Map.class);
	    	String xml = xStream.toXML(userDetMap);
	    	System.out.println("xml output"+xml);

	    	 
	    	
	    	// from XML, convert back to map
	  //  	Map<String,Object> map2 = (Map<String,Object>) xStream.fromXML(xml);
	    	
	    	//Call date save and update function to store userdetails
	 //   	service.setUserDetailsService(userDetMap,"userDetails");
	    	  
	    	   System.out.println("hashmap"+userDetMap);
	    	   return userDetMap;
	     	
	    }
        
        
        @RequestMapping(value = "/getxmljson", method = RequestMethod.POST,produces={"application/json","application/xml"},
                consumes={"application/json", "application/xml"})
        
 //       @RequestMapping(value="/SelectInsertDetails")
	    public String selectInserDetails() throws SQLException, ParserConfigurationException, SAXException, IOException{
        	
        	
        	 File inputFile = new File("input.txt");
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse("inputFile");
             doc.getDocumentElement().normalize();
             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
             NodeList nList = doc.getElementsByTagName("student");
             System.out.println("----------------------------");
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
	 /*   	
        	HashMap userDetMap = new HashMap();
	    	userDetMap.put("userId", 3);
	    	userDetMap.put("firstName", "Deepa");
	    	userDetMap.put("lastName", "Mohan");
	    	userDetMap.put("emailId", "deepa@jarvis.com");
	    	userDetMap.put("contactNumber", "9876543210");
	    	
	    	//Call date save and update function to store userdetails
	    	service.selectInserDetailsService(userDetMap,"selectinsert");
	    		*/   return "Copied";
	     
	    }
       
       
        @RequestMapping(value="/UpdateUserDetails")
	    public HashMap updateUserDetails() throws SQLException{
	    	
	    	HashMap userDetMap = new HashMap();
	    	userDetMap.put("userId", 3);
	    	userDetMap.put("firstName", "Deepa");
	    	userDetMap.put("lastName", "Mohan");
	    	userDetMap.put("emailId", "deepa@jarvis.com");
	    	userDetMap.put("contactNumber", "9876543210");
	    	
	    	//Call date save and update function to store userdetails
	    	service.updateUserDetailsService(userDetMap,"updateUserDetails");
	    	  
	    	   System.out.println("hashmap"+userDetMap);
	    	   return userDetMap;
	     	
	    }
    }