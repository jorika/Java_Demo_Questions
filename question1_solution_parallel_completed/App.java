import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                Transaction.transaction("a", -10,2.0),
                Transaction.transaction("a", 20, 1.0),
                Transaction.transaction("b", 5, 1.0),
                Transaction.transaction("b", 10, 1.0),
                Transaction.transaction("b", 10, 1.0)
        );
        System.out.println("popular is " + TransactionStatistics.mostPopularTicker(transactions));

        testNumberTransaction(1_000);
        testNumberTransaction(10_000);
        testNumberTransaction(100_000);
        testNumberTransaction(1_000_000);
        testNumberTransaction(10_000_000);
        testNumberTransaction(100_000_000);

    }

    private static void testNumberTransaction(int n) {

        // random tickers
        int number = 40;//(int)(Math.random()*10) + 30; // from 10 to 20 ticker;
        List<String> tickersList = new ArrayList<>();
        for (char t = 'A'; t < 'A'+number; t++) tickersList.add(t+"");

        int countTransactionPerTicker = n / number;

        List<Transaction> transactions = tickersList.stream()
                .map(ticker -> {
                    List<Transaction> sublist = new ArrayList<>(countTransactionPerTicker);
                    for (int i = 0; i < countTransactionPerTicker; i++) {
                        sublist.add(Transaction.transaction(ticker, (int)((Math.random() > 0.5 ? 1 : -1)*Math.random()*100+1), Math.random()*5));
                    }
                    return sublist;
                } ).flatMap(Collection::stream).collect(Collectors.toList());
        Instant start = Instant.now();
        System.out.println("popular is " + TransactionStatistics.mostPopularTicker(transactions));
        Instant end = Instant.now();
        System.out.println("duration: " + (end.toEpochMilli() - start.toEpochMilli()) + " (ms)");
    }
}
