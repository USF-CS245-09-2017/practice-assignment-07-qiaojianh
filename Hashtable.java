/*
    @qiaojian Hu
*/
import java.util.ArrayList;

public class Hashtable{

	private ArrayList<Node> arr;	
	private int size;
	private int numBuckets;

	public Hashtable(){
		arr = new ArrayList<Node>();
		size = 0;
		numBuckets = 314526;

		for (int i = 0; i < numBuckets; i++){
            arr.add(null);
		}
	}

	private int getBucketIndex(String key)
    {
        int hashCode = Math.abs(key.hashCode());
        int index = hashCode % numBuckets;
        return index;
    }

	public boolean contains (String key){

		int bucketIndex = getBucketIndex(key);
        Node head = arr.get(bucketIndex);
 
        while (head != null)
        {
            if (head.getKey().equals(key)){
                return true;
            }
            head = head.getNext();
        }
 
        return false;
	}

	public boolean containsKey (String key){

        return contains(key);
	}

	public String get (String key){

		int bucketIndex = getBucketIndex(key);
        Node head = arr.get(bucketIndex);
 
        while (head != null){
        	if (head.getKey().equals(key)){
                return head.getValue();
            }
            head = head.getNext();
        }
 
        return null;

	}

	public void put (String key, String value){

        int bucketIndex = getBucketIndex(key);
        Node head = arr.get(bucketIndex);
 
        while (head != null)
        {
            if (head.getKey().equals(key))
            {
                head.setValue(value);
                return;
            }
            head = head.getNext();
        }
 
        size++;
        head = arr.get(bucketIndex);
        Node newNode = new Node(key, value);
        newNode.setNext(head);
        arr.set(bucketIndex, newNode);
 

        if ((1.0*size)/numBuckets >= 0.7)
        {
            ArrayList<Node> temp = arr;
            arr = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++){
                arr.add(null);
            }
 
            for (Node headNode : temp)
            {
                while (headNode != null)
                {
                    put(headNode.getKey(), headNode.getValue());
                    headNode = headNode.getNext();
                }
            }
        }

	}

	public String remove (String key){
		
		int bucketIndex = getBucketIndex(key);
 
        Node head = arr.get(bucketIndex);
 
        Node prev = null;
        while (head != null)
        {
            if (head.getKey().equals(key))
                break;
 
            prev = head;
            head = head.getNext();
        }
 
        if (head == null){
            return null;
        }
        size--;
 
        if (prev != null){
            prev.setNext(head.getNext()); 
        }else{
            arr.set(bucketIndex, head.getNext());
        }
 
        return head.getValue();

	}


}