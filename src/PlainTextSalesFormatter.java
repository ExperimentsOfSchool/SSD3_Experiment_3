import java.util.Iterator;

/**
 * Created by Lawrence on 15/10/26.
 */
public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance;
    private PlainTextSalesFormatter() {}
    public static PlainTextSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PlainTextSalesFormatter();
        }
        return singletonInstance;
    }

    private String generateOrderList(Order order) {
        String output = "";
        Iterator<OrderItem> iterator = order.iterator();
        while(iterator.hasNext()) {
            output += iterator.next().toString() + "\n";
        }
        output += "Total = " + order.getTotalCost() + "\n";
        return output;
    }
    @Override
    public String formatSales(Sales sales) {
        String output = "";
        Iterator<Order> iterator = sales.iterator();
        while (iterator.hasNext()) {
            output += "------------------------\n";
            output += generateOrderList(iterator.next());
        }
        return output;
    }
}
