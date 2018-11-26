import com.lmax.disruptor.EventFactory;
public class ValueEvent {
  private String value;
  private long seq;
  public long getSeq() {
    return seq;
  }
  public void setSeq(long seq) {
    this.seq = seq;
  }
  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public final static EventFactory<ValueEvent> EVENT_FACTORY=new EventFactory<ValueEvent>(){
    public ValueEvent newInstance(){
      return new ValueEvent();
    }
  };
}