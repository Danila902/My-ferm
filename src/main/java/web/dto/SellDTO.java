package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SellDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long priceId;

    private BigDecimal quantity;

    private Long id;

    private Long timeId;

    private Long clientId;

}
