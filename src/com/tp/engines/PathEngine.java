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
	
	public static Place determineNextPlace(Place origin, List<Place> destinations) {
		return origin;
	}
}
