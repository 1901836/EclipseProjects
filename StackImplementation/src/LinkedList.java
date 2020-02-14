public class LinkedList<T>{ //<T> allows us to use any data type
	
	//number of elements in list
	private int size;
	
	//reference to the front of the list
	private Node<T> head;
	
	public LinkedList(){
		//job of the constructor is to initialize the instance variables
		size = size;
		head  = head;
		
	}
	
	public Node<T>peek(){ //returns the first element (Headnode)
		return head;
	}
	
	public void add(T t){ //add a node to the end of the list
		//what all needs to happen to add to the list?
		size++;
		
		if(head == null){
			Node<T> n = new Node(t); //create a new node that encapsulates the data t
			head = n; //head reference now points to this first Node
			return;
 		}
		Node<T>temp = head;
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
	Node<T>temp = head;
	if(head==null){
		Node<T>n = new Node(t); //creating another new node that encapsulates the data t
		head = n; //head reference now points to this first node
		return;
	}
	temp = temp.next();
	temp = new Node(t);
	
	
	
	}
	public Node<T>remove(){ //remove and returns first element(Head)
		
	Node<T>temp = head;
		if(head==null){ //if head equals null, then it should return null
			return null;
		}
		
		
		head = temp.next(); //replacing the head to the next location
		size--; //the size will decrement because the head is changing
		return temp; //returning the new head;
		
	}
	/* remove node at index i
	 * REQUIRES i < size
	 */
	public Node<T>remove(int i){ // remove and returns element at the given index
		if(i > size){ //if i is greater than the size, it must return null
			return null;
		}
		
			if(i==0){
		head = null;
		return head;
			}
		Node<T>temp = head;
	
		
		while(i<size){
			temp = temp.next();
		size--;
		}
			
			
		return temp;
		
	}
	//check if last node returns back to head node
	public boolean isCircular(){
		return false;
	}
	
	public int size(){ //returns number of elements
		return size;
	}
}
		                   
		        