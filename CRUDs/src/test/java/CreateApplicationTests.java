import com.CRUDsApp;
import com.entity.Student;
import com.services.StudentRepository;
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

public class CreateApplicationTests {

    @Autowired
    StudentRepositoryService rss;

    @Test
    public void aCreateOneStudentTest() {
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

}