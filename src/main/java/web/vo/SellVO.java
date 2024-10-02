package web.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

//{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotNull")};
//        {stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot(${useJakartaEE},"NotEmpty")};


@Data
public class SellVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long priceId;

    @NotNull(message = "quantity can not null")
    private BigDecimal quantity;

    @NotNull(message = "id can not null")
    private Long id;

    private Long timeId;

    @NotNull(message = "clientId can not null")
    private Long clientId;

}
