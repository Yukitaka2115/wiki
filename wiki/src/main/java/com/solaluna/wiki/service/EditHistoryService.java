package com.solaluna.wiki.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solaluna.wiki.pojo.info.EditHistory;

public interface EditHistoryService extends IService<EditHistory> {
    void saveEditHistory(String editor, int editedPage);

}
