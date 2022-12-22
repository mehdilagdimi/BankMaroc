package com.bank.service;

import com.bank.model.Agent;
import com.bank.model.ConfirmationToken;
import com.bank.model.User;
import com.bank.repository.AgentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
@Primary
public class AgentServiceImpl implements AgentService {
    private final AgentRepo agentRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public Agent saveAgent(Agent agent) {
        log.info("agent is saving ...");
        return agentRepo.save(agent);
    }


    @Override
    public List<Agent> getAgents() {
        log.info("fetching all agents");
        return agentRepo.findAll();
    }


    public User loadUserByEmail(String email) throws UsernameNotFoundException {
//        Optional<Agent> agent = agentRepo.findByUsername(username);
        return agentRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Agent not found......"));
    }

    public String signUpUser(Agent agent){
        boolean userExists = agentRepo.findByUsername(agent.getUsername()).isPresent();
        if(userExists) {
            throw new IllegalStateException("username is already used");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(agent.getPassword());
        agent.setPassword(encodedPassword);
        agentRepo.save(agent);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(3), agent);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return "the token is : "+token;
    }
}
