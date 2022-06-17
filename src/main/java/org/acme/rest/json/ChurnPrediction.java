package org.acme.rest.json;


public class ChurnPrediction {
  private String prediction;
  private String certainty;
 
  public ChurnPrediction(String prediction, String certainty) {
    this.prediction = prediction;
    this.certainty = certainty;
  }
  


  public String getPrediction() {
    return this.prediction;
  }

  public void setPrediction(String prediction) {
    this.prediction = prediction;
  }

  public String getCertainty() {
    return this.certainty;
  }

  public void setCertainty(String certainty) {
    this.certainty = certainty;
  }

}  