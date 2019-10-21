import com.CRUDsApp;
import com.entity.Student;
import com.services.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
public class UpdateTest {
    @Autowired
    StudentRepository sr;

    @Test
    public void addStudentTest() {
        Student student = new Student(1L,"Dominik", "Michalak", 22, "abc@gnail.com");
        sr.save(student);
        Assert.assertEquals(sr.count(), 1L);
    }
}
