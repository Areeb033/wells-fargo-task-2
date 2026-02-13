package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;
        @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;
    @Column(nullable = false)
    private String createdAt;
    @OneToMany(mappedBy = "portfolio")
    private List<Holding> holdings;
    protected Portfolio() {
    }
    public Portfolio(Client client, String createdAt, List<Holding> holdings) {
        this.client = client;
        this.createdAt = createdAt;
        this.holdings = holdings;
    }
    public long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Holding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<Holding> holdings) {
        this.holdings = holdings;
    }
}