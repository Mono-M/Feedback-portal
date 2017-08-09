package com.dubinin.feedbackportal.service.impl;

import com.dubinin.feedbackportal.adapter.adapter.Adapter;
import com.dubinin.feedbackportal.dto.AchievementMessageDto;
import com.dubinin.feedbackportal.entity.AchievementMessage;
import com.dubinin.feedbackportal.repository.AchievementMessageRepository;
import com.dubinin.feedbackportal.service.AchievementMessageService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Vladyslav_Dubinin on 8/8/2017.
 */
@Service
@Log4j
public class AchievementMessageServiceImpl implements AchievementMessageService{
    @Autowired
    private AchievementMessageRepository messageRepository;
    @Autowired
    private Adapter adapter;

    @Override
    public AchievementMessage findById(Long id) {
        log.info("Find achievement by id. Achievement id: " + id);
        return messageRepository.findOne(id);
    }

    @Override
    public AchievementMessage save(AchievementMessageDto message) {
        log.info("Save achievement message to database.");
        return messageRepository.save(adapter.adapt(message, AchievementMessage.class));
    }
}
