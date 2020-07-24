package com.webbfontaine.analysis;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParseException;

public class Test {
	public static void main (String [] args) throws FileNotFoundException, ParseException {
//		String url = "https://api.github.com/repos/collectiveidea/acts_as_money/commits{/sha}";
//		String temp = url.substring(0, url.indexOf("{"));
//		System.out.println(temp);
		FileReader read = new FileReader("C:\\Lhie\\Projects\\workspace_java\\Backup\\JSON\\Repositories.json");
		JSONParser jp = new JSONParser(read);
		
		Object obj = (Object) jp.parse();
		GsonJsonParser gson = new GsonJsonParser();
		
		//JSONArray jArray = new JSONArray(s);
		List<ArrayList> ja =  (List<ArrayList>) obj;
		List<JSONObject> jo = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ja.size(); i++) {
			//gson.parseMap(ja.get(i));
			String str = String.valueOf(ja.get(i));
			//jo.add(new JSONObject(str));
			System.out.println(str);
			
		}
		System.out.println( jo.size());
		//System.out.println(sb.toString());
		//JSONArray jj = new JSONArray(sb.toString());
		//List<JSONObject> jo = new ArrayList<>();
		//jo.stream().forEach(j -> System.out.println(j.getString("name")));
		//System.out.println(jo);
		//List<JSONObject> jo = convertToJsonObjects(jj);
		//jo.stream().forEach(j -> {System.out.println(j.getString("name"));});
		//System.out.println(ja);
//		Iterator<JSONObject> iterator = jo.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(iterator.next().get("name"));
//		}
		
	}
	
	private static List<JSONObject> convertToJsonObjects(JSONArray jsonArray) {
		List<JSONObject> jsonObjects = new ArrayList<>();
		jsonArray.forEach(jsonArrayObject -> {
			//if (jsonArrayObject instanceof JSONObject) {
				jsonObjects.add(new JSONObject(jsonArrayObject.toString()));
			//} else {
			//	throw new JsonParseException();
			//}
		});
		return jsonObjects;
	}

}
