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
 * @version:v1.0 2021/6/19 19:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransHandleVoItem implements Serializable {
    private static final long serialVersionUID = 3290689754385195727L;
    /**
     *
     */
    private String transactionHash;
    /**
     *
     */
    private Integer transactionIndex;
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
    private Long gasUsed;
    /**
     *
     */
    private String contractAddress;
    /**
     *
     */
    private String gasUsedRaw;
    /**
     *
     */
    private String blockNumberRaw;
    /**
     *
     */
    private String transactionIndexRaw;
    /**
     *
     */
    private List<Log> logs;
    /**
     *
     */
    private Long cumulativeGasUsed;
    /**
     *
     */
    private String cumulativeGasUsedRaw;
}
