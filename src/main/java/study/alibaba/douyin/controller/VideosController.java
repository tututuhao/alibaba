package study.alibaba.douyin.controller;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import study.alibaba.douyin.entity.Videos;
import study.alibaba.douyin.service.VideosService;
import study.alibaba.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 视频信息表 前端控制器
 * </p>
 *
 * @author lyh
 * @since 2022-04-01
 */
@RestController
@RequestMapping("/douyin/videos")
public class VideosController {

    @Autowired
    private VideosService videosService;

    @RequestMapping("/test")
    public String test(){
        Videos build = Videos.builder().userId("4545646")
                .videoPath("/asd/asdsa")
                .likeCounts(134L)
                .status(1).build();
        videosService.save(build);
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", "4545646");
        videosService.removeByMap(map);
        Page page = new Page(1,3);
        videosService.page(page, null);

        return JSONObject.toJSONString(page);
    }

}

