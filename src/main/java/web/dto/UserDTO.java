package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    private String userName;

    private Long walletId;

    private String password;

}
