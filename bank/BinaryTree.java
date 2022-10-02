import java.util.*;   

class BinaryTree {
      
    // Root of Binary Tree
    Node root;
    //stack_array sta = new stack_array(20);
    Stack<Node> sta = new Stack<Node>(); 
    
    
    // Constructors
    BinaryTree(int ID, String name) { 
        root = new Node(ID, name); 
    }
  
    public BinaryTree() { root = null; }
 
    public Node searchNode1(int ID) {
        return searchNode(ID, this.root);
    }
    
    private Node searchNode(int ID, Node t) {
        Node temp = t;
        while (temp != null && temp.getKeyID() != ID) {
               if (temp.getKeyID() > ID)
                  temp = temp.getLeftSon();
               else
                  temp = temp.getRightSon(); 
                }
        return temp;
    }
    
    public void addN(int ID, String name) {
        this.root = addNode(ID, name, this.root);
    }
    
    public Node addNode(int ID, String name, Node t) {
        if (t == null) {
           return new Node(ID, name);
        }
        if (ID >= t.getKeyID()) {
               t.setRightSon(addNode(ID, name, t.getRightSon()));
        }
        else
                 t.setLeftSon(addNode(ID, name, t.getLeftSon()));
        t.setHeight();
        if (isBalance(t))
           return t;
        if (t.getHeight(t.getRightSon()) > t.getHeight(t.getLeftSon())) 
             if (t.getHeight(t.getRightSon().getRightSon()) > t.getHeight(t.getRightSon().getLeftSon())) 
                 return rotationLeft(t);
              else {
                 t.setRightSon(rotationRight(t.getRightSon()));
                 return rotationLeft(t);
                }
        else {
             if (t.getHeight(t.getLeftSon().getLeftSon()) > t.getHeight(t.getLeftSon().getRightSon()))
                    return rotationRight(t);
             else {
                    t.setLeftSon(rotationLeft(t.getLeftSon()));
                    return rotationRight(t);
             }
        } 
    }
    
    public void deleteNode1(int ID) {
        this.root = deleteNode(ID, this.root);
    }
    
    private Node deleteNode(int ID, Node t) {
       if (ID == t.getKeyID()) {
           if (t.getRightSon() == null && t.getLeftSon() == null) 
               return null;
           if (t.getRightSon() == null) 
               return t.getLeftSon();
           if (t.getLeftSon() == null) 
                 return t.getRightSon();
           else {
               Node tempRight = t.getRightSon();
               Node tempLeft = t.getLeftSon();
               t = findSuccessor(t);
               tempRight = deleteNode(t.getKeyID(), tempRight);
               t.setLeftSon(tempLeft);
               t.setRightSon(tempRight);
           }
       }
       else {
           if (ID > t.getKeyID()) 
              t.setRightSon(deleteNode(ID, t.getRightSon()));
           else 
              t.setLeftSon(deleteNode(ID, t.getLeftSon()));
       }
       t.setHeight();
       if (isBalance(t))
                  return t;
              else 
                  return checkRotates(t);
    }
    
    private Node rotationLeft(Node t) {
        Node result = t.getRightSon();
        Node temp = t.getRightSon().getLeftSon();
        t.getRightSon().setLeftSon(t);
        t.setRightSon(temp);
        t.setHeight();
        result.setHeight();
        return result;
    }
    
    private Node rotationRight(Node t) {
        Node result = t.getLeftSon();
        Node temp = t.getLeftSon().getRightSon();
        t.getLeftSon().setRightSon(t);
        t.setLeftSon(temp);
        t.setHeight();
        result.setHeight();
        return result;
    }
    
    private boolean isBalance(Node t) {
           return (Math.abs(t.getHeight(t.getLeftSon()) - t.getHeight(t.getRightSon())) <= 1); 
    }
    
    private Node findSuccessor(Node t) {
       Node result = t.getRightSon();
       while (result.getLeftSon() != null)
           result = result.getLeftSon();
       return result;
    }
    
    private Node checkRotates(Node t) {
        if (t.getHeight(t.getRightSon()) > t.getHeight(t.getLeftSon())) 
                 if (t.getHeight(t.getRightSon().getRightSon()) > t.getHeight(t.getRightSon().getLeftSon())) 
                     return rotationLeft(t);
                 else {
                     t.setRightSon(rotationRight(t.getRightSon()));
                     return rotationLeft(t);
                 }
        else {
                 if (t.getHeight(t.getLeftSon().getLeftSon()) > t.getHeight(t.getLeftSon().getRightSon()))
                    return rotationRight(t);
                 else {
                    t.setLeftSon(rotationLeft(t.getLeftSon()));
                    return rotationRight(t);
                 }
        }
    }
    
    // public void postO() {
       // postOrder(this.root);
    // }
   
     // private void postOrder(Node t) {
        // intNode l = new intNode(Integer.MIN_VALUE, null);
        // if (t == null)
          // return;
        // if (t.getRightSon() == null && t.getLeftSon() == null)
            // System.out.print(t.getNumber() + ",");
        // else {
            // postOrder(t.getLeftSon());
            // postOrder(t.getRightSon());
            // System.out.print(t.getNumber() + ",");
        // }
    // }
    
    
    public void preO() {
       preOrder(this.root);
    }
    
    
    public void preOrder(Node t) {
        if (t == null)
          return;
        if (t.getRightSon() == null && t.getLeftSon() == null) {
            System.out.print(t.getKeyID() + ",");
        }
        
        else {
            System.out.print(t.getKeyID() + ",");
            preOrder(t.getLeftSon());
            preOrder(t.getRightSon());
        }
    }
     
