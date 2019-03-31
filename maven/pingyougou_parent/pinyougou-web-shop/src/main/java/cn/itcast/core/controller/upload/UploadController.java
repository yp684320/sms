package cn.itcast.core.controller.upload;

import cn.itcast.core.entity.Result;
import cn.itcast.core.utils.fdfs.FastDFSClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Value("${FILE_SERVER_PATH}")
    private String FILE_SERVER_PATH;

    /**
     * 将图片上传的fastDFS
     * @param file
     * @return
     * @throws Exception
     */
    @RequestMapping("/uploadFile.do")
    public Result uploadFile(MultipartFile file) throws Exception {

        try {
            String conf = "classpath:fastdfs/fdfs_client.conf";
            FastDFSClient fastDFSClient = new FastDFSClient(conf);
            //获取文件的完整名称
            String filename = file.getOriginalFilename();
            //获取文件的扩展名
            String extName = FilenameUtils.getExtension(filename);
            String path = fastDFSClient.uploadFile(file.getBytes(), extName, null);
            // 拼接的服务器地址：
            // 服务器地址：常量 java维护常量方式：枚举、接口、配置文件（服务器地址）
            String url =  FILE_SERVER_PATH + path;
            return new Result(true, url);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "文件上传失败");
        }

    }
}