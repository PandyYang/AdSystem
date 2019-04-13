package com.pandy.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:19
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private Long userId;
    private String username;
    private String token;
    private Date createTime;
    private Date updateTime;
}
