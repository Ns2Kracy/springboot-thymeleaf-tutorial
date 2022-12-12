package com.example.demo.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RException extends RuntimeException {
    private Integer code;

    public RException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public RException(REnum rEnum) {
        super(rEnum.getMsg());
        this.code = rEnum.getCode();
    }
}
