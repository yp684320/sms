package com.itheima.domain;

import java.util.List;

public class PageBean<T> {
    //当前页 (页面传参)
    private Integer pageNum;
    //每页显示条数  (页面传参)
    private Integer pageSize;
    //总页数  (计算得来:Math.ceil( totalCount * 1.0/pageSize) )
    private Integer totalPage;
    //总条数  查询
    private Integer totalCount;
    //当前页展示的数据  查询
    private List<T> list;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
