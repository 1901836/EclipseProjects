import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MapInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// keep input file in the parent folder for the project
				// not in the src folder
				File file = new File("CoordinateMap1"); // point to file
				
				//last line needs to be an element
				//no trailing spaces or trailing empty lines
				String[][][] ch;
				String[][] str;
			
		
			if(file.getName().substring(0, 3).equals("map")){
				try {
					
					Scanner sc = new Scanner(file); // setup scanner
			while(sc.hasNextLine())	{
				
					int i = sc.nextInt();
					//System.out.println(i);
					int j = sc.nextInt();
					//System.out.println(j);
					int k = sc.nextInt();
					//System.out.println(k);
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
			
			
				
			
					sc.close(); // done with scanner
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			}else{
				try{
					Scanner sc = new Scanner(file);
					
					while(sc.hasNextLine()) {
						int i = sc.nextInt();
						int j = sc.nextInt();
						int k = sc.nextInt();
						int count = 1;
						str = new String[i][j];
						for(int a = 0; a < i; a++){
							
							for(int b = 0; b < j; b++){
								
								while(sc.hasNextLine()){
									
									String n = sc.next();
									str[a][b] = n;
									
									if(count%3==0)
									{System.out.print(str[a][b]);}
									
									else{
										System.out.print(str[a][b] + " ");
									}
									
									if(count%3==0) {System.out.println();}
							      
									
									count++;
								}
							}
						}
					}
					sc.close();
					
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		
			}
		
	}
			

}
