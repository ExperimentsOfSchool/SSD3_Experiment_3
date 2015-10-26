import java.util.Iterator;

/**
 * Created by Lawrence on 15/10/26.
 */
public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance;
    private HTMLSalesFormatter() {
        singletonInstance = new HTMLSalesFormatter();
    }
    public static HTMLSalesFormatter getSingletonInstance() {
        return singletonInstance;
    }
    private String generateOrderList(Order order) {
        String output = "<hr />\n";
        output += "<h4>Total = " + order.getTotalCost() + "</h4>\n";
        Iterator<OrderItem> iterator = order.iterator();
        while (iterator.hasNext()) {
            OrderItem orderItem = iterator.next();
            String itemInfo = "<p>\n";
            itemInfo += "<b>code:</b> " + orderItem.getProduct().getCode() + "<br />\n"
                        + "<b>quantity:</b> " + orderItem.getQuantity() + "<br />\n"
                        + "<b>price<\b> " + orderItem.getValue() + "<br />\n";
            itemInfo += "</p>\n";
            output += itemInfo;
        }
        return output;
    }
    @Override
    public String formatSales(Sales sales) {
        String output = "<html>\n" +
                "<body>\n" +
                "<center><h2>Orders</h2></center>\n";
        Iterator<Order> iterator = sales.iterator();
        while (iterator.hasNext()) {
            output += generateOrderList(iterator.next());
        }
        output += "</body>\n" + "</html>\n";
        return output;
    }
}
