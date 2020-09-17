package game;

import game.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    GiftRepository giftRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCreated_UpdateGift(@Payload Created created){

        if(created.isMe()){
            Optional<Gift> giftOptional = giftRepository.findById(created.getGiftId());
            Gift gift = giftOptional.get();
            gift.setRewardId(created.getId());
            giftRepository.save(gift);

            System.out.println("##### listener UpdateGift : " + created.toJson());
        }
    }

}
