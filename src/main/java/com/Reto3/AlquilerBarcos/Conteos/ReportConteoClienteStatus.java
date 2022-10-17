package com.Reto3.AlquilerBarcos.Conteos;

import com.Reto3.AlquilerBarcos.modelo.Client;



public class ReportConteoClienteStatus {
    
    private Integer total;
    private Client client;

    public ReportConteoClienteStatus(Integer total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

  
    
}
