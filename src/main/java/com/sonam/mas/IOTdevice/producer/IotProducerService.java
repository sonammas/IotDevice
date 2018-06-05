package com.sonam.mas.IOTdevice.producer;

import com.sonam.mas.IOTdevice.model.IotDevice;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class IotProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IotProducerService.class);
    private KafkaTemplate<String, IotDevice> iotDeviceKafkaTemplate;

    public IotProducerService(KafkaTemplate<String, IotDevice> iotDeviceKafkaTemplate) {
        this.iotDeviceKafkaTemplate = iotDeviceKafkaTemplate;
    }

    public boolean publish(IotDevice iotDevice) {
        try {
            SendResult<String, IotDevice> sendResult = iotDeviceKafkaTemplate
                    .sendDefault(iotDevice.getId(), iotDevice).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            LOGGER.info("topic = {}, partition = {}, offset = {}, iotDevice = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), iotDevice);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
