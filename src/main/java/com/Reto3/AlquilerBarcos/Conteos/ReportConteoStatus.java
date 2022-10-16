
package com.Reto3.AlquilerBarcos.Conteos;


public class ReportConteoStatus {
    
    Integer completed;
    Integer cancelled;
    
    public ReportConteoStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public ReportConteoStatus() {
    }
    
    
}
