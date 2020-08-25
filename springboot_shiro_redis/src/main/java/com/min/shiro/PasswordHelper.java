package com.min.shiro;

import com.min.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Auther: cpb
 * @Date: 2018/8/10 10:57
 * @Description:
 */
public class PasswordHelper {

    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    public void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,//加密算法
                user.getPassword(),//密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//盐值 username+salt
                hashIterations//hash次数
        ).toHex();

        user.setPassword(newPassword);
    }

    public static void main(String[] args) {
        String newPassword = new SimpleHash(
                "md5",//加密算法
                "123456",//密码
                ByteSource.Util.bytes("min234"),//盐值 username+salt
                2
        ).toHex();
        System.out.println(newPassword);
    }
}
