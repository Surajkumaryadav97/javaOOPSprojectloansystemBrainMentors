//user ke liye set up karenge pehle alag alag method se with validation.
//loantype management
//in main class calculation part will be done.
import java.util.Scanner;
interface loanMethod{
    void ApplyForLoan(Customer customer);
    void QDE(Customer customer);
    boolean Dedupecheck(Customer customer);

}
class suspect{
    //array of 10 customers
    long negcustomermobile[]={1234567890,1234567889,1234567898};
    String customeremail[]={"a@gmail.com","b@gmail.com","c@gmail.com"};
    String dob[]={"12122002","03032004","13132000"};

}
class validation{
    public static boolean isvalidname(String name){
        return name.length()>0; 
    }
    public static boolean isvalidage(int age){
        return age>=18;
    }
    public static boolean isvalidcity(String city){
         return city.length()>1;
    }
    public static boolean isvalidloantype(int loantype){
        return loantype==0||loantype==1;
    }
    public static boolean isvalidamount(double amount){
        return amount>30000;
    }
    public static boolean isvalidmobile(Long mobilenumber){
        String str=Long.toString(mobilenumber);
        return str.length()==10;
    }
    public static boolean isvalidemail(String email){
        //we have to check from last that there should be @gmail.com;
        //so
        if(email.length()<=10) return false;
        String s="@gmail.com";
        for(int i=email.length()-9;i<email.length();i++){
            if(email.charAt(i)!=s.charAt(i)) return false;
        }
          return true;
    }
    public static boolean isvaliddob(String dob){
        return dob.length()>=8;
    }
     public static boolean isvalidannualsalary(double annualincome){
        return annualincome>50000;
    }
    public static boolean isvalidliability(double liability){
        return liability>30000;
    }
}
class negative{
    public static boolean negcusto(Customer customer) {
            boolean flag=false;
            suspect susp=new suspect();
          int n=susp.customeremail.length;
          for(int i=0;i<n;i++){
             if(customer.DOB.equals(susp.dob[i])&&customer.email.equals(susp.customeremail[i])&&customer.mobilenumber==(susp.negcustomermobile[i])){
                flag=true;
                break;
             }
          }
          if(flag==true) return true;
          return false; 
    }
}
class impleinterface implements loanMethod{
   Scanner scanner= new Scanner(System.in);
    @Override
    public void ApplyForLoan(Customer customer) {
        System.out.println("enter your name");
        String name=scanner.nextLine();

        System.out.println("enter your age");
        int age=scanner.nextInt();
        scanner.nextLine();

        System.out.println("enter your city");
        String city=scanner.nextLine();
    
        System.out.println("enter your loantype");
        int loantype=scanner.nextInt();

        System.out.println("enter the loanamount");
        Double amount=scanner.nextDouble();

        System.out.println("enter your phoneno");
        long mobilenumber=scanner.nextLong();
        scanner.nextLine();
       
        //calling with class name because methods are static.
        if(validation.isvalidname(name)&&validation.isvalidage(age)&&validation.isvalidcity(city)&&
        validation.isvalidloantype(loantype)&&validation.isvalidamount(amount)&&validation.isvalidmobile(mobilenumber)){
            customer.setname(name);
            customer.setage(age);
            customer.setcity(city);
            customer.setloantype(loantype);
            customer.setamount(amount);
            customer.setmobilenumber(mobilenumber);
             //there should be a application/customerid to check negative customer and stages;
            String customerid=name+Long.toString(mobilenumber);
            customer.setcustomerid(customerid);
            //main crux of this project.
            customer.setstage(1);
        }
        else{
            System.out.println("please Enter your valid Details");
        }
       
        
    }

    @Override
    public void QDE(Customer customer) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter your email");
        String email=scanner.nextLine();
         
        System.out.println("enter your date of birth");
        String dob=scanner.nextLine();

        System.out.println("enter your annual income");
        double annualincome=scanner.nextDouble();

        System.out.println("enter your liability");
        double liability=scanner.nextDouble();

