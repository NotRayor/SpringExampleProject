package com.exbyte.mvcboard.reply.controller;

import com.exbyte.mvcboard.article.commons.paging.PageMaker;
import com.exbyte.mvcboard.article.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.reply.domain.ReplyVO;
import com.exbyte.mvcboard.reply.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/replies")
public class ReplyController {

    private final ReplyService replyService;
    Logger logger = LoggerFactory.getLogger(ReplyController.class);

    @Inject
    public ReplyController(ReplyService replyService){
        this.replyService = replyService;
    }

    // 댓글 등록 처리
    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ReplyVO replyVO){
        ResponseEntity<String> entity = null;
        try{
            replyService.create(replyVO);
            entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 댓글 목록 메서드
    @RequestMapping(value = "/all/{articleNo}", method = RequestMethod.GET)
    public ResponseEntity<List<ReplyVO>> list(@PathVariable("articleNo") int articleNo){
        ResponseEntity<List<ReplyVO>>entity = null;

        try{
            entity = new ResponseEntity<>(replyService.list(articleNo), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info(entity.toString());
        return entity;
    }

    @RequestMapping(value = "/{articleNo}/{page}", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> listPaging(@PathVariable("articleNo") int articleNo,
                                                    @PathVariable("page") int page){

        ResponseEntity<Map<String, Object>> entity = null;

        try{
            SearchCriteria criteria = new SearchCriteria();
            criteria.setPage(page);
            criteria.setPerPageNum(10);

            List<ReplyVO> replies = replyService.listPaging(articleNo, criteria);
            int repliesCount = replyService.countReply(articleNo);

            PageMaker pageMaker = new PageMaker();
            pageMaker.setCriteria(criteria);
            pageMaker.setTotalCount(repliesCount);

            Map<String, Object> map = new HashMap<>();
            map.put("replies", replies);
            map.put("pageMaker", pageMaker);

            entity = new ResponseEntity<>(map, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 댓글 수정 처리 메서드
    @RequestMapping(value="/{replyNo}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("replyNo") int replyNo, @RequestBody ReplyVO replyVO) throws Exception{
        ResponseEntity<String> entity = null;
        try{
            replyVO.setReplyNo(replyNo);
            replyService.update(replyVO);
            entity = new ResponseEntity<>("modSuccess", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 댓글 삭제 처리
    @RequestMapping(value = "/{replyNo}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("replyNo") int replyNo){
        ResponseEntity<String> entity = null;
        try{
            replyService.delete(replyNo);
            entity = new ResponseEntity<>("delSuccess",HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
