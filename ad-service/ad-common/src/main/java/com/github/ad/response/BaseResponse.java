package com.github.ad.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

//实现get和set方法
@Data
// 无参构造
@NoArgsConstructor
//全参构造函数
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String Message;
    private T data;
    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.Message = message;
    }
}
