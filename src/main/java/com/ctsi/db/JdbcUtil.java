package com.ctsi.db;

import java.sql.*;

public class JdbcUtil {
	static{
		   String driverName = 
			  "oracle.jdbc.driver.OracleDriver";
		   try{
		      Class.forName(driverName);
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		}
		public static Connection getConnection(){
		   String url = "jdbc:oracle:thin:@192.9.100.172:1521:inds";
		   String usr = "mtstest";
		   String pwd = "mtstest";
		   Connection con = null;
		   try{
		      con = DriverManager.getConnection(url,usr,pwd);		
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		   return con;
		   
		}
		public static void close(ResultSet rs,Statement stmt,Connection con){
		   try{
		      if(rs!=null) rs.close();
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		   try{
		      if(stmt!=null) stmt.close();
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		   try{
		      if(con!=null) con.close();
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		}
		public static Integer toInt(String s){
		   Integer n = null;
		   try{
		      n = Integer.parseInt(s);
		   }catch(Exception e){
		      System.out.println(e.getMessage());
		   }
		   return n;
		}
		public static void printRs(ResultSet rs){
		    try{
			   ResultSetMetaData meta =
				    rs.getMetaData();
			   int cols = meta.getColumnCount();
			   StringBuffer sb = new StringBuffer();
			   while(rs.next()){
			      for(int i=1;i<=cols;i++){
				     sb.append(meta.getColumnName(i));
					 sb.append("("+meta.getColumnType(i)+")=");
					 sb.append(rs.getString(i)+"  ");
				  }
				  sb.append("\n");
			   }
	           System.out.print(sb.toString());
			}catch(Exception e){
			   System.out.println(e.getMessage());
			}
		}
}
