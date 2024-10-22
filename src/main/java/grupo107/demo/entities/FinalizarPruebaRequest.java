package grupo107.demo.entities;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FinalizarPruebaRequest {
    @Size(max = 500)
    private String comentario;

}
