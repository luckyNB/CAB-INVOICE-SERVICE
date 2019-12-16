import com.InvoiceService;
import com.InvoiceSummary;
import com.Ride;
import com.RideCategory;
import org.junit.Assert;
import org.junit.Test;

public class InVoiceServiceTest {
    InvoiceService invoiceService = new InvoiceService();


    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {

        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(0.1, 1),
                new Ride(2.0, 5)};
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String userId="abc.com";
        Ride[] rides = {new Ride(0.1, 1),
                new Ride(2.0, 5)};
        Ride[] rides1 = {new Ride(0.1, 1),
                new Ride(2.0, 5)};
        invoiceService.addRide(userId,rides);
        InvoiceSummary summary = invoiceService.getInvoiceServide(userId, RideCategory.PREMIUMRIDE);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }


}
