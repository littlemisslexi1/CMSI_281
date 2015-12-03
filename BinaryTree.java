import java.lang.Iterable;
import java.util.Iterator;
import java.util.Stack;

public class BinaryTree implements Iterable{

	
	private Node root;
	private Node cursor;



	
	private class Node{
		private Object data;
		private Node leftson;
		private Node dad;
		private Node rightbro;



		public Node (Object obj){
		this.data = obj;

		}

		public Object getdata(){
		return this.data;
		}

		public void setdata(Object obj){
		this.data= obj;

		}

	     public void setleftson(Node lbro){
		this.leftson = lbro;

		}

		public Node getleftson(){
		return this.leftson;
		}

		public void setrightbro(Node rson){
		this.rightbro = rson;

		}

		public Node getrightbro(){
		return this.rightbro;
		}

		public void setdad(Node dads){
		this.dad = dads;

		}

		public Node getdad(){
		return this.dad;
		}

	}
	

	private class treeiterator implements Iterator{

			private Node x;
			private Node y;
			private Stack z;


			public treeiterator(Node root){
				this.x = root;
			}	
			public Object next(){
				y=x;
				if(x.getrightbro() != null && y.getleftson() != null){
					z.push(x.getrightbro());
					x= x.getleftson();
				}else if (x.getrightbro() != null){
					x= x.getrightbro();	

				}else if( x.getleftson() != null) {
					x= x.getleftson();
				}else{
					if( z.isEmpty()) {
						x= null;
					} else { 
						x = (Node)z.pop();
					}
				}
				return y.getdata();
			}

			public boolean hasNext(){
				if(x == null){
					return false;

					}else{
					return true;
					}

				
			}

			public void remove(){
				throw new UnsupportedOperationException();
			}




		}


	private class IOiterator implements Iterator{

			private Node x;
			private Node y;
			private Stack z;


			public IOiterator(Node root){
				this.x = root;
				while(x.getleftson() != null){
					z.push(x);
					x = x.getleftson();
				}
			}	


			public Object next(){
				y=x;
				if(x.getleftson() != null){
					z.push(x);
					x= x.getleftson();
				}else{
					if(z.size() >= 1){
						x= (Node)z.pop();

					}else{
						x= null;
					}
				}
				return y.getdata();
			}

			public boolean hasNext(){
				if(x == null){
					return false;

					}else{
					return true;
					}	
			}

			public void remove(){
				throw new UnsupportedOperationException();
			}
		} /* end IOiterator*/

			public BinaryTree(){
		
			}

			public BinaryTree(Object obj){
			this.root = new Node(obj);
			this.cursor = this.root;
			
			}


			public boolean contains(Object obj) {
				for ( Object x : this){
					if(x.equals(obj)){
						return true;
					}
				}
						return false;


				
			}
/*returns true iff the tree contains an object equivalent to obj*/

	public Node cursor(){
		return this.cursor;
	}




	public boolean similar(Object obj) {
		this.putCursorAtRoot();
		((BinaryTree)obj).putCursorAtRoot();
		int j = this.size();
		if( this.size() != ((BinaryTree)obj).size() ){
			return false;

		}else{
			Stack thisStack = new Stack();
			Stack objStack = new Stack();
			Node x = this.cursor;
			Node y = ((BinaryTree)obj).cursor;
			for(int a = 0; a < this.size(); a++){
				if(x.getrightbro() != null && x.getleftson() != null){
					if(y.getrightbro() == null || y.getleftson() == null){
						return false;
					}
					thisStack.push(x.getrightbro() );
					objStack.push(y.getrightbro() );
					x = x.leftson;
					y = y.leftson;



				}else if(x.getrightbro() == null && x.getleftson() != null){
					if(y.getrightbro() == null || y.getleftson() == null){
						return false;
					}

					x = x.rightbro;
					y = y.rightbro;


				}else if(x.getrightbro() != null && x.getleftson() == null){
					if(y.getrightbro() == null || y.getleftson() != null){
						return false;
					}
						x = x.leftson;
						y = y.leftson;

				}else{
					if(y.getrightbro() != null || y.getleftson() != null){
						return false;
					}

						x = (Node)thisStack.pop();
						y = (Node)objStack.pop();

				}
			}
		}
				return true;

	}
/*returns true iff obj is a similar binary tree- i.e., obj must have identical structure (only)*/

	public boolean equals(Object obj) {
		if(this.similar(obj) == false){
			return false;
		}
		Iterator b = this.iterator();
		Iterator c = ((BinaryTree)obj).iterator();
		while( b.hasNext() ){
			if( b.next().equals(c.next()) == false ){
				return false;
			}
				
		}
		
				return true;
	}

/*returns true iff obj is an equivalent binary tree- i.e., obj must have identical structure and equivalent objects*/

	



	public boolean isEmpty() {

		if(this.size() == 0){
			return true;

		} else{
			return false;
		} 

	}

	



	public int size(){
		int j = 0;
		for( Object p : this){
			j= j+1;

		}

			return j; 
	} 

	public int hashCode(){
		int hash = 1;
		for(Object x : this){
			hash = hash * 271 + (int)x;
			hash = hash / 29;
			hash = hash +73;

		}
			return hash;


		
	}

	





	public Iterator iterator() {
		return new treeiterator(this.root);

	}

	public Iterator inOrder(){
		return new IOiterator(this.root);
	}


	public boolean putCursorAtRoot(){
		this.cursor = this.root;
		if( this.size() == 0){
			return false;
		}
		
			return true;
	} 
 		/*returns false if this is an empty tree*/


	public boolean putCursorAtLeftSon(){
		if(this.cursor.getleftson() != null){
			this.cursor= this.cursor.getleftson();
			return true;
		}
			return false;
		
	}

	public boolean putCursorAtRightSon(){
		if(this.cursor.getrightbro() != null){
			this.cursor= this.cursor.getrightbro();
			return true;
		}
			return false;
	}

	public boolean putCursorAtFather(){
		if(this.cursor.getdad() != null){
			this.cursor= this.cursor.getdad();
			return true;
		}
			return false;
		
	}

	public boolean attachLeftSonAtCursor(Object obj) {
		if(cursor.getleftson() == null){
			cursor.setleftson(new Node (obj));
			return true;
		}
			return false;



		
	}



	public boolean attachRightSonAtCursor(Object obj) {

		if(cursor.getrightbro() == null){
			cursor.setrightbro(new Node (obj));
			return true;
		}
			return false;
	}

	public boolean pruneFromCursor(){
		if( cursor == cursor.getdad().getleftson() ){
			cursor.getdad().setleftson(null);
			this.cursor = this.root;
			return true;

		}else if(cursor == cursor.getdad().getrightbro() ){
			cursor.getdad().setrightbro(null);
			this.cursor = this.root;
			return true;

		}
			return false;
	}	

}












