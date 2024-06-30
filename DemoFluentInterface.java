import java.time.LocalDate;
import java.util.List;

record SalesOrderRecord(Long id, Long customerId, LocalDate orderDate, LocalDate shipDate, String status, List<Object> items)
{
    // Create fluent builder
    static SalesOrderBuilderStage1 builder()
    {
        return id -> customerId -> orderDate -> shipDate -> status -> items -> new SalesOrderRecord(id, customerId, orderDate, shipDate, status, items);
    }

    // The order of initialization is: id, customerId, orderDate, shipDate, status, items
    interface SalesOrderBuilderStage1 {
        SalesOrderBuilderStage2 id(Long id);
    }

    interface SalesOrderBuilderStage2 {
        SalesOrderBuilderStage3 customerId(Long customerId);
    }

    interface SalesOrderBuilderStage3 {
        SalesOrderBuilderStage4 orderDate(LocalDate orderDate);
    }

    interface SalesOrderBuilderStage4 {
        SalesOrderBuilderStage5 shipDate(LocalDate shipDate);
    }

    interface SalesOrderBuilderStage5 {
        SalesOrderBuilderStage6 status(String status);
    }

    interface SalesOrderBuilderStage6 {
        SalesOrderRecord items(List<Object> items);
    }
}

public class DemoFluentInterface
{
    public static void main(String[] args) {
        SalesOrderRecord salesOrder = SalesOrderRecord.builder()
            .id(1L)
            .customerId(2L)
            .orderDate(LocalDate.now())
            .shipDate(LocalDate.now().plusDays(1))
            .status("Pending")
            .items(List.of("Item 1", "Item 2"));

        System.out.println(salesOrder);
    }
}
