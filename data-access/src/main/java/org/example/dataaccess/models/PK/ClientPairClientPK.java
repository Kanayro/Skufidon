package org.example.dataaccess.models.PK;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.dataaccess.models.Client;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientPairClientPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "client_id",insertable = false,updatable = false)
    private Client pairClient;


    public ClientPairClientPK() {
    }

    public ClientPairClientPK(Client client, Client pairClient) {
        this.client = client;
        this.pairClient = pairClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getPairClient() {
        return pairClient;
    }

    public void setPairClient(Client pairClient) {
        this.pairClient = pairClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPairClientPK that = (ClientPairClientPK) o;
        return Objects.equals(client, that.client) && Objects.equals(pairClient, that.pairClient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client, pairClient);
    }
}
