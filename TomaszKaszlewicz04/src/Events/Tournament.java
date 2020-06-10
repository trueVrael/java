package Events;

import Exceptions.StaticException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.*;
import java.time.LocalDate;
import classes.ObjectPlus4;

@Getter
@Setter
@ToString
public class Tournament extends ObjectPlus4 {

	protected int seats;
	public String scale;
	
	private Set<Attendance> attendanceHistory = new TreeSet<>();
	
	public Tournament(int seats, String scale) throws StaticException {
		setSeats(seats);
		setScale(scale);
	}
	
	public Tournament(int seats) throws StaticException {
		setSeats(seats);
	}
	
    public void setSeats(int seats) throws StaticException {

        if(seats <= 10) {
            throw new StaticException("There must be at least 100 seats for spectators during tournament");
        }

        this.seats = seats;
    }
    
	public void getTournamentScale() {
		System.out.println(this.scale);
	}
	
	public void addEvent(int attendance, LocalDate time) {
		this.attendanceHistory.add(new Attendance(this, attendance, time));
	}
}
