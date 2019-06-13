package homonorphic;

import java.math.BigInteger;

public class RsaModel {

  private BigInteger n;
  private BigInteger d;
  private BigInteger e;


  public RsaModel(BigInteger n, BigInteger d, BigInteger e) {
    this.n = n;
    this.d = d;
    this.e = e;
  }

  public BigInteger getN() {
    return n;
  }

  public void setN(BigInteger n) {
    this.n = n;
  }

  public BigInteger getD() {
    return d;
  }

  public void setD(BigInteger d) {
    this.d = d;
  }

  public BigInteger getE() {
    return e;
  }

  public void setE(BigInteger e) {
    this.e = e;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("homonorphic.RsaModel{");
    sb.append("n=").append(n);
    sb.append(", d=").append(d);
    sb.append(", e=").append(e);
    sb.append('}');
    return sb.toString();
  }
}
