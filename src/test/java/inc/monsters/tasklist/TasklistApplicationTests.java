package inc.monsters.tasklist;

import inc.monsters.tasklist.controller.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TasklistApplicationTests {
    @Autowired
    HomePage homepage;
    
    @Test
    void contextLoads() {
        Assertions.assertThat(homepage).isNotNull();
    }

}
