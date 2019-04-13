package com.pandy.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:18
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;

    public boolean validate(){
        return StringUtils.isEmpty(username);
    }
}
