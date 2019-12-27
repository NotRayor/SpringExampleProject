package com.exbyte.mvcboard.persistence;

import com.exbyte.mvcboard.domain.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    private static final String NAMESPACE = "com.exbyte.mvcboard.mappers.MemberMapper";

    private final SqlSession sqlSession;

    @Inject
    public MemberDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(MemberVO memberVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", memberVO);
    }

    @Override
    public MemberVO read(String memberId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".read", memberId);
    }

    @Override
    public MemberVO readWithPassword(String userid, String userpw) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);

        return sqlSession.selectOne(NAMESPACE + ".readWithPw", paramMap);
    }

    @Override
    public void update(MemberVO memberVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", memberVO);
    }

    @Override
    public void delete(String memberId) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", memberId);
    }

    @Override
    public List<MemberVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listAll");
    }
}
