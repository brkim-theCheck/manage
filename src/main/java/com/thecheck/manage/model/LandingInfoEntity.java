package com.thecheck.manage.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "wp_landing_info")
@Getter
@Setter
public class LandingInfoEntity implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(length= 10)
    private String userNm;

    @Column(length = 50)
    private String mutual;

    @Column(length = 11)
    private String telNo;

    @Column(length = 11)
    private String businessNo;

    @Column(length = 100)
    private String address;

    @Column(length = 14)
    private String visitAt;

    @CreationTimestamp
    private LocalDateTime acptAt;

    @Column(length = 100)
    private String rcptManager;

    @Column(length = 2000)
    private String opinionDesc;

    @Column(length = 5)
    private String channel;

    @Column(length = 8)
    private LocalDateTime rcptAt;
}
