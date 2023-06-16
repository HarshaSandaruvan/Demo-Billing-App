package com.Demo.FoodCity.paginated;

import com.Demo.FoodCity.dto.response.ResponseOrderDetailsDto;
import com.Demo.FoodCity.dto.response.ResponseOrderDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PaginatedOrderDetailsResponseDto {
    private long count;
    private List<ResponseOrderDetailsDto> datalist;


}
