import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //-------------------------------------------------------------------------------------------------------------
        //getLatest(String symbol, int type) type:1=Open, type:2=High, type:3=Low, type:4=Close, type:5=Volume, type:6=Adj Close
        //getLatest(String symbol) Gets all the newest data
        System.out.println("Print data for today");
        String[] data =  YahooFinanceAPI.getLatest("AMD");

        for(int i = 0; i < data.length; i++){
           System.out.print(data[i] + " | ");
        }
        System.out.println();

        System.out.println("Latest Close: " + YahooFinanceAPI.getLatest("AMD", 4));
        //-------------------------------------------------------------------------------------------------------------
        //getRange(String symbol, String fromDay, String fromMonth, String fromYear, String toDay, String toMonth, String toYear, String frequency, int type)
        //getRange(String symbol, String fromDay, String fromMonth, String fromYear, String toDay, String toMonth, String toYear, String frequency)
    }
}
