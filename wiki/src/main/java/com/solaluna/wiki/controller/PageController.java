package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.pojo.page.Group;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.pojo.user.User;
import com.solaluna.wiki.service.EditHistoryService;
import com.solaluna.wiki.service.PageService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("/page")
public class PageController {
    @Autowired
    PageService pageService;
    @Autowired
    EditHistoryService editHistoryService;

    @GetMapping("/test")
    public String test(){return "114514";}
    @Operation(summary = "新增页面")
    @PostMapping("/addPage")//外链跟其他的活动之类的功能没写
    public Result add(@RequestBody Page pageParam){
        if(pageParam == null){
            return Result.fail(400,"输入内容为空");
        }//判空
        String title = pageParam.getTitle();
        String brief = pageParam.getBrief();
        String background = pageParam.getBackground();
        Map<String, String> history = pageParam.getHistory();
        Chara mainChara = pageParam.getMainchara();
        Chara relatives = pageParam.getRelatives();
        Group team = pageParam.getTeam();
        Page page = new Page();
        page.setTitle(title);
        page.setBrief(brief);
        page.setBackground(background);
        page.setHistory(history);
        page.setMainchara(mainChara);
        page.setRelatives(relatives);
        page.setTeam(team);
        pageService.save(page);
        return Result.success(page);
    }//1,2,3

    @DeleteMapping("/deletePage")
    public Result delete(@RequestParam("id") int id){
        pageService.removeById(id);
        return Result.success("删除成功",id);
    }//1,2

    @PutMapping("/editPage")
    public Result update(@RequestParam("id") int id, @RequestBody Page pageParam , HttpServletRequest req){
        Page page = pageService.getById(id);
        if(page == null){
            return Result.fail(406,"查询失败");
        }
        //执行页面编辑与更新操作
        page.setId(pageParam.getId());
        page.setTitle(pageParam.getTitle());
        page.setBrief(pageParam.getBrief());
        page.setBackground(pageParam.getBackground());
        page.setHistory(pageParam.getHistory());
        page.setMainchara(pageParam.getMainchara());
        page.setRelatives(pageParam.getRelatives());
        page.setTeam(pageParam.getTeam());
//        //判空
//        if(pageParam == null){
//            return Result.fail(406,"内容为空");
//        }//这个判空为什么会一直为null？
        boolean updated = pageService.updateById(page);
        if (updated) {//目前没法测试这个功能，等前端
            // 添加编辑历史记录
            String token;
            token = req.getHeader("Authorization");
            String jwtSecret = "Yukitaka1116"; // 替换为你的 JWT 密钥
            // 解析 JWT Token
            Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
            // 从 claims 中获取用户名
            String username = claims.getSubject();
            User editor = new User();
            editor.setUsername(username);
            editHistoryService.saveEditHistory(username,page.getId());
            return Result.success("更新成功", page);
        } else {
            return Result.fail(407, "更新失败");
        }
    }//1,2

    @GetMapping("/{title}")
    public Result get(@PathVariable("title") String title) { //@PathVariable 跟 @RequestParam 区别
        /*
         * @PathVariable 用于获取路径中的占位符参数值，例如 /users/{userId}。
         * @RequestParam 用于获取请求中的查询参数值，例如 /users?id=123。
         */
        Page page = pageService.getByTitle(title);
        if (page == null) {
            return Result.fail(406, "数据不存在");
        }
        return Result.success(page);
    }//1，2
}