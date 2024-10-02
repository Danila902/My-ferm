package web.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};
//    {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class BuyVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull(message = "priceId can not null")
    private Long priceId;

    @NotNull(message = "quantity can not null")
    private Long quantity;

    @NotNull(message = "id can not null")
    private Long id;

    @NotNull(message = "timeId can not null")
    private Long timeId;

    @NotNull(message = "clientId can not null")
    private Long clientId;

}
