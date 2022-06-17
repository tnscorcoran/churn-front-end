package org.acme.rest.json;


public class Churn {
    private String url;
    Object jason;
  
  
   // Getter Methods 
  
    public String getUrl() {
      return url;
    }
  

    public Object getJason() {
        return this.jason;
    }

    public void setJason(Object jason) {
        this.jason = jason;
    }

  
   // Setter Methods 
  
    public void setUrl( String url ) {
      this.url = url;
    }
  

  }

