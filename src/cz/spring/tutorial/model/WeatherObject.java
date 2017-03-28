package cz.spring.tutorial.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WeatherObject")
@XmlAccessorType(XmlAccessType.FIELD)
public class WeatherObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7494628749632934047L;
	@XmlAttribute
	private int id;
	@XmlElement
	private String city;
	@XmlElement
	private String main;
	@XmlElement
	private String description;
	@XmlElement
	private double temp;
	@XmlElement
	private double pressure;
	@XmlElement
	private double humidity;
	
	public WeatherObject(){
		
	}		
	
	public WeatherObject(int id, String city, String main, String description, double temp, double pressure,
			double humidity) {
		super();
		this.id = id;
		this.city = city;
		this.main = main;
		this.description = description;
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	@Override
	public String toString() {
		return "WeatherObject [id=" + id + ", city=" + city + ", main=" + main + ", description=" + description
				+ ", temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + "]";
	}

	
	
	
	
			
}
