import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSDynamic {

  public static ScriptEngine initEngine() {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    return engine;
  }

  /**
   * read file
   */
  private static FileReader getScriptFile() throws FileNotFoundException {
    Path file = Paths.get("js-runner/scripts", "util.js").toAbsolutePath();
    return new FileReader(file.toFile());
  }

  /**
   * engine load js file
   */
  private static void exeFile(FileReader fr, ScriptEngine engine) {
    try {
      engine.eval(fr);
    } catch (ScriptException e) {
      e.printStackTrace();
    }
  }

  public static void invokeFunByJavaObject(Object price)
      throws FileNotFoundException, NoSuchMethodException, ScriptException {
    ScriptEngine engine = initEngine();
    exeFile(getScriptFile(), engine);
    Invocable invocable = (Invocable) engine;

    Object result = invocable.invokeFunction("priceTransfer", price);
    System.out.println(result);
    System.out.println(result.getClass());
  }

  public static void invokeFunByJavaObject1(Object obj)
      throws FileNotFoundException, NoSuchMethodException, ScriptException {
    ScriptEngine engine = initEngine();
    exeFile(getScriptFile(), engine);
    Invocable invocable = (Invocable) engine;
    System.out.println(System.identityHashCode(obj));
    Object result = invocable.invokeFunction("fun2", obj);
    System.out.println(System.identityHashCode(result));
    System.out.println(result.getClass());
    System.out.println(result.hashCode());
  }

  public static void main(String[] args) throws Exception {
    invokeFunByJavaObject("762");
    HashMap<Object, Object> param = new HashMap<>();
    param.put("1", "1");
    param.put("2", "2");
    invokeFunByJavaObject1(param);
  }

}
