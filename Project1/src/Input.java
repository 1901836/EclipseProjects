import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// keep input file in the parent folder for the project
				// not in the src folder
				File file = new File("input11"); // point to file
				//last line needs to be an element
				//no trailing spaces or trailing empty lines
				
				try {
					
					Scanner sc = new Scanner(file); // setup scanner
					while (sc.hasNextLine()) { // check a line exists in the input file
						String k = sc.next();
						System.out.println(k);
						int i = sc.nextInt(); // NOTE format of input file is expected
						System.out.println(i); // call nextInt() 
						int j = sc.nextInt();
						System.out.println(j);
						
						
					}
					sc.close(); // done with scanner
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	}

}
