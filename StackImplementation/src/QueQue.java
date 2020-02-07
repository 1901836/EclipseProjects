
public class QueQue<T>{
		Stack<T> s;
		Stack<T> s2;
	
		private int size;
		
		
		public QueQue(){
			Stack<T> s = new Stack<T>();
			Stack<T> s2 = new Stack<T>();
		
		}
	
		public void add(T t){
			s.push(t);
			size++;
			
		}
		
		
		public T remove(){
			size--;
			for(int i = 0; i < s.size(); i++){
				T a = s.pop();
				s2.push(a);
			}
			return s2.pop();
			
		}
		
//		public T peek(){
//			for(int i = 0; i < s.size(); i++){
//				T a = s.pop();
//				s2.push(a);
//			}
//		
//		}
		
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
