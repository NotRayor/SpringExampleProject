package com.exbyte.mvcboard.article.commons.paging;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Getter
@Setter
public class PageMaker {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;

    private int displayPageNum = 10;

    private SearchCriteria criteria;

    public void setCriteria(SearchCriteria criteria){
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount){
        this.totalCount = totalCount;
        calcData();
    }

    private void calcData(){
        endPage = (int)Math.ceil(criteria.getPage()/(double)displayPageNum) * displayPageNum;

        // 끝 페이지가 20일 때, 표현할 페이지 번호는 10개, 끝페이지 번호 - 표현할 페이지 번호 + 1
        startPage = endPage - displayPageNum + 1;

        // 끝 페이지 번호 보정
       int tempEndPage = (int)Math.ceil(totalCount/(double)criteria.getPerPageNum());

       if(endPage > tempEndPage){
           endPage = tempEndPage;
       }

       prev = (startPage != 1);
       next = endPage * criteria.getPerPageNum() < totalCount;
    }

    public String makeQuery(int page){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", criteria.getPerPageNum())
                .build();

        return uriComponents.toString();
    }

    public String makeSearch(int page){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", criteria.getPerPageNum())
                .queryParam("searchType", criteria.getSearchType())
                .queryParam("keyword", criteria.getKeyword())
                .build();

        return uriComponents.toString();
    }

    private String encoding(String keyword){
        if(keyword == null || keyword.trim().length() == 0){
            return "";
        }
        try{
            return URLEncoder.encode(keyword, "UTF-8");
        }catch (UnsupportedEncodingException e){
            return "";
        }
    }
}
