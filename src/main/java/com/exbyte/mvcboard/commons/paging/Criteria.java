package com.exbyte.mvcboard.commons.paging;

import lombok.ToString;

@ToString
public class Criteria {

    private int page;
    private int perPageNum;

    public Criteria(){
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        if(page <= 0){
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public int getPageStart(){
        return (this.page - 1) * perPageNum;
    }

    public void setPerPageNum(int perPageNum) {
        if(page <= 0 || page >= 100){
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }
}