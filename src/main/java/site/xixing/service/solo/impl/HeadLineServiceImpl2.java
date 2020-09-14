package site.xixing.service.solo.impl;

import lombok.extern.slf4j.Slf4j;
import org.xixing.qaqframework.core.annotation.Service;
import site.xixing.entity.bo.HeadLine;
import site.xixing.entity.dto.Result;
import site.xixing.service.solo.HeadLineService;

import java.util.List;

/**
 * @author xixing
 * @version 1.0
 * @date 2020/8/27 16:26
 */
@Service
public class HeadLineServiceImpl2 implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
