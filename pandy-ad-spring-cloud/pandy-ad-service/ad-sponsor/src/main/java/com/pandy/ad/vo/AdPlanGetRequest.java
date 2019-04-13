package com.pandy.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:46
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanGetRequest {

    private Long userId;
    private List<Long> ids;

    public boolean validate(){
        return userId != null && !CollectionUtils.isEmpty(ids);
    }
}
