package cz.spring.tutorial.WeatherLogic;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.spring.tutorial.model.WeatherObject;

public class WeatherJSONParser {

	public static WeatherObject getWeather(String data) throws JsonProcessingException, IOException {
				
		WeatherObject weather = new WeatherObject();
		ObjectMapper m = new ObjectMapper();
		JsonNode rootNode = m.readTree(data);		
		
		JsonNode weatherNode = rootNode.path("weather");
		String weatherMain = "";
		String weatherDesc = "";
		for (JsonNode node : weatherNode) {
			weatherMain = node.path("main").asText("none");
			weatherDesc = node.path("description").asText("none");
		}
		JsonNode mainNode = rootNode.path("main");
		double mainTemp = mainNode.path("temp").asDouble();
		double mainPressure = mainNode.path("pressure").asDouble();
		double mainHumidity = mainNode.path("humidity").asDouble();
		weather.setMain(weatherMain);
		weather.setDescription(weatherDesc);
		weather.setTemp(mainTemp);
		weather.setPressure(mainPressure);
		weather.setHumidity(mainHumidity);										
		
		return weather;
	}
	
	public static boolean isJSONValid(String jsonInString ) {
	    try {
	       final ObjectMapper mapper = new ObjectMapper();
	       mapper.readTree(jsonInString);
	       return true;
	    } catch (IOException e) {
	       return false;
	    }
	  }
	
	public static WeatherObject getWeatherStaticTest() throws JsonProcessingException, IOException {
		WeatherObject weather = new WeatherObject();

		ObjectMapper m = new ObjectMapper();
		JsonNode rootNode = m.readTree(new File("C:\\Users\\Radek Soucek\\testData\\weather.json"));		
		
		JsonNode weatherNode = rootNode.path("weather");
		String weatherMain = "";
		String weatherDesc = "";
		for (JsonNode node : weatherNode) {
			weatherMain = node.path("main").asText("none");
			weatherDesc = node.path("description").asText("none");
		}
		JsonNode mainNode = rootNode.path("main");
		double mainTemp = mainNode.path("temp").asDouble();
		double mainPressure = mainNode.path("pressure").asDouble();
		double mainHumidity = mainNode.path("humidity").asDouble();
		weather.setMain(weatherMain);
		weather.setDescription(weatherDesc);
		weather.setTemp(mainTemp);
		weather.setPressure(mainPressure);
		weather.setHumidity(mainHumidity);										
		
		return weather;
	}			
	
}
