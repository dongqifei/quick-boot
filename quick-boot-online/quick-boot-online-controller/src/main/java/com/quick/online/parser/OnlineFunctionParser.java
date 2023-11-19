package com.quick.online.parser;

import apijson.NotNull;
import apijson.RequestMethod;
import apijson.framework.APIJSONFunctionParser;
import com.alibaba.fastjson.JSONObject;
import com.quick.common.constant.CommonConstant;
import com.quick.common.util.SpringBeanUtils;
import com.quick.common.vo.Result;
import com.quick.system.api.ISysDictApi;
import jakarta.servlet.http.HttpSession;

/**可远程调用的函数类，用于自定义业务逻辑处理
 * 具体见 https://github.com/Tencent/APIJSON/issues/101
 */
public class OnlineFunctionParser extends APIJSONFunctionParser {
    public static final String TAG = "OnlineFunctionParser";


    public OnlineFunctionParser() {
        this(null, null, 0, null, null);
    }

    public OnlineFunctionParser(RequestMethod method, String tag, int version, JSONObject curObj, HttpSession session) {
        super(method, tag, version, curObj, session);
    }

    /**
     * 通过字典code获取字典数据 Text
     * @param dictCode
     * @param dictValue
     * @return
     */
    /**
     *
     * @param current 当前的
     * @param dictCode 字典code
     * @param dictValueKey 字典值Key(字段名)
     */
    public void translateDict(@NotNull JSONObject current,@NotNull String dictCode, String dictValueKey) {
        ISysDictApi sysDictApi = SpringBeanUtils.getBean(ISysDictApi.class);
        Result<String> result = sysDictApi.translateDict(dictCode, current.getString(dictValueKey));
        String textValue = result.getData();
        current.put(dictValueKey + CommonConstant._DICT_TEXT_SUFFIX, textValue);
    }


}