import com.CRUDsApp;

import com.entity.Chore;
import com.entity.Student;
import com.services.ChoreRepository;
import com.services.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
public class IntegrationtestApplicationTests {

    @Autowired
    ChoreRepository rm;

    @Autowired
    StudentRepository sm;

    @Test
    public void addStudentTest(){
        Student student= new Student(1L,"A","B",5);
        sm.save(student);
        Assert.assertEquals(1L, sm.count());
    }
    @Test
    public void addChoreTest(){
        Chore chore = new Chore(1L,"Name",14.5,"Details");
        rm.save(chore);
        Assert.assertEquals(1L, rm.count());
    }
    @Test
    public void changeChoreTest(){
        Chore chore = new Chore(2L,"Jan",50.0,"Wojownik");
        rm.save(chore);
        Chore changedChore = new Chore(2L,"Max",10.0,"Rolnik");
        rm.save(changedChore);
        Assert.assertEquals(2L, rm.count());
    }
}