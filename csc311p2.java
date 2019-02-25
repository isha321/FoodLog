import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat; //imports that call other classes
import java.util.Random;
import java.util.Scanner;

//Isha Sinha CSC 311- Data Structures; Amlan Chatterjee
public class csc311p2
{
    public static FoodStack food = new FoodStack();// main stack
    
    public static void main(String[] args) //programs cant run without main method
    {
        start();//method that starts first menu
    }
    
     public static void start(){
        Scanner input = new Scanner(System.in);// setting up menu
        String account; //checks if account is registered
       
        System.out.println("[1] Register");
        System.out.println("[2] Log in");
        System.out.println("[3] Exit");
       
        
        System.out.println("Please select an option: ");
        int option = input.nextInt();

        switch (option) {
            case 1: 
                register();
                break;
            
            case 2:
                account = signIn();
                if (account.equals("Invalid UserID or passowrd!"))
                {
                    System.out.println(account);
                    start();
                }
                else
                    menu(); 
                break;
             
            case 3:
                System.out.println("Good-Bye!");
                break;

            default:
                System.out.println("Invalid input. Try again.");
                start();
                break;
    }
    }
     public static void register() {    // registers clients to file
        Scanner input = new Scanner(System.in);
        Random rnd = new Random(); //random number password
        int counter = 0;
        String lastName = "";

        //Reference: "http://www.mkyong.com/java/how-to-write-to-file-in-java-bufferedwriter-example/"       
        try {   //writes to file
            //
            File file = new File("C:\\Users\\Isha\\Desktop\\Registry\\FileRun.txt"); //file locater

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            //Reference: http://alvinalexander.com/java/edu/qanda/pjqa00009.shtml
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));     //begin writing to file
            
            System.out.println("Enter your first name: ");
            String firstName = input.nextLine();
            bw.write("\nFirst Name: " + firstName);
            bw.newLine(); 
  
            System.out.println("Enter your last name: ");
            lastName = input.nextLine();
            bw.write("Last Name: " + lastName);
            bw.newLine();
            
            System.out.println("Enter UserID (Must contain at least 8 characters): ");
            String id = input.nextLine();

            //while loop for bad username
            while (id.length() < 8) //Reference: https://answers.yahoo.com/question/index?qid=20110220040530AA8LQkS
            {
                System.out.println("Invalid UserID. Try again.");
                id = input.nextLine();

                if (id.length() < 8) {
                    counter++;
                } else {
                    break;
                }

                if (counter == 2) { //if messes up twice, this code makes one up
                    StringBuilder newid = new StringBuilder();
                    newid.append(lastName);
                    for (int i = 0; i < 4; i++) {
                        newid.append(rnd.nextInt(10));
                    }
                    while (newid.length() < 8) {
                        for (int j = 0; j < (8 - newid.length()); j++) {
                            newid.append(rnd.nextInt(10));
                        }
                    }
                    System.out.println("Too many tries. Your UserID is: " + newid);
                    id = newid.toString();
                    break;
                }
            }

            bw.write("UserID: " + id);

            System.out.println("Enter a password: ");
            String password = input.nextLine();
            bw.write(" Password: " + password);
            bw.newLine();
            
            bw.newLine();

