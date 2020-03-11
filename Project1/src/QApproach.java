import java.util.ArrayDeque;

public class QApproach extends MapInput {

	public static void main(String[] args) {

		ArrayDeque<Integer> deck = new ArrayDeque<Integer>();



		for (int i = 0; i < MapInput.str.length; i++) {
			for (int j = 0; j < MapInput.str[0].length; j++) {
				if (MapInput.str[i][j].equals("K")) {
					deck.add(i);
					deck.add(j);
					System.out.print(deck);
					break;
				}
			}
		}

	}
}
