package BookMyTrain;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

    List<Train> trainList = new ArrayList<>();
    List<Ticket> ticketList = new ArrayList<>();

    BookingService() {
        trainList.add(new Train(1001, "VandeBharat", "Latur", "pune", 100));
        trainList.add(new Train(1002, "Shatapdi Express", "Delhi", "Mumbai", 150));
        trainList.add(new Train(1003, "Mumbai Express", "Mumbai", "pune", 80));
        trainList.add(new Train(1004, "Azadi Express", "Kashmir", "KanyaKumari", 200));
        trainList.add(new Train(1005, "Chennai Express", "Goa", "Chennai", 90));
        trainList.add(new Train(1006, "Bharat Express", "KanyaKumari", "Kashmir", 70));
        trainList.add(new Train(1007, "KK Express", "Latur", "Haidrabad", 50));
        trainList.add(new Train(1008, "VandeBharat", "pune", "Latur", 100));
        trainList.add(new Train(1009, "Shatabdi Express", "Mumbai", "Delhi", 150));
        trainList.add(new Train(1010, "Chennai Express", "Chennai", "Goa", 90));
    }

    public List<Train> searchTrain(String source, String destination) {
        List<Train> showTrains = new ArrayList<>();
        for (Train train : trainList) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination))
                showTrains.add(train);
        }
        return showTrains;
    }

    public Ticket bookTicket(Users user,int trainId,int seats){
        for(Train train:trainList){
            if(train.getTrainId()==trainId){
                if(train.bookSeats(seats)){
                    Ticket ticket=new Ticket(seats,train,user);
                    ticketList.add(ticket);
                    return ticket;
                }
                else {
                    System.out.println("Seats Are Not Available");
                    return null;
                }
            }
        }
        System.out.println("Train Not Found");
        return null;
    }

    public List<Ticket> getTicketByUser(Users user) {
        List<Ticket> showTickets = new ArrayList<>();
        for (Ticket ticket:ticketList){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName())){
                showTickets.add(ticket);
            }
        }
        return showTickets;
    }

    public boolean cancleTicket(int ticketId,Users user){
        for (Ticket ticket:ticketList){
            if(ticket.getUser().getUserName().equalsIgnoreCase(user.getUserName()) && ticket.getTicketId()==ticketId){
                ticket.getTrain().cancleSeats(ticket.getSeats());
                ticketList.remove(ticket);
                System.out.println("Ticket "+ticketId+" Canceled Successfully");
                return true;
            }
            else
                System.out.println("Ticket Not Found Or Doesnt Belong To This User");
        }
        return false;
    }

    public void getAllTrains(){
        System.out.println("All Available Trains List ------>");
        System.out.println("Train Id\tTrain Name\t Source\t Destination\t Total Seats\tAvailable Seats\n" );
        for (Train train:trainList){
            System.out.println(train);
        }
    }
}