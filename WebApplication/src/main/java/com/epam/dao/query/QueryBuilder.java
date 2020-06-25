package com.epam.dao.query;

import java.util.Collection;

public interface QueryBuilder {

    QueryBuilder setSelect(String select);

    QueryBuilder setWhere(String field, Collection<String> values);

    QueryBuilder and();

    QueryBuilder or();

    QueryBuilder moreThen(String field, int value);

    QueryBuilder lessThen(String field, int value);

    QueryBuilder like(String field, String value);

    QueryBuilder setOrderBy(String field, boolean descendingOrder);

    QueryBuilder setLimit(int from, int amount);

    String build();
}
