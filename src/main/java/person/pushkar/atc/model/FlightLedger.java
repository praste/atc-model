package person.pushkar.atc.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FlightLedger {

	@Override
	public String toString() {
		return "FlightLedger [time=" + time + ", waitingForTakeOff=" + waitingForTakeOff + ", waitingForLanding="
				+ waitingForLanding + ", successfullyLanded=" + successfullyLanded + ", successfullyTookOff="
				+ successfullyTookOff + ", inFlightLanding=" + inFlightLanding + ", inFlightTakeOff=" + inFlightTakeOff
				+ "]";
	}

	private long time;

	private List<Flight> waitingForTakeOff;
	private List<Flight> waitingForLanding;

	private List<Flight> successfullyLanded;
	private List<Flight> successfullyTookOff;

	private List<Flight> inFlightLanding;
	private List<Flight> inFlightTakeOff;
	
	public FlightLedger() {
		
	}
	
	public FlightLedger(long time, List<Flight> flights) {
		
		this.time = time;
		
		Map<FlightStatus, List<Flight>> flightsForTakeOff = 
				flights.stream().filter(x -> x.getFlightDirection() == FlightDirection.TAKE_OFF)
				.collect(Collectors.groupingBy(x -> x.getFlightStatus()));
		
		Map<FlightStatus, List<Flight>> flightsForLanding = 
				flights.stream().filter(x -> x.getFlightDirection() == FlightDirection.LAND)
				.collect(Collectors.groupingBy(x -> x.getFlightStatus()));
		
		
		waitingForTakeOff = flightsForTakeOff.getOrDefault(FlightStatus.AWAITING, Collections.<Flight>emptyList());
		successfullyTookOff = flightsForTakeOff.getOrDefault(FlightStatus.SUCCESSFULL, Collections.<Flight>emptyList());
		inFlightTakeOff = flightsForTakeOff.getOrDefault(FlightStatus.INFLIGHT, Collections.<Flight>emptyList());
		
		waitingForLanding = flightsForLanding.getOrDefault(FlightStatus.AWAITING, Collections.<Flight>emptyList());
		successfullyLanded = flightsForLanding.getOrDefault(FlightStatus.SUCCESSFULL, Collections.<Flight>emptyList());
		inFlightLanding = flightsForLanding.getOrDefault(FlightStatus.INFLIGHT, Collections.<Flight>emptyList());
	}
	
	public long getTime() {
		return time;
	}

	public List<Flight> getWaitingForTakeOff() {
		return waitingForTakeOff;
	}

	public List<Flight> getWaitingForLanding() {
		return waitingForLanding;
	}

	public List<Flight> getSuccessfullyLanded() {
		return successfullyLanded;
	}

	public List<Flight> getSuccessfullyTookOff() {
		return successfullyTookOff;
	}

	public List<Flight> getInFlightLanding() {
		return inFlightLanding;
	}

	public List<Flight> getInFlightTakeOff() {
		return inFlightTakeOff;
	}
}
