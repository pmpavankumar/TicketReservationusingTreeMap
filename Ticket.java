package TicketResarvation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Ticket 
{
		private int counter=100;
		private String pnr;
		private LocalDate TravelDate;
		private Train train;
		TreeMap <Passenger,Integer> Passengers;

		public Ticket(LocalDate travelDate, Train train) {

			TravelDate = travelDate;
			this.train = train;
		}
		public int getCounter() {
			return counter;
		}
		public void setCounter(int counter) {
			this.counter = counter;
		}
		public String getPnr() {
			return pnr;
		}
		public void setPnr(String pnr) {
			this.pnr = pnr;
		}
		public LocalDate getTravelDate() {
			return TravelDate;
		}
		public void setTravelDate(LocalDate travelDate) {

		TravelDate = travelDate;
		}
		public Train getTrain() {
			return train;
		}
		public void setTrain(Train train) {
			this.train = train;
		}
		public  String generatePNR()
		{
			String source=String.valueOf(train.getSource().charAt(0));
			String destinaion=String.valueOf(train.getDestination().charAt(0));;
			String date=TravelDate.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
			String pnr=source+destinaion+"_"+date+"_"+counter++;

			if(TravelDate.isAfter(LocalDate.now()))
				return pnr;
			else
				return "Please Enter valid date";

		}

		double calPassengerFare(Passenger Passenger)
		{
			if(Passenger.getAge()<=12)
				return (0.5/100)*(train.getTicketprice());

			else if(Passenger.getAge()>=60)
				return (0.6/100)*(train.getTicketprice());

			else if(Passenger.getGender()=='F' )
				return (0.7/100)*(train.getTicketprice());

			else
				return train.getTicketprice();
		}
		public void addPassenger(String name,int age,char gender)
		{ 
			
	            Integer fare=(int) calPassengerFare(new Passenger(name, age, gender));
			Passengers.put(new Passenger(name, age, gender),fare);
		}

		double calculateTotalTicketPrice()
		{
			double totalPrice=0;
			Collection<Integer> price=Passengers.values();
			for(Integer values:price)
			{
				totalPrice=totalPrice+values;
			}
			
			return totalPrice;

		}

		StringBuilder generateTicket()
		{
			return null;

		}
}
