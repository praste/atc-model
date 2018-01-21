package person.pushkar.atc.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flight implements Cloneable {

    private String id;
    private FlightDirection flightDirection;
    private FlightStatus flightStatus;
    
    private int versionNumber;
    
    // TODO not implemented yet
    private Integer priority;

    public Flight() {
    }

    public Flight(String id, FlightDirection flightDirection, int versionNumber) {
        this.id = id;
        this.flightDirection = flightDirection;
        this.versionNumber = versionNumber;
        flightStatus = FlightStatus.AWAITING;
        
    }
    
    private Flight(Flight other) {
    	this.id = other.id;
    	this.flightDirection = other.flightDirection;
    	this.flightStatus = other.flightStatus;
    	this.versionNumber = other.versionNumber;
    	this.priority = other.priority;
    }

    public String getId() {
        return id;
    }

    public FlightDirection getFlightDirection() {
        return flightDirection;
    }
    
    public FlightStatus getFlightStatus() {
    	return flightStatus;
    }

	public Integer getPriority() {
		return priority;
	}
	
	public int getVersionNumber() {
		return versionNumber;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFlightDirection(FlightDirection flightDirection) {
		this.flightDirection = flightDirection;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public Flight clone() {
		return new Flight(this);
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightDirection=" + flightDirection + ", flightStatus=" + flightStatus
				+ ", versionNumber=" + versionNumber + "]";
	}
	
	
}