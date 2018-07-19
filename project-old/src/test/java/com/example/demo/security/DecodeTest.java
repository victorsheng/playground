package com.example.demo.security;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import org.junit.Test;

public class DecodeTest {

  @Test
  public void decode() throws Exception {
    String jwt = "eyJpc3MiOiJ0ZCIsImF1ZCI6Imh0dHA6Ly8xNzIuMjMuNy4wOjkzMDMvZGF0YXNldCIsImlhdCI6MTUzMTMwNTQ3NDQwNCwiZXhwIjoxNTMxMzA1NTM0NDA0LCJhbGciOiJSUzI1NiIsInN1YiI6Ii9kYXRhc2V0bWFuL3YxL25vQ2VydGlmaWVkTGlzdCIsImp0aSI6MTM4MDc3NjYyOH0.SlzsCg9wB4+dg1IEC4bjAtbr9S1S0ka/Fw93585/tkv9DD5N6xvve9IYOWadoac2X6x6J6DG9DjHuTAbBJAytPtSUwTRqA4FMlrqxfGkp3x1QTO0e9npsYqAW3ZbD9hbs9g/z0nnZ8hii+PFyx3e6VflhUkc3KzUQms9Ldp+qQhoicDaTftRUwU5PelQ5HjcpGvM0Tjd0GfUZCLKRca2RKLRs2NW7dPiWqzvT8rxk7cUdNy0WB5xPNfvEVecE9OX2uz0ElvmBjGOb92hCY4/+D/XE1hZ7EtWmj8ti3LEKD3tPpmPiAqlfB+5zIFFWXFfA+D8p7BwBLiJeRMg6eoKwjjsCCa4dnJwIeRZvZNALz3aPG+Mw772VshY/rw1jWifd9Eq51bamL0UD/KvZb9UXoU8qpLRfakluTDAFAXPHiUpaMU7WDzjScTSboAvATtY8/Y53CO/mPrVnvO8G/xKIj9jHSqT06psQ0R5YqgYYZgPhiTEpE6d9D49XmNLDJl65vzLK5jNnI814wLUUBtafkxkU7cFnppozWTgohgcLQIt/ao1n2z2mzh/zJWMsOw5ANSMca7RAfuOjTNSlvDNlrjVi/LpPh2r/R5iUjdYmcd5o+lZl9hnWTwkFxQTMdDgRwcgRKwR0Y9Rp6NN8mNqyRpQzOo+SDFqrxN+WV/60yE";
    String[] split = jwt.split("\\.");
    System.out.println(Arrays.toString(split));
    Decoder decoder = Base64.getDecoder();
    byte[] data = decoder.decode(split[0]);
    byte[] sign = decoder.decode(split[1]);
    String message = new String(data, StandardCharsets.UTF_8);
    System.out.println(message);

    KeyReader keyReader = new KeyReader();
    PublicKey publicKey = keyReader.read2();
    RsaCoder rsaCoder = new RsaCoder();
    rsaCoder.verify(data, publicKey.getEncoded(), sign);
//    rsaCoder.verify()
  }
}
