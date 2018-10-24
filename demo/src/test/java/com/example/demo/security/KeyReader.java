package com.example.demo.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.List;
import org.junit.Test;

public class KeyReader {

  @Test
  public void read() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

    String path = "/Users/victor/code/tdProjects/nginx_public_key.pem";
    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.US_ASCII);
    if (lines.size() < 2) {
      throw new IllegalArgumentException("Insufficient input");
    }
    if (!lines.remove(0).startsWith("--")) {
      throw new IllegalArgumentException("Expected header");
    }
    if (!lines.remove(lines.size() - 1).startsWith("--")) {
      throw new IllegalArgumentException("Expected footer");
    }
    byte[] raw = Base64.getDecoder().decode(String.join("", lines));
    KeyFactory factory = KeyFactory.getInstance("RSA");
    PublicKey pub = factory.generatePublic(new X509EncodedKeySpec(raw));
    System.out.println(pub);
  }


  public PublicKey read2() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {

    String path = "/Users/victor/code/vicProjects/demo/project-old/src/main/resources/rsa256.key.pub";
    List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.US_ASCII);
    if (lines.size() < 2) {
      throw new IllegalArgumentException("Insufficient input");
    }
    if (!lines.remove(0).startsWith("--")) {
      throw new IllegalArgumentException("Expected header");
    }
    if (!lines.remove(lines.size() - 1).startsWith("--")) {
      throw new IllegalArgumentException("Expected footer");
    }
    byte[] raw = Base64.getDecoder().decode(String.join("", lines));
    KeyFactory factory = KeyFactory.getInstance("RSA");
    PublicKey pub = factory.generatePublic(new X509EncodedKeySpec(raw));
    System.out.println(pub);
    return pub;

  }

}
