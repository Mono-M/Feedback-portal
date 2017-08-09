package com.dubinin.feedbackportal.service;

import com.dubinin.feedbackportal.dto.AchievementDto;
import com.dubinin.feedbackportal.entity.Achievement;

import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
public interface AchievementService {
    List<Achievement> findAll();
    Achievement save(AchievementDto achievementDto);
}
