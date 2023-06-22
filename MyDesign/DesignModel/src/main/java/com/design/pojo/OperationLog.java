package com.design.pojo;

/**
 * @author yuanyuan
 * @version V1.0
 * @date 2023/6/22 15:29
 * @Description null
 */

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yuanyuan
 * @version V1.0
 * @Description 日志记录类
 */
@Data
public class OperationLog implements Serializable {
    private static final long serialVersionUID = 1L;
    String model;
    String  type;
    String  description;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDateTime operationTime;
    //操作用户
    Integer userId;
    //操作IP
    String    ip;
    //返回值信息
    String result;
}
