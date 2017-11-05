package assignment05;
import java.time.*;

public class TravelByBus implements TravelExpenses {
	
	private LocalDate outboundStartDate;
	private LocalDate inboundEndDate;
	private String busLines;
	private double totalCost;
	
	public TravelByBus(LocalDate osd, LocalDate ied, String b, double tc) {
		outboundStartDate = osd;
		inboundEndDate = ied;
		busLines = b;
		totalCost = tc;
	}
	@Override
	public String getDescription() {
		return busLines + " bus from " + outboundStartDate + " to " + inboundEndDate;
	}
	@Override
	public double amountToReimburse() {
		// TODO Auto-generated method stub
		return totalCost;
	}
	@Override
	public LocalDate getStartDate() {
		return outboundStartDate;
	}
	@Override
	public LocalDate getEndDate() {
		return inboundEndDate;
	}
	@Override
	public int sequenceNo() {
		return 3;
	}


}
