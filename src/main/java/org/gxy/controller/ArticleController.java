package org.gxy.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.gxy.pojo.Article;
import org.gxy.pojo.Result;
import org.gxy.service.ArticleService;
import org.gxy.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("list")
    public Result<String> list() {
        //验证token
        return Result.success("所有的文章数据..");
    }

    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success();
    }
}
