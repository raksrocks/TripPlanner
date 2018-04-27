/**
 * 
 */
package com.tp.beans;

import java.util.List;

/**
 * @author RA312921
 *
 */
public class City {
	String name;
	Place startingPoint;
	List<Place> places;
	Place endingPoint;
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
	 * @return the startingPoint
	 */
	public Place getStartingPoint() {
		return startingPoint;
	}
	/**
	 * @param startingPoint the startingPoint to set
	 */
	public void setStartingPoint(Place startingPoint) {
		this.startingPoint = startingPoint;
	}
	/**
	 * @return the places
	 */
	public List<Place> getPlaces() {
		return places;
	}
	/**
	 * @param places the places to set
	 */
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	/**
	 * @return the endingPoint
	 */
	public Place getEndingPoint() {
		return endingPoint;
	}
	/**
	 * @param endingPoint the endingPoint to set
	 */
	public void setEndingPoint(Place endingPoint) {
		this.endingPoint = endingPoint;
	}
}
