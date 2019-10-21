import com.CRUDsApp;
import com.entity.Student;
import com.services.StudentRepository;
import org.junit.*;
import com.services.StudentRepositoryService;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdateTest {

    @Autowired
    StudentRepositoryService sr;

    @Before
    public void initialize() {
        sr.createStudent("Adam", "Nowak", 22, "email");
    }

    @Test
    public void aUpdateStudentTest() {
        Assert.assertEquals(1,sr.updateStudent(1L,"Wojciech","Kowalski",21, "gmail"));
    }

    @Test
    public void bUpdateStudentTest() {
        Assert.assertEquals(1,sr.updateStudent(2L,"","",0, ""));
    }

    @Test
    public void cUpdateStudentTest() {
        Assert.assertEquals(0,sr.updateStudent(3L,null,"Kowalski",21, "gmail"));
    }

    @Test
    public void dUpdateStudentTest() {
        Assert.assertEquals(0,sr.updateStudent(4L,"Wojciech",null,21 , "gmail"));
    }

    @Test
    public void eUpdateStudentTest() {
        Assert.assertEquals(0,sr.updateStudent(5L,"Wojciech","Kowalski",null , "gmail"));
    }

    @Test
    public void fUpdateStudentTest() {
        Assert.assertEquals(0,sr.updateStudent(6L,"Wojciech","Kowalski",21, null));
    }

    @Test
    public void gUpdateStudentTest() {
        Assert.assertEquals(0,sr.updateStudent(33L,"Wojciech","Kowalski",21, "gmail"));
    }
}
