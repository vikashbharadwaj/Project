package net.javaguides.springboot_kafka_tutorial.controoler;

import net.javaguides.springboot_kafka_tutorial.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageControoler {


    private KafkaProducer kafkaProducer;

    public MessageControoler(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
   // http://localhost:8080/api/v1/kafka/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String>publish(@RequestParam("message")String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to the topic");
    }
}