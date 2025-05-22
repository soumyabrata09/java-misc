/**
 * 
 */
package com.sam09.CollectionFramework.Implementation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam
 *
 */
public class Theatre {

	private final String theatreName ;
	List<Seat> seats = new ArrayList<Seat>();
	
	//constructor
	public Theatre(String theatreName, int numOfRows, int seatsOnEachRow) {
		super();
		this.theatreName = theatreName;
		int lastRow = 'A' + (numOfRows-1);
		for(char seatRow ='A' ; seatRow <= lastRow; seatRow++) {
			for( int seatNumber =1 ; seatNumber <= seatsOnEachRow ; seatNumber++) {
		       Seat seat = new Seat(seatRow + String.format("%02d",seatNumber ));
		       seats.add(seat);
			}
			
		}
		
	}
	/**
	 * @return the theatreName
	 */
	public String getTheatreName() {
		return theatreName;
	}
	
	// for testing
    public void getSeats() {
    	char rowDecider = 'A';
    	
        for(Seat seat : seats) {
        	
        	if(rowDecider != seat.getRow()) {
        		System.out.println("----------");
        		rowDecider++;
        	}
        		
        	
        	if( (seat.getSeatName()).startsWith(Character.toString(rowDecider))) {
        	   System.out.print(seat.getSeatName() +"\t");
        	   }
        	else {
        	System.out.println("------");
        		}
        }
    }
	public void reserveSeat(String seatName) {
		Seat requestedSeat = null;
		for(Seat seat : seats) {
			if(seat.getSeatName().equalsIgnoreCase(seatName)) {
				requestedSeat = seat;
				break;
			}
			
		}
		
		if(requestedSeat == null ) {
			System.out.println("Invalid seat selection ");
		}
		else {
			//requestedSeat.reserve();
		}
		
		
	}
	
}
