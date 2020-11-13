package com.thecheck.manage.model;
/*
 * @author brKim
 * @date 2020/10/27
 * @desc
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_role")
@Getter
@Setter
@ToString
public class RoleEntity {

    @Id
    @Column
    @GeneratedValue
    private long role_id;

    @Column
    private String role_name;

    @Column
    private String role_desc;

    @Column
    @CreationTimestamp
    private LocalDate create_timestamp;

    @Column
    @UpdateTimestamp
    private LocalDate update_timestamp;

    @Column
    private int del;

}
