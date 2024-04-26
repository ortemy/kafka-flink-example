package kafka.generator;


import kafka.generator.domain.Order;
import kafka.generator.domain.OrderGenerator;
import kafka.generator.properties.AppProperties;
import kafka.generator.serializer.Mapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import static kafka.generator.properties.Constants.*;


/*
Simulating an e-commerce application that publishes every processed order to Kafka
 */
public final class Producer {

    static Logger logger = LoggerFactory.getLogger(Producer.class.getName());

    public static void main(String[] args) {
         //setup
         Properties properties = AppProperties.setup();

        // create a producer
        KafkaProducer<String, Order> producer = new KafkaProducer<>(properties);

        // keep running until terminated
        for (;;) {
            //generate random e-commerce order and key for the purpose of demonstration
            Order order =  OrderGenerator.generateOrder();
            String key = jsonKey();

            //publish to kafka the order
            producer.send(new ProducerRecord(TOPIC_NAME, key, Mapper.jsonNode(order)));

            logger.info("Message sent: Key:" + key+", value: "+order.jsonRepresentation());

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                producer.close();
            }
        }

    }

    //generate a key as a valid JSON string
    private static String jsonKey(){
        return "\""+UUID.randomUUID().toString()+"\"";
    }



}