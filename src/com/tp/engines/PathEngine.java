/**
 * 
 */
package com.tp.engines;

import java.util.List;

import com.tp.beans.Place;
import com.tp.utils.GoogleAPI;

/**
 * @author RA312921
 *
 */
public class PathEngine {
	
	
	/**
	 * @param origin
	 * @param destinations
	 * @param time
	 * @return
	 */
	public static Place determineNextPlace(Place origin, List<Place> destinations, int time) {
		
		return origin;
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
