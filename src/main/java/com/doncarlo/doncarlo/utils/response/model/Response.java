package com.doncarlo.doncarlo.utils.response.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response<T> {

    private Integer status;
    private String message;
    private T data;

}