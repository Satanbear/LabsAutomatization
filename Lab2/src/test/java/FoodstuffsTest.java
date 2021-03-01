import test.DAO.DAOFoodStuffs;
import config.DBUnitConfig;
import test.model.Foodstuffs;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import java.util.List;

public class FoodstuffsTest extends DBUnitConfig {

    private final DAOFoodStuffs service = new DAOFoodStuffs();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("foodStuffsData/foodstuffsData.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public FoodstuffsTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Foodstuffs> foodstuffs = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("foodStuffsData/foodstuffsDataExpected.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("foodstuffs").getRowCount(),foodstuffs.size());
        getTearDownOperation();
    }

    @Test
    public void testGetAllFromView() throws Exception {
        List<Foodstuffs> foodstuffs = service.getAllFromView();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("foodStuffsData/foodstuffsDataExpected.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("productdetails").getRowCount(),foodstuffs.size());
        getTearDownOperation();
    }

    @Test
    public void testGetExpiredProducts() throws Exception {
        List<Foodstuffs> foodstuffs = service.getExpiredProducts();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("foodStuffsData/foodstuffsDataExpected.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("expiredproducts").getRowCount(),foodstuffs.size());
        getTearDownOperation();
    }
}
