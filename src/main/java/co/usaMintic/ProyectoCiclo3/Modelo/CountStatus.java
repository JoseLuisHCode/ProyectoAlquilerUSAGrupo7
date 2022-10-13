package co.usaMintic.ProyectoCiclo3.Modelo;

public class CountStatus {
    
    private long completed;

    private long cancelled;

    public CountStatus(long completed, long cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public long getCompleted() {
        return completed;
    }

    public void setCompleted(long completed) {
        this.completed = completed;
    }

    public long getCancelled() {
        return cancelled;
    }

    public void setCancelled(long cancelled) {
        this.cancelled = cancelled;
    }

    
}
