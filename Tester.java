
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackInterface<Integer> stack = new LLStack<Integer>();
		for(int i = 0; i < 10; i++)
		{
			stack.push(i);
		}
		stack.print();

	}

}
