package tw.leonchen.oop.collections.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TestGenericsEx2<T extends List<String>>{
    private T t1;
	
	public void setT(T t1){
		this.t1=t1;
	}
	
	public T getT(){
		return t1;
	}
}

public class CallTestGenericsEx2 {

	public static void main(String[] args) {
		TestGenericsEx2<ArrayList<String>> generics1 = new TestGenericsEx2<ArrayList<String>>();
		
		//TestGenericsEx2<HashSet> generics2 = new TestGenericsEx2<HashSet>();  //compile error
		
		TestGenericsEx2<LinkedList<String>> generics3 = new TestGenericsEx2<LinkedList<String>>();

	}

}
