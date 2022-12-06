package com.example.demo.utils;

import com.example.demo.exception.REnum;
import com.example.demo.vo.Result;

public class RUtil {

    public static Result success(Object object) {
        Result r = new Result();
        r.setCode(0);
        r.setMsg("success");
        r.setData(object);
        return r;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static Result error(REnum rEnum) {
        return error(rEnum.getCode(), rEnum.getMsg());
    }
}
