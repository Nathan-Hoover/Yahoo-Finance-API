# Yahoo-Finance-API
An easy to use API for stock data from Yahoo Finance

//Returns amended trading ammount after closing
float getAdjClose(String symbol, Date targetDate, int type)

//Returns the stock value at close
float getClose(String symbol, Date targetDate, int type)

//Returns current stock rate
float getCurrent(String symbol)

//Returns highest stock value for that day
float getHigh(String symbol, Date targetDate, int type)

//Returns lowest stock value for that day
float getLow(String symbol, Date targetDate, int type)

//Returns value of stock at open
float getOpen(String symbol, Date targetDate)

//Returns Date,Open,High,Low,Close,Volume,Adj Close in HashMap format
HashMap getRange(String symbol, Date fromDate, Date toDate)

//Returns Date,Open,High,Low,Close,Volume,Adj Close in String array format
String[] getStats(String symbol, Date targetDate)

//Returns amount of shares that trade hands from sellers to buyers for that day
float getVolume(String symbol, Date targetDate, int type)
