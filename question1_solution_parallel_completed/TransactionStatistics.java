import java.util.*;
import java.util.stream.Collectors;

/**
 * Please implement the {@link #mostPopularTicker(List)} method. With a sequential and a parallel algorithm.
 * DO NOT modify the existing code.
 */
public final class TransactionStatistics {

   /**
    * Return the most popular ticker in terms of transaction total absolute value (i.e. abs(price * quantity)). For example,
    * let's say we have these transactions:
    * <ul>
    *     <li>transaction("a", -10, 2.0)</li>
    *     <li>transaction("a", 20, 1.0)</li>
    *     <li>transaction("b", 5, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    *     <li>transaction("b", 10, 1.0)</li>
    * </ul>
    * The most popular one ticker is "a" with a traded value of 40 compared to b that only has 25.
    *
    * @param transactions List containing all transactions we want to look at
    * @return the most popular ticker
    */
   public static String mostPopularTicker(List<Transaction> transactions) {
      final Map<String, List<Transaction>> byTicker = transactions.stream().collect(Collectors.groupingBy(Transaction::getTicker));
      return byTicker
              .keySet()
              .stream()
              .parallel().unordered()
              .map( (key) -> Map.entry(key, byTicker.get(key).stream().parallel().unordered().mapToDouble(t -> Math.abs(t.getQuantity() * t.getPrice())).sum()))
              .max( Comparator.comparingDouble(Map.Entry::getValue)).orElseThrow().getKey();
   }

   private TransactionStatistics()  {}
}
