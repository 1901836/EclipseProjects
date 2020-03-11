import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MapInput {
	public static File file = new File("map1"); // point to file
	public static String[][][] ch;
	public static String[][] str;
	public static boolean first = true;
	public static Queue q;
	public static Stack st;

	String[] args2 = { "--Stack", "map1" };
	String fileName = args2[args2.length - 1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// keep input file in the parent folder for the project
		// not in the src folder
		// the last element in the args array is always the fileName

		// last line needs to be an element
		// no trailing spaces or trailing empty lines

		// reading in second
		// line can help you identify if you have a map
		// or coordinate based file!

		try {

			Scanner sc = new Scanner(file); // setup scanner

			while (sc.hasNextLine()) {

				int i = sc.nextInt();
				// System.out.println(i);
				int j = sc.nextInt();
				// System.out.println(j);
				int k = sc.nextInt();
				// System.out.println(k);
				int count = 2;

				ch = new String[i][j][k];
				str = new String[i][j];
				// for(int r = 0; r < str.length; r++){
				// for(int s = 0; s < str[0].length; s++){
				// if(sc.hasNextLine()){
				// str[r][s] = sc.nextLine();
				// System.out.println(str);
				// }
				// }
				// }

				System.out.print(sc.next() + " ");

				for (int a = 0; a < i; a++) {
					for (int b = 0; b < j; b++) {

						if (sc.hasNext("0") || sc.hasNext("1")
								|| sc.hasNext("2") || sc.hasNext("3")
								|| sc.hasNext("4") || sc.hasNext("5")
								|| sc.hasNext("6") || sc.hasNext("7")
								|| sc.hasNext("8") || sc.hasNext("9")) {
							while (sc.hasNextLine()) {

								String n = sc.next();
								
								if (count % 3 == 0) {
									System.out.print(n);

								} else {
									System.out.print(n + " ");
								}
								if (count % 3 == 0) {
									System.out.println();
								}
								count++;

							}

						} else {
							for (int c = 0; c < k; c++) {
								while (sc.hasNextLine()) {

									String x = sc.next();
									ch[a][b][c] = x;
									if(sc.next().contains("K")){
										q.add(a);
										q.add(b);
										q.add(c);
										System.out.print(q);
									}


									if (first) {
										System.out.println();
										System.out.println(ch[a][b][c]);
										first = false;
									} else {
										System.out.println(x);
									}

								}
							}

						}

					}

				}
			}
			sc.close(); // done with scanner
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
