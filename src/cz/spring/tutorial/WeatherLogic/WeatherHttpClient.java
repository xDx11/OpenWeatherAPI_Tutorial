package cz.spring.tutorial.WeatherLogic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {

	private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
	
	public String getWeatherData(String location) {
		  HttpURLConnection con = null ;
		  InputStream is = null;
		 
		  try {
		   con = (HttpURLConnection) ( new URL(BASE_URL + location + "&units=metric&APPID=cbb62d72bc31618d822f0f887b9368da")).openConnection();
		   //String url = "http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a1";
		   //con = (HttpURLConnection) ( new URL(url)).openConnection();
		   con.setRequestMethod("GET");
		   con.setDoInput(true);
		   con.setDoOutput(true);
		   con.connect();
		   
		   boolean isError = con.getResponseCode() >= 400;
		   int responseCode = con.getResponseCode();
		   String responseMessage = con.getResponseMessage();
		   System.out.println("Response code: " + responseCode);
		   System.out.println("Response message: " + responseMessage);
		   // Let's read the response
		   
		   if(!isError){
			   StringBuffer buffer = new StringBuffer();
			   is = con.getInputStream();
			   BufferedReader br = new BufferedReader(new InputStreamReader(is));
			   String line = null;
			   while ( (line = br.readLine()) != null )
			     buffer.append(line + "rn");
			 
			   is.close();
			   con.disconnect();
			   return buffer.toString();
		   } else {
			   con.disconnect();
			   return responseMessage;
		   }
		   
		 }
		 catch(Throwable t) {
		  t.printStackTrace();
		 }
		 finally {
		  try { is.close(); } catch(Throwable t) {}
		  try { con.disconnect(); } catch(Throwable t) {}
		 }
		 
		 return null;
		 
		}
	
}
