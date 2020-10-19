package com.huyang.common.dto;

import com.huyang.common.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应码
 *
 * @author huyang
 * @since 1.0
 */
@Data
@AllArgsConstructor
public class ResponseCode<T> implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    private ResponseCode(StatusEnums responseCode){
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    private ResponseCode(StatusEnums responseCode, T data){
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    private ResponseCode(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 功能描述: 返回成功信息
     * @param: data  信息内容
     * @return: <T>
     * @auther: huyang
     * @date: 2020/10/16 16:31
     */
    public static<T> ResponseCode success(T data){
        return new ResponseCode<>(StatusEnums.SUCCESS, data);
    }

    /**
     * 功能描述: 返回成功信息
     * @return:
     * @auther: huyang
     * @date: 2020/10/16 16:31
     */
    public static<T> ResponseCode success(){
        return new ResponseCode(StatusEnums.SUCCESS);
    }
    
    /**
     * 功能描述: 返回错误信息
     * @param: statusEnums 响应码
     * @return:
     * @auther: huyang
     * @date: 2020/10/16 16:33
     */
    public static ResponseCode error(StatusEnums statusEnums){
        return new ResponseCode(statusEnums);
    }
}
    