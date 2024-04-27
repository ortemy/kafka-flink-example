package kafka.generator.properties;

import kafka.generator.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;


public class AppProperties {

    public static final String  TRUSTSTORE_PASSWORD = "Password123";
    public static final String  KEYSTORE_PASSWORD = "Password123";
    public static final String  KEY_PASSWORD = "Password123";
    public static final String  TOPIC_NAME  = "orders";
    //OVERRIDE THESE VALUES FOR YOUR ENV
    public static Properties setup(){
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty("bootstrap.servers", "kafka-2f088c05-artem-ea11.h.aivencloud.com:23351");
        properties.setProperty("security.protocol", "SSL");
        properties.setProperty("ssl.truststore.location", "/Users/ortemy/Dev/certs/client.truststore.jks");
        properties.setProperty("ssl.truststore.password", TRUSTSTORE_PASSWORD);
        properties.setProperty("ssl.keystore.type", "PKCS12");
        properties.setProperty("ssl.keystore.location", "/Users/ortemy/Dev/certs/client.keystore.p12");
        properties.setProperty("ssl.keystore.password", KEYSTORE_PASSWORD);
        properties.setProperty("ssl.key.password", KEY_PASSWORD);
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", JsonSerializer.class.getName());
        return properties;
    }
}
