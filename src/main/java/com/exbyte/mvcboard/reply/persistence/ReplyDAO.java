package com.exbyte.mvcboard.reply.persistence;


import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.reply.domain.ReplyVO;

import java.util.List;

public interface ReplyDAO {

    void create(ReplyVO replyVO) throws Exception;
    List<ReplyVO> list(int articleNo) throws Exception;
    void update(ReplyVO replyVO) throws Exception;
    void delete(int replyNo) throws Exception;

    // 댓글 페이징 처리,
    List<ReplyVO> listPaging(int articleNo, Criteria criteria) throws Exception;
    int countReply(int articleNo) throws Exception;
}
