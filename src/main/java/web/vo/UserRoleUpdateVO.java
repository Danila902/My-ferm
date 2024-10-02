package web.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserRoleUpdateVO extends UserRoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

}
