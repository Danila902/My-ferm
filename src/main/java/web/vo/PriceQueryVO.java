package web.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PriceQueryVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private Long unitId;

    private Long id;

    private Long price;

}
