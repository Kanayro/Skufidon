package org.example.dataaccess.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.dataaccess.models.PK.ClientBlockedClientPK;


@Entity
@Table(name = "blockedlist")
public class BlockedList {

    @EmbeddedId
    @JsonIgnore
    private ClientBlockedClientPK clientBlockedClientPK;



    public BlockedList() {
    }

    public BlockedList(ClientBlockedClientPK clientBlockedClientPK) {
        this.clientBlockedClientPK = clientBlockedClientPK;

    }

    public ClientBlockedClientPK getClientBlockedClientPK() {
        return clientBlockedClientPK;
    }

    public void setClientBlockedClientPK(ClientBlockedClientPK clientBlockedClientPK) {
        this.clientBlockedClientPK = clientBlockedClientPK;
    }


}
