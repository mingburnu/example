package tw.leonchen.oop.array;

public class TestArrayWithEnhancedForLoopEx1 {

	public static void main(String[] args) {
		int[] data = {1,2,3,4,5,6,7,8};
		
		for(int i=0;i<data.length;i++){
			System.out.println("data[" + i + "]=" + data[i]);
		}
		
		for(int value:data){
			System.out.println("value=" + value);
		}
		
		char[] alphabet = {'a','b','c','d','e'};
		
		for(char ch:alphabet){
			System.out.println("ch=" + ch);
		}

	}

}
