import tech.tablesaw.api.Table;
import static tech.tablesaw.aggregate.AggregateFunctions.*;

public class MainClass {
    public static void main(String[] args) {
        try {
            Table titanicTable = Table.read().csv("src/main/resources/titanic.csv");
            Table dataSummary = titanicTable.summary();
            System.out.println(dataSummary);
            System.out.println("=======================================================================================================");
            System.out.println(titanicTable.summarize(titanicTable.columnNames(), mean).apply());
            System.out.println("=======================================================================================================");
            System.out.println(titanicTable.summarize(titanicTable.columnNames(), max).apply());
            System.out.println("=======================================================================================================");
            System.out.println(titanicTable.summarize(titanicTable.columnNames(), min).apply());
            System.out.println("=======================================================================================================");
            System.out.println(titanicTable.summarize(titanicTable.columnNames(), stdDev).apply());
        } catch (Exception ex) {
            System.out.println("File not found");
        }

    }
}
