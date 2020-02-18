package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void should_print_customer_information_on_order() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>(),"2020年2月17日，星期一");
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceiptOld();


        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void should_print_line_item_and_sales_tax_information_need_delete_000000000000000() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems,"2020年2月17日，星期一"));

        String output = receipt.printReceiptOld();

        assertThat(output, containsString("Sales Tax\t6.5"));
        assertThat(output, containsString("Total Amount\t71.5"));
    }

    @Test
    public void should_print_new_head_information_not_on_Wednesday() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, "2020年2月17日，星期一"));

        String output = receipt.printReceipt();

        assertThat(output, containsString("===== 老王超市，值得信赖 ======\n\n"));
    }

    @Test
    public void should_print_date_information() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, "2020年2月17日，星期一"));

        String output = receipt.printReceipt();

        assertThat(output, containsString("2020年2月17日，星期一\n\n"));
    }

    @Test
    public void should_print_product_details_information() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("巧克力", 21.50, 2));
            add(new LineItem("小白菜", 10.00, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems, "2020年2月17日，星期一"));

        String output = receipt.printReceipt();

        assertThat(output, containsString("巧克力，21.50 x 2，43.00\n"));
        assertThat(output, containsString("小白菜，10.00 x 1，10.00\n"));
        assertThat(output, containsString("----------------------------\n"));
    }
}
