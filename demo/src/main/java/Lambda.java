import java.util.stream.IntStream;

public class Lambda {

  public static void main(String[] args) {
    int x = 10;
    IntStream intStream = IntStream.of(1, 2, 3).map(i -> i * 2).map(i -> i * x);

  }

}
