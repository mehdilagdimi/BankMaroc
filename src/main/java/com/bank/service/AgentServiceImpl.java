package com.bank.service;

import com.bank.model.Agent;
import com.bank.model.UserRole;
import com.bank.repository.AgentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AgentServiceImpl implements AgentService, UserDetailsService
{
    private final AgentRepo agentRepo;

    @Override
    public Agent saveAgent(Agent agent) {
        log.info("agent is saving ...");
        return agentRepo.save(agent);
    }

    @Override
    public Agent getAgent(String username) {
        log.info("fetching agent {}",username);
        return agentRepo.findByUsername(username);
    }

    @Override
    public List<Agent> getAgents() {
        log.info("fetching all agents");
        return agentRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Agent agent = agentRepo.findByUsername(username);
       if(agent == null){
           log.error("Agent not found......");
           throw new UsernameNotFoundException("Agent not found......");
       } else {
           log.info("Agent {} found in DB....", username);
       }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
       authorities.add(new SimpleGrantedAuthority(UserRole.AGENT.name()));
        return new org.springframework.security.core.userdetails.User(agent.getUsername(),agent.getPassword(), authorities);
    }
}
