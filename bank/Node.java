
public class Node
{
    //propertires
    private key x;
    private int height;
    private Node _leftSon, _rightSon;
    
    // constructor
    public Node(int ID, String name) {
        this.x = new key(ID, name);
        this.height = 1;
        this._leftSon = null;
        this._rightSon = null;
    }
    
    // the get methods
    public int getHeight(Node t) {
        if (t == null)
           return 0;
        return t.height;
    }
    
        public Node getLeftSon() {
        return this._leftSon;
    }
    
    public Node getRightSon() {
        return this._rightSon;
    }
    
    public int getKeyID() {
        return this.x.getID();
    }
    
    public double getKeyBalance() {
        return this.x.getBalance();
    }
    
    // the set methods
    public void setHeight() {
        this.height = (this.getHeight(this.getRightSon()) > this.getHeight(this.getLeftSon()))? (1 + this.getHeight(this.getRightSon())): 1 + this.getHeight(this.getLeftSon());
        //this.height = 1 + Math.max(this.getHeight(this.getRightSon()), this.getHeight(this.getLeftSon()));
    }
    
    public void setLeftSon(Node node) {
        _leftSon = node;
    }
    
    public void setRightSon(Node node) {
        _rightSon = node;
    }
    
    public void setKeyBalance(int sum) {
        this.x.setBalance(sum);
    }
    
} //end of class Node
    

    
