package People;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class PlayingCoach extends Coach implements IPlayer{
	
	private Player player;
	
	public PlayingCoach(PersonBuilder build, String rank, int salary, String hand, int prizes) {
		super(build, rank, salary);
		this.player = new Player(build, hand, prizes);
	}
	
	@Override
	public int getIncome() {
		return super.getIncome() + player.getPrizes();
	}
	
    @Override
    public void appointment() {
        super.appointment();
    }
    
    @Override
	public void prepare() {
		player.prepare();
	}
}
