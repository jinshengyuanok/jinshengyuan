package com.yuan.utils;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-06
 * Time: 14:52
 * description: 只作为封装EasyUI DataGrid 数据用,请勿改变其结构及加入其他业务代码
 **/
public class RowsList<T> {
    private long pageNum;
    private long total;
    private List<T> rows;

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
