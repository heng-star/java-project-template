package com.lvmoney.frame.sync.canal.common.annotation.ddl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lvmoney.frame.sync.canal.common.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @describe：重命名表
 * @author: lvmoney /成都三合力通科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.RENAME)
public @interface RenameTableListenPoint {

    /**
     * canal 指令
     * default for all
     */
    @AliasFor(annotation = ListenPoint.class)
    String destination() default "";

    /**
     * 数据库实例
     */
    @AliasFor(annotation = ListenPoint.class)
    String[] schema() default {};
}
