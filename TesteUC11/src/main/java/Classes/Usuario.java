package Classes;

public class Usuario {
    int id;
    private String TipoUsuario="User";

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    protected void setUser(String tipo){
        this.TipoUsuario=tipo;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }
}
