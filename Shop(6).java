public class Shop {
    int total=0;
    public Phone[] phones;
    //Create an array
    public void shop(int Number){
        phones =new Phone[Number];
    }
    public boolean isFull(){
        return total== phones.length;
    }
    public boolean isEmpty(){
        return total==0;
    }
    //Create some basic programs
    public boolean add(Phone phone1){
        if(isFull()){
            if(phones[total-1]==null) {
                phones[total-1]=phone1;
                return true;
            }
            return false;
        }
        else {
            for (int i = 0; i < phones.length; i++) {
                phones[total]=phone1;
                total++;
                break;
            }
            return true;
        }
    }
    //This program can add new phones to the array
    public String list(){
        String listofphone="";
        if(isEmpty()){
            return ("nothing");
        }
        else {
            for (int i=0;i<total;i++) {
                if (phones[i] != null) {
                    listofphone += i + 1 + ":" + "name:" + phones[i].getName() + " price:" + phones[i].getPrice() + " number:" + phones[i].getNumber() + "\n";
                }
            }
        }
        return listofphone;
    }
    //This program can list all the phones in the array
    public Phone find(String name){
        Phone foundPhone=null;
        if(isEmpty()){
            return null;
        }
        else{
            for(int i=0;i<total;i++){
                boolean result;
                result= phones[i].getName().contains(name);
                if(result) {
                    foundPhone =  phones[i];
                    System.out.print("name:" + foundPhone.getName() + " price:" +foundPhone.getPrice() + " number:" + foundPhone.getNumber() + "\n");
                }
            }
        }
        return foundPhone;
    }
    //This program can filter the phone you want
    public  void buyPhones(String name,int num){
        for(int i = 0; i< phones.length; i++){
            if(phones[i]!=null){
                if(phones[i].getName().equals(name)){
                    int number= phones[i].getNumber()-num;
                    phones[i].setNumber(number);
                    System.out.println("you succeed in buying what you want");
                    break;
                }
            }
        }
        if(!changePhone(name)){
            System.out.println("No phone matches!");
        }
    }
    //This program can buy the phone you want

    public boolean changePhone(String name){
        for (int i = 0; i < phones.length; i++) {
            if(phones[i]!=null){
                if(phones[i].getName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }
    public void changeAPhone(String name, double price, int number){
        for (int i = 0; i < phones.length; i++) {
            if(phones[i]!=null){
                if(phones[i].getName().equals(name)){
                    phones[i].setNumber(number);
                    phones[i].setPrice(price);
                    break;
                }
            }
        }
    }
    //This two program above can change the parameters of a certain phone
    public void deleteAPhone(String name){
        for (int i = 0; i < phones.length; i++) {
            if((phones[i]!=null)&&phones[i].getName().equals(name)) {
                phones[i] = null;
                if (i < phones.length - 1) {
                    for (int j = i; j < phones.length; j++) {
                        phones[j] = phones[j+1];
                    }
                }
                phones[phones.length - 1] = null;
                System.out.println("Successfully delete!");
                break;
            }
            if(!changePhone(name)){
                System.out.println("nothing is deleted!");
                break;
            }
        }


    }
    //This program can detele the certain phone in the array
}
