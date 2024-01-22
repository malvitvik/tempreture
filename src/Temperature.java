import java.util.ArrayDeque;
import java.util.Deque;

public class Temperature {

	public static void main(String[] args) {
		int[] temperatures = new int[] { 9, 12, 10, 7, 11, 14, 13, 17, 11, 10, 9, 16 };
		int[] days = getDaysToWarmerDay(temperatures);
		print(temperatures, days);

	}


	public static void print(int[] temperatures, int[] days) {
		for (int i = 0; i < temperatures.length; i++) {
			System.out.printf("Day %0,2d with temp %0,2d degree has bigger temperature in %0,2d days\n",
			                  i + 1, temperatures[i], days[i]);
		}
	}


	public static int[] getDaysToWarmerDay(int[] temperatures) {
		int[] days = new int[temperatures.length];

		Deque<C> stack = new ArrayDeque<>();
		
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek().value < temperatures[i]) {
				stack.pop();
			}

			days[i] = stack.isEmpty() ? 0 : stack.peek().index - i;

			stack.push(new C(i, temperatures[i]));
		}
		
		return days;
	}


	static class C {
		int value, index;
		
		public C(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

}