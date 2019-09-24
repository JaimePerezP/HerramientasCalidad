
public class HelloWorld {

	public static void main(String[] args) {
		opA(2, 4);
		opB(2, 4);
	}
	
	public static int opA(int a, int b) {
		int sum = a + b;
		return sum*2;
	}
	
	public static int opB(int a, int b) {
		int sum = a + b;
		return sum/2;
	}

}