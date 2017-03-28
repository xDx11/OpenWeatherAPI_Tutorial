package cz.spring.tutorial.dao;

import java.util.List;

import cz.spring.tutorial.model.WeatherObject;

public interface WeatherObjectDAO {

	public void addWeatherObject(WeatherObject object);
	public void updateWeatherObject(WeatherObject object);
	public WeatherObject getWeatherObject(int id);
	public void deleteWeatherObject(int id);
	public List<WeatherObject> getWeatherObjects();
	public void writeWeatherObjects(List<WeatherObject> objects);
}
