package com.zhku.acl.entity.dto;

import lombok.Data;

/**
 * @author WZX
 * @since 2022-10-26
 */
@Data
public class ResultDto {
    private String code;
    private String message;
    private TokenDto data;
}
