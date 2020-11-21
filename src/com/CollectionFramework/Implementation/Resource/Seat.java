/**
 * 
 */
package com.CollectionFramework.Implementation.Resource;

/**
 * @author Sam
 *
 */
public class Seat {

	private final String seatName ;
	private enum availabilityStatus {Available,Booked};
	
	private boolean isReserved = false;
	public Seat(String seatName) {
		this.seatName = seatName;
	}
	/**
	 * @return the seatName
	 */
	public String getSeatName() {
		return seatName;
	}
	
	public char getRow() {
		return seatName.charAt(0);
	}
/*	public void reserve() {
		if(isReserved())
	}*/
	/**
	 * @return the isReserved
	 */
	public boolean isReserved() {
		if( !this.isReserved ) {
			//System.out.println("your seat "+ seatName + " has been booked.");
			// set reserved to true
			isReserved = true;
		}
		else {
			//System.out.println("your seat "+ seatName + " is not available.");
			isReserved = true;
		}
		return isReserved ;
	}
	/**
	 * @param isReserved the isReserved to set
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

}
