package com.lxy.communitymanagementsystem.constant.enums;

/**
 * @Author ：AngryYYYYYY
 * @Date ：Created in 2024/7/17 20:21
 * @Description：
 */
public enum ExceptionCode {
    RESOURCE_NOT_FOUND(404, "请求的资源未找到"),
    DATA_INVALID(400, "提供的数据无效"),
    INTERNAL_SERVER_ERROR(500, "发生了一个意外的内部服务器错误"),
    ACCESS_DENIED(403, "拒绝访问资源"),
    EXCEL_FAILURE(501,"导出Excel失败，请联系网站管理员"),
    FILE_UPLOAD_EMPTY(502, "上传Excel文件未空"),
    EXCEL_PARSE_ERROR(503, "Excel文件解析失败"),
    EXCEL_IMPORT_FAILURE(504, "Excel文件导入失败");
    private final int code;
    private final String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

