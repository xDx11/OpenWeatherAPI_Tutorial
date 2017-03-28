package cz.spring.tutorial.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import cz.spring.tutorial.WeatherLogic.WeatherJSONParser;
import cz.spring.tutorial.WeatherLogic.WeatherService;
import cz.spring.tutorial.model.City;
import cz.spring.tutorial.model.WeatherObject;

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;
	
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
        model.getModelMap().addAttribute("prom1", "class=active");
        return model;
	}
	
	@RequestMapping("/api")
	public ModelAndView restApi() {
		ModelAndView model = new ModelAndView("api");
        model.getModelMap().addAttribute("prom4", "class=active");
        return model;
	}
	
	@RequestMapping(value="/weather", method=RequestMethod.GET)
	public ModelAndView helloWeather() {
		String message = "<br><div style='text-align:center;'>" + "<h3>Hello OpenWeather APP</div><br><br>";
		ModelAndView model = new ModelAndView("weather", "message", message); 
		model.getModelMap().addAttribute("prom2", "class=active");		
		return model;
	}		

	@RequestMapping(value="/weather", method=RequestMethod.POST)
	public ModelAndView getWeatherDataPost(@ModelAttribute("city") City city, BindingResult result) {
		ModelAndView model = new ModelAndView("weather");		
		WeatherObject object = weatherService.getWeatherDataService(city);		
		if(object!=null){
			model.addObject("object", object);
			model.addObject("cityName", city.getName());
			String message = "<br><div style='text-align:center;'>" + "<h3>Hello OpenWeather APP</div><br><br>";
			model.addObject("message", message);
			model.getModelMap().addAttribute("prom2", "class=active");
		} else {
			String errorMsg = "Error! City not found!";
			model.addObject("error", errorMsg);
		}
		return model;
	}
	
	@RequestMapping(value="/weatherActionPostPara", method=RequestMethod.POST)
	public ModelAndView getWeatherDataPostPara(@RequestParam("name")String name) {
		System.out.println("TEST");
		ModelAndView model = new ModelAndView("weather");
		City city = new City();
		city.setName(name);
		WeatherObject object = weatherService.getWeatherDataService(city);
		//test
		if(object!=null){
			model.addObject("object", object);
			model.addObject("cityName", city.getName());
			String message = "<br><div style='text-align:center;'>" + "<h3>Hello OpenWeather APP</div><br><br>";
			model.addObject("message", message);
			model.getModelMap().addAttribute("prom2", "class=active");
		}
		return model;
	}
	
	@RequestMapping("/weatherTest")
	public ModelAndView getWeatherData() {
		ModelAndView model = new ModelAndView("weather");
		System.out.println("before test");
		try {
			WeatherObject object = WeatherJSONParser.getWeatherStaticTest();
			System.out.println(object.getMain());
			System.out.println(object.getDescription());
			System.out.println(object.getTemp());
			System.out.println(object.getPressure());
			System.out.println(object.getHumidity());
			if(object!=null){
				model.addObject("object", object);
				model.addObject("cityName", "London TEST");
				String message = "<br><div style='text-align:center;'>" + "<h3>Hello OpenWeather APP</div><br><br>";
				model.addObject("message", message);
				model.getModelMap().addAttribute("prom2", "class=active");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("after test");
		return model;
	}
	
	
	
	
}
