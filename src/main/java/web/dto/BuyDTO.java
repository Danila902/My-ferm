package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BuyDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long priceId;

    private Long quantity;

    private Long id;

    private Long timeId;

    private Long clientId;

}
