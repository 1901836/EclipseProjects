
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Stack<String> myStrs = new Stack<String>();
		myStrs.push("Hello");
		System.out.println(myStrs.pop());
		System.out.println(myStrs.size());
		
		
		Stack<Integer> myNums = new Stack<Integer>();
		myNums.push(111);
		System.out.println(myNums);
		
		QueQue<Integer> nums = new QueQue<Integer>();
		nums.add(5);
		nums.add(4);
		nums.remove();
		System.out.println(nums);
		
		
		
	}

}

