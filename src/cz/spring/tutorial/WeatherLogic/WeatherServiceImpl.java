package cz.spring.tutorial.WeatherLogic;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.spring.tutorial.dao.WeatherObjectDAO;
import cz.spring.tutorial.model.City;
import cz.spring.tutorial.model.WeatherObject;

@Service
public class WeatherServiceImpl implements WeatherService {
	
	@Autowired
	private WeatherObjectDAO weatherObjectDao;
	
	public WeatherObject getWeatherDataService(City city){
		WeatherObject object;
		System.out.println("TEST");
		System.out.println(city.getName());
		System.out.println("before test");
		try {
			WeatherHttpClient client = new WeatherHttpClient();
			String dataJSON = client.getWeatherData(city.getName());
			System.out.println("DATA JSON: ");
			System.out.println(dataJSON);			
			if (!dataJSON.isEmpty()) {
				if(WeatherJSONParser.isJSONValid(dataJSON)){
					object = WeatherJSONParser.getWeather(dataJSON);
					System.out.println(object.getMain());
					System.out.println(object.getDescription());
					System.out.println(object.getTemp());
					System.out.println(object.getPressure());
					System.out.println(object.getHumidity());
					return object;
				} else {
					return null;
				}
				
			}
			return null;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
						
	}

	@Override
	public void addWeatherObject(WeatherObject object) {
		weatherObjectDao.addWeatherObject(object);				
	}

	@Override
	public void updateWeatherObject(WeatherObject object) {
		weatherObjectDao.updateWeatherObject(object);		
	}

	@Override
	public WeatherObject getWeatherObject(int id) {
		return weatherObjectDao.getWeatherObject(id);
	}

	@Override
	public void deleteWeatherObject(int id) {		
		weatherObjectDao.deleteWeatherObject(id);
	}

	@Override
	public List<WeatherObject> getWeatherObjects() {
		return weatherObjectDao.getWeatherObjects();
	}
	
	

}
