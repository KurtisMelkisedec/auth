package com.api.auth.web.dto;

import java.util.HashMap;
import java.util.Map;

public class RestResponseDto {
    public static Map<Object,Object> response(
            Object result,
            Object status
    ){
        Map<Object,Object> model = new HashMap<Object,Object>();

        model.put("result", result);
        model.put("status", status);
        return model;
    }
    public static Map<Object,Object> response(
            Object result

    ){
        Map<Object,Object> model = new HashMap<Object,Object>();

        model.put("result", result);

        return model;
    }
}
