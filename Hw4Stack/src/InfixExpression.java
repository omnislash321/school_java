//
// Name: Xu Kuang, Roberto Hong
// Homework:#5
// Due: 2/28/14
// Course: cs-240-02-w14
// Description: InfixExpression takes an infixed expression that is split up into String arrays,
// and will calculate an answer from that string array. The string must consist of operators
// that are +,-,*,/,( and ), or doubles. Using a stack of numbers and operators, the calculations
// are done with pushing and popping.

public class InfixExpression {
	private NodeStack operator = new NodeStack();
	private NodeStack numbers = new NodeStack();
	//These Doubles and Strings are used for other methods.
	private Double a, b;
	private String op;
	
	//Will return a double that has the proper math operator applied.
	public Double calc(double a, double b, String x){
		if (x.equals("+"))
			return a+b;
		else if (x.equals("-"))
			return a-b;
		else if (x.equals("*"))
			return a*b;
		else //The last possible case is "/", which is divide.
			return a/b;
	}
	
	//This is used to pop the stacks and set the variables accordingly.
	public void setVars(){
		Double b = Double.parseDouble((String)numbers.pop());
		Double a = Double.parseDouble((String)numbers.pop());
		String op = (String) operator.pop();
	}
	
	//Pops the variables, then pushes them once they're calculated.
	public void pushCalc(){
		setVars();
		numbers.push(calc(a, b, op).toString());
	}
	
	
	public double eval(String[] ie){
		//A for-each loop to go through every single index of the Array.
		for(String x : ie){
			//Checks if they're an operator. 
			if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")|| x.equals("(") || x.equals(")")){
				
				//If they are, if the stack is empty, or if the operator is a (, *, or /,
				if(operator.isEmpty() || x.equals("(") || x.equals("*") || x.equals("/")){
					//It will be pushed into the operator stack.
					operator.push(x);
				}
				//If the String is a + or -,
				if(x.equals("+") || x.equals("-")){
					//This checks for precedence.
					//If the top of the stack is * or /,
					if (operator.top().equals("*") || operator.top().equals("/")){
						//Then a calculation must be done and pushed to number stack.
						pushCalc();
					}
					//If it's not a * or /, then simply push the + or -.
					operator.push(x);
				}
				
				//If the string is a )
				if(x.equals(")")){
					//This will ensure the code will run at least once.
					do{
						//I tried to use setVars() or pushCalc() here, but it gave me NullPointerExceptions.
						//This is the normal code in place of the methods called.
						Double b = Double.parseDouble((String)numbers.pop());
						Double a = Double.parseDouble((String)numbers.pop());
						String op = (String) operator.pop();
						
						numbers.push(calc(a, b, op).toString());
					}while (!operator.top().equals("(")); 
					//Will loop until it reaches a (
					//Then pops that ( so it isn't counted anymore.
					operator.pop();
				}

			} else  //If the String is not an operator, then simply push it to the number stack.
				numbers.push(x);
		}
		
		//Return a double of the String element of the Number stack.
		return Double.parseDouble((String)numbers.pop());
	}
	
	//Main to test out the method.
	public static void main(String[] args) {
		InfixExpression infix = new InfixExpression();
		
		// (1+(2*3))
		// (1+(6))
		// 7
		String[] ie = "( 1 + ( 2 * 3 ) )".split(" ");
		System.out.println(infix.eval(ie));
		
		// (((6+9)/3)*(6-4))
		// (((15)/3)*(2))
		// ((5)*(2))
		// 10
		String[] ie2 = "( ( ( 6 + 9 ) / 3 ) * ( 6 - 4 ) )".split(" ");
		System.out.println(infix.eval(ie2));
		
		// (5+3+9-5*3/7)
		// (5+3+9-15/7)
		// (5+3+9-2.14)
		// (5+9+0.857)
		// (14.857)
		String[] ie3 = "( 5 + 3 + 9 - 5 * 3 / 7 )".split(" ");
		System.out.println(infix.eval(ie3));

	}

}
