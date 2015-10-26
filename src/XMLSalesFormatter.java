import java.util.Iterator;

/**
 * Created by Lawrence on 15/10/26.
 */
public class XMLSalesFormatter {
    private static XMLSalesFormatter singletonInstance;
    private XMLSalesFormatter() {
        singletonInstance = new XMLSalesFormatter();
    }
    public XMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        Iterator<Order> iterator = sales.iterator();
        
    }
}
