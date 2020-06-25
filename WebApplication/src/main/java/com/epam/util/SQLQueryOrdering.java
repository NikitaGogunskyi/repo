package com.epam.util;

import com.epam.constant.Regex;
import com.epam.dao.query.QueryBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.constant.Parameter.*;
import static com.epam.constant.SQLQuery.COST_FIELD;
import static com.epam.dao.query.SQLQueryBuilder.DESC;

public class SQLQueryOrdering {

    private static Map<String, String> orderBy = new HashMap<>();

    static {
        orderBy.put(PRICE, COST_FIELD);
        orderBy.put(HIGH_TO_LOW, DESC);
    }

    public static void sortBy(String keyWord, QueryBuilder query) {
        Pattern pattern = Pattern.compile(Regex.SORT_REGEX);
        Matcher matcher = pattern.matcher(keyWord);
        if (matcher.find()) {
            String order = matcher.group(ORDER);
            if (Objects.nonNull(order) && order.equals(DESC)) {
                query.setOrderBy(orderBy.get(matcher.group(FIELD)), true);
            } else {
                query.setOrderBy(orderBy.get(matcher.group(FIELD)), false);
            }
        }
    }
}