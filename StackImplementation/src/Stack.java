import java.util.ArrayList;

public class Stack<T>{ //A stack can only add or remove from the top like a pringles can 
	//push and pop
	
	private ArrayList<T> data;
	private int size;
	
	public Stack(){
		data = new ArrayList<T>();
	}
	
	//adding to the top, the push method
	public void push(T t){
		data.add(t);
		size++;
	}
	//write the pop method to remove the top element from the list
	public T pop(){
		size--;
		return data.remove(size);
	}
	
	//write the method peek which returns the last element
	//but doesn't remove it from the list
	
	public T peek(){ //redo this
		return data.get(size-1);
		
	}
	
	
	
	//write the isEmpty method which returns true if
	//the stack is empty
	
	public boolean isEmpty(){
		if(data.size()==0) return true;
		return false;
	}
	
	
	public int size(){ //same thing as public int getSize - following ArrayList size naming
		return size;
	}
	
	//override so that Stack objects can be printed
	public String toString(){
		return data.toString();
	}
	
	
	
	
	
	
	
	
}
