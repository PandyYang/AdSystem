package com.pandy.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 11:39
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    public boolean createValidate(){
        return userId !=null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate)
                && !StringUtils.isEmpty(endDate);
    }

    public boolean updateValidate(){
        return id != null && userId != null;
    }

    public boolean deleteValidate(){
        return id != null && userId != null;
    }
}
