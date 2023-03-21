package org.carbonPool;




import org.carbonPool.service.carbonPool.*;

import org.carbonPool.service.*;
import org.carbonPool.service.user.loginService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
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






















}
