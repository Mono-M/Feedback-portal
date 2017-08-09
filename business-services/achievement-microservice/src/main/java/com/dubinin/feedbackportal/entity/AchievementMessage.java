package com.dubinin.feedbackportal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="ACHIEVEMENT_MESSAGE")
public class AchievementMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "MESSAGE_TEXT")
    private String messageText;
}
