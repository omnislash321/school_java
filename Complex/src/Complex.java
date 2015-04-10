/*
 *		Name: Xu, Roberto
 *		Quiz: #6
 *		Due: 11/2/2012 Midnight
 *		Course: CS-141-01-f12
 *		Description: The take-home quiz given to us during class, due at midnight of the very same day. 
 *			A Complex object class with mutators, accessors, and several constructors and methods
 *			that include interactions with other Complex objects through the arguments of the methods.
 */

public class Complex {
	private int real;
	private int imaginary;
	private int defObjCount;
	
	public Complex(){
		this(0,0);
	}
	
	public Complex(int r, int i){
		real = r;
		imaginary = i;
	}
	
	public Complex(Complex comp){
		real = comp.getReal();
		imaginary = comp.getImaginary();
	}
	
	public void setReal(int r){
		real = r;
	}
	
	public void setImaginary(int i){
		imaginary = i;
	}
	
	public int getReal(){
		return real;
	}
	
	public int getImaginary(){
		return imaginary;
	}
	
	public boolean equals(Complex comp){
		boolean temp = false;
		
		if (real == comp.getReal() && imaginary == comp.getImaginary())
			temp = true;
		
		return temp;
	}
	
	public String toString(){
		return ("" + real + " + " + imaginary + "i");
	}
	
	public void copy(Complex comp){
		comp.setReal(real);
		comp.setImaginary(imaginary);
	}

	public void showCounter(){
		System.out.println(defObjCount);
	}
	
	public Complex multiply(Complex comp){
		Complex temp;
		
		int r = (real*comp.getReal()) - (imaginary * comp.getImaginary());
		int i = (imaginary*comp.getReal()) + (real*comp.getImaginary());
		
		temp = new Complex(r, i);
		
		return temp;
	}
	
	public Complex add(Complex comp){
		Complex temp;
		
		int r = (real + comp.getReal());
		int i = (imaginary + comp.getImaginary());
		
		temp = new Complex(r, i);
		
		return temp;
	}
	
	public static void main(String[] args){
		Complex a = new Complex();
		Complex b = new Complex(1,5);
		Complex c = new Complex(a);
		
		if (a.equals(c))
		{
			System.out.println(a.toString());
			System.out.println(c.getReal() + " + " + c.getImaginary() + "i\n");
		}
		a.setReal(3);
		a.setImaginary(5);
		
		a.copy(c);
		
		if (a.equals(c))
		{
			System.out.println(a.toString());
			System.out.println(c.getReal() + " + " + c.getImaginary() + "i\n");
		}
		
		System.out.println(a.toString() + "\n" + b.toString() + "\n" + c.toString() + "\n");
		
		Complex multiAB = a.multiply(b);
		Complex addBC = b.add(c);
		
		System.out.println(multiAB.toString());
		System.out.println(addBC.toString());
	}
}
