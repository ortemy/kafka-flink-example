package kafka.generator.serializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static  JsonNode jsonNode( Object toMap){
        return objectMapper.valueToTree(toMap);
    }
}
