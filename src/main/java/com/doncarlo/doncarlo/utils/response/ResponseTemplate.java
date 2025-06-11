package com.doncarlo.doncarlo.utils.response;


import org.springframework.http.HttpStatus;
import com.doncarlo.doncarlo.utils.response.model.ExceptionResponse;
import com.doncarlo.doncarlo.utils.response.model.Response;

public class ResponseTemplate {

    public static <T> Response<T> createResponse(T data){
        return createResponse(data, "success");
    }

    public static <T> Response<T> createResponse(T data, String message){
        return constructSuccessRequest(data, message, 200);
    }

    public static <T> Response<T> createResponse(Integer statusCode, String message){
        return constructSuccessRequest(message, statusCode);
    }

    public static <T> Response<T> createResponse(Integer statusCode, T data){
        return constructSuccessRequest(data, "Success", statusCode);
    }

    public static ExceptionResponse createExceptionResponse(HttpStatus statusCode, String message){
        return ExceptionResponse.builder()
                .status(statusCode.value())
                .message(message)
                .build();
    }

    public static ExceptionResponse createExceptionResponse(Integer statusCode, String message){
        return ExceptionResponse.builder()
                .status(statusCode)
                .message(message)
                .build();
    }

    private static  <T, I extends Integer> Response<T> constructSuccessRequest(T data, String message, I statusCode)
    {
        return new Response<T>() {{
            setData(data);
            setMessage(message);
            setStatus(statusCode);
        }};
    }

    private static  <T, I extends Integer> Response<T> constructSuccessRequest(String message, I statusCode)
    {
        return new Response<T>() {{
            setMessage(message);
            setStatus(statusCode);
        }};
    }

}
