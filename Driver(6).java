import java.util.Scanner;
//Introduce the Scanner
public class Driver {
    public Scanner input=new Scanner(System.in);
    public Shop ashop=new Shop();
    public static void main(String[] args) {
        System.out.println("test");
        Driver driver=new Driver();
        driver.processOrder();
        driver.runMenu();
    }
    //The main body of running the program
    public int mainMenu(){
        System.out.println("""
                \033[32;57;255m
                Shop Menu
                (1)add a phone
                (2)list the phones
                (3)find the phone
                (4)buy a phone
                (5)delete a phone
                (6)change a phone
                (0)exit
                ==>>\033[0m""");
        int option=input.nextInt();
        return option;
    }
    //Create the menu and set its color to green
    private void runMenu(){
        int option=mainMenu();
        while (option!=0){
            switch (option){
                case 1-> addAPhone();
                case 2-> listAllPhones();
                case 3-> findAPhone();
                case 4-> buyPhones();
                case 5->deleteAPhone();
                case 6->changeAPhone();
                default -> System.out.println("Invalid option entered"+option);
            }
            System.out.println("\nPress enter key to continue");
            input.nextLine();
            input.nextLine();
            option=mainMenu();
        }
        System.out.println("exiting,bye!");
        System.exit(0);
    }
    //The main body of running the menu
    private void findAPhone(){
        input.nextLine();
        System.out.println("enter a phone name");
        String name=input.nextLine();
        Phone foundPhone = ashop.find(name);
        if(foundPhone ==null){
            System.out.println("There are no phones with the name [" + name + "] in the store.");
        }
    }
    //This program can filter the phone you want
    private void processOrder(){

        System.out.print("How many Products would you like to have in your shop now?  ");
        int num = input.nextInt();

        ashop.shop(num+1);


        for (int i = 0; i < num; i++){
            addAPhone();
        }
    }
    //The program for initializing the shop (adding some phones)
    public void addAPhone(){
        input.nextLine();
        System.out.println("enter the phone name");
        String phoneName =input.nextLine();
        System.out.println("enter the price");
        double phonePrice =input.nextFloat();
        System.out.println("enter the amount");
        int phoneNumber =input.nextInt();
        Phone temp=new Phone(phoneName, phonePrice, phoneNumber);
        boolean isadded=ashop.add(temp);
        if(isadded){
            System.out.println("Phone Added Successfully");
        }
        else {
            System.out.println("No Phone Added");
        }
    }
    //The program can add a new phone to the array
    public void listAllPhones(){
        System.out.println("phones are");
        System.out.println(ashop.list());
    }
    //This program can list all the phones in the array
    public void buyPhones(){
        input.nextLine();
        System.out.println("enter the name you want to buy");
        String name=input.nextLine();
        System.out.println("enter how many the goods you want to buy");
        int num=input.nextInt();
        ashop.buyPhones(name,num);
    }
    //This program can buy the phone you want in the array
    public void deleteAPhone(){
        System.out.println("enter the name you want to delete");
        String name=input.next();
        ashop.deleteAPhone(name);
    }
    //This program can delete the certain phone in the array
    public void changeAPhone(){
        System.out.println("enter the name of the goods you want to change");
        String name=input.next();
        if(ashop.changePhone(name)){
            System.out.println("enter the new amount");
            int num=input.nextInt();
            System.out.println("enter the new price");
            double price=input.nextDouble();
            ashop.changeAPhone(name,price,num);
            System.out.println("The phone is changed successfully!");
        }
        else {
            System.out.println("what you want to change doesn't exist");
        }
    }
    //This program can change the parameters of a certain phone
}