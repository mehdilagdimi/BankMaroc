package com.bank.service;

import com.bank.model.Agent;
import com.bank.repository.AgentRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AgentServiceImpl implements AgentService
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
}
