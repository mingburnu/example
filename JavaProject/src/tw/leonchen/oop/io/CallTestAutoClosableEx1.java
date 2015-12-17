package tw.leonchen.oop.io;

class TestAutoClosableEx1 implements AutoCloseable {

	public void executeProcess() {
		System.out.println("Execute Process");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Resource Closed");
	}

}

public class CallTestAutoClosableEx1 {

	public static void main(String[] args) {
		try (TestAutoClosableEx1 resource = new TestAutoClosableEx1()) {
			resource.executeProcess();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
