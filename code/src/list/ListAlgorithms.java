package list;

import java.util.List;

public class ListAlgorithms {

	
	static <E> void slowPrintAll( List232<E> list) throws Exception {
		for(int i = 0; i < list.size(); ++i) {
			E curObject = list.get(i);
			System.out.println(curObject.toString());
		}
	}
	
	static <E> void iterPrintAll( Iterator232<E> myIter) {
		
		
		while(myIter.hasNext()) {
			E val = myIter.next();
			System.out.println(val);
		}
	}
	
	static <E> void iterPrintAll( Iterable232<E> list) {
		
		Iterator232<E> myIter = list.getIterator();
				
		while(myIter.hasNext()) {
			E val = myIter.next();
			System.out.println(val);
		}
	}
	
	static <Blah extends Comparable<Blah> > Blah findMax(Iterator232<Blah> myIter) {
		Blah best = myIter.next();
		
		while(myIter.hasNext()) {
			Blah cur = myIter.next();
			if(best.compareTo(cur) <0) {
				cur = best;
			}
		}
		return best;
	}
}
