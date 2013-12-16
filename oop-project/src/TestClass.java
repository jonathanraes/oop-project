import OOP.Formule;

abstract class Instance{
	public abstract void print();
}


public class TestClass extends Instance{
	
	public TestClass(){};
	
	public void print(){
		System.out.println("Hello World!");
	}
	
	public static void main(String[] args){
		try {
			Class c = Class.forName("TestClass");
			Object o = c.newInstance();
			((TestClass)o).print();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
