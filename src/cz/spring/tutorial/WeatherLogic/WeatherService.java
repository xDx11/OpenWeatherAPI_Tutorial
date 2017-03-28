package cz.spring.tutorial.WeatherLogic;

import java.util.List;

import cz.spring.tutorial.model.City;
import cz.spring.tutorial.model.WeatherObject;

public interface WeatherService {
	public WeatherObject getWeatherDataService(City city);
	
	public void addWeatherObject(WeatherObject object);
	public void updateWeatherObject(WeatherObject object);
	public WeatherObject getWeatherObject(int id);
	public void deleteWeatherObject(int id);
	public List<WeatherObject> getWeatherObjects();

}
