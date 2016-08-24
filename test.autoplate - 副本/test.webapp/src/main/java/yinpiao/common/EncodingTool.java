package yinpiao.common;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by zhanxiaobing on 2016/8/23.
 */
public class EncodingTool {
    public Writer getWriter(HttpServletResponse httpServletResponse) throws IOException {
        HttpServletResponse tempHttpServletResponse = httpServletResponse;
        tempHttpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
        return tempHttpServletResponse.getWriter();
    }
}
