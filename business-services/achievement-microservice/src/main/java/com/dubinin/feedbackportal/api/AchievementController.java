package com.dubinin.feedbackportal.api;

import com.dubinin.feedbackportal.dto.AchievementDto;
import com.dubinin.feedbackportal.entity.Achievement;
import com.dubinin.feedbackportal.entity.AchievementMessage;
import com.dubinin.feedbackportal.entity.AchievementReference;
import com.dubinin.feedbackportal.service.AchievementMessageService;
import com.dubinin.feedbackportal.service.AchievementReferenceService;
import com.dubinin.feedbackportal.service.AchievementService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Vladyslav_Dubinin on 20/7/2017.
 */
@Log4j
@RestController
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    @Autowired
    private AchievementReferenceService achievementReferenceService;

    @Autowired
    private AchievementMessageService achievementMessageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getAchievements() {
        final List<Achievement> achievements = achievementService.findAll();
        log.info("Get all achievements. Amount of achievements is " + achievements.size());
        return new ResponseEntity<>(achievements, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity addAchievement(@RequestBody AchievementDto achievement) {
        log.info("Add new achievement.");
        return new ResponseEntity<>(achievementService.save(achievement), HttpStatus.OK);
    }
}
