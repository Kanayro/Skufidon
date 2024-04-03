package org.example.dataaccess.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.dataaccess.models.PK.ClientPairClientPK;

@Entity
@Table(name = "pairusers")
public class PairUsers {

    @EmbeddedId
    @JsonIgnore
    private ClientPairClientPK clientPairClientPK;


    public PairUsers() {
    }

    public PairUsers(ClientPairClientPK clientPairClientPK) {
        this.clientPairClientPK = clientPairClientPK;
    }

    public ClientPairClientPK getClientPairClientPK() {
        return clientPairClientPK;
    }

    public void setClientPairClientPK(ClientPairClientPK clientPairClientPK) {
        this.clientPairClientPK = clientPairClientPK;
    }
}
