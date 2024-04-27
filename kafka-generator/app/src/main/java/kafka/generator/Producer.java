package kafka.generator;


import kafka.generator.domain.Order;
import kafka.generator.domain.OrderGenerator;
import kafka.generator.domain.Utils;
import kafka.generator.properties.AppProperties;
import kafka.generator.serializer.Mapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import static kafka.generator.properties.AppProperties.TOPIC_NAME;


/*
Simulating an e-commerce application that publishes every processed order to Kafka
 */
public final class Producer {

    static Logger logger = LoggerFactory.getLogger(Producer.class.getName());

    public static void main(String[] args) {
         //setup
         Properties properties = AppProperties.setup();
         Utils utils = new Utils();
        // create a producer
        KafkaProducer<String, Order> producer = new KafkaProducer<>(properties);

        // keep running until terminated
        for (;;) {
            //generate random e-commerce order and key for the purpose of demonstration
            Order order =  OrderGenerator.generateOrder();
            String key = utils.jsonUUID();

            //publish to kafka the order
            producer.send(new ProducerRecord(TOPIC_NAME, key, Mapper.jsonNode(order)));

            logger.info("Message sent: Key:" + key+", value: "+utils.jsonRepresentation(order));

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                producer.close();
            }
        }

    }
}