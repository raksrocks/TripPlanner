/**
 * 
 */
package com.tp.engines;

import java.util.List;

import com.tp.beans.Place;

/**
 * @author RA312921
 *
 */
public class PathEngine {
	private static final String placesKey="AIzaSyANymbtH2hJwZrPUVH8uhGtdF-iFsNDvzE";
	private static final String geoKey="AIzaSyAeJ5nMpaqfTjNzPVg9ZkYvmRw1JjzL6Y0";
	private static final String mapsKey="AIzaSyAr1ykVTp2ggAOhE9aQ3_evLSl1qmnLaec";
	
	public static Place determineNextPlace(Place origin, List<Place> destinations, int time) {
		
		return origin;
	}
	
	public static void setDistances(List<Place> places) {
		for(Place place:places)
			for(Place innerplace:places) {
				place.getDistances().put(innerplace, getDistance(place,innerplace));
			}
	}
}
