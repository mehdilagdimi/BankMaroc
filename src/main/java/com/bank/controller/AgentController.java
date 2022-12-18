package com.bank.controller;

import com.bank.model.Agent;
import com.bank.service.AgentService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class AgentController {
    private final AgentService agentService;

    @GetMapping("/agents")
    public ResponseEntity<List<Agent>> getAgents(){
        return ResponseEntity.ok().body(agentService.getAgents());
    }


    @PostMapping("/agent/save")
    public ResponseEntity<Agent> saveAgent(@RequestBody Agent agent){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/agent/save").toUriString());
        return ResponseEntity.created(uri).body(agentService.saveAgent(agent));
    }

}
