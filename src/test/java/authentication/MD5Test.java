package authentication;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {

    public static void main(String[] args) {
        Md5Hash md5 = new Md5Hash("111111","aaa",1);
        System.out.println(md5.toString());

        Md5Hash md5Hash = new Md5Hash("111111","aaa",2);
        System.out.println(md5Hash.toString());

        SimpleHash simpleHash = new SimpleHash("md5","111111","aaa",2);
        System.out.println(simpleHash.toString());
        /*
        f51775f5ed43dc50a7488567bb234541
        94519953fb11a7bad9f50172f03b225a

         */
    }
}
