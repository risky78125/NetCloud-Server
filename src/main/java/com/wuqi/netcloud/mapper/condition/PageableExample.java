package com.wuqi.netcloud.mapper.condition;

public class PageableExample {

    private int offset;
    private int count = 8;

    public PageableExample() {
    }

    public PageableExample(int offset, int count) {
        this.offset = offset;
        this.count = count;
    }

    public static PageableExample create(int page, int count) {
        page = page <= 0 ? 1 : page;
        PageableExample params = new PageableExample();
        count = count <= 0 ? params.getCount() : count;
        int offset = (page - 1) * count;
        params.setOffset(offset);
        params.setCount(count);
        return params;
    }

    public static PageableExample create(int page) {
        page = page <= 0 ? 1 : page;
        PageableExample params = new PageableExample();
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
