package tw.leonchen.oop.exception;

public class TestArgsArrayWithExceptionEx1 {

	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i>args.length;i++){
			System.out.println("args[" + i + "]=" + args[i]);
			try{
				int num = Integer.parseInt(args[i]);
				sum=sum+num;
			}catch(NumberFormatException e){
				System.exit(-1);
			}finally{
				System.out.println("finally");
			}
		}
		System.out.println("sum=" + sum);

	}

}
