package com.webbfontaine.analysis;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.webbfontaine.analysis.helper.JsonFetcher;

@SpringBootApplication
@EnableAutoConfiguration
public class WebbFontaineApplication{
	 
	public static void main(String[] args) throws JSONException, IOException {
		
//		JsonFetcher jf = new JsonFetcher();
//		String url = "https://api.github.com/repositories?since=364";
//		//URL url = new URL("https://api.github.com/repos/collectiveidea/tinder/commits");
//		
//		List<JSONObject> jsonObjectList = jf.urlToJson(url);
//		System.out.println("Count " + jsonObjectList.size());
//		jsonObjectList.stream().forEach(jsonObject -> {
//			System.out.println(jsonObject.getString("name"));
//			System.out.println(jsonObject.getString("commits_url"));
////			System.out.println(jsonObject.getJSONObject("commit").getJSONObject("committer").getString("name"));
////			System.out.println(jsonObject.getJSONObject("commit").getString("message"));
////			System.out.println(jsonObject.getJSONObject("commit").getJSONObject("committer").getString("date"));
//		});
	    
	    SpringApplication.run(WebbFontaineApplication.class, args);
		
	}
}
