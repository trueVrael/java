package Health;

import lombok.ToString;

@ToString(callSuper = true)
public class Injured extends PersonStatus{

    public Injured(int time) {
        super(time);
    }

    @Override
    public Status getPersonStatus() {
        return Status.INJURED;
    }

    @Override
    public void available(int time) {
        System.out.format("Person will be ready in %d%n", time);
    }
    
}
