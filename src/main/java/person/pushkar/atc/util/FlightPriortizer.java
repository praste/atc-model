package person.pushkar.atc.util;

import java.util.Comparator;

import person.pushkar.atc.model.Flight;
import person.pushkar.atc.model.FlightDirection;

/**
 * Implementation for prioritizing flights 
 * @author pushkar
 *
 */
public class FlightPriortizer implements Comparator<Flight> {

	@Override
	public int compare(Flight o1, Flight o2) {
		if(o1.getFlightDirection().equals(o2.getFlightDirection())) {
			return o1.getVersionNumber() - o2.getVersionNumber();
		} else {
			// if flights have different direction, flight to LAND is given higher priority.
			return o1.getFlightDirection().equals(FlightDirection.LAND) ? -1 : 1;
		}
	}

}
