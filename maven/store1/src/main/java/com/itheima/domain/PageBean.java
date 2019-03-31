package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
    private List<T> data;
    private int total;
    private int pageSize;
    private int totalPage;
    private int pageNumber;
    private int start;
    private int end;
    private int showNum=10;

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return (int) Math.ceil(total*1.0/pageSize);
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getStart() {
        return getRange()[0];
    }

    public int getEnd() {
        return getRange()[1];
    }
    private int[] getRange(){
        totalPage=getTotalPage();

        //开始计算前后可以留几个
        //如果为奇数 7 3-3
        //如果为偶数 8 4-3

        int pre=showNum%2==0?showNum/2:showNum/2;
        int suf=showNum%2==0?showNum/2-1:showNum/2;

        //计算前后的满足情况
        //前后的个数已定
        //前后都满足的情况
        if(totalPage-pageNumber>=suf&&pageNumber-1>=pre){
            start=pageNumber-pre;
            end=pageNumber+suf;
            return new int[]{start,end};
        }
        //前面不满足的情况
        if(pageNumber-1<pre&&totalPage-pageNumber>=suf){
            start=1;
            //前面缺失的个数
            int preNum=pre-pageNumber+1;
            end=pageNumber+suf+preNum>totalPage?totalPage:pageNumber+suf+preNum;
            return new int[]{start,end};
        }
        //后面的不满足
        if(totalPage-pageNumber<suf&&pageNumber-1>=pre){
            end=totalPage;
            //后面缺失的个数
            int sufNum=pageNumber+suf-totalPage;
            start=pageNumber-pre-sufNum<1?1:pageNumber-pre-sufNum;
            return new int[]{start,end};
        }
        //都不满足
        if(totalPage-pageNumber<suf&&pageNumber-1<pre){
            return new int[]{1,totalPage};
        }
        return new int[]{1,1};
    }

}
