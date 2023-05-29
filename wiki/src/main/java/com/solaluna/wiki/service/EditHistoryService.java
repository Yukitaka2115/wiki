package com.solaluna.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solaluna.wiki.pojo.info.EditHistory;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.pojo.user.User;

public interface EditHistoryService extends IService<EditHistory> {
    void saveEditHistory(User editor, Page editedPage);
}
