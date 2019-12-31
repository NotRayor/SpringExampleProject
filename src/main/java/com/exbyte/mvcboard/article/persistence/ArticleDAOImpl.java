package com.exbyte.mvcboard.article.persistence;

import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.article.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.article.domain.ArticleVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

    private static final String NAMESPACE = "com.exbyte.mvcboard.mappers.tutorial.ArticleMapper";

    private final SqlSession sqlSession;

    @Inject
    public ArticleDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void create(ArticleVO articleVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", articleVO);
    }

    @Override
    public ArticleVO read(int articleNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
    }

    @Override
    public void update(ArticleVO articleVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", articleVO);
    }

    @Override
    public void delete(Integer articleNo) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", articleNo);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listAll");
    }

    @Override
    public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listCriteria", criteria);
    }

    @Override
    public int countArticle() throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countArticle");
    }

    @Override
    public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listSearch", searchCriteria);
    }

    @Override
    public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".countSearchedArticles", searchCriteria);
    }
}
