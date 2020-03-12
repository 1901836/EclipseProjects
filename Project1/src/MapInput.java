import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MapInput {
	public static File file = new File("map1"); // point to file
	public static File file2 = new File("CoordinateMap2");
	public static String[][][] ch;
	public static String[][] str;
	public static String[][] arr;
	public static boolean first = true;
	ArrayDeque<Integer> deck = new ArrayDeque<Integer>();
	public static Queue que;
	public static Stack st;
	public static int row;
	public static int col;

	String[] args2 = { "--Stack", "map1" };
	String fileName = args2[args2.length - 1];

	public static void main(String[] args) {
		boolean coordinate = false;
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

			Scanner sc = new Scanner(file2); // setup scanner

			while (sc.hasNextLine()) {

				int i = sc.nextInt();
				// System.out.println(i);
				int j = sc.nextInt();
				// System.out.println(j);
				int k = sc.nextInt();
				// System.out.println(k);
				int count = 2;
				row = i;
				col = j;

				ch = new String[i][j][k];
				str = new String[i][j];
				arr = new String[i][j];
				ch[0][0][0] = sc.next();

				if (ch[0][0][0].length() > 1) {
					int count2 = 1;

					System.out.print(ch[0][0][0] + " ");
					for (int q = 0; q < col; q++) {
						arr[0][q] = ch[0][0][0].substring(q, count2);
						count2++;

					}
				}

				if (sc.hasNext("0") || sc.hasNext("1") || sc.hasNext("2")
						|| sc.hasNext("3") || sc.hasNext("4")
						|| sc.hasNext("5") || sc.hasNext("6")
						|| sc.hasNext("7") || sc.hasNext("8")
						|| sc.hasNext("9")) {
					System.out.print(ch[0][0][0] + " ");
					coordinate = true;
				} else {
					coordinate = false;
				}

				for (int a = 0; a < i; a++) {
					for (int b = 0; b < j; b++) {

						if (coordinate) {
							while (sc.hasNextLine()) {

								String n = sc.next();
								str[a][b] = n;

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
									int count3 = 1;

									row = 0;
									for (int t = 0; t < col; t++) {
										arr[row][t] = ch[a][b][c].substring(t,
												count3);
										count3++;
									}
									row++;

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
