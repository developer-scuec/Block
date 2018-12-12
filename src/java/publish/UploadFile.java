package publish;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import Database.ConnectDatabase;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
public class UploadFile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        request.setCharacterEncoding("UTF-8");
        String url=null;

        //解析请求
        try {
            List<FileItem> items=upload.parseRequest(request);
            Iterator<FileItem> iterator=items.iterator();
            Map<String,String> goodsInfo=new LinkedHashMap<>();
            while(iterator.hasNext()){
                FileItem item = iterator.next();
                if(item.isFormField()){
                    String name=item.getFieldName();
                    String value=item.getString("UTF-8");
                    goodsInfo.put(name,value);
                }
                if(!item.isFormField()){
                    String name=item.getFieldName();
                    String fileName=item.getName();
                    String extension = FilenameUtils.getExtension(fileName);
                    long time=System.currentTimeMillis();
                    File file=new File("./upload_img");
                    if(!file.exists()){
                        file.mkdirs();
                    }
                    String src="upload_img/"+time+"."+extension;
                    url=request.getSession().getServletContext().getRealPath("/")+src;


                    goodsInfo.put(name,src);
                    InputStream in=item.getInputStream();
                    file=new File(url);
                    if(!file.exists()){
                        file.createNewFile();
                    }

                    OutputStream os=new FileOutputStream(file);
                    byte buffer[]=new byte[1024];
                    int len=0;
                    while((len=in.read(buffer))!=-1){
                        os.write(buffer, 0, len);
                    }
                    in.close();
                    os.close();
                }

            }
            ConnectDatabase connectDatabase=new ConnectDatabase();
            Connection conn=connectDatabase.getConnection();
            String username=null;
            Cookie cookies[]=request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("username")){
                    username=cookie.getValue();
                }
            }
            String sql="insert into goods (publisher,title,price,description,img_url,phone,pay) values (?,?,?,?,?,?,?)";
            System.out.println(goodsInfo);
            try{
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,goodsInfo.get("title"));
                ps.setInt(3,Integer.parseInt(goodsInfo.get("price")));
                ps.setString(4,goodsInfo.get("description"));
                ps.setString(5,goodsInfo.get("uploadImg"));
                ps.setString(6,goodsInfo.get("telephone"));
                ps.setString(7,goodsInfo.get("alipay"));
                int result=ps.executeUpdate();
                if(result>0)response.sendRedirect("/Block/index.jsp");
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (FileUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