            bw.close();
            menu();
            
			
			}
			catch (IOException e) {       //catches input output exception error
            e.printStackTrace();
			}
        } 
		
		 public static String signIn() // reads file for username and password
    {
        Scanner input = new Scanner(System.in);
        String textline = "Invalid UserID or passowrd!";    //method returns a string
        
        //Reference: http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Isha\\Desktop\\Registry\\FileRun.txt")))
        {
            System.out.println("Enter UserID: ");
            String user = input.nextLine();
            
            System.out.println("Enter password: ");
            String pass = input.nextLine();
            String line;
            
            while ((line = br.readLine()) != null) //while line is not blank, goes over each line of text in the file
            {
                if (line.equals("UserID: " + user + " Password: " + pass)){
                    textline = "UserID: " + user + " Password: " + pass; //string will be rertuned if correct
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return textline; //returns string if right or wrong
    }
     
      public static void menu() { // main menu after log in
        Scanner input = new Scanner(System.in);

        System.out.println("-------------------------------------"); 
        System.out.println("Welcome back!");
        System.out.println("[3] Enter Foods eaten");
        System.out.println("[4] Diet history");
        System.out.println("[5] Display Foods Eaten");
		System.out.println("[6] Total Calories in all ");
		System.out.println("[7] Food Items with Maximum Calorie content");
		System.out.println("[8] Food item eaten the most");
		System.out.println("[9] Exit ");
        System.out.println("-------------------------------------");

        System.out.println("Please select an option: ");
        int option = input.nextInt();

        switch (option) {

            case 3:
                addFood();
                break;

            case 4:
                FoodHistory();
                break;

            case 5:
                FoodDisplay();
                break;
				
			 case 6:
                TotalCalories();
                break;
				
			 case 7:
                MaxCal();
                break;
				
				 case 8:
                Mostcommonfood();
                break;
				
            case 9:
                System.out.println("Come back again soon!");
                break;

            default:
                System.out.println("Invalid input. Try again.");
                menu();
                break;
        }
    }
      public static void addFood()// adds food to stack
      {
        Scanner input = new Scanner(System.in);
        Scanner check = new Scanner(System.in); //made 2 scanners because program was not taking 3 inputs
        Random rnd = new Random();
        Food x = new Food();

        System.out.println("What is the name of the food?");
        String n = input.nextLine();
		System.out.println("What is the quantity consumed?");
        int q = input.nextInt();
		System.out.println("How many calories?");
        int c = input.nextInt();
		System.out.println("What is the Meal Type? (breakfast, lunch, dinner,etc)");
        String m = check.nextLine();
        
        x = new Food(n, q, c, m);    //initializes food object
        
        food.push(x);  // pushes food object into stack
        
        System.out.println("Would you like to add another food?");
        String o = check.nextLine();
        if (o.equalsIgnoreCase("yes"))  //if yes, does whole menu again
          addFood();
        else
            menu();     //if not goes to menu
       }
      public static void FoodHistory()//puts calls in another stack and pops them
    {
        FoodStack reverse = new FoodStack();    //creates temporary stack
        while (!food.isEmpty())  //while main stack is not empty
        {
            reverse.push(food.pop());   //pops obejcts from main stack onto temporary stack
        }
        reverse.display();
        System.out.println("");
        while (!reverse.isEmpty())  //after displaying, it pushes everything back onto main stack
        {
            food.push(reverse.pop());// puts back in main stack
        }
        menu();
    }
	public static void FoodDisplay(){
		FoodStack x= new FoodStack();
		StringStack rev= new StringStack();
		Food f= new Food();
		while(!food.isEmpty()){
			f=food.pop();
			rev.push(f.getName());
			x.push(f);
		}
		while(!x.isEmpty())
		{	
			f=x.pop();
			food.push(f);
		}
		rev.display();
		System.out.println("");
		menu();
	}
		

	public static void TotalCalories(){
		Food f= new Food();
		FoodStack temp= new FoodStack();
		int sum=0;
		while(!food.isEmpty()){
			f=food.pop();
			sum+= f.getCalorie();
			temp.push(f);
		}
		while(!temp.isEmpty())
		{
			f=temp.pop();
			food.push(f);
		}
		System.out.println("Total Calories:" +sum);
		System.out.println("");
		menu();
		
	}
	
      public static void MaxCal()// displays all food
      {
        Food x = new Food();  //creates two caller objects to check duration data members
        Food y = new Food();
        FoodStack n = new FoodStack(); //temp stack
        int xd = 0;
        int yd = 0;
        int greatest = 0;
        int smallest = 0;
        
        while (!food.isEmpty())
        {
            x = food.pop();
            xd = x.getCalorie();
            n.push(x);
            
            if (xd > yd)  
            {
                greatest = xd;
                smallest = yd;
            }
            
            else if (yd > xd)
            {
                greatest = yd;
                smallest = xd;
            }
            
            yd = xd;
        }
        
          System.out.println("Maximum Calories " + greatest);
          System.out.println("Samllest: " + smallest);
        System.out.println("");
        
        while (!n.isEmpty())    //pushes all obejects from temp stack back onto main stack
        {
            food.push(n.pop());
        }
        menu();
      }
      public static void Mostcommonfood(){
        Food x = new Food();  //creates two caller objects to check duration data members
        Food y = new Food();
        FoodStack n = new FoodStack(); //temp stack
        int xd = 0;
        int yd = 0;
        int greatest = 0;
        int smallest = 0;
        
        while (!food.isEmpty())
        {
            x = food.pop();
            xd = x.getCalorie();
            n.push(x);
            
            if (xd > yd)  
            {
                greatest = xd;
                smallest = yd;
            }
            
            else if (yd > xd)
            {
                greatest = yd;
                smallest = xd;
            }
            
            yd = xd;
        }
        
          System.out.println("Maximum Calories " + greatest);
          System.out.println("Samllest: " + smallest);
        System.out.println("");

    }
	
}
		  
	  
      

   