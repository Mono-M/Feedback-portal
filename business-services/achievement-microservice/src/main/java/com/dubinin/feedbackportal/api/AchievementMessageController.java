package com.dubinin.feedbackportal.api;

import com.dubinin.feedbackportal.dto.AchievementMessageDto;
import com.dubinin.feedbackportal.entity.AchievementMessage;
import com.dubinin.feedbackportal.service.AchievementMessageService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
@Log4j
@RestController
public class AchievementMessageController {
    @Autowired
    private AchievementMessageService messageService;

    @RequestMapping(value = "message", method = RequestMethod.PUT)
    public ResponseEntity addAchievementMessage(@RequestBody AchievementMessageDto message) {
        log.info("Add new achievement message.");
        return new ResponseEntity<>(messageService.save(message), HttpStatus.OK);
    }

    @RequestMapping(value = "message/{id}", method = RequestMethod.GET)
    public ResponseEntity getMessageById(@PathVariable(name = "id") Long id){
        log.info("Get achievement message by id. Achievement message id: " + id);
        final AchievementMessage message = messageService.findById(id);
        if (message == null) {
            log.info("Can not find achievement message by id:" + id);
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
