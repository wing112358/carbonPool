package org.carbonPool;




import org.carbonPool.service.carbonPool.*;

import org.carbonPool.service.*;
import org.carbonPool.service.user.loginService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    /**
     * 重写服务
     */

    @Autowired
    public loginService loginservice;

    @Autowired
    public projectWorkService projectWorkService;

    @Autowired
    public entrustWorkService entrustWorkService;

    @Autowired
    public equityWorkService equityWorkService;

    @Autowired
    public assetWorkService assetWorkService;

    @Autowired
    public transactionWorkService transactionWorkService;


    //引用数据方法
    @Resource
    public ProjectService projectService;

    @Resource
    public AssetsService assetsService;

    @Resource
    public AssetsEquityService assetsEquityService;

    @Resource
    public DemandService demandService;

    @Resource
    public EntrustService entrustService;

    @Resource
    public EntrustDataService entrustDataService;

    @Resource
    public EquityService equityService;

    @Resource
    public TransactionService transactionService;

    @Resource
    public TransactionAssetsService transactionAssetsService;

    @Resource
    public TransactionPriceService transactionPriceService;




















//
//    @Resource
//    public AssetsDao assetsDao=sqlSession.getMapper(AssetsDao.class);
//    @Resource
//    public AssetsEquityDao assetsEquityDao=sqlSession.getMapper(AssetsEquityDao.class);
//    @Resource
//    public DemandDao demandDao=sqlSession.getMapper(DemandDao.class);
//    @Resource
//    public EntrustDao entrustDao=sqlSession.getMapper(EntrustDao.class);
//    @Resource
//    public EntrustDataDao entrustDataDao=sqlSession.getMapper(EntrustDataDao.class);
//    @Resource
//    public EquityDao equityDao=sqlSession.getMapper(EquityDao.class);
//
//    @Resource
//    public ProjectDao projectDao=sqlSession.getMapper(ProjectDao.class);
//    @Resource
//    public TransactionDao transactionDao=sqlSession.getMapper(TransactionDao.class);
//    @Resource
//    public TransactionAssetsDao transactionAssetsDao=sqlSession.getMapper(TransactionAssetsDao.class);
//    @Resource
//    public TransactionPriceDao transactionPriceDao=sqlSession.getMapper(TransactionPriceDao.class);







}
