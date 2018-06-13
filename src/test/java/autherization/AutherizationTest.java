package autherization;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AutherizationTest {

    @Test
    public void testAutherization(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("calsspath:shiro-permission.ini");
        SecurityManager securityanager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityanager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("认证情况："+subject.isAuthenticated());

        subject.hasRole("role1");
        subject.isPermitted("user:creat");
    }
}
