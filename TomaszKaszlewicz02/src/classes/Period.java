package classes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Period extends ObjectPlusPlus{

    private LocalDate joined;
    private LocalDate left;
    private Player player;
    private Team team;
    
    public Period(LocalDate joined, LocalDate left, Player player, Team team) {
        this.joined = joined;
        this.left = left;
        this.player = player;
        this.team = team;
        
        this.addBinaryAssociation("Players", "Teams", player);
        this.addBinaryAssociation("Teams", "Players", team);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlayerTeam(");
        sb.append("joined=").append(joined);
        sb.append(", left=").append(left);
        sb.append(", player=").append(player.getFirstName()).append(" ").append(player.getLastName());
        sb.append(", team=").append(team.getName());
        sb.append(')');
        return sb.toString();
    }
}
