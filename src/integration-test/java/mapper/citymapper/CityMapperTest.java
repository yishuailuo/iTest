package mapper.citymapper;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.yishuailuo.iTest.entity.City;
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
@DatabaseSetup("setUp.xml")
public class CityMapperTest {

    @Autowired
    private CityMapper cityMapper;


    @ExpectedDatabase("cityData-add-expected.xml")
    @Test
    public void testAdd_uniqName_addSuccess() throws Exception {

        // given by @DatabaseSetup("setUp.xml")

        // when invoking add
        City city = City.builder().name("sz").area(3).pop(3).build();
        cityMapper.add(city);

        // then asserted by @ExpectedDatabase("cityData-add-expected.xml")
    }
    /*
    @ExpectedDatabase("setUp.xml")
    @Test(expected = DuplicateKeyException.class)
    public void testAdd_duplicateName_throwDuplicateKeyException() throws Exception {

        // given by @DatabaseSetup("setUp.xml")

        // when invoking add
        City city = City.builder().name("bj").area(2).pop(2).build();
        cityMapper.add(city);

        // then asserted by @ExpectedDatabase("setUp.xml") and expected exception
    }*/

    @ExpectedDatabase("cityData-update-expected.xml")
    @Test
    public void testUpdate_entityExists_updateSuccess() throws Exception {

        // given by @DatabaseSetup("setUp.xml")

        // when invoking update
        City city = City.builder().id(2).name("bj").area(3).pop(3).build();
        cityMapper.update(city);

        // then asserted by @ExpectedDatabase("cityData-update-expected.xml")
    }

    @ExpectedDatabase("cityData-delete-expected.xml")
    @Test
    public void testDeleteById_entityExists_deleteSuccess() throws Exception {

        // given by @DatabaseSetup("setUp.xml")

        // when invoking deleteById
        cityMapper.deleteById(2);

        // then asserted by @ExpectedDatabase("cityData-delete-expected.xml")
    }

    @ExpectedDatabase("cityData-get-expected.xml")
    @Test
    public void testGetAll_entityExists_getSuccess() throws Exception {

        // given by @DatabaseSetup("setUp.xml")

        // when invoking getAll
        cityMapper.getAll();

        // then asserted by @ExpectedDatabase("cityData-get-expected.xml")
    }

}
