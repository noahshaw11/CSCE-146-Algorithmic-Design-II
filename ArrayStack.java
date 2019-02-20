
public class ArrayStack <T> implements StackInterface<T>{
	private T[] stack;
	public static final int DEF_SIZE = 100;
	private int head; //First null element
	public ArrayStack()
	{
		init(DEF_SIZE);
	}
	public ArrayStack(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size <= 0)
		{
			return;
		}
		head = 0;
		stack = (T[])(new Object[size]);
	}
	public void push(T aData)
	{
		if(head >= stack.length)
		{
			return;
		}
		stack[head] = aData;
		head++;
	}
	public T pop()
	{
		if(head <= 0)
		{
			return null;
		}
		T ret = stack[head - 1];
		head--;
		return ret;
	}
	public T peek()
	{
		if(head <= 0)
		{
			return null;
		}
		return stack[head - 1];
	}
	public void print()
	{
		for(int i = head - 1; i >= 0; i--)
		{
			System.out.println(stack[i]);
		}
	}

}
