package authentication;

/**
 * authentication 认证测试
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthenticationTest {

    @Test
    public void testLongAndLogOut(){
        //创建shiro运行环境,通过ini的配置文件创建securityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-first.ini");
        //获取securityManager
        SecurityManager securityManager = factory.getInstance();
        //将securitymanager注入环境
        SecurityUtils.setSecurityManager(securityManager);
        //设置登录令牌token
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","1111111");
        //获取subject主体
        Subject subject = SecurityUtils.getSubject();
        try {
            //主体调用认证
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        //认证是否通过
        boolean authenticated = subject.isAuthenticated();
        if(authenticated){
            System.out.println("认证通过");
        }else{
            System.out.println("认证失败");

        }
    }
}
