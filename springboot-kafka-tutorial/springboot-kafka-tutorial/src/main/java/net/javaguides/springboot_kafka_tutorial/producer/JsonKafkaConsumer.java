package net.javaguides.springboot_kafka_tutorial.producer;

import net.javaguides.springboot_kafka_tutorial.payload.User;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger logger= LoggerFactory.getLogger(JsonKafkaConsumer.class);



    @KafkaListener(topics = "$(spring.kafka.topic-json.name)",groupId = "myGroup")
    public void consume(User user){
        logger.info(String.format("json msg recived -> %s",user.toString()));

    }
}
