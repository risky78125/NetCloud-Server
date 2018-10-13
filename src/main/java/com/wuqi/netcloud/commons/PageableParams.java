package com.wuqi.netcloud.commons;

public class PageableParams {

    private int offset;
    private int count = 10;

    public PageableParams() {
    }

    public PageableParams(int offset, int count) {
        this.offset = offset;
        this.count = count;
    }

    public static PageableParams create(int page) {
        PageableParams params = new PageableParams();
        int offset = (page - 1) * params.getCount();
        params.setOffset(offset);
        return params;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
