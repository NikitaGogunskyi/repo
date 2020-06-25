package com.epam.bean;

import java.util.ArrayList;
import java.util.List;

import static com.epam.constant.Parameter.DEFAULT_ITEMS_COUNT;

public class PageBean {

    private int currentPage = 1;
    private int lastPage;
    private int itemsPerPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage > 0 & currentPage <= lastPage) {
            this.currentPage = currentPage;
        }
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int itemsAmount) {
        this.lastPage = itemsAmount % itemsPerPage > 0 ? itemsAmount / itemsPerPage + 1 : itemsAmount / itemsPerPage;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage > 0 ? itemsPerPage : DEFAULT_ITEMS_COUNT;
    }

    public int getStartIndex(int page) {
        if (page > 0 & page <= lastPage) {
            return Math.abs(page - 1) * itemsPerPage;
        } else {
            return (currentPage - 1) * itemsPerPage;
        }
    }

    public List<Integer> getPageNumbers() {
        List<Integer> pageNumbers = new ArrayList<>();
        int begin = currentPage - 1;
        if (begin <= 0) {
            begin = 1;
        }
        int end = begin + 3;
        for (int i = begin; i <= end & i <= lastPage; i++) {
            pageNumbers.add(i);
        }
        return pageNumbers;
    }
}
