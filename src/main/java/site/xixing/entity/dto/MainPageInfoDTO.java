package site.xixing.entity.dto;


import lombok.Data;
import site.xixing.entity.bo.HeadLine;
import site.xixing.entity.bo.ShopCategory;

import java.util.List;

@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
