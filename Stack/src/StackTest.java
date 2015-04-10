import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class StackTest
{
	private Stack<Integer> sta;
	
	@Before
	public void createStack()
	{
		sta = new Stack<Integer>();
		sta.push(5);
		sta.push(4);
		sta.push(3);
		sta.push(2);
		sta.push(1);
		sta.push(0);
	}

	@Test
	public void checkIfNewStackHasACountOfZero()
	{
		Stack<Integer> gogo = new Stack<Integer>();
		assertTrue(gogo.isEmpty());
	}
	
	@Test
	public void addingToStackPutsTheNumberOnTop()
	{	
		for(Integer i =0; i<=5;i++)
		{
			try
			{
				assertEquals(i,sta.top());
				sta.pop();
			}
			catch (StackEmptyException e)
			{
			}
			
		}
		
	}
	
	@Test
	public void popRemovesFirstStoredElement()
	{		
		for(Integer i =1; i<=5;i++)
		{
			
			try
			{
				sta.pop();
				assertEquals(i, sta.top());
			}
			catch (StackEmptyException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void returnsFalseUntilStackIsEmpty()
	{
		for(Integer i = 0; i<=5;i++)
		{
			assertFalse(sta.isEmpty());
			try
			{
				sta.pop();
			}
			catch (StackEmptyException e)
			{
				e.printStackTrace();
			}
		}
		assertTrue(sta.isEmpty());
	}
}