package com.chdriver.frame.blockchain.webase.front.api.surface;/**
 * 描述:
 * 包名:com.chdriver.frame.blockchain.webase.front.api.surface
 * 版本信息: 版本1.0
 * 日期:2021/6/23
 * Copyright XXXXXX科技有限公司
 */


import com.chdriver.frame.blockchain.webase.front.api.ao.PrivateKeyAo;
import com.chdriver.frame.blockchain.webase.front.api.constant.FrontConstant;
import com.chdriver.frame.blockchain.webase.front.api.vo.PrivateKeyVo;
import com.chdriver.frame.blockchain.webase.front.api.vo.Web3TransactionVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describe：
 * @author: lvmoney/XXXXXX科技有限公司
 * @version:v1.0 2021/6/23 15:02
 */
public interface IFront {

    /**
     * 1、会在webasesign库tb_user表中生成用户数据
     * 2、在webase管理页面私钥管理模块无法查看到用户信息
     * 3、若想在webase管理页面私钥管理页面查看用户信息需将对应数据拷贝到webbasenodemanager库表tb_user中(节点管理接口：http://192.168.0.35:5001/WeBASE-Node-Manager/user/userInfo能完成该操作，但是该操作需用用户登录（必须图形验证码校验）获得token，通过接口直接获得token难完成)，通过自定义接口操作数据库表复制数据即可
     * 4、完成3的操作后可在私钥管理模块查看用户信息也可以在交易信息模块 from处查看到对应的signUserId
     *
     * @param appId:appId
     * @param signUserId:signUserId
     * @param type:0-本地用户；1-本地随机；2-外部用户
     * @param userName:用户名
     * @param returnPrivateKey:是否返回私钥，true:返回，false：不返回
     * @throws
     * @return: com.chdriver.frame.blockchain.webase.front.api.vo.PrivateKeyVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/23 17:49
     */
    @GetMapping(value = FrontConstant.URL_FRONT_PRIVATE_KEY, headers = {"content-type=application/x-www-form-urlencoded"})
    PrivateKeyVo privateKey(@RequestParam("appId") String appId, @RequestParam("signUserId") String signUserId, @RequestParam("type") int type, @RequestParam("userName") String userName, @RequestParam("returnPrivateKey") boolean returnPrivateKey);

    /**
     * 根据交易hash获取交易信息
     *
     * @param groupId:
     * @param transHash:
     * @throws
     * @return: com.chdriver.frame.blockchain.webase.front.api.vo.Web3TransactionVo
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/23 15:53
     */
    @GetMapping(value = FrontConstant.URL_FRONT_WEB3_TRANSACTION)
    Web3TransactionVo web3Transaction(@PathVariable("groupId") int groupId, @PathVariable("transHash") String transHash);
}
