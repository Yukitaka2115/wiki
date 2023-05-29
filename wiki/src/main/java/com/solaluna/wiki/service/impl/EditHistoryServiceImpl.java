package com.solaluna.wiki.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solaluna.wiki.mapper.EditHistoryMapper;
import com.solaluna.wiki.pojo.info.EditHistory;
import com.solaluna.wiki.pojo.page.Page;
import com.solaluna.wiki.pojo.user.User;
import com.solaluna.wiki.service.EditHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class EditHistoryServiceImpl extends ServiceImpl<EditHistoryMapper, EditHistory> implements EditHistoryService {
    @Autowired
    EditHistoryMapper mapper;
    public void saveEditHistory(User editor, Page editedPage) {
        EditHistory editHistory = new EditHistory();
        editHistory.setEditTime(Timestamp.from(Instant.now()));
        editHistory.setEditorName(editor.getUsername());
        editHistory.setEditedPageId(editedPage.getId());
        mapper.insert(editHistory);
    }
}
