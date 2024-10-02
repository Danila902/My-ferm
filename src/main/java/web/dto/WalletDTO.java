package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class WalletDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    private Long userId;

    private Long sum;

    private Long timeId;

}
