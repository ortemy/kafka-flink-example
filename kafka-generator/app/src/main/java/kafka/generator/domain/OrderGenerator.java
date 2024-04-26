package kafka.generator.domain;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class OrderGenerator {

    private static String[] countries = new String[]
            {"Canada", "US"};
    private static String [] item_descriptions = new String[]
            {"hockey stick","car tire","belt","t-shirt", "hammer","baseball cap", "soccer ball","mountain bike"};
    private static String[] prices = new String[]
            {"78.34", "234.23", "34.1", "42.2", "22.23", "13.23", "23.33", "345.23"};


    public static Order generateOrder(){
        Order order = new Order();
        Random random = new Random();

        //set US as a country of order origin 2 times out of 3 and Canada 1 times out of 3
        int rand_int1 = random.nextInt(3);
        if (rand_int1==0){
            order.setCountry(countries[0]);
        }
        else {
            order.setCountry(countries[1]);
        }

        //randomly pick order item & price out of 8 different options
        int rand_int2=random.nextInt(8);
        order.setDescription(item_descriptions[rand_int2]);
        order.setAmount(prices[rand_int2]);

        //set the time to now
        order.setOrder_timestamp(ZonedDateTime.now( ZoneOffset.UTC ).format( DateTimeFormatter.ISO_INSTANT ));

        return order;
    }

}
