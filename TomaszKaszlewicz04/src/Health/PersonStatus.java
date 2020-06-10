package Health;

import lombok.ToString;
import classes.ObjectPlusPlus;

@ToString
public abstract class PersonStatus extends ObjectPlusPlus {

	protected int time;
	
    public PersonStatus() {
    	this.time = 0;
    }
    public PersonStatus(int time) {
    	this.time = time;
    }

    public abstract Status getPersonStatus();
    public abstract void available(int time);
    
}
