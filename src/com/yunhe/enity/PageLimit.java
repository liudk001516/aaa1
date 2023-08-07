package com.yunhe.enity;

import java.util.List;

public class PageLimit {
    private int currentPage;
    private int pageSize;
    private int total;
    private List<Employees> list;

    public PageLimit(int currentPage, int pageSize, int total, List<Employees> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public PageLimit() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Employees> getList() {
        return list;
    }

    public void setList(List<Employees> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageLimit{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
