package site.xixing.service.combine;


import site.xixing.entity.dto.MainPageInfoDTO;
import site.xixing.entity.dto.Result;

public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}
