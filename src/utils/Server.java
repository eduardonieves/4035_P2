package utils;

public class Server {

	public boolean Serving;
	private String QueueID;
	private boolean hasNext;
	
	
	public boolean isServing() {
		return Serving;
	}
	public void setServing(boolean serving) {
		Serving = serving;
	}
	public String getQueueID() {
		return QueueID;
	}
	public void setQueueID(String queueID) {
		QueueID = queueID;
	}
	public boolean HasNext() {
		return hasNext;
	}
	
	
	
}
