package com.sonam.mas.IOTdevice.controller;

import com.sonam.mas.IOTdevice.model.IotDevice;
import com.sonam.mas.IOTdevice.producer.IotProducerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This rest controller is used to publish any IotDevice data to kafka
 */
@RestController
@RequestMapping(value = "iotdevice")
public class IotCommandController {

    private final IotProducerService iotProducerService;

    public IotCommandController(IotProducerService iotProducerService) {
        this.iotProducerService = iotProducerService;
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean publishIotDeviceData(@RequestBody IotDevice iotDevice) {
        return iotProducerService.publish(iotDevice);
    }
}
