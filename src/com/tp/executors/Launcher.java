/**
 * 
 */
package com.tp.executors;

import java.util.List;
import java.util.Scanner;

import com.tp.beans.City;
import com.tp.beans.Distance;
import com.tp.beans.Place;
import com.tp.engines.PathEngine;
import com.tp.utils.GoogleAPI;

/**
 * @author RA312921
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		City city = new City();
		//System.out.println("Enter City Name:");
		//city.setName(scan.next());
		//city.setName("Durham,UK");
		//city.setName("York,UK");
		city.setName("Cardiff,UK");
		//city.setName("Hyderabad,India");
		//System.out.println("Enter Starting Point:");
		//String address=scan.next();
		//String address="North+Road+Busstand+Durham+UK";
		//String address="Railway+station+York+UK";
		String address="Brut+Park+Cardiff+UK";
		//String address="Rajiv+Gandhi+International+Airport";
		scan.close();
		Place origin = GoogleAPI.getGeoLocationDetails(address);
		origin.setName(address.replace("+", " "));
		System.out.println("Finding nearest places in "+city.getName());
		List<Place> attractions = GoogleAPI.getAttractions(city, origin, 20000);
		for(Place pl: attractions)
			System.out.println("Found:"+pl.getName());
		System.out.println("********************************************************************* ");
		Double timeSpent =600d;
		while(timeSpent>0 && attractions.size()>1) { // 10 hours
			Place nextPlace = PathEngine.determineNextPlaceByTime(origin, attractions);
			Distance distance = GoogleAPI.getDistance(origin, nextPlace);
			System.out.println("Go from "+origin.getName()+" to " +nextPlace.getName()+"("+(distance.getDistance())/1000+" km)");
			int intValue = distance.getTime().intValue();
			//System.out.println("Distance travelled is: "+intValue/60 +"("+intValue+" secpnds)");
			timeSpent = timeSpent - (intValue)/60;
			timeSpent = timeSpent - 45;
			attractions.remove(attractions.indexOf(nextPlace));
			//System.out.println("Time Spent:"+timeSpent);
			origin = nextPlace;
		}
		
		
		
	}

}
