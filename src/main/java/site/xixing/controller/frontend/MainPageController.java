package site.xixing.controller.frontend;





import lombok.Getter;
import org.xixing.qaqframework.core.annotation.Controller;
import org.xixing.qaqframework.inject.annotation.Autowired;
import site.xixing.entity.dto.MainPageInfoDTO;
import site.xixing.entity.dto.Result;
import site.xixing.service.combine.HeadLineShopCategoryCombineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Getter
@Controller
public class MainPageController {

    @Autowired
    private HeadLineShopCategoryCombineService headLineShopCategoryCombineService;
    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp){
        return headLineShopCategoryCombineService.getMainPageInfo();
    }
}
