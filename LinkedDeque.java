public class LinkedDeque {

			private int size;
			private Node leftpointer;
			private Node rightpointer;
			private Node n;



		public LinkedDeque () { 
    	/** default constructor to create new LD and pass next,o,next as parameters. This statement assign values passsed thru to their respective variables*/ 
        this.leftpointer = null;
        this.size = 0;
        this.rightpointer = null;

        
    
   		 }
	 	public void insertLeft ( Object o ){
	 		if (this.size == 0){
	 			this.leftpointer = new Node (null,o,null);
	 			this.rightpointer= this.leftpointer;

	 		}else{

	 		this.leftpointer.setNext(new Node(null,o,this.leftpointer));
	 		this.leftpointer = this.leftpointer.getNext();
	 		} 
	 		this.size= this.size +1;
	 	
		}
  	



		public void insertRight ( Object o ){
	 		
	 		if (this.size == 0){

	 			this.rightpointer= new Node (null,o,null);
	 			this.leftpointer= this.rightpointer;

	 		}else{

	 		this.rightpointer.setNext2(new Node(this.rightpointer,o,null));
	 		this.rightpointer = this.rightpointer.getNext2();
	 		 }
	 		this.size= this.size +1;
	 	}
			 
			
 		public void deleteLeft (){

 			if (this.size == 0){
 			throw new UnsupportedOperationException();
 			}
 			if(this.size == 1){
 				this.leftpointer =null;
 				this.rightpointer=null;
 				this.size = 0;
 			} else {
 				this.leftpointer = this.leftpointer.getNext2();
 				this.leftpointer.setNext(null);
 				this.size= this.size -1;
 			}
   		 }



public void deleteRight (){

	if (this.size == 0){
 			throw new UnsupportedOperationException();
 	}
 			
 			
 				if(this.size == 1){
 					this.leftpointer =null;
 					this.rightpointer=null;
 					this.size = 0;
 			



 			} else{
 				this.rightpointer = this.rightpointer.getNext();
 				this.rightpointer.setNext2(null);
 				this.size= this.size -1;
 			}

}


  public Object left () {
    /** returns the left element without modifiying the deque just tells us what in it*/

    return this.leftpointer.getO();
    }


    public Object right () {
    /**returns the right element without modifiying the deque*/
    return this.rightpointer.getO();

        }   


public int size (){
	return this.size;

    }



 public String toString () {
        /**returns [obj][obj]...[obj]    Coverts output to string*/
        String strings = "";
       Node dog = this.leftpointer;


        while( dog != null){
        	strings = strings + "[" + dog.getO() + "]";
        	dog = dog.getNext2();

        } 
        return strings;
    }




public class Node{
		
		private Node next;
		private Object o;
		private Node next2;


		Node (Node next, Object o, Node next2){

		   this.o = o;
		   this.next = next;
		   this.next2 = next2;
		}


		public Object getO () {
			return o;
		}

		public Node getNext(){
			return next;
		}

		public Node getNext2(){
			return next2;
		}

		 public void setO(Object d){ 
		 	o = d; 
		 }

		 public void setNext(Node n){
		 	next = n;
		 }

		 public void setNext2(Node n2){
		 	next2 = n2;
		 }


	}


      
         













public static void main ( String[] args ){ 
    /** runs a comprehensive set of unit tests*/

 	
 System.out.println( "LinkedDeques looks like" );




  /** tests constructer & toString method */
 LinkedDeque test = new LinkedDeque();
 


/** insert left from blank */
 test.insertLeft("strawberries");
 System.out.println(test.toString().equals( "[strawberries]"));

/**inserts left to existing*/
test.insertLeft(1994);
System.out.println(test.toString().equals( "[1994][strawberries]"));


 /** inserts right to blank*/
 LinkedDeque test2 = new LinkedDeque();
 test2.insertRight("peaches");
  System.out.println(test2.toString().equals( "[peaches]"));

  /**inserts right to existing*/
test2.insertRight(315);
System.out.println(test2.toString().equals( "[peaches][315]")&& test2.size()==2);
 
/**inserts from left and right to existing*/

 test2.insertRight("grape");

 test2.insertLeft("apple");

 System.out.println(test2.toString().equals( "[apple][peaches][315][grape]")&& test2.size()==4);
 
/**Deletes from right and left*/
 test2.deleteRight();
 System.out.println(test2.toString().equals( "[apple][peaches][315]")&& test2.size()==3);
 
 test2.deleteLeft();
 System.out.println(test2.toString().equals( "[peaches][315]")&& test2.size()==2);


/**Empties deques */
 test2.deleteLeft();

 test2.deleteRight();
 System.out.println(test2.toString().equals( "")&& test2.size()==0);









   
}
  
  
    


   
}
