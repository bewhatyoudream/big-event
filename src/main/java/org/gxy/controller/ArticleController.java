package org.gxy.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.gxy.pojo.Article;
import org.gxy.pojo.PageBean;
import org.gxy.pojo.Result;
import org.gxy.service.ArticleService;
import org.gxy.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;



    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state){
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }
}
