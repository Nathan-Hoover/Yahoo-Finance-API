import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        //getLatest(String symbol, int type) type:1=Open, type:2=High, type:3=Low, type:4=Close, type:5=Volume, type:6=Adj Close
        //getLatest(String symbol) Gets all the newest data
        System.out.println("Print data for today");
        HashMap<Integer, String[]> data =  YahooFinanceAPI.getLatest("AMD");

        String[] currentLine;
        for(int i = 0; i < data.size(); i++){
            currentLine = data.get(i);
            for(int j = 0; j < currentLine.length; j++){
                System.out.print(currentLine[j] + "\t|");
            }
            System.out.println();
        }
    }
}
