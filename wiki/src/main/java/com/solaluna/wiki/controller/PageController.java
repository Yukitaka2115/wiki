package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.pojo.page.Group;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.service.PageService;
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
        Chara mainCharacter = pageParam.getMainChara();
        Chara relatives = pageParam.getRelatives();
        Group team = pageParam.getTeam();
        Page page = new Page();
        page.setTitle(title);
        page.setBrief(brief);
        page.setBackground(background);
        page.setHistory(history);
        page.setMainChara(mainCharacter);
        page.setRelatives(relatives);
        page.setTeam(team);
        pageService.save(page);
        return Result.success(page);
    }//1

    @DeleteMapping("/page/deletePage")
    public Result delete(@RequestParam("id") int id){
        pageService.removeById(id);
        return Result.success("删除成功",id);
    }//1

    @PutMapping("/page/updatePage")
    public Result update(@RequestParam("id") int id, @RequestBody Page pageParam){
        Page page = pageService.getById(id);
        if(page == null){
            return Result.fail(406,"查询失败");
        }
        page.setTitle(pageParam.getTitle());
        page.setBrief(pageParam.getBrief());
        page.setBackground(pageParam.getBackground());
        page.setHistory(pageParam.getHistory());
        page.setMainChara(pageParam.getMainChara());
        page.setRelatives(pageParam.getRelatives());
        page.setTeam(pageParam.getTeam());
        pageService.updateById(page);
        return Result.success("更新成功", page);
    }//1

    @GetMapping("{title}")
    public Result get(@RequestParam("id")  int id) {
        Page page = pageService.getById(id);
        if (page == null) {
            return Result.fail(406, "数据不存在");
        }
        return Result.success(page);
    }//1
}