import java.util.Arrays;

public class ArrayQueue<T> implements Queue<T>
{
	protected T[] a = (T[]) new Object[10];
	protected int front=0;

	public T dequeue()
	{
		if(empty())
			throw new RuntimeException("Cannot dequeue because queue is empty.");
		else
		{
			for (int i=1; i<=front; i++)
				a[i-1]=a[i];
		}
		front--;
		return a[0];

	}

	public void enqueue(T item)
	{
		if(front>=a.length-1)
			grow_array();
		a[++front]=item;
	}

	public boolean empty()
	{
		return (front==0);
	}

	private void grow_array()
	{
		int len = a.length;
		T [] new_array = (T[]) new Object[len*2];
		new_array = Arrays.copyOf(a, len*2);
		a = new_array;
	}
}