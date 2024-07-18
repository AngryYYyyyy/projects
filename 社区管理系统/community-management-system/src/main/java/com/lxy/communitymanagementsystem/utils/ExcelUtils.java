package com.lxy.communitymanagementsystem.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import com.lxy.communitymanagementsystem.exception.BusinessException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ExcelUtils {


    /**
     * excel 导出
     *
     * @param list         数据列表
     * @param pojoClass    pojo类型
     * @param fileName     导出时的excel名称
     * @param response
     * @param exportParams 导出参数（标题、sheet名称、是否创建表头，表格类型）
     */
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        //把数据添加到excel表格中
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        downLoadExcel(fileName, response, workbook);
    }

    /**
     * excel下载
     *
     * @param fileName 下载时的文件名称
     * @param response
     * @param workbook excel数据
     */
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {

        ServletOutputStream outputStream = null;

        try {
            response.setCharacterEncoding("UTF-8");
            // 设置文件名,下载方式(弹框下载)
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode("community.xls", "UTF-8"));

            outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e) {
            throw new BusinessException(ExceptionCode.EXCEL_FAILURE);
        } finally {
            try {
                outputStream.close();
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}