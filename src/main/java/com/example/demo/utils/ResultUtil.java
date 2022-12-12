package com.example.demo.utils;

import com.example.demo.exception.REnum;
import com.example.demo.model.Result;

public class ResultUtil {

    public static Result<Object> success(Object object) {
        Result<Object> r = new Result<>();
        r.setCode(0);
        r.setMsg("success");
        r.setData(object);
        return r;
    }

    public static Result<Object> success() {
        return success(null);
    }

    public static Result<Object> error(Integer code, String msg) {
        Result<Object> r = new Result<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static Result<Object> error(REnum rEnum) {
        return error(rEnum.getCode(), rEnum.getMsg());
    }
}
