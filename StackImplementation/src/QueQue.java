
public class QueQue<T>{
		Stack<T> s = new Stack<T>();
		Stack<T> s2 = new Stack<T>();
		Stack<T> s3 = new Stack<T>();
		
	
		private int size;
		
		
		public QueQue(){
			 s = new Stack<T>();
			s2 = new Stack<T>();
			s3 = new Stack<T>();
		
		}
	
		public void add(T t){
			s.push(t);
			size++;
			
		}
		
		
//		public T remove(){
//		
//			for(int i = s.size()-1; i < s.size(); i++){
//				
//					s2.push(s.pop());	
//					s2.pop();
//				s.push(s2.pop());
//			}
//			
//			return 
//		
//		}
		
		public T peek(){
	Stack<T> temp = new Stack<T>();
		//reversing the order of the stack
		for(int i = 0; i < size; i++){
			temp.push(s.pop());
			
		}
		//popping the last one then adding back to preserve the size
			T r = temp.pop();
			temp.push(r);
			for(int i = 0; i < size; i++){
				s.push(temp.pop());
			}
			return r;
			
		
		}
		
		public boolean isEmpty(){
			if(s.size()==0) return true;
			return false;
		}
		
	
		public int size(){
			return s.size();
		}
		
		public String toString(){
			return s.toString();
		}
		
		
}
