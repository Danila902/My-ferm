package web.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class ClientQueryVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

}
