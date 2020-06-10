package GameObject;

import java.util.EnumSet;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PlayerCharacter {
	
	private EnumSet<PlayerCharacterType> type = EnumSet.of(PlayerCharacterType.NEUTRAL);
	private int dmg;
	private int hp;
	
	public PlayerCharacter(int dmg, int hp) {
		this.dmg = dmg;
		this.hp = hp;
	}
	
	public void evolve(PlayerCharacterType type) {
		this.type.add(type);
	}
	
	public void lose(PlayerCharacterType type) {
		this.type.remove(type);
	}
}
