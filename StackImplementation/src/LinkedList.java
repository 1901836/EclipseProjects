
public class LinkedList<T>{ //<T> allows us to use any data type
	
	//number of elements in list
	private int size;
	
	//reference to the front of the list
	private Node head;
	
	public LinkedList(){
		//job of the constructor is to initialize the instance variables
		size = size;
		head  = head;
		
	}
	
	public Node peek(){ //returns the first element (Headnode)
		return head;
	}
	
	public void add(T t){ //add a node to the end of the list
		//what all needs to happen to add to the list?
		size++;
		
		if(head == null){
			Node n = new Node(t); //create a new node that encapsulates the data t
			head = n; //head reference now points to this first Node
			return;
 		}
		Node temp = head;
		while(temp.next!=null){
			//we know its not the end of the list unless the next Node reference is pointing to null
			temp = temp.next();
		}
		//if we hit the end of the loop, we know next is null!
		//aka end of the list!
		temp.next = new Node(t); //done
		
	}
	public void addFront(T t){ //add to the beginning of the list
	size++;
	Node temp = head;
	if(head==null){
		Node n = new Node(t); //creating another new node that encapsulates the data t
		head = n; //head reference now points to this first node
		return;
	}
	temp = temp.next();
	temp = new Node(t);
	
	
	
	}
	public Node remove(){ //remove and returns first element(Head)
		
	Node temp = head;
		if(head==null){
			return null;
		}
		
		
		head = temp.next();
		size--;
		return temp;
		
	}
	/* remove node at index i
	 * REQUIRES i < size
	 */
	public Node remove(int i){ // remove and returns element at the given index
		if(i > size){
			return null;
		}
		if(head == null){
			return null;
		}
		
		Node temp = head;
		if(i==0){
			head = null;
			size--;
			return null;}
		
		if(i<size){
			temp = temp.next();
		size--;
		}
			
			
		return temp;
		
	}
	public boolean isCircular(){
		return false;
	}
	
	public int size(){ //returns number of elements
		return size;
	}
	public String toString(){
		return head.toString();
	}
	
}