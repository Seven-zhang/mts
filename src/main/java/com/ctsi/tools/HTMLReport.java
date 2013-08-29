package com.ctsi.tools;

import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.io.FileWriter;
import java.io.Writer;
import org.apache.log4j.Logger;
import org.testng.ITestResult;



public class HTMLReport {
Writer outputReport = null;
Logger logger = Logger.getLogger(this.getClass());
static Writer outputSummaryReport = null;

public static String folderName = null;
public static String fileName = "LogReport";
public static String reportGenerated = "";
public static int PassCount=0;
public static int FailCount=0;
public static int NotCompleted=0;
public static int TotalDuration = 0; 


private Map caseinfo = new HashMap();


private int testmodule_totalnum = 0;
private int testmodule_passnum = 0;
private int testmodule_failnum = 0;
private int testmodule_nanum   = 0;

private Map steps = new HashMap();

public HTMLReport(){
	
}



/********************************************************/
/***************HTML Reporting PHASE-2*******************/
/********************************************************/

//Method to generate reports
public void generateReport()throws Exception
{	reportGenerated="true";  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	Calendar cal = Calendar.getInstance();
	String timeStamp=dateFormat.format(cal.getTime());
	String path = System.getProperty("user.dir");
	 if(path.equals("")){
		 fileName = "Regression_Result-"+"-"+timeStamp+".html";
	    }else{
	    	fileName = path+"\\"+"Regression_Result-"+"-"+timeStamp+".html";
	    }   
    FileWriter fstream = new FileWriter(fileName);
    System.out.println("Report's FileName: "+fileName);
    BufferedWriter out = new BufferedWriter(fstream);
    out.write("<html>");
    out.write("<head>");
    out.write("<style type='text/css'> " 
    		+ " #summary" 
  	      + " {"
  	      + " font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;"
  	      + " width:100%;"
  	      + " border-collapse:collapse;"
  	      + " }"
  	      + " #summary td, #summary th"
  	      + " {"
  	      + " font-size:0.8em;"
  	      + " border:1px solid #98bf21;"
  	      + " padding:3px 7px 2px 7px;"
  	      + " }"
  	      + " #summary th"
  	      + " {"
  	      + " font-size:1.0em;"
  	      + " text-align:left;"
  	      + " padding-top:5px;"
  	      + " padding-bottom:4px;"
  	      + " background-color:#A7C942;"
  	      + " color:#ffffff;"
  	      + " }"
  	      
  	    + " #componentWiseSummary" 
	      + " {"
	      + " font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;"
	      + " width:100%;"
	      + " border-collapse:collapse;"
	      + " }"
	      + " #summary td, #summary th"
	      + " {"
	      + " font-size:0.8em;"
	      + " border:1px solid #98bf21;"
	      + " padding:3px 7px 2px 7px;"
	      + " }"
	      + " #summary th"
	      + " {"
	      + " font-size:1.0em;"
	      + " text-align:left;"
	      + " padding-top:5px;"
	      + " padding-bottom:4px;"
	      + " background-color:#A7C942;"
	      + " color:#ffffff;"
	      + " }"
  	      
		  + " #customers" 
	      + " {"
	      + " font-family:\"Trebuchet MS\", Arial, Helvetica, sans-serif;"
	      + " width:100%;"
	      + " border-collapse:collapse;"
	      + " }"
	      + " #customers td, #customers th"
	      + " {"
	      + " font-size:0.8em;"
	      + " border:1px solid #98bf21;"
	      + " padding:3px 7px 2px 7px;"
	      + " }"
	      + " #customers th"
	      + " {"
	      + " font-size:1.1em;"
	      + " text-align:left;"
	      + " padding-top:5px;"
	      + " padding-bottom:4px;"
	      + " background-color:#A7C942;"
	      + " color:#ffffff;"
	      + " }"
	      + " #customers tr.alt td"
	      + " {"
	      + " color:#000000;"
	      + " background-color:#EAF2D3;"
	      + " }"
+ " </style>");
    out.write("</head>");

    out.write("<body>");
    
    out.write("<table width=800 border=0 cellpadding=2 cellspacing=2>");
    out.write("<tbody>");
    out.write("<tr>");
	out.write("<td>");
	out.write("<table width=100% border=0 cellpadding=2 cellspacing=2>");
	out.write("<tbody>");
	out.write("<tr>");
	out.write("<td align=center><p class=title><h1>mts Test Report </h1></p></td></tr>");
	out.write("</tr>" + "</tbody>" + "</table>" + "<br>");
    
    
    
    /**
     * Creating tables in HTML for Test Status
     */
    
    
    
    out.write("<table id=\"customers\">");
    out.write("<tr>");
    out.write("<th>Sr No</th>");
    out.write("<th>Test Case ID</th>");
    out.write("<th>Test Name and Steps</th>");
    out.write("<th>Execution Time(secs)</th>");
    out.write("<th>Status</th>");
    out.write("<th>Comments</th>");
    out.write("</tr>");
    out.write("</body>");
    out.write("</html>");
    out.flush();
    out.close();
    
}


// Method to Log the Status
public void sendStatusToReport(int SR_NO,String TC_ID, long Duration,String Comments,ITestResult result,Map steps)throws Exception
{   String keyname = null;
    this.steps = steps;
    
	FileWriter fstream = new FileWriter(fileName, true);
    
    BufferedWriter out = new BufferedWriter(fstream);
    out.write("<tr >");
    out.write("<td><b>" + SR_NO + "</b></td>");
    out.write("<td><b>" + TC_ID + "</b></td>");
    out.write("<td><b>" + result.getName() + "</b></td>");
    out.write("<td><b>" + Duration + "</b></td>");
    int mark= 0;
    Iterator it = steps.keySet().iterator();
    while(it.hasNext()){
        keyname = (String)it.next();           
    	if(steps.get(keyname).toString().equals("false")|steps.get(keyname).toString().equals("")|steps.get(keyname).toString()==null){    		
    		mark = 1;
    		break;
    	}
    }

    
    if(mark == 0&&result.getStatus()==1){
        out.write("<td><b>" + "Pass"+ "</b></td>");
        PassCount++;
    }
    if(mark==1|result.getStatus()==2){
    	out.write("<td><b>" + "Fail"+ "</b></td>");
    	FailCount++;
    }
    out.write("<td><b>" + Comments + "</b></td>");
    out.write("</tr>");
    out.flush();
    out.close();
    String currDirectory = System.getProperty("user.dir");
 	
    
    testmodule_totalnum++;

    TotalDuration = TotalDuration+(int)(Duration);
    this.sendMessageToReport();
    steps.clear();
}

// Method to log the message.
public void sendMessageToReport()throws Exception
{   
	String keyname = null;
	
	TreeMap tm = new TreeMap(steps);
	Iterator it = tm.keySet().iterator();

	FileWriter fstream = new FileWriter(fileName, true);
	 BufferedWriter out = new BufferedWriter(fstream);
	
	int i = 1; 
	while(it.hasNext()){
		keyname = (String)it.next();  		
        if(tm.get(keyname).toString().equals("true"))
           // out.write("<tr class=\"alt\">");
            out.write("<tr bgcolor=rgb(187,187,187)>");
        else if(tm.get(keyname).toString().equals("false"))
        	out.write("<tr bgcolor=#FF0000>");
            //out.write("<tr class=\"alt\">");
        	
        else
        	out.write("<tr class=\"alt\">");           
            
        out.write("<td></td>"); 
        out.write("<td></td>");       	 
        out.write("<td>" + keyname + "</td>");    
        out.write("<td></td>");
        if(tm.get(keyname).toString().equals("true"))
            out.write("<td>Pass</td>");
        else if(tm.get(keyname).toString().equals("false"))
    	    out.write("<td>Fail</td>");
        else
    	    out.write("<td>Not Completed</td>");    
            out.write("<td></td>");
            out.write("</tr>");
	}
		

    out.flush();
    out.close();
}



}
