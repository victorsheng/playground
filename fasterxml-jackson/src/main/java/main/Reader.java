package main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Reader {

  public static void main(String[] args) throws IOException {
    String data = "{\"type\":2,\"range\":1,\"start\":1368417600,\"end\":1368547140,"
        + "\"cityName\":\"天津\",\"companyIds\":[\"12000001\"],\"companyNames\":[\"天津\"],"
        + "\"12000001\":{\"data\":[47947,48328,48573,48520],"
        + "\"atimestamps\":[1368417600,1368417900,1368418200,1368418500]}}";

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
    JsonNode jsonNode = objectMapper.readTree(data);
    System.out.println(jsonNode.toString());
  }

}
