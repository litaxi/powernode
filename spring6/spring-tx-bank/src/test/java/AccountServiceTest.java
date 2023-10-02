import com.powernode.bank.config.Spring6config;
import com.powernode.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author wataxi @Date 2023/9/27 17:50 @Version 1.0
 */
public class AccountServiceTest {

  @Test
  public void testTransfer() {
    ApplicationContext context = new AnnotationConfigApplicationContext(Spring6config.class);
    AccountService accountService = context.getBean("accountService", AccountService.class);
    try {
      accountService.transfer("act-001", "act-002", 10000);
      System.out.println("转账成功");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
