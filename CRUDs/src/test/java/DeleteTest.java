import com.CRUDsApp;
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
public class DeleteTest {

    @Autowired
    StudentRepository rs;

    @Autowired
    StudentRepositoryService rss;

    @Test
    public void aRemoveOnlyStudentTest() {
        rss.createStudent("Marcin", "Zbożowski", 25, "mar@gnail.com");
        Assert.assertEquals(1,rss.deleteStudent(1L));
        long expected = 0L;
        Assert.assertEquals(expected, rs.count());
    }
    @Test
    public void bRemoveMiddleStudentTest() {
        rss.createStudent("Arkadiusz", "Smoliński", 21, "ars@gnail.com");
        rss.createStudent("Mateusz", "Michalak", 21, "mam@gnail.com");
        rss.createStudent("Arkadiusz", "Ciupa", 32, "arc@gnail.com");
        Assert.assertEquals(3L, rs.count());
        Assert.assertEquals(1,rss.deleteStudent(2L));
        Assert.assertEquals(2L, rs.count());
        Assert.assertEquals(1,rss.deleteStudent(3L));
        Assert.assertEquals(1,rss.deleteStudent(4L));
        Assert.assertEquals(0L, rs.count());
    }

    @Test
    public void cRemoveWithoutStudentTest() {
        Assert.assertEquals(0L, rs.count());
        int result = rss.deleteStudent(1L);
        Assert.assertEquals(0, result);
    }

    @Test
    public void dRemoveBadIndexTest() {
        rss.createStudent("Arkadiusz", "Smoliński", 21, "ars@gnail.com");
        Assert.assertEquals(1L, rs.count());
        int result = rss.deleteStudent(2L);
        Assert.assertEquals(0, result);
        Assert.assertEquals(1L, rs.count());
        Assert.assertEquals(1,rss.deleteStudent(5L));
        Assert.assertEquals(0L, rs.count());
    }
    @Test
    public void eRemoveBigList() {
        rss.createStudent("Arkadiusz", "Smoliński", 21, "ars@gnail.com");
        rss.createStudent("Mateusz", "Michalak", 21, "mam@gnail.com");
        rss.createStudent("Arkadiusz", "Ciupa", 32, "arc@gnail.com");
        rss.createStudent("Erkadiusz", "Smoliński", 21, "ars@gnail.com");
        rss.createStudent("Cateusz", "Michalak", 21, "mam@gnail.com");
        rss.createStudent("Barkadiusz", "Ciupa", 32, "arc@gnail.com");
        rss.createStudent("Harkadiusz", "Smoliński", 21, "ars@gnail.com");
        rss.createStudent("Bateusz", "Michalak", 21, "mam@gnail.com");
        rss.createStudent("Urkadiusz", "Ciupa", 32, "arc@gnail.com");
        Assert.assertEquals(9L, rs.count());
        for(long i = 6L; i < 15L; i++) {
            rss.deleteStudent(i);
        }
        Assert.assertEquals(0L, rs.count());
    }
}