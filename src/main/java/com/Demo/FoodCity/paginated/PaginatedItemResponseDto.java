package com.Demo.FoodCity.paginated;

import com.Demo.FoodCity.dto.response.ResponseCustomerDto;
import com.Demo.FoodCity.dto.response.ResponseItemDto;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedItemResponseDto {
    private long count;
    private List<ResponseItemDto> datalist;
}
