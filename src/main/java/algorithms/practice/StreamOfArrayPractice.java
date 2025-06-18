package algorithms.practice;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamOfArrayPractice {

    //init product Array
    public String[] initProductArray() {
        String[] products = {"tablet", "computer", "mouse", "charger"};
        return products;
    }

    public Stream<String> getProductStream() {
        String[] products = {"tablet", "computer", "mouse", "charger"};
        return Arrays.stream(products);
    }

    // Sorting
    public void sortProductAlphabetic() {
        String[] products = {"tablet", "computer", "charger", "mouse"};
        Stream<String> productStream = Arrays.stream(products);
        productStream.sorted().forEach(System.out::println);
    }

    public void sortProductByNameLength() {
        String[] products = {"tablet", "computer", "mouse", "charger"};
        Stream<String> productStream = Arrays.stream(products);
        productStream.sorted(
                        (p1, p2) -> Integer.compare(p1.length(), p2.length())
                )
                .forEach(System.out::println);
        ;
    }

    //Mapping
    public void mapProductToUppercase() {
        String[] products = {"tablet", "computer", "mouse", "charger", "computer"};
        Stream<String> productStream = Arrays.stream(products);
        Function<? super String, ? super String> function = str -> str.toUpperCase();
        productStream.map(function)
                .forEach(System.out::println);

    }

    //to Map
    public void toUppercaseMap() {
        String[] products = {"tablet", "computer", "mouse", "charger"};
        Stream<String> productStream = Arrays.stream(products);
        Map<String, String> productUpperCaseMap =
                productStream.collect(Collectors.toMap(
                        item -> item, item -> item.toUpperCase()
                ));
        System.out.println(productUpperCaseMap);
    }

    public void toSortedWordMap() {
        String[] products = {"tablet", "computer", "mouse", "charger"};
        Stream<String> productStream = Arrays.stream(products);
        Map<String, String> sortedWordMap =
                productStream.collect(Collectors.toMap(
                        item -> item, item -> {
                            char[] chars = item.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ));
        System.out.println(sortedWordMap);
    }

    public void sortWord() {
        String word = "word";
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        String sortedWord = new String(wordChars);
        System.out.println("original word: " + word);
        System.out.println("sorted word: " + sortedWord);
    }

    public void primitiveToStream() {
        int[] ints = {1, 3, 2, 4, 45};
        IntStream intStream = Arrays.stream(ints);

        long[] longs = {1l, 2l, 23};
        LongStream longStream = Arrays.stream(longs);
        longStream.map(longValue -> longValue + 1);

        char[] chars = {'a', 'b', 'd', 'c'};
//        IntStream charStream = String.valueOf(chars).chars();
//        charStream.forEach(System.out::println);

        IntStream charStreamAgain = String.valueOf(chars).chars();
        charStreamAgain.mapToObj(i -> Character.toUpperCase((char) i))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        StreamOfArrayPractice practice = new StreamOfArrayPractice();
        System.out.println("sort by alphabetically");
        practice.sortProductAlphabetic();

        System.out.println("sort by name length");
        practice.sortProductByNameLength();

        System.out.println("mapProductByFrequency()");
        practice.mapProductToUppercase();

        System.out.println("toMap()");
        practice.toUppercaseMap();

        practice.toSortedWordMap();
        practice.sortWord();

        practice.primitiveToStream();
    }
}
