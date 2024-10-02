package web.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class ClientVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "firstName can not null")
    private String firstName;

    private String lastName;

}
