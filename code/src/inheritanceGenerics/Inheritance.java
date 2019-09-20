package inheritanceGenerics;

public class Inheritance implements OneInputFunction, TwoInputFunction{

	int field = 8;
	String stringField = "asdf";
	
	public static void main(String[] args) {
		Inheritance x = new ChildClass();

		System.out.println(x.func(10));
		System.out.println(x.func(10, 20));
	}

	@Override
	public int func(int x) {
		return x*7;
	}

	@Override
	public int func(int x, int y) {
		
		return x*y;
	}
	
	
	

	
	
	

}

class ChildClass extends Inheritance{
	
	public int func(int x) {
		return field*x;
	}
}


interface OneInputFunction{
	
	public int func(int x);
}

interface TwoInputFunction{
	public int func(int x, int y);
}

