package com.dubinin.feedbackportal.repository;

import com.dubinin.feedbackportal.entity.Achievement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Repository
public interface AchievementRepository extends CrudRepository<Achievement, Long>{}
