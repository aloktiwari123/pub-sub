package com.neustar.pub.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("v1/pubsub")
public class Controller {

    @Autowired
    Publisher.PubsubOutboundGateway pubsubOutboundGateway;

//    @Autowired
//    Subscriber subscriberService;
//
//
//    @GetMapping("/fetchMessage")
//    public ResponseEntity<?> getMessage() {
//
//        return new ResponseEntity(subscriberService.recievedMessages(), HttpStatus.OK);
//    }

    @GetMapping("/postMessage")
    public void postMessage(@RequestParam("message") String message) {
        pubsubOutboundGateway.sendToPubsub(message);
    }
}



