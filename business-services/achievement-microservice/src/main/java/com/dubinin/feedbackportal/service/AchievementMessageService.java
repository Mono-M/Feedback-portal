package com.dubinin.feedbackportal.service;

import com.dubinin.feedbackportal.dto.AchievementMessageDto;
import com.dubinin.feedbackportal.entity.AchievementMessage;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
public interface AchievementMessageService{
    AchievementMessage findById(Long id);
    AchievementMessage save(AchievementMessageDto message);
}
