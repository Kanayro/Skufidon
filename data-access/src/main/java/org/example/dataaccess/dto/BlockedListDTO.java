package org.example.dataaccess.dto;

public class BlockedListDTO {

    private ClientDTO blockedClient;

    public BlockedListDTO() {
    }

    public BlockedListDTO(ClientDTO blockedClient) {
        this.blockedClient = blockedClient;
    }

    public ClientDTO getBlockedClient() {
        return blockedClient;
    }

    public void setBlockedClient(ClientDTO blockedClient) {
        this.blockedClient = blockedClient;
    }
}
