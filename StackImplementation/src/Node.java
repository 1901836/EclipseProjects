
public class Node<T>{
	
	//Ball b; Paddle p; Vehicle v; <-- all references as they will eventually describe an object
	private T data;
	public Node next;
	
	public Node(T t){
		data = t;
	}
	
	//returns next reference
	public Node next(){
		return next;
	}
	
}
