// https://leetcode.com/problems/design-browser-history/

public class Q17_design_browser_history {
    
    class Listnode {
        String data;
        Listnode prev;
        Listnode next;
        public Listnode(String data){
            this.data = data;
        }
    }

    Listnode curr;

    public BrowserHistory(String homepage) {
        curr = new Listnode(homepage);
    }
    
    public void visit(String url) {
        Listnode newNode = new Listnode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }
    
    public String back(int steps) {
        while(curr.prev!=null && steps-->0){
            curr = curr.prev;
        }
        return curr.data;
    }
    
    public String forward(int steps) {
        while(curr.next!=null && steps-- > 0){
            curr=curr.next;
        }
        return curr.data;
    }
}


/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */

 