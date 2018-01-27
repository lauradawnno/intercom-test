package com.intercom.customer_test.utils;

import static java.lang.Math.atan;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.toRadians;

public class GeoUtils {
	
	public static final int EARTH_RADIUS = 6371;
	public static final double OFFICE_LAT = toRadians(53.339428);
	public static final double OFFICE_LON = toRadians(-6.257664);
	
	/**
	 * Calculates the distance in km between the provided point and the Intercom 
	 * office location
	 * 
	 * @param lat latitude in degrees
	 * @param lon longitude in degrees
	 * @return distance in km between the provided point and Intercom office location
	 */
	public static double getDistance (double lat,double lon){
		
		double radLat = toRadians(lat);
		double radLon = toRadians(lon);
		
		double angle = getCentralAngle(radLat,radLon);
		
		return angle * EARTH_RADIUS;
	}

	/**
	 * Calculates the central angle between the provided point and the Intercom
	 * office location
	 * 
	 * @param lat latitude in radians
	 * @param lon longitude in radians
	 * @return the central angle between the provided point and Intercom office location
	 */
	public static double getCentralAngle(double lat, double lon){
		
		double cosOffLat = cos(OFFICE_LAT);
		double cosLat = cos(lat);
		double sinOffLat = sin(OFFICE_LAT);
		double sinLat = sin(lat);
		double cosDiffLon = cos(lon- OFFICE_LON);
		double sinDiffLon = sin(lon- OFFICE_LON);
		
		double numerator = sqrt(pow((cosOffLat*sinDiffLon),2) + 
								pow(((cosLat*sinOffLat)-(sinLat*cosOffLat*cosDiffLon)),2));
		
		double denominator = (sinLat*sinOffLat) + (cosLat*cosOffLat*cosDiffLon);
		
		return atan(numerator/denominator);
	}

}