    // public void inO() {
       // inOrder(this.root);
    // }
    
    // public void inOrder(Node t) {
        // if (t == null)
          // return;
        // if (t.getRightSon() == null && t.getLeftSon() == null) {
            // System.out.print(t.getNumber() + ",");
        // }
        // else {
            // inOrder(t.getLeftSon());
            // System.out.print(t.getNumber() + ",");
            // inOrder(t.getRightSon());
        // }
    // }
    
    public void levelO() {
       levelOrder(this.root);
    }
    
    public void levelOrder(Node t) {
        Node y = t;
        queue_array que = new queue_array(30);
        que.enqueue(t);
        while (!que.isEmpty()) {
            y = que.denqueue(); 
            System.out.print(y.getKeyID() + ",");
            if (y.getLeftSon() != null)
                que.enqueue(y.getLeftSon());
            if (y.getRightSon() != null)
                que.enqueue(y.getRightSon());
        }
    }
    
    // private int counterLevel(Node t) {
        // int counter = 0;
        // if (t == null) 
           // return 0;
        // else {
            
        // if (t.getRightSon() != null)
          // counter++;
        // if (t.getLeftSon() != null)
           // counter++;
        // }
        // return counter;
    // }
    
    
    // public int widthLevel() {
        // Node y = this.root;
        // queue_array que = new queue_array(20);
        // que.enqueue(y);
        // int counter = 1;
        // int temp = 1;
        // int result = 1;
        // while (!que.isEmpty()) {
            // temp = counter;
            // counter = 0;
            // for (int i = 1; i <= temp; i++) {
                // y = que.denqueue();
                // // System.out.println(y);
                // // System.out.println("counter-1:" + counter + ",");
                // // System.out.println("temp0:" + temp + ",");
                 // if (y.getLeftSon() != null) {
                   // que.enqueue(y.getLeftSon());
                   // counter++;
                // }
                // if (y.getRightSon() != null) {
                   // que.enqueue(y.getRightSon());
                   // counter++;
                // }
            // }
            // if (counter > result)
                // result = counter;
        // }
        // return result;
    // }
    
    // public int largeLevel() {
        // Node y = this.root;
        // queue_array que = new queue_array(20);
        // que.enqueue(y);
        // int max = 0;
        // int counter = 1;
        // int temp = 1;
        // int result = this.root.getNumber();
        // while (!que.isEmpty()) {
            // max = 0;
            // temp = counter;
            // counter = 0;
            // for (int i = 1; i <= temp; i++) {
                // y = que.denqueue();
                // max += y.getNumber();
                // // System.out.println(y);
                // // System.out.println("counter-1:" + counter + ",");
                // // System.out.println("temp0:" + temp + ",");
                 // if (y.getLeftSon() != null) {
                   // que.enqueue(y.getLeftSon());
                   // counter++;
                // }
                // if (y.getRightSon() != null) {
                   // que.enqueue(y.getRightSon());
                   // counter++;
                // }
            // }
            // if (max > result)
                // result = max;
        // }
        // return result;
    // }
    
    // public void pushLeftSide(Node t) {
        // while (t.getLeftSon() != null) {
            // t = t.getLeftSon();   
            // this.sta.push(t);
        // }
    // }
    
    // public void newInO() {
       // newInorder(this.root);
    // }
    
    // public void newInorder(Node t) {
        // this.sta.push(t);
        // Node a;
        // while (!this.sta.isEmpty()) {
           // a = this.sta.pop();
           // this.sta.push(a);
           // pushLeftSide(a);
           // a = this.sta.pop(); 
           // System.out.print(a.getNumber() + ",");
           // while (!this.sta.isEmpty() && a.getRightSon() == null) {
              // a = this.sta.pop();
              // System.out.print(a.getNumber() + ",");
           // }
           // if (a.getRightSon() != null)
                // this.sta.push(a.getRightSon());
        // }
    // }
    
    // public void mirrorT() {
       // mirrorTree(this.root);
    // }
    
    // public void mirrorTree(Node n) {
        // Node t = n;
        // Node temp;
        // if (t == null || t.getRightSon() == null && t.getLeftSon() == null)
            // return;
        // if (t.getLeftSon() == null) {
           // t.setLeftSon(t.getRightSon());
           // t.setRightSon(null);
           // mirrorTree(t.getRightSon());
        // }
        // if (t.getRightSon() == null) {
           // t.setRightSon(t.getLeftSon());
           // t.setLeftSon(null);
           // mirrorTree(t.getRightSon());
        // }
        // else {
            // temp = t.getLeftSon();
            // t.setLeftSon(t.getRightSon());
            // t.setRightSon(temp);
            // mirrorTree(t.getLeftSon());
            // mirrorTree(t.getRightSon());
        // }
    // }
    
    
}