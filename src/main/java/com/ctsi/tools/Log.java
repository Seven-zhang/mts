package com.ctsi.tools;

import org.testng.Reporter;

	public class Log {
		public static void comment(String log)
		{
			Reporter.log(log, true);
		}

	
}
