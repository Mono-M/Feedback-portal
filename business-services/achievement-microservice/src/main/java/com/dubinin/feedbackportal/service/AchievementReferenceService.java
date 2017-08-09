package com.dubinin.feedbackportal.service;

import com.dubinin.feedbackportal.dto.AchievementReferenceDto;

import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
public interface AchievementReferenceService{
    List<AchievementReferenceDto> findByRecipientId(Long recipientId);
    AchievementReferenceDto save(AchievementReferenceDto referenceDto);
}
