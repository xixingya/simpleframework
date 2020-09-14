package site.xixing.service.combine.impl;




import org.xixing.qaqframework.core.annotation.Service;
import org.xixing.qaqframework.inject.annotation.Autowired;
import site.xixing.entity.bo.HeadLine;
import site.xixing.entity.bo.ShopCategory;
import site.xixing.entity.dto.MainPageInfoDTO;
import site.xixing.entity.dto.Result;
import site.xixing.service.combine.HeadLineShopCategoryCombineService;
import site.xixing.service.solo.HeadLineService;
import site.xixing.service.solo.ShopCategoryService;

import java.util.List;


@Service
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {

    @Autowired("HeadLineServiceImpl")
    private HeadLineService headLineService;

    @Autowired
    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLineCondition = new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> HeadLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        //2.获取店铺类别列表
        ShopCategory shopCategoryCondition = new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult =shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //3.合并两者并返回
        Result<MainPageInfoDTO> result = mergeMainPageInfoResult(HeadLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfoResult(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> shopCategoryResult) {
        return  null;
    }
}
