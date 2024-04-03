package org.example.dataaccess.models.PK;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.dataaccess.models.Client;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientBlockedClientPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client blockedClient;



    public ClientBlockedClientPK() {
    }

    public ClientBlockedClientPK(Client client, Client blockedClient) {
        this.client = client;
        this.blockedClient = blockedClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getBlockedClient(){
        return blockedClient;
    }



    public void setBlockedClient(Client blockedClient) {
        this.blockedClient = blockedClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientBlockedClientPK that = (ClientBlockedClientPK) o;
        return Objects.equals(client, that.client) && Objects.equals(blockedClient, that.blockedClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, blockedClient);
    }
}
