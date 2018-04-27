/**
 * 
 */
package com.tp.beans;

import java.util.Map;

/**
 * @author RA312921
 *
 */
public class Timings {
	Boolean openNow;
	Map <Integer,Integer> openingDayTimes;
	Map <Integer,Integer> closingDayTimes;
	/**
	 * @return the openNow
	 */
	public Boolean getOpenNow() {
		return openNow;
	}
	/**
	 * @param openNow the openNow to set
	 */
	public void setOpenNow(Boolean openNow) {
		this.openNow = openNow;
	}
	/**
	 * @return the openingDayTimes
	 */
	public Map<Integer, Integer> getOpeningDayTimes() {
		return openingDayTimes;
	}
	/**
	 * @param openingDayTimes the openingDayTimes to set
	 */
	public void setOpeningDayTimes(Map<Integer, Integer> openingDayTimes) {
		this.openingDayTimes = openingDayTimes;
	}
	/**
	 * @return the closingDayTimes
	 */
	public Map<Integer, Integer> getClosingDayTimes() {
		return closingDayTimes;
	}
	/**
	 * @param closingDayTimes the closingDayTimes to set
	 */
	public void setClosingDayTimes(Map<Integer, Integer> closingDayTimes) {
		this.closingDayTimes = closingDayTimes;
	}

}
