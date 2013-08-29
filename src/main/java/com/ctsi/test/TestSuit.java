package com.ctsi.test;

import java.sql.*;

import com.ctsi.db.JdbcUtil;

public class TestSuit {

	static Connection dbcon=null;
	static Statement st=null;
	static ResultSet rs=null;
		
	public static void main(String[] args) throws SQLException {
		int columnIndex=1; 
		String sql="select * from SMS a,r_sms_outworker b where a.id=b.sms_id and b.outworker_id  in (select id from outworker t where t.mobile='12301270003')";	
		dbcon=JdbcUtil.getConnection();
		st=dbcon.createStatement();
		rs=st.executeQuery(sql);
		JdbcUtil.printRs(rs);
		while(rs.next()){
			
			System.out.println(rs.getString(columnIndex));			
			
		}
		
	   int b=Types.INTEGER;
	   int a=Types.CHAR;
	   System.out.println(a);
	   System.out.println(b);
	   
	}

}
