package utils;

import java.util.Queue;

public class Server {

	public boolean Serving;
	private Queue<Customer> QueueID;
	private boolean hasNext;
	
	
	public boolean isServing() {
		return Serving;
	}
	public void setServing(boolean serving) {
		Serving = serving;
	}
	public Queue<Customer> getQueueID() {
		return QueueID;
	}
	public void setQueueID(Queue<Customer> queueID) {
		QueueID = queueID;
	}
	public boolean HasNext() {
		return hasNext;
	}
	
	
	
}
