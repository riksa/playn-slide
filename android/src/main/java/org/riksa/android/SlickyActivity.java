package org.riksa.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import org.riksa.core.Slicky;

public class SlickyActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new Slicky());
  }
}
