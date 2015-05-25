import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.HashMap;

class Testing {
    public static void main(String[] args) {
        Calendar testDate = new GregorianCalendar(2015, 4, 1);

        System.out.println(testDate.get(Calendar.DAY_OF_MONTH) + "|" + testDate.get(Calendar.MONTH) + "|" + testDate.get(Calendar.YEAR));
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
        System.out.println(testDate.get(Calendar.DAY_OF_MONTH) + "|" + testDate.get(Calendar.MONTH) + "|" + testDate.get(Calendar.YEAR));
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

        //Testing bulk data during weekend
        testDate = new GregorianCalendar(2015, 4, 4);
        System.out.println(testDate.get(Calendar.DAY_OF_MONTH) + "|" + testDate.get(Calendar.MONTH) + "|" + testDate.get(Calendar.YEAR));
        String[] dailyStats = YahooFinanceAPI.getStats("AMD", testDate);
        for (String statValue : dailyStats) {
            System.out.print(statValue + " | ");
        }
        System.out.println();

        //Testing ranges
        Calendar fromDate = new GregorianCalendar(2014, 4, 4);
        Calendar toDate = new GregorianCalendar(2015, 5, 24);
        HashMap<Integer, String[]> rangeData = YahooFinanceAPI.getRange("INTL", fromDate, toDate, "m");
        String[] hashedString;
        for (int i = 0; i < rangeData.size(); i++) {
            hashedString = rangeData.get(i);
            for (String statValue : hashedString) {
                System.out.print(statValue + " | ");
            }
            System.out.println();
        }
    }
}


