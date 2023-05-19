package com.solaluna.wiki.config.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapTypeHandler extends BaseTypeHandler<Map<String, String>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, String> parameter, JdbcType jdbcType) throws SQLException {
        // 将 Map 类型的参数转换为合适的数据库类型并设置到 PreparedStatement 中
        // 这里可以根据具体数据库的类型选择适当的转换方法
        // 例如，可以将 Map 转换为 JSON 字符串存储到对应的 VARCHAR 字段中
         ps.setString(i, convertMapToString(parameter));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 从 ResultSet 中获取指定列名的值，并将其转换为 Map 类型
        // 这里可以根据具体数据库的类型选择适当的转换方法
        // 例如，可以将存储为 JSON 字符串的字段值转换为 Map 对象
         String json = rs.getString(columnName);
         return convertStringToMap(json);
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 从 ResultSet 中获取指定列索引的值，并将其转换为 Map 类型
        // 这里可以根据具体数据库的类型选择适当的转换方法
        // 例如，可以将存储为 JSON 字符串的字段值转换为 Map 对象
         String json = rs.getString(columnIndex);
         return convertStringToMap(json);
    }

    @Override
    public Map<String, String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        // 从 CallableStatement 中获取指定列索引的值，并将其转换为 Map 类型
        // 这里可以根据具体数据库的类型选择适当的转换方法
        // 例如，可以将存储为 JSON 字符串的字段值转换为 Map 对象
         String json = cs.getString(columnIndex);
         return convertStringToMap(json);
    }

    // 根据需要编写 Map 和 JSON 之间的转换方法
    // ...

    // 示例的转换方法
    private String convertMapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey())
                    .append(":")
                    .append(entry.getValue())
                    .append(",");
        }
        // Remove the trailing comma if needed
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private Map<String, String> convertStringToMap(String str) {
        Map<String, String> map = new HashMap<>();
        String[] entries = str.split(",");
        for (String entry : entries) {
            String[] parts = entry.split(":");
            if (parts.length == 2) {
                map.put(parts[0], parts[1]);
            }
        }
        return map;
    }
}
