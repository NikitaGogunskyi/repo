package com.epam.repository;

import com.epam.bean.FilterBean;

import java.util.Comparator;
import java.util.List;

public interface Repository<T> {

    void sort(Comparator<T> comparator);

    List<T> get();

    List<T> getSpecified();

}
