package com.exbyte.mvcboard.service;

import com.exbyte.mvcboard.commons.paging.Criteria;
import com.exbyte.mvcboard.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.domain.ArticleVO;

import java.util.List;

public interface ArticleService {
    void create(ArticleVO articleVO) throws Exception;
    ArticleVO read(int articleNo) throws Exception;
    void update(ArticleVO articleVO) throws Exception;
    void delete(int articleNo) throws Exception;
    List<ArticleVO> listAll() throws Exception;
    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
    int countArticle() throws Exception;
    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
}
