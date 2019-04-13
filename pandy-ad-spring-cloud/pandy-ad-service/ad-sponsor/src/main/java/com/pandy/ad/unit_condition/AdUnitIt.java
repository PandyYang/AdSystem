package com.pandy.ad.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:06
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit_it")
public class AdUnitIt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "ti_tag",nullable = false)
    private String itTag;

    public AdUnitIt(Long unitId,String itTag){
        this.unitId = unitId;
        this.itTag = itTag;
    }
}
