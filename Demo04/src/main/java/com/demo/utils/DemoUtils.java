package com.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoUtils {

	public static Date formatadaData(String data) throws Exception {
		
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception("Erro ao formatar data");
		}
		return date;
	}

}
