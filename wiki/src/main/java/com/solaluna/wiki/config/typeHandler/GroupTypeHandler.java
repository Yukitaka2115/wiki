package com.solaluna.wiki.config.typeHandler;

import com.solaluna.wiki.pojo.page.Group;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupTypeHandler extends BaseTypeHandler<Group> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Group group, JdbcType jdbcType) throws SQLException {
        ps.setString(i,convertGroupToString(group));
    }

    @Override
    public Group getNullableResult(ResultSet rs, String s) throws SQLException {
        String res = rs.getString(s);
        return convertStringToGroup(res);
    }

    @Override
    public Group getNullableResult(ResultSet rs, int i) throws SQLException {
        String res = rs.getString(i);
        return convertStringToGroup(res);
    }

    @Override
    public Group getNullableResult(CallableStatement cs, int i) throws SQLException {
        String res = cs.getString(i);
        return convertStringToGroup(res);
    }
    public String convertGroupToString(Group group) {
        StringBuilder sb = new StringBuilder();
        sb.append(group.getChara())
                .append(":")
                .append(group.getGrade())
                .append(":")
                .append(group.getGroup());
        return sb.toString();
    }

    public Group convertStringToGroup(String str) {
        String[] parts = str.split(":");
        if (parts.length == 3) {
            String chara = parts[0];
            String grade = parts[1];
            String group = parts[2];
            return new Group(chara, grade, group);
        }
        return null;
    }


}
