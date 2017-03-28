package cz.spring.tutorial.dao;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cz.spring.tutorial.model.WeatherObject;

@Repository
public class WeatherObjectDAOImpl implements WeatherObjectDAO {

	public static String DATABASE_FILE = "C:\\Users\\Radek Soucek\\testData\\weatherDatabase.txt";
	
	@Override
	public void addWeatherObject(WeatherObject object) {
		List<WeatherObject> objects = getWeatherObjects();
		objects.add(object);
		writeWeatherObjects(objects);		
	}

	@Override
	public void updateWeatherObject(WeatherObject object) {
		// TODO Auto-generated method stub

	}

	@Override
	public WeatherObject getWeatherObject(int id) {
		List<WeatherObject> objects = getWeatherObjects();
		for( WeatherObject object : objects){
			if(object.getId()==id){
				return object;
			}
		}
		return null;
	}

	@Override
	public void deleteWeatherObject(int id) {
		List<WeatherObject> objects = getWeatherObjects();
		List<WeatherObject> copyObjects = new ArrayList<>(objects);
		
		for( WeatherObject object : copyObjects){
			if(object.getId()==id){
				objects.remove(object);
			}
		}
		writeWeatherObjects(objects);

	}
	
	

	@Override
	public List<WeatherObject> getWeatherObjects() {
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		List<WeatherObject> objects = new ArrayList<>();
		try{
			fi = new FileInputStream(new File(DATABASE_FILE));
			oi = new ObjectInputStream(fi);

			// Read objects
			while(true){
				try{
					WeatherObject object = (WeatherObject) oi.readObject();
					objects.add(object);
					System.out.println(object.toString());
				} catch (EOFException ex){
					return objects;
				} 								
			}						
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			if (fi != null) {
				try {
					System.out.println("fi close!");
					fi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oi != null) {
				try {
					System.out.println("oi close!");
					oi.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
		return null;
	}

	@Override
	public void writeWeatherObjects(List<WeatherObject> objects) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		try {
			fout = new FileOutputStream(DATABASE_FILE);
			oos = new ObjectOutputStream(fout);
			for(WeatherObject object : objects){
				oos.writeObject(object);
			}			
			System.out.println("Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		
	}

}
