package zad3;

public class ReversibleString implements Reversible {

	private String str;
	
	public ReversibleString(String string) {
		this.str = string;
	}

	@Override
	public String toString() {
		return str;
	}

	@Override
	public void reverse() {
		 byte [] chars = this.str.getBytes();
		 byte [] res = new byte [chars.length]; 
		 int rev_id,help;
		 help = chars.length;
		 for(int i = 0; i<chars.length; i++){
			 rev_id = help-i-1;
			res[i] = chars[rev_id];
		 }
		 this.str = new String(res);
	}

}
