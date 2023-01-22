package com.bank.service;

import com.bank.model.Agent;
import com.bank.repository.AgentRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AgentService  {

 Agent saveAgent(Agent agent);
 // Agent getAgent(String username);
 List<Agent> getAgents();


}
