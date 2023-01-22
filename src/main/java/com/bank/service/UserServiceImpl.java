package com.bank.service;


import com.bank.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserServiceImpl implements UserDetailsService {


    @Autowired
    private ClientServiceImpl clientService;
    @Autowired
    private AgentServiceImpl agentService;


    @Override
    public User loadUserByUsername(String emailAndRole) throws UsernameNotFoundException {
        User user = null;
        System.out.println(" email and role " + emailAndRole);
        final String email = emailAndRole.split(":")[0];
        final String userRole = emailAndRole.split(":")[1];

        if("CLIENT".equals(userRole)){
            System.out.println(" inside load by user name client");
            user = clientService.loadUserByEmail(email);
        } else if("AGENT".equals(userRole)){
            System.out.println(" inside load by user name agent");
            user = agentService.loadUserByEmail(email);
        }
        return user;
    }


}
