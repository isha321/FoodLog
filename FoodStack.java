class FoodStack{
	private Food[] stack;
	private int tos;			// Top of stack
	private int capacity;	// Total capacity of the stack
	private int size;		// Current number of elements in the stack
	
	// Default Constructor, creates a stack of size 10
 
        public FoodStack(){
		this.stack = new Food[10];
		this.tos = -1;
		this.capacity = 10;
		this.size = 0;
	}
	
	// Overloaded Constructor, create a stack for user defined value
	public FoodStack(int arraySize){
		this.stack = new Food[arraySize];
		this.tos = -1;
		this.capacity = arraySize;
		this.size = 0;
	}
	
	// push() for stack
	public void push (Food value){
		// Check if there is space to add data or not
		if(size == capacity){
			System.out.println("Stack Overflow...!!");
			return;
		}
		stack[++tos] = value;
		this.size++;
	}
	
	// pop() for stack
	public Food pop(){
		// Check if there is any data to actually pop
		if(isEmpty())
                {       
                    System.out.println("Stack Underflow...!!");
                    return null;
		}
		Food temp = stack[tos--];	// Element to return
		this.size--;
		return temp;
	}
	
	// Method to check if the stack is empty
	public boolean isEmpty(){
		if(this.tos == -1)
			return true;
		return false;
	}
	
	// Method to display the contents of the stack
	public void display()
        {
		System.out.print("Stack Contents: ");
		for(int i = 0; i < this.size; i++){
			System.out.print(" | " + this.stack[i]);
		}
		System.out.println("");
	}
}
