package grupo107.demo.entities;

import jakarta.validation.constraints.Size;

public class FinalizarPruebaRequest {
    @Size(max = 500)
    private String comentario;

    // Getters y Setters
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
