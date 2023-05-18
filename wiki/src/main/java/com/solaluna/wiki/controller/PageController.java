package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.page.Chara;
import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.service.CharaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageController {

    @Autowired
    CharaService charaservice;

    @GetMapping("/chara/test")
    public String test(){return "114514";}

    @PostMapping("/chara/addChara")
    public Result add(@RequestBody Chara charaparam){
        String charaname = charaparam.getChara();
        String cast = charaparam.getCast();
        String info = charaparam.getInfo();
        Chara chara = new Chara();
        chara.setChara(charaname);
        chara.setCast(cast);
        chara.setInfo(info);
        charaservice.save(chara);
        return Result.success(chara);
    }//1

    @DeleteMapping("/chara/deleteChara")
    public Result delete(@RequestParam("id") int id){
        charaservice.removeById(id);
        return Result.success("删除成功",id);
    }//1

    @PutMapping("/chara/updateChara")
    public Result update(@RequestParam("id") int id, @RequestBody Chara charaparam){
        Chara chara = charaservice.getById(id);
        if(chara == null){
            return Result.fail(406,"查询失败");
        }
        chara.setChara(charaparam.getChara());
        chara.setCast(charaparam.getCast());
        chara.setInfo(charaparam.getInfo());
        charaservice.updateById(chara);
        return Result.success("更新成功", chara);
    }//1

    @GetMapping("/chara/getChara")
    public Result getChara(@RequestParam("id")  int id) {
        Chara chara = charaservice.getById(id);
        if (chara == null) {
            return Result.fail(406, "数据不存在");
        }
        return Result.success(chara);
    }//1
}