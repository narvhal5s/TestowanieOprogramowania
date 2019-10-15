import com.CRUDsApp;
import com.entity.Chore;
import com.services.ChoreRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CRUDsApp.class)
public class IntegrationtestApplicationTests {

    @Autowired
    ChoreRepository rm;

    @Test
    public void addChoreTest(){
        Chore chore = new Chore(1L,"Name",14.5,"Details");
        rm.save(chore);
        Assert.assertEquals(rm.count(),1L);
    }
}