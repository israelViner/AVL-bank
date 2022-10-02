public class intNode {
    
    private int value;
    private intNode next;
    private int length = 0;
    
    
    public intNode(int v,intNode n){
        value= v;
        next=n;
        length = Length();
    }

    public int getValue(){
        return value;
    }
    
    public void setValue(int v){
        value=v;
    }
    
    public intNode getNext(){
        return next;
    }
    
    public void setNext(intNode n){
        next=n;
        length = Length();
    }
    
    public String toString() {
        intNode q = this;
        String str = "";
        while (q != null) {
            str += q.getValue() + "-->";
            q = q.getNext();
        }
        str += "null";
        return str;        
    }
    
    public void addToStart(int x) {
        this.setNext(new intNode(this.getValue(),this.getNext()));
        this.setValue(x);
    }
    
    public void addToEnd(int x) {
        intNode s;
        for (s = this;s.getNext() != null; s = s.getNext());
        intNode a = new intNode(x, null);
        s.setNext(a);    
    }
    
    public int Length() {
        intNode p;
        int l = 0;
        for (p = this; p != null; p = p.getNext()) {
              l += 1;
        }
        return l;
    }
    
    public void remove(int x) {
        intNode p = this;
        if (p.getValue() == x && p.getNext() == null)
            p.setValue(Integer.MIN_VALUE);
        if (this.getValue() == x) {
              this.setValue(getNext().getValue());
              this.setNext(getNext().getNext());
        }     
        else {
           while (p.getNext() != null) {
               if (p.getNext().getValue() == x) {
                  p.setNext(p.getNext().getNext());
                  return;
               }
               else
                  p = p.getNext();
           }
        }
    }

     public void reverse() {
       intNode tempList = this.getNext();
       intNode headList = new intNode(this.getValue(), null);
       intNode newList = new intNode(Integer.MIN_VALUE, null);
       while (tempList != null) {
            newList.addToStart(tempList.getValue());
            tempList = tempList.getNext();
       }
       newList.remove(Integer.MIN_VALUE);
       newList.addToEnd(headList.getValue());
       this.setNext(newList);
       this.setValue(this.getNext().getValue());
       this.setNext(this.getNext().getNext());
    }
       
         
         
       // intNode p = this.getNext().getNext();
       // intNode nextTerm;
       // intNode previousTerm =  this.getNext();
       // this.getNext().setNext(null);
       // this.setNext(new intNode(30, null));
       // while (p != null) {
           // nextTerm = p.getNext();
           // p.setNext(previousTerm);
           // previousTerm = p;
           // p = nextTerm;
       // }
       // this.setNext(previousTerm);
       // int a = this.value;
       // this.remove(a);
       // this.addToEnd(a);                              
    //}
    
    public void printReverse() {
        if (this.getNext() == null)
           System.out.print(this.value + "-->");
        else {
           this.getNext().printReverse();
           System.out.print(this.getValue() + "-->");
        }
    }
    
}


