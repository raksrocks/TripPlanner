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

	
	/**
	 * @param urlToRead
	 * @return
	 * @throws IOException
	 */
	public static String call(String urlToRead) throws IOException {
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
		return null;
	}
}
