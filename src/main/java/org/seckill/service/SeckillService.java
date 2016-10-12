package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * @author chenyigang
 *         业务接口：站在“使用者”的角度设计接口
 *         三个方面：方法定义粒度、参数（简练）、返回类型（return 类型/异常）
 */
public interface SeckillService {
    /**
     * 获取秒杀列表
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 根据id查询秒杀商品单
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 暴露秒杀链接
     *
     * @param seckillId
     * @return
     */
    Exposer exposeSeckillUrl(long seckillId);

    /**
     * 执行秒杀
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws org.seckill.exception.RepeatKillException
     * @throws SeckillCloseException
     */
    SeckillExecution excuteSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

    SeckillExecution excuteSeckillProcedure(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;

}
