package com.example.bootcrm.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
/**
 * FileName: Member
 * Author:   刘帅
 * Date:     2019-5-30 19:23
 */
@Entity
@Table(name = "t_member")
public class Member {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "member_id",length = 36)
    public String id;
    //注册时间
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    @Temporal(TemporalType.DATE)
    @Column(name = "`date`")
    public Date date;
    // 姓名
    @Column(name = "`name`",length = 50)
    public String name;
    //性别
    @Column(name = "sex")
    public Integer sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
