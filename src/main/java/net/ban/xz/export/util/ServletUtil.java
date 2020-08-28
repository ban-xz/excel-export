package net.ban.xz.export.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * The Class ExportServlet
 */
public class ServletUtil {

    private String fileName;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ServletUtil(String fileName, HttpServletRequest request, HttpServletResponse response){
        this.fileName = fileName;
        this.request = request;
        this.response = response;
    }

    public OutputStream getOut(){
        try {
            return response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void poiExcelServlet(){
        response.setContentType("application/vnd.ms-excel");
        String contentDisposition = "";
        try {
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                contentDisposition = "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1")
                        + "\"";// firefox浏览器
            } else {
                contentDisposition = "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"";// IE浏览器
            }
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        response.setHeader("Content-Disposition", contentDisposition);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
    }

}
