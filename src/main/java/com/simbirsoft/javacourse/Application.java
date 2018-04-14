package com.simbirsoft.javacourse;

import com.simbirsoft.javacourse.data.DataKeys;
import com.simbirsoft.javacourse.service.HtmlService;
import com.simbirsoft.javacourse.service.HtmlServiceImpl;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Application {

	public static void main(String[] args) {
        System.out.println("Hello world!");
		String configFileInput = "resources/person.properties";
		String configFileOutput = "person.html";
		Properties prop = new Properties();
		try {
			prop.load(new BufferedReader(new InputStreamReader(new FileInputStream(configFileInput), "UTF-8")));
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put(DataKeys.FIO, prop.getProperty(DataKeys.FIO));
		map.put(DataKeys.DOB, prop.getProperty(DataKeys.DOB));
		map.put(DataKeys.PHONE, prop.getProperty(DataKeys.PHONE));
		map.put(DataKeys.EMAIL, prop.getProperty(DataKeys.EMAIL));
		map.put(DataKeys.SKYPE, prop.getProperty(DataKeys.SKYPE));
		map.put(DataKeys.TARGET, prop.getProperty(DataKeys.TARGET));
		map.put(DataKeys.EXPERIENCES, prop.getProperty(DataKeys.EXPERIENCES));
		map.put(DataKeys.EDUCATIONS, prop.getProperty(DataKeys.EDUCATIONS));
		HtmlService htmlService = new HtmlServiceImpl();
		htmlService.createHtml(map);
		htmlService.write(configFileOutput);
	}
}
