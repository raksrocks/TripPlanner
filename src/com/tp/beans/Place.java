/**
 * 
 */
package com.tp.beans;

import java.util.Map;

/**
 * @author Rakesh
 *
 */
public class Place {
	String name;
	String lat;
	String lng;
	Timings timings;
	Pricing pricing;
	String rating;
	String placeId;
	Map<Place,Distance> distances;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lat
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * @param lat the lat to set
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * @return the lng
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * @param lng the lng to set
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	/**
	 * @return the timings
	 */
	public Timings getTimings() {
		return timings;
	}
	/**
	 * @param timings the timings to set
	 */
	public void setTimings(Timings timings) {
		this.timings = timings;
	}
	/**
	 * @return the pricing
	 */
	public Pricing getPricing() {
		return pricing;
	}
	/**
	 * @param pricing the pricing to set
	 */
	public void setPricing(Pricing pricing) {
		this.pricing = pricing;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}
	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	/**
	 * @return the distances
	 */
	public Map<Place, Distance> getDistances() {
		return distances;
	}
	/**
	 * @param distances the distances to set
	 */
	public void setDistances(Map<Place, Distance> distances) {
		this.distances = distances;
	}

}
