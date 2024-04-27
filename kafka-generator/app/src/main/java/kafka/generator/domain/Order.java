package kafka.generator.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Order {

    @Getter @Setter
    private String order_timestamp;

    @Getter @Setter
    private String amount;

    @Getter @Setter
    private String country;

    @Getter @Setter
    private String description;



}
