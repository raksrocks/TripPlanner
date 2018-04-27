package com.tp.beans;

public class Distance {
	Integer timeInSeconds;
	/**
	 * @return the timeInMinutes
	 */
	public Integer getTime() {
		return timeInSeconds;
	}
	/**
	 * @param timeInMinutes the timeInMinutes to set
	 */
	public void setTime(Integer timeInMinutes) {
		this.timeInSeconds = timeInMinutes;
	}
	/**
	 * @return the distanceInMiles
	 */
	public Long getDistance() {
		return distance;
	}
	/**
	 * @param distanceInMiles the distanceInMiles to set
	 */
	public void setDistance(Long distanceInMiles) {
		this.distance = distanceInMiles;
	}
	Long distance;

}
