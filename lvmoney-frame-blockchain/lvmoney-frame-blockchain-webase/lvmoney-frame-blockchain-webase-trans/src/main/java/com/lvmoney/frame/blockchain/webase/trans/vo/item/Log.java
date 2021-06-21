package com.lvmoney.frame.blockchain.webase.trans.vo.item;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.vo.item
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 19:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log implements Serializable {
    private static final long serialVersionUID = 4759815214869431531L;
    /**
     *
     */
    private Boolean removed;
    /**
     *
     */
    private String logIndex;
    /**
     *
     */
    private String transactionIndex;
    /**
     *
     */
    private String transactionHash;
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
    private String address;
    /**
     *
     */
    private String data;
    /**
     *
     */
    private String type;
    /**
     *
     */
    private List<String> topics;
    /**
     *
     */
    private String logIndexRaw;
    /**
     *
     */
    private String blockNumberRaw;
    /**
     *
     */
    private String transactionIndexRaw;


}
