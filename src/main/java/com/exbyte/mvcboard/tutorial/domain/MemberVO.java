package com.exbyte.mvcboard.tutorial.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class MemberVO {
    private String userid;
    private String userpw;
    private String username;
    private String email;
    private Date regdate;
    private Date updatedDate;
}
