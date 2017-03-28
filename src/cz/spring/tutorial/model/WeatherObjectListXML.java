package cz.spring.tutorial.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="objects")
public class WeatherObjectListXML {

	 private static final long serialVersionUID = 1L;
     
	    private List<WeatherObject> weatherObjects = new ArrayList<WeatherObject>();
	 
	    public List<WeatherObject> getWeatherObjects() {
	        return weatherObjects;
	    }
	 
	    public void setWeatherObjects(List<WeatherObject> objects) {
	        this.weatherObjects = objects;
	    }
}
