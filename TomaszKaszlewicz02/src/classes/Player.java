package classes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)

public class Player extends Person {

	private String hand;
	
	public Player(PersonBuilder build, String hand) {
		super(build);
		this.hand = hand;
	}
	
	public class Racket extends ObjectPlusPlus {
		private String name;
		private int id;
		
		private Racket(String name, int id) {
			this.name = name;
			this.id = id;
		}
		
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setPrice(int id) {
            this.id = id;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Racket)) return false;

            Racket r = (Racket) o;

            if (!name.equals(r.name)) return false;
            return id == r.id;
        }

        @Override
        public int hashCode() {
            int res = name.hashCode();
            res = 73 * res + id;
            return res;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Racket(");
            sb.append("name='").append(name).append(" ");
            sb.append(", id=").append(id);
            sb.append(')');
            return sb.toString();
        }
	}
	
    public Racket addRacket(String name, int id) throws Exception {
        Racket r = new Racket(name, id);
        this.addPart("Player", "Racket", r);
        return r;
    }
}
