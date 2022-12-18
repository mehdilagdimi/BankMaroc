package com.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @SequenceGenerator(name = "confirmation_token_sequence", sequenceName = "confirmation_token_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confirmation_token_sequence")

    private Long id;
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = true,name = "user_id")
    private Agent agent;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,Agent agent) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.agent = agent;
    }
    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,Client client) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.client = client;
    }
}
