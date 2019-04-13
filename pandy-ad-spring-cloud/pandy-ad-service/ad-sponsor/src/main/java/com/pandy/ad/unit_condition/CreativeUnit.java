package com.pandy.ad.unit_condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:30
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "creative_unit")
public class CreativeUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "creative_id",nullable = false)
    private Long creativeId;

    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    public CreativeUnit(Long creativeId,Long unitId){
        this.creativeId = creativeId;
        this.unitId = unitId;
    }

}
