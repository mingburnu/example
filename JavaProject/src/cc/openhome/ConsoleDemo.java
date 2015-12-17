package cc.openhome;
import java.io.Console;

public class ConsoleDemo {

	public static void main(String[] args) {
		Console console = System.console();
		String account = console.readLine("enter account:");
		char[] password = console.readPassword("enter password:");
		System.out.println(account);
		System.out.println(password);
	}

}
