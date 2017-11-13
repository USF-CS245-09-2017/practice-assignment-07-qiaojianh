/*
	@Qiaojian Hu
*/
public class Node{
	private String key;
	private String value;
	private Node next;


	public Node(String key, String value){
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public String getKey(){
		return key;
	}

	public String getValue(){
		return value;
	}

	public Node getNext(){
		return next;
	}

	public void setKey(String key){
		this.key = key;
	}

	public void setValue(String key){
		this.value = value;
	}

	public void setNext(Node next){
		this.next = next;
	}

}