package main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.Map;
import model.AlgoExecuteResult;

public class Writer {


  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
    AlgoExecuteResult algoExecuteResult = new AlgoExecuteResult();
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    map.put("3", "1");
    map.put("2", "1");
    map.put("1", "1");
    map.put("a", "1");
    map.put("b", "1");
    map.put("c", "1");
    algoExecuteResult.setResult(map);
    String value = objectMapper.writeValueAsString(algoExecuteResult);
    System.out.println(value);
  }

}
