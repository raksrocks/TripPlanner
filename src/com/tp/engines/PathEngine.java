/**
 * 
 */
package com.tp.engines;

import java.util.List;

import com.tp.beans.Distance;
import com.tp.beans.Place;
import com.tp.utils.GoogleAPI;

/**
 * @author RA312921
 *
 */
public class PathEngine {
	
	
	/**
	 * Get nearest destination from the list in a given time.
	 * @param origin
	 * @param destinations
	 * @param time
	 * @return
	 */
	public static Place determineNextPlaceByTime(Place origin, List<Place> destinations) {
		
		Integer nearest =1000000;
		Place nearestPlace = origin;
		for(Place dest: destinations) {
			if(!origin.equals(dest) && dest.getName()!=null&& dest.getName().length()!=0) {
				Distance distance = GoogleAPI.getDistance(origin, dest);
				Integer time = distance.getTime();
				//System.out.println(dest.getName()+" is approximately "+(time.intValue()) / 60+" minutes ("+time.intValue()+"ms) drive far from you");
				if(nearest.intValue()<distance.getTime())
					continue;
				nearest = distance.getTime();
				nearestPlace = dest;
			}
		}
		return nearestPlace;
	}
	
	/**
	 * Get nearest destination from the list sorted by distance
	 * @param origin
	 * @param destinations
	 * @param time
	 * @return
	 */
	public static Place determineNextPlaceByDistance(Place origin, List<Place> destinations) {
		
		Integer nearest =0;
		Place nearestPlace = origin;
		for(Place dest: destinations) {
			if(!origin.equals(dest)) {
				Distance distance = GoogleAPI.getDistance(origin, dest);
				
				if(nearest.intValue()<distance.getDistance())
					continue;
				nearest = distance.getDistance().intValue();
				nearestPlace = dest;
			}
		}
		return nearestPlace;
	}
	
	/**
	 * @param places
	 */
	public static void setDistances(List<Place> places) {
		for(Place place:places)
			for(Place innerplace:places) 
				if(!place.equals(innerplace))
					place.getDistances().put(place, GoogleAPI.getDistance(place,innerplace));
			
	}
}
