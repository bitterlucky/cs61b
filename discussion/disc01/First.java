public class First {
	public static void main(String[] args) {
		int[] inputArray = {3, 0, 4, 6, 3};
		mystery(inputArray, 2);
	}
	public static int mystery(int[] inputArray, int k) {
		int x = inputArray[k];
		int answer = k;
		int index = k + 1;
		while (index < inputArray.length) {
			if (inputArray[index] < x) {
				x = inputArray[index];
				answer = index;
			}
			index = index + 1;
		}
		return answer;
	}
	public static void mystery2(int[] inputArray) {
		int index = 0;
		while (index < inputArray.length) {
			int targetInedx = mystery(inputArray, index);
			int temp = inputArray[targetInedx];
			inputArray[targetInedx] = inputArray[index];
			inputArray[index] = temp;
			index = index + 1;
		}
	}
	public static int fib(int n) {
		if (n == 0) {
			return 0;
		} elif (n == 1) {
			return 1;
		} elif (n == 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}
	public static int fib2(int n, int k, int f0, int f1) {
		while (n-- > 0) { 
			int temp = f1; 
			f1 += f0; 
			f0 = temp; 
		}
    	return f0;
	}
}