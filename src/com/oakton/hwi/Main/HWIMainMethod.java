package com.oakton.hwi.Main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.TestNG;

import com.oakton.hwi.Utility.Log;
import com.oakton.hwi.Utility.ReadConfigFile;

public class HWIMainMethod {

	public static void main(String[] args) {

		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("Get Health at Work Automation");

		ReadConfigFile rcf = new ReadConfigFile();
		TestNG runner = new TestNG();

		// Create a list of String
		List<String> suitefiles = new ArrayList<String>();
		suitefiles.add(rcf.getTestNGPath());
		// now set xml file for execution
		runner.setTestSuites(suitefiles);

		// finally execute the runner using run method
		runner.run();

	}

}
