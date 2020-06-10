package zad2;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer>{
	
	public int start;
	private boolean was = false;
	
	public Hailstone(int ini) {
		this.start = ini;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>(){
			int tmp = start;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return !was;
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				if(tmp == 1) was = true;
				if(tmp%2 == 0)
					tmp/=2;
				else
					tmp = (3*tmp)+1;
				return tmp;
			}
			
		};
	}
}
