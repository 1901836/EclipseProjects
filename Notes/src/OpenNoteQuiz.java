
public class OpenNoteQuiz {

	public static void main(String[] args){
		// TODO Auto-generated method stub
     
		int[] nums = { 13, 0, 1, 12, 13, 1};
		
		int sum = 0;
		for(int i =0; i < nums.length-1; i++)
			
			if(nums[i]+nums[i+1] !=13){
			sum+=nums[i];
	}else{
		i++;
	}
		System.out.println(sum);
	}
}
