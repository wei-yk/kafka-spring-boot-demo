package com.wyk.kafkaspringbootdemo.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
public class Consumer {

    @KafkaListener(topics ="my-replication-topic01",groupId = "groupid")
    private void Consumer(ConsumerRecord<String,String> record, Acknowledgment ack){
       String value= record.value();
       System.out.println(value);
       System.out.println(record);
       //手动提交offset
       ack.acknowledge();
    }

}
