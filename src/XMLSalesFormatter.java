import java.util.Iterator;

/**
 * Created by Lawrence on 15/10/26.
 */
public class XMLSalesFormatter implements SalesFormatter{
    private static XMLSalesFormatter singletonInstance;
    private XMLSalesFormatter() {}
    public static XMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new XMLSalesFormatter();
        }
        return singletonInstance;
    }
    private String generateOrderList(Order order) {
        String output = "<Order total=\"";
        output += order.getTotalCost() + "\">\n";
        Iterator<OrderItem> iterator = order.iterator();
        while (iterator.hasNext()) {
            OrderItem orderItem = iterator.next();
            String itemInfo = "<OrderItem quantity=\"" +
                                orderItem.getQuantity() +
                                "\"price=\"" +
                                orderItem.getProduct().getPrice() +
                                "\">" + orderItem.getProduct().getCode() +
                                "</OrderItem>\n";
            output += itemInfo;
        }
        output += "</Order>\n";
        return output;
    }
    @Override
    public String formatSales(Sales sales) {
        String output = "<Sales>\n";
        Iterator<Order> iterator = sales.iterator();
        while (iterator.hasNext()) {
            output += generateOrderList(iterator.next());
        }
        output += "</Sales>\n";
        return output;
    }
}
