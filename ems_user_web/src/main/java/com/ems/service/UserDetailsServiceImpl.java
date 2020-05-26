package com.ems.service;

import com.ems.pojo.Staff;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserDetailsService
 * @Description: TODO
 * @Autor:13528
 * @Date: 2020/3/17 19:16
 * @Version 1.0
 **/
public class UserDetailsServiceImpl implements UserDetailsService {

    private StaffService staffService;
    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("经过了UserDetailsServiceImpl");
        //构建角色列表
        List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
        //从username中获取员工id
        Integer id = Integer.valueOf(username.substring(6));
        //System.out.println("id:"+id);
        //得到员工对象
        Staff staff = staffService.findOne(id);
        System.out.println("controller: "+staff);
        if(staff != null){
            return new User(username,staff.getPassword(),grantedAuths);
        }else {
            return null;
        }
    }
}
