package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.pojo.page.Group;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.service.PageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PageController {

    @Autowired
    PageService pageService;


    @GetMapping("/page/test")
    public String test(){return "114514";}

    @PostMapping("/page/addPage")
    public Result add(@RequestBody Page pageParam){
        String title = pageParam.getTitle();
        String brief = pageParam.getBrief();
        String background = pageParam.getBackground();
        Map<String, String> history = pageParam.getHistory();
        Chara mainChara = pageParam.getMainchara();
        System.out.println(mainChara);
        Chara relatives = pageParam.getRelatives();
        Group team = pageParam.getTeam();
        if (StringUtils.isBlank((CharSequence) pageParam)){
            return Result.error("空白");
        }
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
    }//1，2

    @DeleteMapping("/page/deletePage")
    public Result delete(@RequestParam("id") int id){
        pageService.removeById(id);
        return Result.success("删除成功",id);
    }//1,2

    @PutMapping("/page/editPage")
    public Result update(@RequestParam("id") int id, @RequestBody Page pageParam){
        Page page = pageService.getById(id);
        if(page == null){
            return Result.fail(406,"查询失败");
        }
        page.setTitle(pageParam.getTitle());
        page.setBrief(pageParam.getBrief());
        page.setBackground(pageParam.getBackground());
        page.setHistory(pageParam.getHistory());
        page.setMainchara(pageParam.getMainchara());
        page.setRelatives(pageParam.getRelatives());
        page.setTeam(pageParam.getTeam());
        pageService.updateById(page);
        return Result.success("更新成功", page);
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