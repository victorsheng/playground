import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

public class NoCLassTest {

  @Test
  public void noclass() throws ClassNotFoundException {
    Class<?> aClass = Class.forName("www.qqq");
  }

  @Test
  public void noClass() {
    DispatcherServlet dispatcherServlet = new DispatcherServlet();
  }
}
