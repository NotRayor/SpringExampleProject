package com.exbyte.mvcboard.article.controller;

import com.exbyte.mvcboard.article.commons.paging.Criteria;
import com.exbyte.mvcboard.article.commons.paging.PageMaker;
import com.exbyte.mvcboard.article.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.article.domain.ArticleVO;
import com.exbyte.mvcboard.article.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
@RequestMapping("/article")
public class OldArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    @Inject
    public OldArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }



    //조회 페이지 이동
    @RequestMapping(value="/read", method = RequestMethod.GET)
    public String readGET(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
        logger.info("read...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/read";
    }

    // 수정 처리
    @RequestMapping(value="/modify", method = RequestMethod.POST)
    public String modifyPOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("modifyPOST...");
        articleService.update(articleVO);
        redirectAttributes.addFlashAttribute("msg", "msgSuccess");

        return "redirect:/article/list";
    }

    // 삭제 처리
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String remove(@RequestParam("articleNo") int articleNo, RedirectAttributes redirectAttributes)
            throws Exception{
        logger.info("remove...");
        articleService.delete(articleNo);
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/list";
    }

    // 페이징 처리
    @RequestMapping(value="/listCriteria", method = RequestMethod.GET)
    public String listCriteria(Model model, Criteria criteria) throws Exception{
        logger.info("listCriteria...");

        model.addAttribute("articles", articleService.listCriteria(criteria));
        return "/article/list_criteria";
    }

    // 페이징 처리  페이지네이션 구현
    @RequestMapping(value="/listPaging", method = RequestMethod.GET)
    public String listPaging(Model model, Criteria criteria) throws Exception{
        logger.info("listPaging...");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria((SearchCriteria) criteria);
        pageMaker.setTotalCount(articleService.countArticle());

        model.addAttribute("articles", articleService.listCriteria(criteria));
        model.addAttribute("pageMaker", pageMaker);

        return "/article/list_paging";
    }

}
