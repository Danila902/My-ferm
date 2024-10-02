package web.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PriceUpdateVO extends PriceVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
