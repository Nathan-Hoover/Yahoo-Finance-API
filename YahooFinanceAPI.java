import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

class YahooFinanceAPI {
	public static void main(String[] args) {
		//getInfo("^GSPC");
		getInfo("AMD");
	}
	
	public static void getInfo(String symbol){
		try {
			//s = symbol ^ a = from month ^ b = from day ^ c = from year ^ d = to month
			//e = to day ^ f = to year ^ g = d for day | m for month | y for yearly
			String urlString = "http://ichart.yahoo.com/table.csv?s=" + symbol + "&a=1&b=1&c=2015&d=5&e=16&f=2015&g=m";
		    URL url = new URL(urlString);
		    URLConnection urlConn = url.openConnection();
		    InputStreamReader inputStreamReader = new InputStreamReader(urlConn.getInputStream());
		    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			Hashtable<Integer, String[]> data = new Hashtable<Integer, String[]>();
			
			int i = 0;
		    String line;
		    while ((line = bufferedReader.readLine()) != null) {
				data.put(i, line.split(","));
		        //System.out.println(line);
				i++;
		    }
		
			String[] currentData;
			for(int j =0; j <= i; j++){
				currentData = data.get(j);
				//for(int k = 0; k < currentData.length; k++){
					System.out.println(currentData[3]);
				//}
			}
			
		    bufferedReader.close();
			inputStreamReader.close();	
		} catch (Exception e) {
	    	e.printStackTrace();
		}
	}
}