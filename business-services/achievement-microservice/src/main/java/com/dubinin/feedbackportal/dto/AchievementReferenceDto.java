package com.dubinin.feedbackportal.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * Created by Vladyslav_Dubinin on 9/8/2017.
 */

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class AchievementReferenceDto {
    private long achievementId;
    private long senderId;
    private long recipientId;
    private long messageId;
    private Date presentDate;
}
