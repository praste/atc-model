package person.pushkar.atc.util;

import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

import person.pushkar.atc.model.Flight;
import person.pushkar.atc.model.FlightDirection;

public class FlightPrioritizerTest {

	@Test
	public void testFlightsAreReturnInRightPriority() throws InterruptedException {
		Comparator<Flight> prioritizer = new FlightPriortizer();
		
		// for flights with same direction a flight added first wins 
		Flight takingOffFlight1 = new Flight("1", FlightDirection.TAKE_OFF, 1);
		Flight takingOffFlight2 = new Flight("2", FlightDirection.TAKE_OFF, 2);
		Assert.assertTrue(prioritizer.compare(takingOffFlight1, takingOffFlight2) < 0);
		
		Flight landingFlight1 =  new Flight("3", FlightDirection.LAND, 3);
		Flight landingFlight2 =  new Flight("3", FlightDirection.LAND, 4);
		Assert.assertTrue(prioritizer.compare(landingFlight1, landingFlight2) < 0);
		
		// for flights in different direction landing flight has priority over taking off flights
		Assert.assertTrue(prioritizer.compare(landingFlight1, takingOffFlight1) < 0);
		Assert.assertTrue(prioritizer.compare(landingFlight1, takingOffFlight2) < 0);
		
		Assert.assertTrue(prioritizer.compare(landingFlight2, takingOffFlight1) < 0);
		Assert.assertTrue(prioritizer.compare(landingFlight2, takingOffFlight2) < 0);
	}
}
