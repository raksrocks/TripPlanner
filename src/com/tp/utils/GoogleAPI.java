/**
 * 
 */
package com.tp.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author RA312921
 *
 */
public class GoogleAPI {
	private static final String placesKey="AIzaSyANymbtH2hJwZrPUVH8uhGtdF-iFsNDvzE";
	private static final String geoKey="AIzaSyAeJ5nMpaqfTjNzPVg9ZkYvmRw1JjzL6Y0";
	private static final String mapsKey="AIzaSyAr1ykVTp2ggAOhE9aQ3_evLSl1qmnLaec";
	
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
}
