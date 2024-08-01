package com.lxy.communitymanagementsystem.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lxy.communitymanagementsystem.constant.enums.ExceptionCode;
import com.lxy.communitymanagementsystem.exception.BusinessException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {


    /**
     * @param list         数据列表
     * @param pojoClass    pojo类型，用于映射数据
     * @param fileName     导出时的excel名称
     * @param response     HttpServletResponse 响应对象
     * @param exportParams 导出参数（标题、sheet名称、是否创建表头，表格类型）
     * @Description: 导出数据到Excel文件
     */
    public static void exportExcel(List<?> list, Class<?> pojoClass, String fileName, HttpServletResponse response, ExportParams exportParams) {
        // 把数据添加到excel表格中
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, pojoClass, list);
        // 下载生成的excel文件
        downLoadExcel(fileName, response, workbook);
    }

    /**
     * @Description: 导入Excel文件中的数据
     * @param file 包含Excel数据的MultipartFile对象
     * @param pojoClass 映射数据的pojo类型
     * @return List<?> 包含导入数据的列表
     * @Author: AngryYYYYYY
     * @Date: 2024/7/20
     */
    public static List<?> importExcel(MultipartFile file, Class<?> pojoClass,ImportParams importParams) {
        List<?> dataList = new ArrayList<>();
        try {
            // 使用ExcelImportUtil将Sheet中的数据映射到指定的pojo类
            dataList = ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, importParams);

        } catch (Exception e) {
            // 捕获异常并抛出自定义业务异常
            throw new BusinessException(ExceptionCode.EXCEL_IMPORT_FAILURE);
        }
        return dataList;
    }



    /**
     * @param fileName 下载时的文件名称
     * @param response HttpServletResponse 响应对象
     * @param workbook 包含excel数据的Workbook对象
     * @Description: 下载生成的Excel文件
     */
    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) {
        ServletOutputStream outputStream = null;

        try {
            // 设置响应编码为UTF-8
            response.setCharacterEncoding("UTF-8");
            // 设置文件名和下载方式（弹框下载）
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

            // 获取响应的输出流
            outputStream = response.getOutputStream();
            // 将Workbook中的数据写入到输出流中
            workbook.write(outputStream);
        } catch (Exception e) {
            // 捕获异常并抛出自定义业务异常
            throw new BusinessException(ExceptionCode.EXCEL_FAILURE);
        } finally {
            try {
                // 关闭输出流和Workbook对象
                if (outputStream != null) {
                    outputStream.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException e) {
                // 打印IO异常的堆栈信息
                e.printStackTrace();
            }
        }
    }
}
