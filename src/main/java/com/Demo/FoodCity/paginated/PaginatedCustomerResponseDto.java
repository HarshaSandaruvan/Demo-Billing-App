package com.Demo.FoodCity.paginated;

import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedCustomerResponseDto {
    private long count;
    private List<ResponseCustomerDto> datalist;


}
