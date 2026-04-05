package BookMyTrain;

public class Ticket {
    private int ticketId;
    private int seats;
    private Train train;
    private Users user;
    private static int counter=10001;

    public Ticket(int seats, Train train, Users user) {
        this.ticketId = counter++;
        this.seats = seats;
        this.train = train;
        this.user = user;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket ------------------------>\n"
                +"Train Id :- "+ ticketId +
                "\tNo Of Seats :- " + seats +
                "\n" + user +
                "\nTrain---->\n" + train+"\n\n" ;
    }
}
