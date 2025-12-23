package net.javaguides.springboot_kafka_tutorial.controoler;

import net.javaguides.springboot_kafka_tutorial.payload.User;
import net.javaguides.springboot_kafka_tutorial.producer.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessage {


    private JsonKafkaProducer jsonKafkaProducer;


    public JsonMessage(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }
    @PostMapping("/publish")
    public ResponseEntity<String>publish(@RequestBody User user){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("json Message sent to kafka topic");

    }
}
