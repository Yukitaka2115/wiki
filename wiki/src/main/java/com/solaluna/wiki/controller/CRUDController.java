package com.solaluna.wiki.controller;

import com.solaluna.wiki.pojo.Chara;
import com.solaluna.wiki.pojo.Result;
import com.solaluna.wiki.service.CharaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CRUDController {

    @Autowired
    CharaService service;

    @GetMapping("/test")
    public String test(){return "114514";}

    @PostMapping("/addChara")
    public Result add(@RequestBody Chara charaparam){
        String charaname = charaparam.getChara();
        String cast = charaparam.getCast();
        String info = charaparam.getInfo();
        Chara chara = new Chara();
        chara.setChara(charaname);
        chara.setCast(cast);
        chara.setInfo(info);
        service.save(chara);
        return Result.success(chara);
    }

    @DeleteMapping("/deleteChara/{id}")
    public Result delete(@PathVariable int id){
        service.removeById(id);
        return Result.success("删除成功",id);
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable int id, @RequestBody Chara charaparam){
        Chara chara = service.getById(id);
        if(chara == null){
            return Result.fail(404,"查询失败");
        }
        chara.setChara(charaparam.getChara());
        chara.setCast(charaparam.getCast());
        chara.setInfo(charaparam.getInfo());
        service.updateById(chara);
        return Result.success("更新成功", chara);
    }

    @GetMapping("/getChara/{id}")
    public Result getChara(@PathVariable int id) {
        Chara chara = service.getById(id);
        if (chara == null) {
            return Result.fail(404, "数据不存在");
        }
        return Result.success(chara);
    }
}