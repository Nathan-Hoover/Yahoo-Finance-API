import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        //-------------------------------------------------------------------------------------------------------------
        //getLatest(String symbol, int type) type:1=Open, type:2=High, type:3=Low, type:4=Close, type:5=Volume, type:6=Adj Close
        //getLatest(String symbol) Gets all the newest data
       /* System.out.println("Print data for today");
        String[] data =  YahooFinanceAPI.getLatest("AMD");

        for(int i = 0; i < data.length; i++){
           System.out.print(data[i] + " | ");
        }
        System.out.println();

        System.out.println("Latest Close: " + YahooFinanceAPI.getLatest("AMD", 4));*/
        //-------------------------------------------------------------------------------------------------------------
        //getRange(String symbol, String fromDay, String fromMonth, String fromYear, String toDay, String toMonth, String toYear, String frequency, int type)
        //getRange(String symbol, String fromDay, String fromMonth, String fromYear, String toDay, String toMonth, String toYear, String frequency)

        //Testing Getting individual daily stats of a stock
        Calendar testDate = new GregorianCalendar(2015, 4, 1);

        System.out.print(testDate.get(Calendar.DAY_OF_MONTH) +"|"+testDate.get(Calendar.MONTH)+"|"+testDate.get(Calendar.YEAR));
        String adjClose = YahooFinanceAPI.getAdjClose("AMD", testDate);
        System.out.println("Adjusted Close of AMD: " + adjClose);
        String volume = YahooFinanceAPI.getVolume("AMD", testDate);
        System.out.println("Volume of AMD: " + volume);
        String close = YahooFinanceAPI.getClose("AMD", testDate);
        System.out.println("Close of AMD: " + close);
        String low = YahooFinanceAPI.getLow("AMD", testDate);
        System.out.println("Low of AMD: " + low);
        String high = YahooFinanceAPI.getHigh("AMD", testDate);
        System.out.println("High of AMD: " + high);
        String open = YahooFinanceAPI.getOpen("AMD", testDate);
        System.out.println("Open of AMD: " + open);

        //Testing Weekend (Stock market Closed)
        testDate = new GregorianCalendar(2015, 4, 3);
        System.out.print(testDate.get(Calendar.DAY_OF_MONTH) +"|");
        System.out.print(testDate.get(Calendar.MONTH)+"|");
        System.out.println(testDate.get(Calendar.YEAR));
        adjClose = YahooFinanceAPI.getAdjClose("AMD", testDate);
        System.out.println("Adjusted Close of AMD: " + adjClose);
        volume = YahooFinanceAPI.getVolume("AMD", testDate);
        System.out.println("Volume of AMD: " + volume);
        close = YahooFinanceAPI.getClose("AMD", testDate);
        System.out.println("Close of AMD: " + close);
        low = YahooFinanceAPI.getLow("AMD", testDate);
        System.out.println("Low of AMD: " + low);
        high = YahooFinanceAPI.getHigh("AMD", testDate);
        System.out.println("High of AMD: " + high);
        open = YahooFinanceAPI.getOpen("AMD", testDate);
        System.out.println("Open of AMD: " + open);

     ///
     testDate = new GregorianCalendar(2015, 4, 4);

     System.out.print(testDate.get(Calendar.DAY_OF_MONTH) +"|");
     System.out.print(testDate.get(Calendar.MONTH)+"|");
     System.out.println(testDate.get(Calendar.YEAR));
      adjClose = YahooFinanceAPI.getAdjClose("AMD", testDate);
     System.out.println("Adjusted Close of AMD: " + adjClose);

      volume = YahooFinanceAPI.getVolume("AMD", testDate);
     System.out.println("Volume of AMD: " + volume);

      close = YahooFinanceAPI.getClose("AMD", testDate);
     System.out.println("Close of AMD: " + close);

      low = YahooFinanceAPI.getLow("AMD", testDate);
     System.out.println("Low of AMD: " + low);

      high = YahooFinanceAPI.getHigh("AMD", testDate);
     System.out.println("High of AMD: " + high);

      open = YahooFinanceAPI.getOpen("AMD", testDate);
     System.out.println("Open of AMD: " + open);

    }
}


