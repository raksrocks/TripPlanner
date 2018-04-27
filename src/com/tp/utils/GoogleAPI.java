/**
 * 
 */
package com.tp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.tp.beans.City;
import com.tp.beans.Distance;
import com.tp.beans.Place;

/**
 * @author RA312921
 *
 */
public class GoogleAPI {

	private static final String placesKey="AIzaSyANymbtH2hJwZrPUVH8uhGtdF-iFsNDvzE";
	private static final String geoKey="AIzaSyAeJ5nMpaqfTjNzPVg9ZkYvmRw1JjzL6Y0";
	private static final String mapsKey="AIzaSyAr1ykVTp2ggAOhE9aQ3_evLSl1qmnLaec";
	private static final String URL="https://maps.googleapis.com/maps/api/";
	/**
	 * @param urlToRead
	 * @return
	 * @throws IOException
	 */
	private static String call(String urlToRead) throws IOException {
		StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
           result.append(line);
        }
        rd.close();
        return result.toString();
	}
	
	
	/**
	 * @param from
	 * @param to
	 * @return
	 */
	public static Distance getDistance(Place from, Place to) {
		
		String url= URL+"distancematrix/xml?units=imperial&origins="+from.getLat()+","+from.getLng()+"&destinations="+to.getLat()+","+to.getLng()+"&key="+mapsKey;
		String response="";
		try{ response = call(url); } catch (Exception e) {
			e.printStackTrace();
		}
		if(response.equalsIgnoreCase(""))
			return null;
		Distance distance = new Distance();
		distance.setDistance(Long.parseLong(XMLUtils.getElement(response, "duration", "value")));
		distance.setTime(Integer.parseInt(XMLUtils.getElement(response, "distance", "value")));		
		return distance;
	}
	
	
	/**
	 * @param address
	 * @return
	 */
	public static Place getGeoLocationDetails(String address) {
		Place location = new Place();
		String url =URL+"geocode/xml?address="+address+"&key="+geoKey;
		String response="";
		try{ response = call(url); } catch (Exception e) {
			e.printStackTrace();
		}
		if(response.equalsIgnoreCase(""))
			return null;
		
		location.setLat((XMLUtils.getElement(response, "GeocodeResponse", "lat")));
		location.setLng((XMLUtils.getElement(response, "GeocodeResponse", "lng")));
		
		return location;
	}
	
	
	/**
	 * @param city
	 * @param origin
	 * @param radiusInMeters
	 * @return
	 */
	public static List<Place> getAttractions(City city, Place origin,int radiusInMeters){
		List<Place> places = new ArrayList<Place>();
		String url =URL+"place/textsearch/xml?query="+city.getName()+"+point+of+interest&language=en&location="+origin.getLat()+","+origin.getLng()+"&radius="+radiusInMeters+"&key="+placesKey;				
		String response="";
		try{ response = call(url); } catch (Exception e) {
			e.printStackTrace();
		}
		if(response.equalsIgnoreCase(""))
			return null;
		
		// rewrite the logic with XPath regex.
		int count = response.split("<result>").length-1;
		for(int i=0;i<count;i++) {
			String result = XMLUtils.getElement(response, "PlaceSearchResponse", "result", i);
			Place place = new Place();
			place.setLat((XMLUtils.getElement(result, "location", "lat")));
			place.setLng((XMLUtils.getElement(result, "location", "lng")));
			place.setName(XMLUtils.getElement(result, "result", "name"));
			place.setPlaceId(XMLUtils.getElement(result, "result", "place_id"));
			place.setRating(Long.parseLong(XMLUtils.getElement(result, "result", "rating")));
			getTimings(place);
			places.add(place);
		}
		return places;
	}


	private static void getTimings(Place place) {
		
		String url =URL+"place/details/xml?placeid="+place.getPlaceId()+"&key="+placesKey;								
		String response="";
		try{ response = call(url); } catch (Exception e) {
			e.printStackTrace();
		}
		//TODO: Code later.
		
	}
}
