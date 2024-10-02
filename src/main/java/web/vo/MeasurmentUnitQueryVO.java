package web.vo;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class MeasurmentUnitQueryVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String unitName;

}
