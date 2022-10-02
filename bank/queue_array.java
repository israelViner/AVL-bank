import java.util.*;
import java.lang.Integer;


public class queue_array {
    //propreties
    private Node[] elements;
    private int last;
    private int insert;
    private int takeout;
    private int Size;
    
    public queue_array(int size) {
        this.elements =  new Node[size];
        this.last = -1;
        this.insert = 0;
        this.takeout = 0;
        this.Size = size;
    }
    
    public boolean enqueue(Node x) {
        if (this.last == this.elements.length - 1)
           return false;
        else {
            this.elements[insert % Size] = x;
            this.insert +=1;
            this.last += 1;
            return true;
        }
    }
        
    public Node denqueue() {
        Node i;
        i = this.elements[takeout % Size];
        this.takeout += 1;
        this.last -= 1;
        return i;
    }
    
    public boolean isEmpty() {
        if (this.last < 0)
           return true;
        else
           return false;
    }
    
    public int size() {
        return last + 1;
    }
               
}
    
