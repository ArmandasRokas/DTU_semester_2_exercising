package advanced_programming.uge4_linkedstak;


public class LinkedStakImpl<T> implements Stak<T> {

	private class StakElement{
		private StakElement nextElement;
		private T content;
		public StakElement(StakElement nextElement, T content) {
			super();
			this.nextElement = nextElement;
			this.content = content;
		}
	}
	private StakElement top;
	
	public LinkedStakImpl(){
		 top = null;
	
	}
	
	@Override
	public void push(T element) {
		StakElement newElement = new StakElement(top, element);
		top = newElement;
	}

	@Override
	public T pop() {
		StakElement returnElement = top;
		top = top.nextElement;
		return returnElement.content;
		
	}

	@Override
	public boolean empty() {
		return top==null;
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public void show() {
		StakElement cur = top;
		while(cur!=null){
			System.out.println(cur.content);
			cur = cur.nextElement;
		}
		
		
	}

}
