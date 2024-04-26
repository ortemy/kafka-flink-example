package kafka.generator.domain;

import org.json.JSONObject;

import java.util.UUID;

public class Utils {
    public String jsonRepresentation(Order ord){
        JSONObject order = new JSONObject();
        order.put("order_timestamp",ord.getOrder_timestamp());
        order.put("amount",ord.getAmount());
        order.put("country",ord.getCountry());
        order.put("description",ord.getDescription());
        return order.toString() ;
    }


    //generate a key as a valid JSON string
    public String jsonUUID(){
        return "\""+ UUID.randomUUID().toString()+"\"";
    }

}
