import java.util.ArrayDeque;

public class Demo {

	public static void main(String[] arg) {

		int val = 1001;

		switch (val) { // similar to an if statement
		case 0:
			System.out.println("val is 0"); // when val is zero
			break; // <- what if you forget a break for a case; -> bleeds into
					// the next case; runs the body of the next case

		case 1:
			System.out.println("3");
			break;
		case 5: // colon is how you define the case; runs until it hits a break
				// point
			System.out.println("found the cake");
			break;

		default:
			System.out.println(" default case - all other cases");
		}

		// Using Queues in Java!

		// queue that's implemented using an array
		ArrayDeque<Integer> myQ = new ArrayDeque<Integer>();

		// now myQ behaves like a queue
		// first in first out

		myQ.push(1);
		myQ.push(12);

		System.out.println(myQ.peekLast() + " should be 1");

		// Try Catches

		try {
			// when something throws an exception
			// or you might want to handle exceptions in this way
			int[] x = null;
			x[1] = 5;
			int x2 = 1;
			x2 = x2 / 0;

		} catch (NullPointerException n) {
			System.out.println("null pointer exception handler");

		} catch (Exception e) { // Exception covers all cases -> superclass for
								// all other exceptions
			System.out.println("handled all other exceptions" + e);

		}

	}
}
