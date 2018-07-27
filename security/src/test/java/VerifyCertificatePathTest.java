import java.io.FileInputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class VerifyCertificatePathTest {

  //PKCS7 PkiPath
  public static void main(String[] args) throws Exception {

    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    CertPath pkcs7 = cf
        .generateCertPath(new FileInputStream("/Users/victor/tmp/*.google.com.hk.cer"), "PkiPath");
    List<? extends Certificate> certificates = pkcs7.getCertificates();
    for (Certificate certificate : certificates) {
      System.out.println(certificate);
    }
  }


  public static void main2(String args[]) throws Exception {
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    List mylist = new ArrayList();
    for (int i = 0; i < args.length; i++) {
      FileInputStream in = new FileInputStream(args[i]);
      Certificate c = cf.generateCertificate(in);
      mylist.add(c);
    }
    CertPath cp = cf.generateCertPath(mylist);
    List cplist = cp.getCertificates();
    Object[] o = cplist.toArray();
    for (int i = 0; i < o.length; i++) {
      X509Certificate c = (X509Certificate) o[i];
      System.out.println(c.getSubjectDN());
      byte[] pbk = c.getPublicKey().getEncoded();
      for (int j = 0; j < pbk.length; j++) {
        System.out.print(pbk[j] + ",");
      }
      System.out.println("\nIssued by " + c.getIssuerDN());
    }
  }
}
