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
		System.out.println("Enter City Name:");
		city.setName(scan.next());
		System.out.println("Enter Starting Point:");
		String address=scan.next();
		scan.close();
		Place origin = GoogleAPI.getGeoLocationDetails(address);
		
		List<Place> attractions = GoogleAPI.getAttractions(city, origin, 2000);
		
		Place nextPlace = PathEngine.determineNextPlaceByTime(origin, attractions);
		System.out.println(nextPlace.getName());
		
	}

}
