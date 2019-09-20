package inheritanceGenerics;

public class Generic<E extends OneInputFunction> {
	
	E field;
	public static void main(String[]args) {
		
		Generic<Type1> g = new Generic<Type1>();
		g.field = new Type1();
		System.out.println(g.field.func(10));
		Generic<Type2> g2 = new Generic<Type2>();
		g2.field = new Type2();
		System.out.println(g2.field.func(10));
	
	
	}
	
	
	public void printField() {
		System.out.println(field);
	}
	
	public void printFuncWithInput(int x) {
		System.out.println(field.func(x));
	}

}

class Type1 implements OneInputFunction{

	@Override
	public int func(int x) {
		
		return 5*x;
	}
	
}

class Type2 implements OneInputFunction{

	@Override
	public int func(int x) {
		
		return 10*x;
	}
	
}
