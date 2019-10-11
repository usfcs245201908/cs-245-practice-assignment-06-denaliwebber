import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>
{
	protected int top;
	protected T a[];

	public ArrayStack()
	{
		top = -1;
		a = (T[]) new Object[20];
	}
	
	public T pop()
	{
		if (top == -1)
			throw new RuntimeException("Cannot pop, stack is empty.");
		return a[top--];
	}

	public void push(T item)
	{
		if (top == a.length-1)
			grow_array();
		a[++top]=item;
	}

	public T peek()
	{
		if (top == -1)
			throw new RuntimeException("Cannot peek, stack is empty.");
		return a[top];
	}

	public boolean empty()
	{
		if (top == -1)
			return true;
		return false;
	}

	private void grow_array()
	{
		int len = a.length;
		T [] new_array = (T[]) new Object[len*2];
		new_array = Arrays.copyOf(a, len*2);
		a = new_array;
	}
}