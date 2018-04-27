/**
 * 
 */
package com.tp.executors;

import java.util.List;
import java.util.Scanner;

import com.tp.beans.City;
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
		city.setName("Hyderabad,India");
		//System.out.println("Enter Starting Point:");
		//String address=scan.next();
		//String address="North+Road+Busstand+Durham+UK";
		String address="Rajiv+Gandhi+International+Airport";
		scan.close();
		Place origin = GoogleAPI.getGeoLocationDetails(address);
		System.out.println("Finding nearest places in "+city.getName());
		List<Place> attractions = GoogleAPI.getAttractions(city, origin, 20000);
		for(Place pl: attractions)
			System.out.println("Found:"+pl.getName());
		Place nextPlace = PathEngine.determineNextPlaceByTime(origin, attractions);
		System.out.println("Nearest to you is:"+nextPlace.getName());
		
	}

}
