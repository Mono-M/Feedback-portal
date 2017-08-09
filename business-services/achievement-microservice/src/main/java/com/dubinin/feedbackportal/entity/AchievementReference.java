package com.dubinin.feedbackportal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vladyslav_Dubinin on 7/8/2017.
 */
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="ACHIEVEMENT_REFERENCE_LINK")
public class AchievementReference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Achievement achievement;

    @Column(name = "SENDER_ID")
    private long senderId;

    @Column(name = "RECIPIENT_ID")
    private long recipientId;

    @OneToOne(cascade = CascadeType.ALL)
    private AchievementMessage message;

    @Column(name = "PRESENT_DATE")
    private Date presentDate;
}
