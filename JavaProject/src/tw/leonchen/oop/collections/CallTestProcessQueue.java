package tw.leonchen.oop.collections;

import java.util.LinkedList;
import java.util.Queue;


public class CallTestProcessQueue {

	private Queue queue;
		
	public void executeStoreQueue(){
		queue = new LinkedList();
		queue.offer("mary");
		queue.offer("mary");
		queue.offer("john");
		queue.offer(new Integer(6));
		queue.offer(new Double(3.14));
		queue.remove(new Double(3.14));
	}
	
	public void executeRetriveQueue(){
		System.out.println("queue=" + queue);
		while(queue.peek()!=null){
			Object obj1 = queue.poll();
			System.out.println("obj1=" + obj1);
		}
	}
	
	public static void main(String[] args) {
		CallTestProcessQueue process = new CallTestProcessQueue();
		process.executeStoreQueue();
		process.executeRetriveQueue();
	}

}
