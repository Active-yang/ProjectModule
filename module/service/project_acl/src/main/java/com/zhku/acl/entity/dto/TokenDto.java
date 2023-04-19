package com.zhku.acl.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author WZX
 * @since 2022-10-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String token;
    private Long expiration;
}
