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
 * @version:v1.0 2021/6/19 20:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignMessageHashAo implements Serializable {
    /**
     * 用户地址	 用户地址，可通过/privateKey接口创建
     */
    private String user;
    /**
     * Hash值
     */
    private String hash;
}
