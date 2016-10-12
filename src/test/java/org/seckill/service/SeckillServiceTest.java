package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @Test
    public void testGetSeckillList() throws Exception {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}", seckillList);
    }

    @Test
    public void testGetById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    //@Test
    //public void testExposeSeckillUrl() throws Exception {
    //    Exposer exposer = seckillService.exposeSeckillUrl(1000L);
    //    logger.info("exposer:" + exposer);
    //    /**
    //     * exposer:Exposer
    //     * {exposed=true,
    //     * md5='026d3fa8a8dff2cbb3392bb22a5ed71b',
    //     * seckillId=1000, now=0, start=0, end=0}
    //     */
    //}
    //
    //@Test
    //public void testExcuteSeckill() throws Exception {
    //    long seckillId = 1000L;
    //    long userPhone = 18882342341L;
    //    String md5 = "026d3fa8a8dff2cbb3392bb22a5ed71b";
    //    try {
    //        SeckillExecution seckillExecution = seckillService.excuteSeckill(seckillId, userPhone, md5);
    //        logger.info("seckillExecution=" + seckillExecution);
    //    } catch (SeckillCloseException e) {
    //        logger.error(e.getMessage());
    //    } catch (RepeatKillException e) {
    //        logger.error(e.getMessage());
    //    }
    //
    //}

    @Test
    public void testSeckillLogic() throws Exception {
        long id = 1000L;
        Exposer exposer = seckillService.exposeSeckillUrl(id);
        if (exposer.isExposed()) {
            logger.info("exposer: " + exposer);
            long phoneNumber = 13574678323L;
            String md5 = exposer.getMd5();

            try {
                SeckillExecution seckillExecution = seckillService.excuteSeckill(id, phoneNumber, md5);
                logger.info("seckillExecution:" + seckillExecution);
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            logger.info("exposer: " + exposer);
        }
    }


}