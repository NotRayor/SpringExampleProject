package com.exbyte.mvcboard.tutorial.persistence;


import com.exbyte.mvcboard.tutorial.domain.MemberVO;

import java.util.List;

public interface MemberDAO {
    void create(MemberVO memberVO) throws Exception;
    MemberVO read(String memberId) throws Exception;
    MemberVO readWithPassword(String userid, String userpw) throws Exception;
    void update(MemberVO memberVO) throws Exception;
    void delete(String memberId) throws Exception;
    List<MemberVO> listAll() throws Exception;

}

