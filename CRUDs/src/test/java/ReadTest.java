import com.CRUDsApp;
import com.services.StudentRepositoryService;
import org.junit.*;
import org.junit.runner.RunWith;
import com.entity.Student;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReadTest {

    @Autowired
    StudentRepositoryService rss;

    @Before
    public void initialize() {
        rss.createStudent("Dominik", "Michalak", 22, "email");
        rss.createStudent("Jan", "Kowalski", 25, "email2");
        rss.createStudent("Jacek", "Buk", 28, "email3");
        rss.createStudent("Janina", "Chrzanowicz", 19, "email4");
        rss.createStudent("Mirosław", "Bojkot", 35, "email5");
    }

    @Test
    public void aReadFirstStudentTest() {
        Student result = rss.readStudent(1L);
        Student student = new Student(1L, "Dominik", "Michalak", 22, "email");
        Assert.assertEquals(result, student);
        rss.deleteStudent(6L);
    }

    @Test
    public void bReadSecondStudentTest() {
        Student result = rss.readStudent(2L);
        Student student = new Student(2L, "Jan", "Kowalski", 25, "email2");
        Assert.assertEquals(result, student);
        rss.deleteStudent(6L);
    }

    @Test
    public void cReadThirdStudentTest() {
        Student result = rss.readStudent(3L);
        Student student = new Student(3L, "Jacek", "Buk", 28, "email3");
        Assert.assertEquals(result, student);
        rss.deleteStudent(6L);
    }

    @Test
    public void dReadNullTest() {
        Student result = rss.readStudent(6L);
        Assert.assertEquals(result, null);
    }

    @Test
    public void eReadHundredthStudentTest() {
        for (int i = 0; i < 100; i++) {
            rss.createStudent("Name", "Surname", 99, "email");
        }
        Student result = rss.readStudent(106L);
        Student student = new Student(106L, "Name", "Surname", 99, "email");
        Assert.assertEquals(result, student);
        for(long i = 5L; i <= 106L; i++) {
            rss.deleteStudent(i);
        }
    }

    @Test
    public void fReadThousandthStudentTest() {
        for (int i = 0; i < 1000; i++) {
            rss.createStudent("Name", "Surname", 99, "email");
        }
        Student result = rss.readStudent(1006L);
        Student student = new Student(1006L, "Name", "Surname", 99, "email");
        Assert.assertEquals(result, student);
        for(long i = 5L; i <= 1006L; i++) {
            rss.deleteStudent(i);
        }
    }
}