/**
 * 
 */
package com.tp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.tp.beans.Distance;
import com.tp.beans.Place;

/**
 * @author RA312921
 *
 */
public class GoogleAPI {

	//private static final String placesKey="AIzaSyANymbtH2hJwZrPUVH8uhGtdF-iFsNDvzE";
	//private static final String geoKey="AIzaSyAeJ5nMpaqfTjNzPVg9ZkYvmRw1JjzL6Y0";
	private static final String mapsKey="AIzaSyAr1ykVTp2ggAOhE9aQ3_evLSl1qmnLaec";
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
		
		String url= "https://maps.googleapis.com/maps/api/distancematrix/xml?units=imperial&origins="+from.getLat()+","+from.getLng()+"&destinations="+to.getLat()+","+to.getLng()+"&key="+mapsKey;
		String response="";
		try{ response = call(url); } catch (Exception e) {
			e.printStackTrace();
		}
		if(response.equalsIgnoreCase(""))
			return null;
		Distance distance = new Distance();
		distance.setDistanceInMiles(Long.parseLong(XMLUtils.getElement(response, "duration", "value")));
		distance.setTimeInMinutes(Integer.parseInt(XMLUtils.getElement(response, "distance", "value")));		
		return distance;
	}
}
