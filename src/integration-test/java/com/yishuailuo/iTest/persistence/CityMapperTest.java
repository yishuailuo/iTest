package com.yishuailuo.iTest.persistence;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.yishuailuo.iTest.mapper.CityMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

/**
 * Created by luoyishuai on 17/7/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("integration-test")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class}
)
@ContextConfiguration(locations = "classpath:applicationContext-persistenceTest.xml")
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;

    @DatabaseSetup("classpath:setUp.xml")
    @Test
    public void test() throws Exception {
        System.out.println(cityMapper.getAll());
    }
}
