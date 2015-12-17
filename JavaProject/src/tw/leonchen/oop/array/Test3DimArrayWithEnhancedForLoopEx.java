package tw.leonchen.oop.array;

public class Test3DimArrayWithEnhancedForLoopEx {

	public static void main(String[] args) {
		int[][][] data = {{{1,2,3},{4,5,6,7,8},{9,10}}};
		
		for(int[][] value:data){
			for(int[] num:value){
				for(int k:num){
				System.out.println("num=" + k);
			}
		}
		}
	}

}
