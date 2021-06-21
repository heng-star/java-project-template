package com.lvmoney.frame.blockchain.webase.trans.vo;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.vo
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.blockchain.webase.trans.vo.item.Log;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 19:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HandleWithSignVo implements Serializable {
    private static final long serialVersionUID = -2884814184854499395L;
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
    private String root;
    /**
     *
     */
    private String status;
    /**
     *
     */
    private String from;
    /**
     *
     */
    private String to;
    /**
     *
     */
    private String input;
    /**
     *
     */
    private String output;
    /**
     *
     */
    private String logsBloom;
    /**
     *
     */
    private String gasUsedRaw;
    /**
     *
     */
    private Boolean statusOK;
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

}
