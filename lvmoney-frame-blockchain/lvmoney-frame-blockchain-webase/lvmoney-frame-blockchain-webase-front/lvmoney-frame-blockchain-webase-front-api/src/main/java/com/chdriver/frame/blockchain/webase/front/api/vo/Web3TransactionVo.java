package com.chdriver.frame.blockchain.webase.front.api.vo;/**
 * 描述:
 * 包名:com.chdriver.frame.blockchain.webase.front.api.vo
 * 版本信息: 版本1.0
 * 日期:2021/6/23
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/23 15:15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Web3TransactionVo implements Serializable {
    /**
     *
     */
    private String blockHash;
    /**
     *
     */
    private Long blockNumber;
    /**
     *
     */
    private String from;
    /**
     *
     */
    private String gas;
    /**
     *
     */
    private String hash;
    /**
     *
     */
    private String input;
    /**
     *
     */
    private String nonce;
    /**
     *
     */
    private String to;
    /**
     *
     */
    private String transactionIndex;
    /**
     *
     */
    private String value;
    /**
     *
     */
    private String gasPrice;
    /**
     *
     */
    private String blockLimit;
    /**
     *
     */
    private String chainId;
    /**
     *
     */
    private String groupId;
    /**
     *
     */
    private String extraData;
    /**
     *
     */
    private Signature signature;
}
