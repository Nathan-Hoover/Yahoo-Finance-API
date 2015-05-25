import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.HashMap;

public class YahooFinanceAPI {
    private static HashMap fromInterval(String symbol, Calendar fromDate, Calendar toDate, String frequency) {
        HashMap<Integer, String[]> data = new HashMap<>();
        boolean finished = false;

        while (!finished) {
            try {
                //s = symbol ^ a = from month ^ b = from day ^ c = from year ^ d = to month
                //e = to day ^ f = to year ^ g = d for day | m for month | y for yearly
                String urlString = "http://ichart.yahoo.com/table.csv?s=" + symbol
                        + "&a=" + Integer.toString(fromDate.get(Calendar.MONTH) - 1)
                        + "&b=" + Integer.toString(fromDate.get(Calendar.DAY_OF_MONTH))
                        + "&c=" + Integer.toString(fromDate.get(Calendar.YEAR))
                        + "&d=" + Integer.toString(toDate.get(Calendar.MONTH) - 1)
                        + "&e=" + Integer.toString(toDate.get(Calendar.DAY_OF_MONTH))
                        + "&f=" + Integer.toString(toDate.get(Calendar.YEAR))
                        + "&g=" + frequency;
                URL url = new URL(urlString);
                URLConnection urlConn = url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(urlConn.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                int i = 0;
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    data.put(i, line.split(","));
                    i++;
                }

                bufferedReader.close();
                inputStreamReader.close();
                finished = true;

            } catch (Exception e) {
                fromDate.add(Calendar.DAY_OF_YEAR, -1);
            }
        }


        return data;
	}

    public static HashMap fromDate(String symbol, String fromDay, String fromMonth, String fromYear){
        HashMap<Integer, String[]> data = new HashMap<>();

        try {
            //s = symbol ^ a = from month ^ b = from day ^ c = from year
            String urlString = "http://ichart.yahoo.com/table.csv?s=" + symbol
                    + "&a=" + fromMonth
                    + "&b=" + fromDay
                    + "&c=" + fromYear;
            System.out.println(urlString);
            URL url = new URL(urlString);
            URLConnection urlConn = url.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int i = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.put(i, line.split(","));
                i++;
            }

            bufferedReader.close();
            inputStreamReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private static String fromType(String symbol, Calendar targetDate, int type){
        HashMap<Integer, String[]> mapOfValues = fromInterval(symbol, targetDate, targetDate, "d");
        return mapOfValues.get(1)[type];
    }

    //Returns amended trading ammount after closing
    public static String getAdjClose(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 6);
    }

    //Returns the stock value at close
    public static String getClose(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 4);
    }

    /*//Returns current stock rate
    public static float getCurrent(String symbol){

    }*/

    //Returns highest stock value for that day
    public static String getHigh(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 2);
    }

    //Returns lowest stock value for that day
    public static String getLow(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 3);
    }

    //Returns value of stock at open
    public static String getOpen(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 1);
    }
/*
    //Returns Date,Open,High,Low,Close,Volume,Adj Close in HashMap format
    public static HashMap getRange(String symbol, Date fromDate, Date toDate){

    }*/

    //Returns Date,Open,High,Low,Close,Volume,Adj Close in String array format
    public static String[] getStats(String symbol, Calendar targetDate) {
        HashMap<Integer, String[]> mapOfValues = fromInterval(symbol, targetDate, targetDate, "d");
        return mapOfValues.get(1);
    }

    //Returns amount of shares that trade hands from sellers to buyers for that day
    public static String getVolume(String symbol, Calendar targetDate){
        return fromType(symbol, targetDate, 5);
    }
}