package Health;

import lombok.ToString;

@ToString(callSuper = true)
public class Healthy extends PersonStatus {

    public Healthy() {
        super(0);
    }

    @Override
    public Status getPersonStatus() {
        return Status.HEALTHY;
    }

    @Override
    public void available(int time) {
        System.out.format("Person is ready to work");
    }
}
