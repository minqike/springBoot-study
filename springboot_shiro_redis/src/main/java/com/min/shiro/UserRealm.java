package com.min.shiro;

import com.min.entity.User;
import com.min.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Auther: cpb
 * @Date: 2018/8/10 10:36
 * @Description:
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    @Lazy
    private UserService userService;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        User user = (User) principals.getPrimaryPrincipal();


        Set<String> role= userService.findRoles(user.getUsername()); //获取用户角色
        //获取用户权限.这里直接根据用户名来去权限,最好的是根据角色来循环取权限
        Set<String> permission= userService.findPermissions(user.getUsername());
        System.out.println(permission);
        //将用户角色和权限放入SimpleAuthorizationInfo对象时.需要使用set类型,list转换一下.
        //userService应该可以直接用set对象来接受的吧?
//        Set<String> role = new HashSet<>();
//        Set<String> permission = new HashSet<>(permissionList.size());
//
//        role.addAll(roleList);
//        permission.addAll(permissionList);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(role);
        authorizationInfo.setStringPermissions(permission);

        return authorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        String username=usernamePasswordToken.getUsername();
        System.out.println("token="+token);
        System.out.println("username="+username);
//        String username = (String)token.getPrincipal();
//        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByName(username);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if(Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户对象
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
