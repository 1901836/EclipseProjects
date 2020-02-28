import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MapInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// keep input file in the parent folder for the project
				// not in the src folder
				File file = new File("map1"); // point to file
				
				//last line needs to be an element
				//no trailing spaces or trailing empty lines
				String[][][] ch;
				
				try {
					
					Scanner sc = new Scanner(file); // setup scanner
			while(sc.hasNextLine())	{
					int i = sc.nextInt();
					System.out.println(i);
					int j = sc.nextInt();
					System.out.println(j);
					int k = sc.nextInt();
					System.out.println(k);
				 ch = new String[i][j][k];
					
				 for(int a = 0; a < i; a++){
						for(int b = 0; b < j; b++){
							for(int c = 0; c < k; c++){
								while(sc.hasNextLine())	{
									String n = sc.next();
										ch[a][b][c] = n;
							System.out.println(ch[a][b][c]);
								
					
				}
									
								
							}
						}
					}
				
				
				
			}
			
			
				
			
			
					
//					while (sc.hasNextLine()) { // check a line exists in the input file
//					
//						String k = sc.next();
//						System.out.println(k);
//						int i = sc.nextInt(); // NOTE format of input file is expected
//						System.out.println(i); // call nextInt() 
//						int j = sc.nextInt();
//						System.out.println(j);
						
						
					//}
					sc.close(); // done with scanner
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	}

}
