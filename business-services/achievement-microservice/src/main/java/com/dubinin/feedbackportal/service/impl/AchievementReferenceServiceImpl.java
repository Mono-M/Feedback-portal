package com.dubinin.feedbackportal.service.impl;

import com.dubinin.feedbackportal.dto.AchievementReferenceDto;
import com.dubinin.feedbackportal.entity.Achievement;
import com.dubinin.feedbackportal.entity.AchievementMessage;
import com.dubinin.feedbackportal.entity.AchievementReference;
import com.dubinin.feedbackportal.repository.AchievementReferenceRepository;
import com.dubinin.feedbackportal.service.AchievementReferenceService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
@Log4j
@Service
public class AchievementReferenceServiceImpl implements AchievementReferenceService {
    @Autowired
    private AchievementReferenceRepository achievementReferenceRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public AchievementReferenceDto save(AchievementReferenceDto referenceDto) {
        log.info("Save achievement reference to database.");
        final AchievementReference result = adapt(referenceDto);
        return adapt(achievementReferenceRepository.save(result));
    }

    @Override
    public List<AchievementReferenceDto> findByRecipientId(Long recipientId) {
        log.info("Find achievement reference by recipient id. Recipient id: " + recipientId);
        final List<AchievementReferenceDto> referenceDtos = new ArrayList<>();
        achievementReferenceRepository.findByRecipientId(recipientId)
                .forEach(achievementReference -> referenceDtos.add(adapt(achievementReference)));
        return referenceDtos;
    }

    private AchievementReference adapt(AchievementReferenceDto referenceDto) {
        final AchievementReference reference = new AchievementReference();
        reference.setAchievement(entityManager.getReference(Achievement.class, referenceDto.getAchievementId()));
        reference.setMessage(entityManager.getReference(AchievementMessage.class, referenceDto.getMessageId()));
        reference.setRecipientId(referenceDto.getRecipientId());
        reference.setSenderId(referenceDto.getSenderId());
        reference.setPresentDate(referenceDto.getPresentDate());
        return reference;
    }

    private AchievementReferenceDto adapt(AchievementReference reference) {
        final AchievementReferenceDto referenceDto = new AchievementReferenceDto();
        referenceDto.setAchievementId(reference.getAchievement().getId());
        referenceDto.setMessageId(reference.getMessage().getId());
        referenceDto.setRecipientId(reference.getRecipientId());
        referenceDto.setSenderId(reference.getSenderId());
        referenceDto.setPresentDate(reference.getPresentDate());
        return referenceDto;
    }
}
