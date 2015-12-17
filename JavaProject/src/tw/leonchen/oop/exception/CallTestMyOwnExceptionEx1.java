package tw.leonchen.oop.exception;

class TestMyOwnExceptionEx1 extends Exception {

	private String server = "deep blue";
	private int port = 80;

	public TestMyOwnExceptionEx1(String server, int port, String msg) {
	   super(msg);
       this.server=server;
       this.port=port;
	}
	
	public void showDetails(){
		System.out.println("server:" + server + " port:" + port);
	}
}

public class CallTestMyOwnExceptionEx1 {

	public static void main(String[] args) {
		int num=6;
		if(num%2==0){
			System.out.println("data incorrect");
			try {
				throw new TestMyOwnExceptionEx1("¨Ê",8080,"System error");
			} catch (TestMyOwnExceptionEx1 e) {
                e.showDetails();
                String msg=e.getMessage();
                System.out.println("msg=" + msg);
			} 
		}else{
			System.out.println("data correct");
		}

	}

}
