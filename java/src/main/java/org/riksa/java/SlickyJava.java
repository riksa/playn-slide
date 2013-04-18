package org.riksa.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import org.riksa.core.Slicky;

public class SlickyJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new Slicky());
  }
}
