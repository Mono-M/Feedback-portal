package com.dubinin.feedbackportal.repository;

import com.dubinin.feedbackportal.entity.AchievementMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Repository
public interface AchievementMessageRepository extends CrudRepository<AchievementMessage, Long> {}
