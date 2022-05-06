package com.wyk.kafkaspringbootdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    private  KafkaTemplate<String,String> kafkaTemplate;



    @RequestMapping("/send/{message}")
    public String send(@PathVariable String message)throws InterruptedException, ExecutionException{

        ListenableFuture<SendResult<String, String>> key = kafkaTemplate.send("my-replication-topic01", 0, "key", message);

        System.out.println("生产者"+key);

        return "成功";
    }
}
