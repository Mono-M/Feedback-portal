package com.dubinin.feedbackportal.api;

import com.dubinin.feedbackportal.dto.AchievementReferenceDto;
import com.dubinin.feedbackportal.service.AchievementReferenceService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
@Log4j
@RestController
public class AchievementReferenceController {
    @Autowired
    private AchievementReferenceService referenceService;

    @RequestMapping(value = "reference", method = RequestMethod.PUT)
    public ResponseEntity addAchievementReference(@RequestBody AchievementReferenceDto achievementReference) {
        log.info("Add new achievement reference.");
        return new ResponseEntity<>(referenceService.save(achievementReference), HttpStatus.OK);
    }

    @RequestMapping(value = "reference/list", method = RequestMethod.GET)
    public ResponseEntity achievementReferencesByRecipientId(@RequestParam(name = "recipient_id") Long recipientId) {
        final List<AchievementReferenceDto> referenceDtos = referenceService.findByRecipientId(recipientId);
        log.info("Get all achievement references. Amount of achievement references is " + referenceDtos.size());
        return new ResponseEntity<>(referenceDtos, HttpStatus.OK);
    }
}
