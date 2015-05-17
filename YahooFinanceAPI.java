import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class YahooFinanceAPI {
	public static HashMap getData(String symbol, String fromDay, String fromMonth, String fromYear, String toDay, String toMonth, String toYear, String frequency){
        HashMap<Integer, String[]> data = new HashMap<Integer, String[]>();
		try {
			//s = symbol ^ a = from month ^ b = from day ^ c = from year ^ d = to month
			//e = to day ^ f = to year ^ g = d for day | m for month | y for yearly
            System.out.println("From " + fromYear + "-" + fromMonth + "-" + fromDay + " To " + toYear + "-" + toMonth + "-" + toDay);
            String urlString = "http://ichart.yahoo.com/table.csv?s=" + symbol
                    + "&a=" + fromMonth
                    + "&b=" + fromDay
                    + "&c=" + fromYear
                    + "&d=" + toMonth
                    + "&e=" + toDay
                    + "&f=" + toYear
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

		} catch (Exception e) {
	    	e.printStackTrace();
		}

        return data;
	}

    public static void getLatest(String symbol, int type){

    }

    public static HashMap getLatest(String symbol){
        DateFormat currentMonthFormat = new SimpleDateFormat("MM");
        DateFormat currentYearFormat = new SimpleDateFormat("yyyy");
        DateFormat currentDayFormat = new SimpleDateFormat("dd");

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, -2);

        Date currentDate = cal.getTime();

        String currentDay = currentDayFormat.format(currentDate);
        String currentMonth = currentMonthFormat.format(currentDate);
        String currentYear = currentYearFormat.format(currentDate);

        cal.add(Calendar.DATE, -1);

        currentDate = cal.getTime();

        String yestDay = currentDayFormat.format(currentDate);
        String yestMonth = currentMonthFormat.format(currentDate);
        String yestYear = currentYearFormat.format(currentDate);

        System.out.println("From " + yestYear + "-" + yestMonth + "-" + yestDay + " To " + currentYear + "-" + currentMonth + "-" + currentDay);
        return getData(symbol, yestDay, yestMonth, yestYear, currentDay, currentMonth, currentYear, "d");
    }
}