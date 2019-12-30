package com.exbyte.mvcboard.controller;

import com.exbyte.mvcboard.commons.paging.PageMaker;
import com.exbyte.mvcboard.commons.paging.SearchCriteria;
import com.exbyte.mvcboard.domain.ArticleVO;
import com.exbyte.mvcboard.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

    private final ArticleService articleService;

    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 등록 페이지 이동
    @RequestMapping(value="/write", method= RequestMethod.GET)
    public String writeGET(){
        logger.info("write GET...");

        return "/article/write";
    }

    // 등록 처리
    @RequestMapping(value="/write", method= RequestMethod.POST)
    public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception {
        logger.info("write POST...");
        logger.info(articleVO.toString());
        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");

        return "redirect:/article/list";
    }

    //변경된 조회 페이지 이동
    @RequestMapping(value="/readPaging", method = RequestMethod.GET)
    public String readPagingGET(@RequestParam("articleNo") int articleNo,
                                @ModelAttribute("criteria") SearchCriteria searchCriteria,
                                Model model) throws Exception{
        model.addAttribute("article", articleService.read(articleNo));

        logger.info("readPaging...");

        return "/article/read_paging";
    }

    //변경된 수정 페이지 이동
    @RequestMapping(value="modifyPaging", method = RequestMethod.GET)
    public String modifyPaingGET(@RequestParam("articleNo") int articleNo,
                                 @ModelAttribute("criteria") SearchCriteria searchCriteria,
                                 Model model) throws Exception {

        logger.info("modifyPagingGET...");
        model.addAttribute("article", articleService.read(articleNo));

        return "/article/modify_paging";
    }

    //변경된 수정 처리
    @RequestMapping(value="modifyPaging", method = RequestMethod.POST)
    public String modifyPaingPOST(ArticleVO articleVO,
                                  @ModelAttribute("criteria") SearchCriteria searchCriteria,
                                 RedirectAttributes redirectAttributes) throws Exception {

        logger.info("modifyPagingPOST...");
        articleService.update(articleVO);
        redirectAttributes.addAttribute("page", searchCriteria.getPage());
        redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
        redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
        redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
        redirectAttributes.addFlashAttribute("msg", "msgSuccess");

        return "redirect:/article/list";
    }

    // 변경된 삭제 처리
    @RequestMapping(value="/deletePaging", method = RequestMethod.POST)
    public String removePaging(@RequestParam("articleNo") int articleNo,
                               @ModelAttribute("criteria") SearchCriteria searchCriteria,
                               RedirectAttributes redirectAttributes) throws Exception{

        logger.info("removePaging...");

        articleService.delete(articleNo);
        redirectAttributes.addAttribute("page",searchCriteria.getPage());
        redirectAttributes.addAttribute("perPageNum",searchCriteria.getPerPageNum());
        redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
        redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/article/list";
    }

    // 페이징 처리  페이지네이션 구현
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String listPagingRead(Model model, @ModelAttribute("criteria") SearchCriteria searchCriteria) throws Exception{
        logger.info("list search() called...");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        //pageMaker.setTotalCount(articleService.countArticle());
        pageMaker.setTotalCount(articleService.countSearchedArticles(searchCriteria));

        //model.addAttribute("articles", articleService.listCriteria(searchCriteria));
        model.addAttribute("articles",articleService.listSearch(searchCriteria));
        model.addAttribute("pageMaker", pageMaker);

        return "/article/list";
    }
    
}
