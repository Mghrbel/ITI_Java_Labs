import joinery.DataFrame;

public class MAinClass {
    public static void main(String[] args){
        try {
            DataFrame<Object> df = DataFrame.readCsv("src/main/resources/titanic.csv");
            System.out.println(df.describe());
            System.out.println("===================================================");
            System.out.println("Mean Calculations : \n" + df.mean());
            System.out.println("===================================================");
            System.out.println("Max Calculations : \n" + df.max());
            System.out.println("===================================================");
            System.out.println("Min Calculations : \n" + df.min());
            System.out.println("===================================================");
            System.out.println("Standard deviation Calculations : \n" + df.stddev());
        }catch (Exception ex){
            System.out.println("File not found");
        }
    }
}
