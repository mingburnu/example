package tw.leonchen.oop;

public class TestStringMethodEx1 {

	public static void main(String[] args) {
		String data = "abcdefgh";
		
		char ch1 = data.charAt(3);
        System.out.println("ch1=" + ch1);
        
        String subdata = data.substring(3);
        System.out.println("subdata=" + subdata);
	}

}
