import com.CRUDsApp;
import com.services.StudentRepositoryService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class CreateTests {

    @Autowired
    StudentRepositoryService rss;

    @Test
    public void aAddOneStudentTest() {
        int result = rss.createStudent("Dominik", "Michalak", 22, "email");
        Assert.assertEquals(result, 1);
        Assert.assertEquals(rss.countObject(), 1L);
    }

    @Test
    public void bAddOneStudentButNameIsNullTest() {
        int result = rss.createStudent(null, "Michał", 12, "email@gnail.com");
        Assert.assertEquals(result, 0);
        Assert.assertEquals(rss.countObject(), 1L);
    }

    @Test
    public void cAddOneStudentButSurnameIsNullTest() {
        int result = rss.createStudent("Mateusz", null, 32, "email@onet.com");
        Assert.assertEquals(result, 0);
        Assert.assertEquals(rss.countObject(), 1L);
    }

    @Test
    public void dAddOneStudentButAgeIsNullTest() {
        int result = rss.createStudent("Michał", "Michalak", null, "Konrad@gnail.com");
        Assert.assertEquals(result, 0);
        Assert.assertEquals(rss.countObject(), 1L);
    }

    @Test
    public void eAddOneStudentButEmailIsNullTest() {
        int result = rss.createStudent("Konrad", "Michalak", 12, null);
        Assert.assertEquals(result, 0);
        Assert.assertEquals(rss.countObject(), 1L);
    }

    @Test
    public void fAddHundredStudentsTest() {
        for(int i = 0; i < 100; i++) {
            rss.createStudent("Name", "Surname", 99, "email");
        }

        Assert.assertEquals(rss.countObject(), 101L);
    }

    @Test
    public void gAddThousandStudentsTest() {
        for(int i = 0; i < 1000; i++) {
            rss.createStudent("Name", "Surname", 99, "email");
        }

        Assert.assertEquals(rss.countObject(), 1101L);
    }

}