package com.dubinin.feedbackportal.repository;

import com.dubinin.feedbackportal.entity.AchievementReference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Repository
public interface AchievementReferenceRepository extends CrudRepository<AchievementReference, Long> {
    List<AchievementReference> findByRecipientId(Long recipientId);
}