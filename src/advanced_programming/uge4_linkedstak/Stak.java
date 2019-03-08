package advanced_programming.uge4_linkedstak;

public interface Stak<Test> {
	void push(Test element);
	 Test pop();
	boolean empty();
	boolean full();
	void show();
}

