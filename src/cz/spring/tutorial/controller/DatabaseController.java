package cz.spring.tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cz.spring.tutorial.WeatherLogic.WeatherService;
import cz.spring.tutorial.model.WeatherObject;

@Controller
@RequestMapping("/database")
public class DatabaseController {

	@Autowired
	WeatherService weatherService;
	
	@RequestMapping("/list")
	public ModelAndView showList() {
		ModelAndView model = new ModelAndView("list");
		List<WeatherObject> objects = weatherService.getWeatherObjects();
        model.getModelMap().addAttribute("prom3", "class=active");
        model.addObject("weatherObjects", objects);
        return model;
	}
	
	
	@RequestMapping(value="/show/{id}", method=RequestMethod.GET)
	public ModelAndView showObject(@PathVariable int id) {
		ModelAndView model = new ModelAndView("showObject");		
        model.getModelMap().addAttribute("prom3", "class=active");
        WeatherObject weatherObject = weatherService.getWeatherObject(id);
        model.addObject("weatherObject", weatherObject);
        return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView showAdd() {
		ModelAndView model = new ModelAndView("addObject");		
        model.getModelMap().addAttribute("prom3", "class=active");
        model.getModelMap().addAttribute("weatherObject", new WeatherObject());
        return model;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAdd(@ModelAttribute("weatherObject") WeatherObject weatherObject) {		
        weatherService.addWeatherObject(weatherObject);
        System.out.println(weatherObject.toString());
        return "redirect:/database/list";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView showUpdate(@PathVariable int id) {
		ModelAndView model = new ModelAndView("updateObject");		
        model.getModelMap().addAttribute("prom3", "class=active");
        WeatherObject weatherObject = weatherService.getWeatherObject(id);
        model.addObject("weatherObject", weatherObject);
        System.out.println("UPDATE PAGE");
        return model;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView processUpdate(@ModelAttribute("weatherObject") WeatherObject weatherObject) {
		ModelAndView model = new ModelAndView("list");		
        model.getModelMap().addAttribute("prom3", "class=active");
        weatherService.updateWeatherObject(weatherObject);
        return model;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		
        weatherService.deleteWeatherObject(id);
        return "redirect:/database/list";        
	}
	
}
