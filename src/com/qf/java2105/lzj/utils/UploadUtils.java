package com.qf.java2105.lzj.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传工具类
 * @Author lzj
 * @Date 2021/9/12
 */
public class UploadUtils {
    /**
     * 文件上传
     * @param request 请求对象
     * @param uploadName 上传的文件名
     * @param destPath 文件上传的地址路径
     * @return
     */
    public static String upload(HttpServletRequest request, String uploadName, String destPath){
        try {
            //获取封装图片的的对象
            Part part = request.getPart(uploadName);
            //获取文件名
            String fileName = part.getSubmittedFileName();
            //文件名是否为空
            if (null == fileName || "".equals(fileName.trim())) {
                return "";
            }
            //获取后缀名
            String extName = getExtName(fileName);
            //获取新的文件名
            fileName = getUUIDStr().concat(extName);

            //获取文件保存路径
            String path = request.getServletContext().getRealPath(destPath);

            //创建文件对象
            File file = new File(path,fileName);
            //判断路径是否存在
            if (!file.getParentFile().exists()) {
                //不存在就创建
                file.getParentFile().mkdirs();
            }
            //上传
            part.write(path+fileName);
            return destPath+fileName;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 随机生成一个UUID字符串
     * @return
     */
    public static String getUUIDStr(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取一个文件的后缀名
     * @param filename
     * @return
     */
    public static String getExtName(String filename){
        return filename.substring(filename.lastIndexOf("."));
    }

}
