package web.dto;


import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TimeDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    private LocalDateTime time;

}
