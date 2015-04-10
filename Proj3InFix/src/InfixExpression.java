//
// Name: Xu Kuang, Roberto Hong
// Project: #3
// Due: 3/14/14
// Course: cs-240-02-w14
// Description: This project converts an infix Expression into a prefix and postfix expression
// using stacks. It checks to have the correct amount of parentheses, and it will also make sure
// that the expressions are formatted properly, no matter how much space.

import java.util.Stack;
import java.util.Scanner;

public class InfixExpression {

	//I used strings because variables/operands may be more than 1 character.
	Stack<String> postfix = new Stack<String>();
	Stack<String> prefixVar = new Stack<String>();
	Stack<String> prefixSym = new Stack<String>();

	//This converts character arrays into proper formatted strings.
	public String convert(char[] exp){
		String temp = "";
	
		//A space is added if missing.
		for(int x = 0; x < exp.length; x++){
			if(exp[x] == ' '){
				
			}
			else{
				temp = temp + " " + exp[x];
			}
		}
		return temp;
	}
	
	//Checks for the correct number of parantheses.
	public boolean isCorrect(char[] temp){
		int leftP = 0;
		int rightP = 0;
		
		for (int loop = 0; loop < temp.length; loop++){
			if (temp[loop] == '(')
				leftP ++;
			if (temp[loop] == ')')
				rightP ++;
		}
		
		return (leftP == rightP);
	}
	
	//Checks if the string is a variable or not.
	public boolean varString(String s){
		
		if(s.equals("+"))
			return false;
		if(s.equals("-"))
			return false;
		if(s.equals("*"))
			return false;
		if(s.equals("/"))
			return false;
		if(s.equals("%"))
			return false;
		if(s.equals("("))
			return false;
		if(s.equals(")"))
			return false;
		
		return true;
	}
	
	//This returns the precedence of operators. 
	public int prec(String x){
        
		//I used charAt(0) because there are times when it's more than 1 character.
		switch(x.charAt(0))
        {
            case '-':return 1;
            case '+':return 1;
            case '*':return 2;
            case '/':return 2;
            case '%':return 2;
        }
        return 0;
	}
	
	public char[] convertToPostfix(char[] iE){
		
		//First, checks for the correct amount of parentheses.
		if(!isCorrect(iE)){
			System.out.println("Incorrect Parethenses!");
			return new char['!'];
		}
		
		char[] temp = new char[iE.length];
		
		//Converts the char Array into a String.
		String s = convert(iE);

		String[] s2 = s.split(" ");
		
		String s3 = "";
		for(int loop = 0; loop < s2.length; loop++){
			String temp2 = s2[loop];
			
			if(varString(temp2)){
				s3 = s3 + temp2;
			} else if(temp2.equals("(") || postfix.isEmpty() || prec(temp2) > prec(postfix.peek())){
				postfix.push(temp2);
			} else if(temp2.equals(")")){
				do{
					s3 = s3 + postfix.pop();
				}while(!postfix.peek().equals("("));
				postfix.pop();
			} else if(prec(temp2) <= prec(postfix.peek())){
				
				s3 = s3 + postfix.pop();
				loop--;

			}
			
		}
		
		while(!postfix.isEmpty()){
			s3 = s3 + postfix.pop();
		}
		
		temp = s3.toCharArray();
		return temp;
	
	}

	public char[] convertToPrefix(char[] iE){
		if(!isCorrect(iE)){
			System.out.println("Incorrect Parethenses!");
			return new char['!'];
		}
		
		char[] temp = new char[iE.length];
		
		String s = convert(iE);
		
		String[] s2 = s.split(" ");
		
		String s3 = "";
		for(int loop = 0; loop < s2.length; loop++){
			String temp2 = s2[loop];
			
			if(varString(temp2)){
				
				prefixVar.push(temp2);
			}else if(temp2.equals("(") || prefixSym.isEmpty() || prec(temp2) > prec(prefixSym.peek())){
				
				prefixSym.push(temp2);
			}else if(temp2.equals(")")){
				do{
					String op = prefixSym.pop();
					String rightOp = prefixVar.pop();
					String leftOp = prefixVar.pop();
					
					String expNew = op + leftOp + rightOp;
					prefixVar.push(expNew);
					s3 = s3 + expNew;
				}while(!prefixSym.peek().equals("("));
				
				prefixSym.pop();
			} else if(prec(temp2) <= prec(prefixSym.peek())){
				String op = prefixSym.pop();
				String rightOp = prefixVar.pop();
				String leftOp = prefixVar.pop();
				
				String expNew = op + leftOp + rightOp;
				prefixVar.push(expNew);
				
				loop--;
			}
			
		}
		
		while(!prefixSym.isEmpty()){
			String op = prefixSym.pop();
			String rightOp = prefixVar.pop();
			String leftOp = prefixVar.pop();
			
			String expNew = op + leftOp + rightOp;
			prefixVar.push(expNew);
			
			s3 = expNew;
		}
		
		temp = s3.toCharArray();
		return temp;
	}
	
	public static void main(String[] args) {
		InfixExpression ie = new InfixExpression();
		
		String temp;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix: ");
		temp = sc.nextLine();


		char[] temp3 = temp.toCharArray();
		
		
		char[] temp4 = ie.convertToPostfix(temp3);
		System.out.print("Postfix: "); 
		System.out.println(temp4); 
	
		char[] temp5 = ie.convertToPrefix(temp3);
		System.out.print("Prefix: ");
		System.out.println(temp5); 
	}

}
