package advanced_programming.uge4_linkedstak;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StakImpl<T> implements Stak<T>{

	List<T> list = new ArrayList<T>();
//	List<T> list = new LinkedList<T>();
	
	@Override
	public void push(T element) {
		list.add(element);
		
	}

	@Override
	public T pop() {
		return list.remove(list.size()-1);
	}

	@Override
	public boolean empty() {
		return list.isEmpty();
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public void show() {
		for(int i = list.size()-1;i>=0;i--){
			System.out.println(list.get(i));
		}
		
	}

}
