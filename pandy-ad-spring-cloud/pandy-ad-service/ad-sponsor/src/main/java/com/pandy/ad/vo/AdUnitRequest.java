package com.pandy.ad.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 16:23
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitRequest {
    private Long planId;
    private String unitName;

    private Integer positionType;
    private Long budget;

    public boolean createValidate(){
        return planId != null && !StringUtils.isEmpty(unitName)
                && positionType != null && budget != null;
    }


}
