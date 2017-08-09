package com.dubinin.feedbackportal.service.impl;

import com.dubinin.feedbackportal.adapter.adapter.Adapter;
import com.dubinin.feedbackportal.dto.AchievementDto;
import com.dubinin.feedbackportal.entity.Achievement;
import com.dubinin.feedbackportal.repository.AchievementRepository;
import com.dubinin.feedbackportal.service.AchievementService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
@Log4j
@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;
    @Autowired
    private Adapter adapter;

    @Override
    public List<Achievement> findAll() {
        final List<Achievement> achievements = new ArrayList<>();
        achievementRepository.findAll().forEach(achievements::add);
        log.info("Find all achievement from database. Total count: " + achievements.size());
        return achievements;
    }

    @Override
    public Achievement save(AchievementDto achievementDto) {
        log.info("Save achievement to database.");
        return achievementRepository.save(adapter.adapt(achievementDto, Achievement.class));
    }
}
