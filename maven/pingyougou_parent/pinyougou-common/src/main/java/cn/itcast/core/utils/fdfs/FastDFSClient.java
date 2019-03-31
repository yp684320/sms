package cn.itcast.core.utils.fdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

public class FastDFSClient {

	private TrackerClient trackerClient = null;//跟踪服务器客户端
	private TrackerServer trackerServer = null;//跟踪服务器
	private StorageServer storageServer = null;//存储服务器
	private StorageClient1 storageClient = null;//存储服务器客户端
	
	public FastDFSClient(String conf) throws Exception {
		//初始化fastDFS配置文件
		if (conf.contains("classpath:")) {
			conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
		}
		ClientGlobal.init(conf);
		// 2、创建跟踪服务器客户端
		trackerClient = new TrackerClient();
		// 3、通过客户端获取跟踪服务器服务端
		trackerServer = trackerClient.getConnection();
		storageServer = null;
		// 4、创建存储服务器客户端
		storageClient = new StorageClient1(trackerServer, storageServer);
	}
	
	/**
	 * 上传文件方法
	 * <p>Title: uploadFile</p>
	 * <p>Description: </p>
	 * @param fileName 文件全路径
	 * @param extName 文件扩展名，不包含（.）
	 * @param metas 文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
		String result = storageClient.upload_file1(fileName, extName, metas);
		return result;
	}
	
	public String uploadFile(byte[] file, String fileName, long fileSize) throws Exception {
		NameValuePair[] metas = new NameValuePair[3];
		metas[0] = new NameValuePair("fileName", fileName);
		metas[1] = new NameValuePair("fileSize", String.valueOf(fileSize));
		metas[2] = new NameValuePair("fileExt", FilenameUtils.getExtension(fileName));
		String result = storageClient.upload_file1(file, FilenameUtils.getExtension(fileName), metas);
		return result;
	}
	
	public String uploadFile(String fileName) throws Exception {
		return uploadFile(fileName, null, null);
	}
	
	public String uploadFile(String fileName, String extName) throws Exception {
		return uploadFile(fileName, extName, null);
	}
	
	/**
	 * 上传文件方法
	 * <p>Title: uploadFile</p>
	 * <p>Description: </p>
	 * @param fileContent 文件的内容，字节数组
	 * @param extName 文件扩展名
	 * @param metas 文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
		
		String result = storageClient.upload_file1(fileContent, extName, metas);
		return result;
	}
	
	public String uploadFile(byte[] fileContent) throws Exception {
		return uploadFile(fileContent, null, null);
	}
	
	public String uploadFile(byte[] fileContent, String extName) throws Exception {
		return uploadFile(fileContent, extName, null);
	}
}
