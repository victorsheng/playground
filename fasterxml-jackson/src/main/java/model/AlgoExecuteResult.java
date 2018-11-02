package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(alphabetic=true)
public class AlgoExecuteResult {

  private Object result;

  public Object getResult() {
    return result;
  }

  public void setResult(Object result) {
    this.result = result;
  }

}
