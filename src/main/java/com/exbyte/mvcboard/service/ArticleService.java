package com.exbyte.mvcboard.service;

import com.exbyte.mvcboard.commons.paging.Criteria;
import com.exbyte.mvcboard.domain.ArticleVO;

import java.util.List;

public interface ArticleService {
    void create(ArticleVO articleVO) throws Exception;
    ArticleVO read(int articleNo) throws Exception;
    void update(ArticleVO articleVO) throws Exception;
    void delete(int articleNo) throws Exception;
    List<ArticleVO> listAll() throws Exception;
    List<ArticleVO> listPaging(Criteria criteria) throws Exception;
}
