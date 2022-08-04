public class LinkedList {
    //navigation variables
    static LinkedList firstElement;
    LinkedList nextElement = null;
    LinkedList prevElement = null;
    //data payload
    int id;  //some number we want to save in our list
    
    LinkedList(int id) {
        if (firstElement == null) {
            firstElement = this;
        } else {
        	firstElement.prevElement = this;
            this.nextElement = firstElement;
            firstElement = this;
        }
        
        this.id = id;
    }
    
    public static LinkedList getElementWithID(int x) {
    	if (firstElement == null) return null;
        LinkedList tempElement = firstElement;
        
        while (tempElement.id != x) {
            tempElement = tempElement.nextElement;
            if (tempElement == null) return null;
        }
        return tempElement;
    }
    
    
    public static void removeElement(LinkedList l) {
    	if(l == null) return;
   
    	
    	if(firstElement == l && firstElement.nextElement == null) {
    		firstElement = null;
    	}
    	else if(firstElement == l) {
    		firstElement = l.nextElement;
    		firstElement.prevElement = null;
    		
    	}
    	else if(l.nextElement == null) {
    		l.prevElement.nextElement = null;
    		
    	}else {
    		l.prevElement.nextElement = l.nextElement;
    		l.nextElement.prevElement = l.prevElement;
    	}
    	
    	
    }
    
    public static void removeElementWithID(int x) {
    	removeElement(getElementWithID(x));
    }
    
    public static void printList() {
    	if(firstElement == null) return;
    	LinkedList tempElement = firstElement;
    	System.out.println("printing list: ");
    	while(tempElement != null) {
    		System.out.println("-  " + tempElement.id);
    		tempElement = tempElement.nextElement;
    		
    	}
    	
    	
    	
    }
        
}