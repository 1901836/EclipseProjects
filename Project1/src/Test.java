
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][][] c = new int[1][1][5];
		for(int i = 0; i < c.length; i++)
			for(int j = 0; j < c[0].length; j++){
				for(int k = 0; k < 5; k++){
					c[i][j][k] = 2;
				System.out.println(c[i][j][k]);
				}
			}
		
	}

}
