import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MapInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] args2 = { "--Stack", "--Queue", "map1" };

		// keep input file in the parent folder for the project
		// not in the src folder
		// the last element in the args array is always the fileName
		String fileName = args2[args2.length - 1];
		File file = new File("CoordinateMap5"); // point to file

		// last line needs to be an element
		// no trailing spaces or trailing empty lines
		String[][][] ch;
		String[][] str;
		boolean first = true;
		ArrayDeque<Integer> deck = new ArrayDeque<Integer>();

		// System.out.println(file);

		// if(file.getName().substring(0,3).equals("map")){ //reading in second
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
				String pattern = "@";
				String pattern1 = "K";
				String pattern2 = "C";
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
								str[a][b] = n;
								if(sc.hasNext(pattern1)){
									int s = Integer.parseInt(n);
									deck.add(s);
									System.out.print(s);
								}

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
