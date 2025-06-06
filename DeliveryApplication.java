import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
class User{
    Scanner sc;
    private String username;
    private String password;
    private String logintype;
    User(Scanner sc){
        this.sc=sc;
    }
    void UserDetails(){
        System.out.println("------------------Login Process----------------"); 
        System.out.println("Logging in as a Customer or Seller?");
        while(true){
        logintype = sc.nextLine();
        switch (logintype){
            case "Customer":{
            System.out.println("------------Logging in as a Customer-----------");
            System.out.println("Enter username");
            username = sc.nextLine();
            System.out.println("Enter password, it should contain minimum 8 characters with one UpperCase character");
            while(true){
                password = sc.nextLine();
                if(PasswordValidator.isValidPassword(password))
                    {System.out.println("Strong password set.");
                    break;}
                else
                    System.out.println("Make sure you enter a valid password!");
        }
            System.out.println("Successful login as "+ username +"!");
            System.out.println("Enjoy your shopping...");
            break;
            }
            case "Seller":{
            System.out.println("------------Logging in as a Seller-------------");
            System.out.println("Enter username");
            username = sc.nextLine();
            System.out.println("Enter password, it should contain minimum 8 characters with one UpperCase character");
            while(true){
                password = sc.nextLine();
                if(PasswordValidator.isValidPassword(password))
                    {System.out.println("Strong password set.");
                    break;}
                else
                    System.out.println("Make sure you enter a valid password!");
        }
            System.out.println("Successful login as " + username +"!");
            System.out.println("Enjoy selling products at the best prices...");
            break;
            }
            default:
            System.out.println("Choose either Customer or Seller only");
            continue;
        } 
        break;
    }
}
class PasswordValidator{
    public static boolean isValidPassword(String password){
   if(password.length()<8)
    return false;
    for(int i=0;i<password.length();i++){
        if (Character.isUpperCase(password.charAt(i))){
        return true;}
    }
    return false;
}
}
}
class Products{
    static int Id=1;
    static int quantity;
    int id;
    String name;
    int price;
    static ArrayList<Products> food =new ArrayList<>();
    static ArrayList<Products> electronics = new ArrayList<>();
    static ArrayList<Products> bodyandskin = new ArrayList<>();
    Products(String name, int price){
        this.id=Id++;
        this.name=name;
        this.price=price;
    }
    static void ProductsList(){
        String ans = "yes";
        while(ans.equals("yes")){
        System.out.println("Choose:");
        System.out.println("1 for food");
        System.out.println("2 for electronics");
        System.out.println("3 for body & skin");
        int choice = DeliveryApplication.sc.nextInt();
        switch(choice){
            case 1:
            Products.DisplayFoodMenu();
            break;
            case 2:
            Products.DisplayElectronicsMenu();
            break;
            case 3:
            Products.DisplayBodyAndSkinMenu();
            break;
            default:
            System.out.println("Invalid choice! Choose again.");
            continue;
        }
    DeliveryApplication.sc.nextLine();
    System.out.println("want to continue shopping? type yes or no.");
    while(true){
    ans = DeliveryApplication.sc.nextLine();
    if(ans.equals("yes")){
        break;
    }
    else if (ans.equals("no")){
        System.out.println("Directing you to your cart...");
        Cart.cart();
    }
    else{
        System.out.println("Type yes or no only.");
    }
}
}
    }
    public static void DisplayFoodMenu(){
        int choice1;
        System.out.println("----------------Food List----------------");
        for(Products p : food){
        System.out.println("id-"+p.id + "] " +p.name+" -Rs."+p.price);
        }
        System.out.println("Choose with id number.");
        while(true){
        choice1 = DeliveryApplication.sc.nextInt();
        boolean idfound=false;
        for(Products p : food){
        if(p.id==choice1){
        while(true){
        System.out.println("How many of "+p.name+"'s would you like?");
        try{
        quantity = DeliveryApplication.sc.nextInt();
        if(quantity==0){
            System.out.print("");
            idfound = true;
            break;
        }
        else{
        System.out.println("--> "+quantity +" "+p.name+" added to cart!");
        Cart.UserCart.add(new Cart(quantity,p.name,p.price));
        idfound = true;
        break;
        }
        }
        catch( InputMismatchException e){
            System.out.println("Choose a number only!");
            DeliveryApplication.sc.nextLine();
            continue;
        }
    }
    }
    }
        if(!idfound){
            System.out.println("Invalid choice! Choose again.");
        }
        else{
            break;
        }
        }
    }
    public static void DisplayElectronicsMenu(){
        int choice1;
        System.out.println("----------------Electronics--------------");
        for(Products p : electronics){
        System.out.println("id-"+p.id + "] " +p.name+" -Rs."+p.price);
        }
        System.out.println("Choose with id number.");
        while(true){
        choice1 = DeliveryApplication.sc.nextInt();
        boolean idfound=false;
        for(Products p : electronics){
        if(p.id==choice1){
        while(true){
        System.out.println("How many of "+p.name+"'s would you like?");
        try{
        quantity = DeliveryApplication.sc.nextInt();
        if(quantity==0){
            System.out.print("");
            idfound = true;
            break;
        }
        else{
        System.out.println("--> "+quantity +" "+p.name+" added to cart!");
        Cart.UserCart.add(new Cart(quantity,p.name,p.price));
        idfound = true;
        break;
        }
        }
        catch( InputMismatchException e){
            System.out.println("Choose a number only!");
            DeliveryApplication.sc.nextLine();
            continue;
        }
    }
        }
    }
        if(!idfound){
            System.out.println("Invalid choice! Choose again.");
        }
        else{
            break;
        }
        }
}
public static void DisplayBodyAndSkinMenu(){
        int choice1;
        System.out.println("----------Body and Skin products---------");
        for(Products p : bodyandskin){
        System.out.println("id-"+p.id + "] " +p.name+" -Rs."+p.price);
        }
        System.out.println("Choose with id number.");
        while(true){
        choice1 = DeliveryApplication.sc.nextInt();
        boolean idfound=false;
        for(Products p : bodyandskin){
            if(p.id==choice1){
            while(true){
                System.out.println("How many of "+p.name+"'s would you like?");
                try{
                quantity = DeliveryApplication.sc.nextInt();
                if(quantity==0){
                    System.out.print("");
                    idfound = true;
                    break;
                }
                else {
                  System.out.println("--> "+quantity +" "+p.name+" added to cart!");
                    Cart.UserCart.add(new Cart(quantity,p.name,p.price));
                    idfound = true;
                    break;  
                }
            }
            catch (InputMismatchException e){
                System.out.println("Choose a number only!");
                DeliveryApplication.sc.nextLine();
                continue;
            }
            }
        }
    }
        if(!idfound){
            System.out.println("Invalid choice! Choose again.");
        }
        else{
            break;
        }
    }
}
}
class Cart{
    int quantity;
    String name;
    int price;
    static String answer;
    static ArrayList<Cart> UserCart = new ArrayList<>();
    Cart(int quantity,String name, int price){
        this.quantity=quantity;
        this.name=name;
        this.price=price;
    }
    public static void cart(){
        int newprice=0;
        System.out.println("--------------------Your Cart------------------");
        for (Cart c : UserCart){
            System.out.println(c.quantity +" "+ c.name+ ","+" Rs." +c.price);
            newprice = newprice + (c.quantity * c.price);
        }
        System.out.println("want to add anything else? type yes or no only.");
        while(true){
        String choice2 = DeliveryApplication.sc.nextLine();
        if(choice2.equals("yes")){
            Products.ProductsList();
        break;}
        else if(choice2.equals("no")){
            System.out.println("Total amount to be paid : Rs." + newprice);
        break;}
        else {
            System.out.println("Invalid reply! Choose again.");
        }
    }
   }
}
public class DeliveryApplication{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String agrs[]){

        User user = new User(sc);
        user.UserDetails();

        System.out.println("--------------Product Categories---------------");

        Products.food.add(new Products("Bingo chilli yummitos",20));
        Products.food.add(new Products("Bingo salted yummitos",20));
        Products.food.add(new Products("Lays indian masala",10));
        Products.food.add(new Products("Lays korean flavour",10));
        Products.food.add(new Products("Bingo Tooyumm",35));
        Products.food.add(new Products("Pringles Chilli",99));

        Products.electronics.add(new Products("dell laptop",76000));
        Products.electronics.add(new Products("mouse",1499));
        Products.electronics.add(new Products("macbook pro",99999));
        Products.electronics.add(new Products("Canon printer",4959));
        Products.electronics.add(new Products("HP printer",3999));

        Products.bodyandskin.add(new Products("Cera Ve moisturiser",390));
        Products.bodyandskin.add(new Products("Cetaphil Toner",1120));
        Products.bodyandskin.add(new Products("Dot & Key Ceramide moisturiser",425));
        Products.bodyandskin.add(new Products("Ilem eyepads",1900));
        Products.bodyandskin.add(new Products("Garnier Micellar water",240));

        Products.ProductsList();
        sc.close();
}
}