package com.exbyte.mvcboard.persistence;

import com.exbyte.mvcboard.commons.paging.Criteria;
import com.exbyte.mvcboard.domain.ArticleVO;

import java.util.List;

public interface ArticleDAO {
    void create(ArticleVO articleVO) throws Exception;

    ArticleVO read(int articleNo) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer articleNo) throws Exception;

    List<ArticleVO> listAll() throws Exception;

    List<ArticleVO> listPaging(Criteria criteria) throws Exception;
}
