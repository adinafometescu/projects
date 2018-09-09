package com.project.byw.search;

import org.elasticsearch.index.query.QueryBuilder;

public interface QueryProvider {

    QueryBuilder getQuery();
}