        if(validation.isvalidemail(email)&&validation.isvaliddob(dob)&&validation.isvalidannualsalary(annualincome)
        &&validation.isvalidliability(liability)){
            customer.setemail(email);
            customer.setdob(dob);
            customer.setannualsalary(annualincome);
            customer.setliability(liability);
            customer.setstage(2);
        }
        else {
            System.out.println("Enter valid details Again!");
            System.out.println();
        }
    }

    @Override
    public boolean Dedupecheck (Customer customer){
    //  suspect  susp=new suspect();
     
    if(negative.negcusto(customer)){
         System.out.println("Sorry! yourloan is rejected");
         customer.setstage(3);
         return negative.negcusto(customer);
       }
    else{
        System.out.println("congratulations! your loan is approved");
        customer.setstage(3);
        return negative.negcusto(customer);
    }
        
    }
    
}

 class Customer{
    String name;
    int age;
    String city;
    int loantype;
    double amount;
    long mobilenumber;
    String email;
    double liability;
    String DOB;
    double annualincome;
    int stage;
    String customerId;
    public Object annualincduration;
    public void setname(String name){
        this.name=name;
    }
    public void setage(int age){
        this.age=age;
    }
     public void setamount(double amount){
        this.amount=amount;
    }
     public void setcity(String city){
        this.city=city;
    }
     public void setloantype(int loantype){
        this.loantype=loantype;
    }
     public void setmobilenumber(Long mobilenumber){
        this.mobilenumber=mobilenumber;
    }
    public void setcustomerid(String customerid){
        this.customerId=customerid;
    }
    public void setemail(String email){
        this.email=email;
    }
    public void setdob(String dob){
        this.DOB=dob;
    }
    public void setannualsalary( double annualincome){
        this.annualincome=annualincome;
    }
    public void setliability( double liability){
        this.liability=liability;
    }
    public void setstage(int stage){
        this.stage=stage;
    }

}
abstract class loan{
    public int loanpercent(){
        return 60;
    }
    public int durationyear(){
        return 5;
    }
}
class homeloan extends loan{
    public int loanpercent(){
        return 80;

    }
    public int durationyear(){
        return 10;
    }
    
}
class autoloan extends loan{
    public int loanpercent(){
        return 50;

    }
    public int durationyear(){
        return 7;
    }
    
}


 class main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Customer cust[]=new Customer[20];
      while(true){ 
        int press=0;
        int i=0;
        System.out.println("1.New Application");
        System.out.println("2.Running Application");
        System.out.println("3.Exit the system");
       while(press<=2){
        String applicationid;
        System.out.println("press to continue");
        press=scanner.nextInt();
        scanner.nextLine();
        if(press==1){
            Customer customer=new Customer();
            impleinterface newform=new impleinterface();
            newform.ApplyForLoan(customer);
            cust[i++]=customer;
         
            // applicationid=customer.customerId;
        }
        else if(press==2){
          System.out.println("please enter your applicationid");
          String appliid=scanner.nextLine();
          Customer customer=null;
          for(int j=0;j<i;j++){
            if(cust[j].customerId.equals(appliid)){
                 customer=cust[j];
                 System.out.println(customer.customerId);
                 break;
            }
           }
           if(customer==null){
              System.out.println("your applicationid is not found");
              continue;
           }
          impleinterface newform=new impleinterface();
          while(customer.stage<3){
            if(customer.stage==1){
                newform.QDE(customer);
                
            }
            else if(customer.stage==2&&!newform.Dedupecheck(customer)){
                double loanamt=0;
                int duration=0;
                if(customer.loantype==0){
                    homeloan loancalc=new homeloan();
                    loanamt = (customer.annualincome*loancalc.loanpercent())/100.00;
                    duration=loancalc.durationyear();
              }
                else{
                    autoloan loancalc=new autoloan();
                    loanamt = (customer.annualincome*loancalc.loanpercent())/100.00;
                    duration=loancalc.durationyear(); 
                }
            System.out.println("loanamount bank will give:" + loanamt);
            System.out.println("The loan duration is:" + duration);
            }
            else{
                System.out.println("your application process has completed");
                
            }
           
        }  
           

         } 
         else if(press==3){
            System.out.println("thankyou");
            
         }
         else{
            System.out.println("invalid input");
           
         }

       }
    }  
    }
}


        


