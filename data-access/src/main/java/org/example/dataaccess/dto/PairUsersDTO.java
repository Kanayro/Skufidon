package org.example.dataaccess.dto;

public class PairUsersDTO {

    private ClientDTO pairClient;

    public PairUsersDTO() {
    }

    public PairUsersDTO(ClientDTO pairClient) {
        this.pairClient = pairClient;
    }

    public ClientDTO getPairClient() {
        return pairClient;
    }

    public void setPairClient(ClientDTO pairClient) {
        this.pairClient = pairClient;
    }
}
