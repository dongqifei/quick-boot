package com.quick.online.parser;

import apijson.RequestMethod;
import apijson.framework.APIJSONObjectParser;
import apijson.framework.APIJSONParser;
import apijson.orm.SQLConfig;
import com.alibaba.fastjson.JSONObject;

public class OnlineParser extends APIJSONParser<Long> {
    public OnlineParser() {
        super();
    }

    public OnlineParser(RequestMethod method) {
        super(method);
    }

    public OnlineParser(RequestMethod method, boolean needVerify) {
        super(method, needVerify);
    }

    // 可重写来设置最大查询数量
    @Override
    public int getMaxQueryDepth() {
        return 6;
    }

    @Override
    public APIJSONObjectParser createObjectParser(JSONObject request, String parentPath, SQLConfig arrayConfig, boolean isSubquery, boolean isTable, boolean isArrayMainTable) throws Exception {
        return new OnlineObjectParser(getSession(),request, parentPath, arrayConfig, isSubquery, isTable, isArrayMainTable).setMethod(getMethod()).setParser(this);
    }
}