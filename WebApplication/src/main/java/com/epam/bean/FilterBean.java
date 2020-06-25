package com.epam.bean;

import com.epam.dao.query.QueryBuilder;
import com.epam.dao.query.SQLQueryBuilder;
import com.epam.util.SQLQueryOrdering;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.epam.constant.Parameter.*;
import static com.epam.constant.Regex.NUMBER_REGEX;
import static com.epam.constant.SQLQuery.*;

public class FilterBean {
    private String keyWord;
    private int productNum = DEFAULT_ITEMS_COUNT;
    private BigDecimal minCost;
    private BigDecimal maxCost;
    private Map<String, String> categories = new HashMap<>();
    private String sortBy;
    private QueryBuilder query = new SQLQueryBuilder();

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        if (!keyWord.isEmpty()) {
            this.keyWord = keyWord;
            query.or().like(TITLE_FIELD, keyWord);
            query.or().like(AUTHOR_FIELD, keyWord);
        }
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(String parameter) {
        if (Objects.nonNull(parameter)) {
            int num = Integer.parseInt(parameter);
            this.productNum = num > 0 ? num : DEFAULT_ITEMS_COUNT;
        }
    }

    public BigDecimal getMinCost() {
        return minCost;
    }

    public void setMinCost(String parameter) {
        if (Objects.nonNull(parameter) & parameter.matches(NUMBER_REGEX)) {
            minCost = new BigDecimal(parameter);
            query.and().moreThen(COST_FIELD, minCost.intValue());
        }
    }

    public BigDecimal getMaxCost() {
        return maxCost;
    }

    public void setMaxCost(String parameter) {
        if (Objects.nonNull(parameter) & parameter.matches(NUMBER_REGEX)) {
            maxCost = new BigDecimal(parameter);
            query.and().lessThen(COST_FIELD, maxCost.intValue());
        }
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String parameter) {
        if (Objects.nonNull(parameter)) {
            this.sortBy = parameter;
            SQLQueryOrdering.sortBy(parameter, query);
        }
    }

    public QueryBuilder getQuery() {
        return query;
    }

    public void makeChecked(String[] categories) {
        this.categories.replaceAll((key, value) -> value = UNCHECKED);
        if (Objects.nonNull(categories)) {
            Arrays.stream(categories).forEach(category -> this.categories.put(category, CHECKED));
            query.and().setWhere(CATEGORY_FIELD, getChecked());
        }
    }

    private List<String> getChecked() {
        return this.categories.keySet().stream()
                .filter(el -> categories.get(el).equals(CHECKED))
                .collect(Collectors.toList());
    }
}