package cz.spring.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.spring.tutorial.WeatherLogic.WeatherService;
import cz.spring.tutorial.model.WeatherObject;
import cz.spring.tutorial.model.WeatherObjectListXML;


@RestController
@RequestMapping("/api")
public class RESTApiWeatherController {
	
	private static String NOT_FOUND_JSON_MESSAGE = "{  \"cod\": \"404\",  \"message\": \"city not found\" }";
	private static String NOT_FOUND_XML_MESSAGE = "<ClientError><cod>404</cod><message>city not found</message></ClientError>";
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping(value = "/xml/weather/{id}", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<?> getWeatherObjectXML(@PathVariable int id) {
		WeatherObject object = weatherService.getWeatherObject(id);
        if (object == null) {
            return new ResponseEntity<String>(NOT_FOUND_XML_MESSAGE, HttpStatus.NOT_FOUND);
        }        
        return new ResponseEntity<WeatherObject>(object, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/xml/weatherAll", method = RequestMethod.GET, produces = "application/xml")
    public ResponseEntity<?> getWeatherObjectsXML() {
		WeatherObjectListXML objects = new WeatherObjectListXML();
		objects.setWeatherObjects(weatherService.getWeatherObjects());
        if(objects.getWeatherObjects().isEmpty()){
            return new ResponseEntity<String>(NOT_FOUND_XML_MESSAGE, HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<WeatherObjectListXML>(objects, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/json/weather/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getWeatherObject(@PathVariable int id) {
		WeatherObject object = weatherService.getWeatherObject(id);
        if (object == null) {
            return new ResponseEntity<String>(NOT_FOUND_JSON_MESSAGE, HttpStatus.NOT_FOUND);
        }        
        return new ResponseEntity<WeatherObject>(object, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/json/weatherAll", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getWeatherObjects() {
		List<WeatherObject> objects = weatherService.getWeatherObjects();
        if(objects.isEmpty()){
            return new ResponseEntity<String>(NOT_FOUND_JSON_MESSAGE, HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<WeatherObject>>(objects, HttpStatus.OK);
    }
	
	
	
	

}
