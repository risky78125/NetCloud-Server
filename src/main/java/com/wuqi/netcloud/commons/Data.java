package com.wuqi.netcloud.commons;

import java.util.List;

public final class Data<T> {
    private int totalSize;
    private int pageSize;
    private List<T> items;

    public Data() {
    }

    public Data(Integer totalSize, List<T> items) {
        this.totalSize = totalSize;
        this.items = items;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
