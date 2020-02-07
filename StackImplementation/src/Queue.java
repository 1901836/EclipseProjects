//FIFO -  first in first out
import java.util.ArrayList;

public class Queue<T>{

	private ArrayList<T> q;
private int size;
	
public Queue(){
	q = new ArrayList<T>();
}

	
	
//enque
	public void add(T t){
		q.add(t);
		size++;
	}
	//dequeue
	//first in first out
	public T remove(){
		T t = q.remove(0);
		size--;
		return t;
	}
	
	//write the method peek which returns the first element
	//but doesn't remove it from the list
	
	public T peek(){ //redo this
		return q.get(0);
		
	}
	
	
	
	//write the isEmpty method which returns true if
	//the stack is empty
	
	public boolean isEmpty(){
		if(q.size()==0) return true;
		return false;
	}
	
	
	public int size(){ //same thing as public int getSize - following ArrayList size naming
		return size;
	}
	
	//override so that Stack objects can be printed
	public String toString(){
		return q.toString();
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
}
