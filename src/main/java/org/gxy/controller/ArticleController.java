package org.gxy.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.gxy.pojo.Result;
import org.gxy.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("list")
    public Result<String> list() {
        //验证token
        return Result.success("所有的文章数据..");
    }
}
