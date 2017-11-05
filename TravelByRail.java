package assignment05;
import java.time.*;

public class TravelByRail implements TravelExpenses {

	private LocalDate outboundStartDate;
	private LocalDate inboundEndDate;
	private String railLines;
	private double totalCost;

	public TravelByRail(LocalDate osd, LocalDate ied, String r, double tc) {
		outboundStartDate = osd;
		inboundEndDate = ied;
		railLines = r;
		totalCost = tc;
	}
	@Override
	public String getDescription() {
		return railLines + " trains from " + outboundStartDate + " to " + inboundEndDate;
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
		return 2;
	}


}
