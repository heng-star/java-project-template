package com.lvmoney.frame.blockchain.webase.trans.vo;/**
 * 描述:
 * 包名:com.lvmoney.frame.blockchain.webase.trans.vo
 * 版本信息: 版本1.0
 * 日期:2021/6/19
 * Copyright XXXXXX科技有限公司
 */


import com.lvmoney.frame.blockchain.webase.trans.vo.item.TransHandleVoItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/19 19:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransHandleVo implements Serializable {
    private static final long serialVersionUID = 8066730058625623841L;
    private Integer code;
    private String message;
    private TransHandleVoItem data;
}
