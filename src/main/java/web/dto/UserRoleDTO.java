package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserRoleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long userId;

    private String role;

    private Long id;

}
