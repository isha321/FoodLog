public class Food 
{
    private String name;
    private int quantity;
	private int calorie;
    private String mealtype;
    
    public Food()// default contuctor
    {
        name = "";
        quantity = 0;
        calorie= 0;
		mealtype="";
    }
    public Food (String n, int q, int c, String m)// non default constructor
    {
        name=n;
        quantity=q;
        calorie=c;
		mealtype=m;
    }
    
    public String toString()// tostring override
    {
        return "Name: " + name + " Quantity: " + quantity + " Calorie: " + calorie+ "Meal Type: "+mealtype;
    }
    
    public int getCalorie()// gets duration data member
    {
        return calorie;
    }
	public String getName()
	{
		return name;
	}
}
