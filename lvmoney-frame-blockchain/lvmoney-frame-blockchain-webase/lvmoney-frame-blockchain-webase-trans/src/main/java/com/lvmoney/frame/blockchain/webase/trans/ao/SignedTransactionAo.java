package com.lvmoney.frame.blockchain.webase.trans.ao;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.ao
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
 * @version:v1.0 2021/6/19 20:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignedTransactionAo implements Serializable {
    private static final long serialVersionUID = 5725358415271175206L;
    /**
     * 已签名字符串
     */
    private String signedStr;
    /**
     * 是否同步发送
     */
    private Boolean sync;
    /**
     * 群组ID
     */
    private Integer groupId;

}
