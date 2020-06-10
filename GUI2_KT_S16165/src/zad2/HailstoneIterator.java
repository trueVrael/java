package zad2;

import java.util.Iterator;

public class HailstoneIterator implements Iterator<Integer> {

	private Hailstone tmp;
	
	public HailstoneIterator(int start) {
		tmp.start = start;
	}

	@Override
	public boolean hasNext() {
		return tmp.start != 1;
	}

	@Override
	public Integer next() {
		if(tmp.start%2 == 0)
			return tmp.start/2;
		else
			return (3*tmp.start)+1;
	}

}
