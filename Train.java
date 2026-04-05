package BookMyTrain;

public class Train {
    private int trainId;
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    public Train(int trainId, String trainName, String source, String destination , int totalSeats) {
        this.trainId = trainId;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats=totalSeats;
        this.availableSeats=totalSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public boolean bookSeats(int seats){
        if(seats<availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }

    public void cancleSeats(int seats){
        availableSeats+=seats;
    }

    @Override
    public String toString() {
        return trainId +"\t\t"+ trainName+"\t\t"+ source +"\t\t"+destination +"\t\t"+ totalSeats + "\t\t" + availableSeats ;
    }

}
