package com.exbyte.mvcboard.reply.service;

import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.reply.domain.ReplyVO;
import com.exbyte.mvcboard.reply.persistence.ReplyDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {

    private final ReplyDAO replyDAO;

    @Inject
    public ReplyServiceImpl(ReplyDAO replyDAO){
        this.replyDAO = replyDAO;
    }

    @Override
    public void create(ReplyVO replyVO) throws Exception {
        replyDAO.create(replyVO);
    }

    @Override
    public List<ReplyVO> list(int articleNo) throws Exception {
        return replyDAO.list(articleNo);
    }

    @Override
    public void update(ReplyVO replyVO) throws Exception {
        replyDAO.update(replyVO);
    }

    @Override
    public void delete(int replyNo) throws Exception {
        replyDAO.delete(replyNo);
    }

    @Override
    public List<ReplyVO> listPaging(int articleNo, Criteria criteria) throws Exception {
        return replyDAO.listPaging(articleNo, criteria);
    }

    @Override
    public int countReply(int articleNo) throws Exception {
        return replyDAO.countReply(articleNo);
    }
}
