package com.Demo.FoodCity.paginated;

import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedOrderResponseDto {
    private long count;
    private List<ResponseOrderDto> datalist;


}
