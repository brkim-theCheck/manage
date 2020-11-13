package com.thecheck.manage.model;
/*
 * @author brKim
 * @date 2020/10/26
 * @desc
 */


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
public class UserEntity implements Serializable {
    private static final long serialVersionID = 1L;

    @Id
    @Column
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String userid;

    @Column(nullable = false, length = 150)
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private RoleEntity role_id;

    @Column
    @CreationTimestamp
    private LocalDate create_timestamp;

    @Column
    @UpdateTimestamp
    private LocalDate update_timestamp;

    @Column
    private int del;
}
