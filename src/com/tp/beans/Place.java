/**
 * 
 */
package com.tp.beans;

import java.util.Map;

/**
 * @author RA312921
 *
 */
public class Place {
	String name;
	Long lat;
	Long lng;
	Timings timings;
	Pricing pricing;
	Long rating;
	String placeId;
	Map<Place,Distance> distances;

}
