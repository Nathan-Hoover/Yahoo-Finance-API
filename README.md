# Yahoo-Finance-API by Nathaniel Hoover
An easy to use API for stock data from Yahoo Finance

//Returns amended trading amount after closing
String getAdjClose(String symbol, Calendar targetDate)

//Returns the stock value at close
String getClose(String symbol, Calendar targetDate)

//Returns current stock rate
float getCurrent(String symbol)

//Returns highest stock value for that day
String getHigh(String symbol, Calendar targetDate)

//Returns lowest stock value for that day
String getLow(String symbol, Calendar targetDate)

//Returns value of stock at open
String getOpen(String symbol, Calendar targetDate)

//Returns Date,Open,High,Low,Close,Volume,Adj Close in HashMap format
HashMap getRange(String symbol, Date fromDate, Date toDate)

//Returns Date,Open,High,Low,Close,Volume,Adj Close in String array format
String[] getStats(String symbol, Calendar targetDate)

//Returns amount of shares that trade hands from sellers to buyers for that day
String getVolume(String symbol, Calendar targetDate)
