import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DisruptorExample {

  private static RingBuffer<ValueEvent> ringBuffer;

  public static void main(String[] args) {
    init();
    testStart();
  }

  /**
   * 初始化Disruptor
   */
  @SuppressWarnings("unchecked")
  public static void init() {
    ExecutorService exec = Executors.newCachedThreadPool();
    // preallocate RingBuffer with 1024 ValueEvents
    Disruptor<ValueEvent> disruptor = new Disruptor<ValueEvent>(
        ValueEvent.EVENT_FACTORY, 1024, exec);
    final EventHandler<ValueEvent> handler = new EventHandler<ValueEvent>() {
      // event will eventually be recycled by the Disruptor after it wraps
      public void onEvent(final ValueEvent event, final long sequence,
          final boolean endOfBatch) {
        //消费数据
        handlerWrite(event);

        if (endOfBatch) {
          System.out.println("endOfBatch");
        }
      }
    };
    // Build dependency graph
    disruptor.handleEventsWith(handler);
    ringBuffer = disruptor.start();
  }

  /**
   * 测试方法入口
   */
  public static void testStart() {
    for (long i = 1; i < 2000; i++) {
      String uuid = UUID.randomUUID().toString();
      ValueEvent valueEvent = new ValueEvent();
      valueEvent.setValue(uuid);
      write(uuid);
    }
  }

  /**
   * 写入数据
   */
  public static void write(String value) {
    long seq = ringBuffer.next();
    ValueEvent valueEvent = ringBuffer.get(seq);
    valueEvent.setValue(value);
    valueEvent.setSeq(seq);
    ringBuffer.publish(seq);
  }

  /**
   * 写入到数据库或者磁盘上，目前从控制台输出
   */
  public static void handlerWrite(ValueEvent valueEvent) {
    System.out.println("Sequenece:" + valueEvent.getSeq());
    System.out.println("ValueEvent:" + valueEvent.getValue());
  }

}