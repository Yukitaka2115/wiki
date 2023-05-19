package com.solaluna.wiki.config.typeHandler;

import com.solaluna.wiki.pojo.page.Chara;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharaTypeHandler extends BaseTypeHandler<Chara> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Chara chara, JdbcType jdbcType) throws SQLException {
        ps.setString(i, convertCharaToString(chara));
    }

    @Override
    public Chara getNullableResult(ResultSet rs, String s) throws SQLException {
        String res = rs.getString(s);
        return convertStringToChara(res);
    }

    @Override
    public Chara getNullableResult(ResultSet rs, int i) throws SQLException {
        String res = rs.getString(i);
        return convertStringToChara(res);
    }

    @Override
    public Chara getNullableResult(CallableStatement cs, int i) throws SQLException {
        String res = cs.getString(i);
        return convertStringToChara(res);
    }



    public String convertCharaToString(Chara chara) {
        StringBuilder sb = new StringBuilder();
        sb.append(chara.getChara())
                .append(":")
                .append(chara.getCast())
                .append(":")
                .append(chara.getInfo());
        return sb.toString();
    }

    public Chara convertStringToChara(String str) {
        String[] parts = str.split(":");
        if (parts.length == 3) {
            String chara = parts[0];
            String cast = parts[1];
            String info = parts[2];
            return new Chara(chara, cast, info);
        }
        return null;
    }
}
