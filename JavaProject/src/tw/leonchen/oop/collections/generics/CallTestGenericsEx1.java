package tw.leonchen.oop.collections.generics;

class TestIntegerEx1{
	private Integer i1;
	
	public void setInteger(Integer i1){
		this.i1=i1;
	}
	
	public Integer getInteger(){
		return i1;
	}
}

class TestDoubleEx1{
	private Double d1;
	
	public void setDouble(Double d1){
		this.d1=d1;
	}
	
	public Double getDouble(){
		return d1;
	}
}

//...

class TestObjectEx1{
	private Object o1;
	
	public void setObject(Object o1){
		this.o1=o1;
	}
	
	public Object getObject(){
		return o1;
	}
}

class TestGenericsEx1<T>{
    private T t1;
	
	public void setT(T t1){
		this.t1=t1;
	}
	
	public T getT(){
		return t1;
	}
}

public class CallTestGenericsEx1 {

	public static void main(String[] args) {
		TestIntegerEx1 test1 = new TestIntegerEx1();
		test1.setInteger(12);
		int value1 = test1.getInteger();
		System.out.println("value1=" + value1);
		
		TestObjectEx1 test2 = new TestObjectEx1();
		test2.setObject(18);
		int value2 = (Integer)test2.getObject();
		System.out.println("value2=" + value2);
		
		//double value3 = (Double)test2.getObject();  //ClassCastException
		//System.out.println("value3=" + value3);
		
		TestGenericsEx1<Integer> generics1 = new TestGenericsEx1<Integer>();
		generics1.setT(6);
		int value4 = generics1.getT();
		System.out.println("value4=" + value4);
		
		TestGenericsEx1<Double> generics2 = new TestGenericsEx1<Double>();
		generics2.setT(3.14);
		double value5 = generics2.getT();
		System.out.println("value5=" + value5);
	}

}
