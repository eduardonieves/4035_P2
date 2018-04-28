package utils;

import java.util.Queue;

public class Server {

	public boolean Serving;
	private Queue QueueID;
	private boolean hasNext;
	
	
	public boolean isServing() {
		return Serving;
	}
	public void setServing(boolean serving) {
		Serving = serving;
	}
	public Queue getQueueID() {
		return QueueID;
	}
	public void setQueueID(Queue queueID) {
		QueueID = queueID;
	}
	public boolean HasNext() {
		return hasNext;
	}
	
	
	
}
