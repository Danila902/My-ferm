package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PetDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    private String name;

    private Long userId;

    private Long timeId;

    private Long momeId;

    private Long dadId;

}
