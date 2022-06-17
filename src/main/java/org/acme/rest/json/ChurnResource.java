package org.acme.rest.json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.cxf.jaxrs.client.WebClient;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

@Path("/churn")
public class ChurnResource {
    ChurnPrediction results;
    private List <Object> providers;

    private Set<ChurnPrediction> predictions = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    public ChurnResource() {
     results = new ChurnPrediction("", "");
    }

    @GET
    public Set<ChurnPrediction> list() {

        return predictions;
    }


    private ChurnPrediction postChurn(String url, String json) {

        providers = new ArrayList<Object>();
        providers.add(new JacksonJsonProvider());

    	WebClient client = WebClient.create(url, providers);
    	client = client.accept("application/json").type("application/json");
        Response r = client.post(json);

        Map map = r.readEntity(HashMap.class);
        Map jsonData = (Map) map.get("jsonData");

        String prediction = (String)jsonData.get("Predicted Class");
        String certainty = (String)jsonData.get("Predicted Certainty Score");
        
        return new ChurnPrediction(prediction, certainty);
    }


    
    @POST
    public Set<ChurnPrediction> add(Churn churn ) {
 
        predictions = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
        ChurnPrediction churnPrediction = postChurn(churn.getUrl(), churn.getJason().toString());
        predictions.add(churnPrediction);

        return predictions;
    }


}
