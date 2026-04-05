package BookMyTrain;

import java.util.List;
import java.util.Scanner;

public class BookMyTrain {

    private final Scanner sc=new Scanner(System.in);
    private final UserService userservice=new UserService();
    private final BookingService bookingservice=new BookingService();

    public static void main(String[] args) {
        new BookMyTrain().start();
    }

    public void start() {
        System.out.println("<----- WelCome To The BookMytrain App ----->");
        while (true) {
            if (!userservice.isloggedIn()) {
                System.out.println("1.Register");
                System.out.println("2.Login");
                System.out.println("3.ExitApp");

                System.out.println("Enter Choice");
                int ch = sc.nextInt();

                switch (ch) {
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exitApp();
                    default -> System.out.println("Invalid Choice");
                }
            }
            else {
                showUserMenu();
            }
        }
    }

    void register(){
        System.out.print("\nEnter Username :- "); String username=sc.next();
        System.out.print("\nEnter Password :- "); String password=sc.next();  sc.nextLine();
        System.out.print("\nEnter FullName :- "); String fullName=sc.nextLine();
        System.out.print("\nEnter Contact  :- "); String contact=sc.next();
        userservice.userRegistration(username,password,fullName,contact);
    }

    void login(){
        System.out.print("\nEnter Username :- "); String username=sc.next();
        System.out.print("\nEnter Password :- "); String password=sc.next();
        userservice.userLogin(username,password);
    }

    private void showUserMenu(){
        while(userservice.isloggedIn()){
            System.out.println("-----User Menu-----");
            System.out.println("1.View All Trains");
            System.out.println("2.Search Train");
            System.out.println("3.Book Ticket");
            System.out.println("4.Cancle ticket");
            System.out.println("5.View My Tickets");
            System.out.println("6.Profile");
            System.out.println("7.Logout");
            System.out.println("Enter Choice");
            int ch=sc.nextInt();
            switch (ch){
                case 1 ->bookingservice.getAllTrains();
                case 2 ->searchTrain();
                case 3 ->book();
                case 4 ->cancle();
                case 5 ->viewTicket();
                case 6 ->System.out.println(userservice.currentUser);
                case 7 ->userservice.userLogout();
            }
        }
    }

    void searchTrain(){
        System.out.print("Enter Source :- ");
        String source=sc.next();
        System.out.print("Enter Destination :- ");
        String destination=sc.next();
        List<Train> trainList=bookingservice.searchTrain(source,destination);
        if(trainList.isEmpty()){
            System.out.println("Train Not Fount From "+source+" to "+destination);
            return;
        }
        System.out.println("<-----Train Found----->");
        for (Train train :trainList ){
            System.out.println(train);
        }
        System.out.println("Do you want to Book Ticket (yes/no)");
        String choice=sc.next();
        if(choice.equalsIgnoreCase("yes")){
            System.out.println("-------Proceeding To Book The Ticket-------");
            System.out.println("Enter Train id :- ");
            int trainId = sc.nextInt();
            System.out.println("No Of Seats :- ");
            int seats = sc.nextInt();
            if(seats<=0){
                System.out.println("Enter Valid Number Of Seats");
                return;
            }
            Ticket ticket=bookingservice.bookTicket(userservice.getCurrentUser(),trainId,seats);
            if(ticket!=null){
                System.out.println("Ticket Booked Successfully ");
                System.out.println(ticket);
            }
        }
    }
    void book(){
        System.out.print("Enter Source :- ");
        String source=sc.next();
        System.out.print("Enter Destination :- ");
        String destination=sc.next();
        List<Train> trainList=bookingservice.searchTrain(source,destination);
        if(trainList.isEmpty()){
            System.out.println("Train Not Fount From "+source+" to "+destination);
            return;
        }
        System.out.println("<-----Train Found----->");
        for (Train train :trainList ){
            System.out.println(train);
        }
        System.out.println();
        System.out.println("-------Proceeding To Book The Ticket-------");
            System.out.println("Enter Train id :- ");
            int trainId = sc.nextInt();
            System.out.println("No Of Seats :- ");
            int seats = sc.nextInt();
            if(seats<=0){
                System.out.println("Enter Valid Number Of Seats");
                return;
            }
            Ticket ticket=bookingservice.bookTicket(userservice.getCurrentUser(),trainId,seats);
            if(ticket!=null){
                System.out.println("Ticket Booked Successfully ");
                System.out.println(ticket);
            }
        }
    void cancle(){
        System.out.println("Enter The ticket Id :- ");
        int ticketId=sc.nextInt();
        System.out.println("Proceeding to Cancel The ticket ");
        bookingservice.cancleTicket(ticketId,userservice.currentUser);
        System.out.println("Your Ticket "+ticketId+" Successfully Canceled");
    }
    void viewTicket() {
        List<Ticket> showTicket = bookingservice.getTicketByUser(userservice.getCurrentUser());
        if (showTicket.isEmpty()) {
            System.out.println("Haven`t Booked Any Ticket");
        } else {
            System.out.println("Your Tickets :- ");
            for (Ticket ticket:showTicket){
                System.out.println(ticket);
            }
        }
    }
    void exitApp(){
        System.out.println("-------Thanks For Visiting The BookMyTrain App--------");
        System.out.println("         Hopefully Will Also Visit Next Time");
        System.exit(0);
    }
}

