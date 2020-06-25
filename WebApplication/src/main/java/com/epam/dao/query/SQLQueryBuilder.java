package com.epam.dao.query;

import java.util.Collection;
import java.util.Objects;

public class SQLQueryBuilder implements QueryBuilder {

    public static final String ORDER_BY = " ORDER BY ";
    public static final String WHERE = " WHERE ";
    public static final String DESC = " DESC ";
    public static final String LIMIT = " LIMIT ";
    public static final String EQUAL_SIGN = "=";
    public static final String TOP_COMMA = "'";
    public static final String COMMA = ", ";
    public static final String AND = " AND ";
    public static final String OR = " OR ";
    public static final String LIKE = " LIKE ";

    private String select = "";
    private String where = "";
    private String orderBy = "";
    private String limit = "";

    @Override
    public QueryBuilder setSelect(String select) {
        this.select = select;
        return this;
    }

    @Override
    public QueryBuilder setWhere(String field, Collection<String> values) {
        StringBuilder where = new StringBuilder(" ( ");
        for (String value : values) {
            where.append(field).append(EQUAL_SIGN).append(TOP_COMMA).append(value).append(TOP_COMMA).append(OR);
        }
        int lastOr = where.lastIndexOf(OR);
        where.delete(lastOr, lastOr + 3);
        this.where += where.toString() + " ) ";
        return this;
    }

    @Override
    public QueryBuilder and() {
        if (!where.isEmpty()) {
            where += AND;
        }
        return this;
    }

    @Override
    public QueryBuilder or() {
        if (!where.isEmpty()) {
            where += OR;
        }
        return this;
    }

    @Override
    public QueryBuilder moreThen(String field, int value) {
        this.where += field + ">" + value;
        return this;
    }

    @Override
    public QueryBuilder lessThen(String field, int value) {
        this.where += field + "<" + value;
        return this;
    }


    @Override
    public QueryBuilder like(String field, String value) {
        this.where += field + LIKE + "'%" + value + "%' ";
        return this;
    }

    @Override
    public QueryBuilder setOrderBy(String field, boolean descendingOrder) {
        orderBy = field;
        if (descendingOrder) {
            orderBy += DESC;
        }
        return this;
    }

    @Override
    public QueryBuilder setLimit(int from, int amount) {
        limit = LIMIT + from + COMMA + amount;
        return this;
    }

    @Override
    public String build() {
        if (Objects.isNull(select)) {
            throw new IllegalStateException();
        }
        StringBuilder sql = new StringBuilder(select);
        if (!where.isEmpty()) {
            sql.append(WHERE).append(where);
        }
        if (!orderBy.isEmpty()) {
            sql.append(ORDER_BY).append(orderBy);
        }
        if (!limit.isEmpty()) {
            sql.append(limit);
        }
        return sql.toString();
    }
}
