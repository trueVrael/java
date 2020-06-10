package Events;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Attendance implements Comparable<Attendance>{

	private Tournament t;
	private int attendance;
	private LocalDate time;


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tournament attendance history(");
        sb.append("attendance=").append(attendance);
        sb.append(", time=").append(time);
        sb.append(')');
        return sb.toString();
    }

    @Override
    public int compareTo(Attendance tmp) {
        return this.time.compareTo(tmp.time);
    }
    
}
