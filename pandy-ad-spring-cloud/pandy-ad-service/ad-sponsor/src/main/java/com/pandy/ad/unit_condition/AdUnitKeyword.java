package com.pandy.ad.unit_condition;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: Pandy
 * @Date: 2019/4/13 10:02
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_unit_keyword")
public class AdUnitKeyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;

    @Basic
    @Column(name = "unit_id",nullable = false)
    private Long unitId;

    @Basic
    @Column(name = "keyword",nullable = false)
    private String keyword;

    public AdUnitKeyword(Long unitId,String keyword){
        this.unitId = unitId;
        this.keyword = keyword;
    }
}
