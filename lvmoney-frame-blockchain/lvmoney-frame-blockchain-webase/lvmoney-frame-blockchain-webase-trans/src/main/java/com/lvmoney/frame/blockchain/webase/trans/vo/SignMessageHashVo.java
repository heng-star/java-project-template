package com.lvmoney.frame.blockchain.webase.trans.vo;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.vo
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 20:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignMessageHashVo implements Serializable {
    private static final long serialVersionUID = -6420244141532093L;
    /**
     *
     */
    private String v;
    /**
     *
     */
    private String r;
    /**
     *
     */
    private String s;
    /**
     *
     */
    private String p;


}
