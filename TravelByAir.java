package assignment05;
import java.time.*;

public class TravelByAir implements TravelExpenses {
	
	private LocalDate outboundStartDate;
	private LocalDate inboundEndDate;
	private String airlines;
	private double totalCost;
	
	public TravelByAir(LocalDate osd, LocalDate ied, String a, double tc) {
		outboundStartDate = osd;
		inboundEndDate = ied;
		airlines = a;
		totalCost = tc;
	}
	@Override
	public String getDescription() {
		return airlines + "flight from " + outboundStartDate + " to " + inboundEndDate;
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
		return 1;
	}


}
