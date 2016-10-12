package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chenyigang
 */
public interface SeckillDao {
    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询对象
     *
     * @param seckillId
     * @return
     */
    Seckill queryById(@Param("seckillId") long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程秒杀
     * @param map
     */
    void killByProcedure(Map<String, Object> map);
}
