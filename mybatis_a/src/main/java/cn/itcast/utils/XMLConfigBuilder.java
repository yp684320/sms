package cn.itcast.utils;


import cn.itcast.domain.Configuration;
import cn.itcast.domain.Mapper;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XMLConfigBuilder {
	//加载mybatis的配置文件 
	public static Configuration buildConfiguration(InputStream is) throws Exception {
		Configuration cfg = new Configuration();
		//创建SAXReader
		SAXReader reader = new SAXReader();
		//获取Document对象（xml的文档）
		Document document = reader.read(is);
		//获取根节点
		Element root = document.getRootElement();
		//获取property节点
		List<Element> propertys =  root.selectNodes("//property"); //获取property节点结合
		//对cfg对象赋值:数据库的基本信息
		for (Element element : propertys) {
			String name = element.attributeValue("name"); //username,password,url,driver
			String value = element.attributeValue("value");
			if("username".equals(name)) {
				cfg.setUsername(value);
			}
			if("password".equals(name)) {
				cfg.setPassword(value);
			}
			if("url".equals(name)) {
				cfg.setUrl(value);
			}
			if("driver".equals(name)) {
				cfg.setDriver(value);
			}
		}
		
		//对sql的map集合赋值
		Map<String,Mapper> mappers = new HashMap();
		
		//解析sql语句的配置文件
		Element mappersElement = root.element("mappers");
		
		if(mappersElement != null) {
			List<Element> mapperElements = mappersElement.elements("mapper");
			for (Element mapperElement : mapperElements) {
				String path = mapperElement.attributeValue("resource");
				//将每一个sql配置文件中的map集合存入到大的map中
				mappers.putAll(loadXmlForMapper(path));
			}
		}
		
		cfg.setMappers(mappers); //封装的map给了Configuration
		return cfg;
	}

	/**
	 * 解析sql的配置文件
	 * @throws Exception 
	 */
	public static Map<String,Mapper> loadXmlForMapper(String path) throws Exception {
		//path是sql配置文件的路径，将路径妆化为字节流
		//类加载器加载配置文件的路径：相对于类src的路径
		
		InputStream is = XMLConfigBuilder.class.getClassLoader().getResourceAsStream(path);
		//dom4j解析
		//创建SAXReader
		SAXReader reader = new SAXReader();
		//获取Document对象（xml的文档）
		Document document = reader.read(is);
		//获取根节点
		Element root = document.getRootElement();
		// 此时key value没有值
		Map<String,Mapper> map = new HashMap();
		// user
		String namespace = root.attributeValue("namespace");
		
		List<Element> selectElements = root.elements("select");
		
		for (Element select : selectElements) {
//			<select id="getUser" resultType="cn.itcast.domain.User">   
//				select *  from user   
//			</select>   
			String id = select.attributeValue("id");  //getAll
			String resultType = select.attributeValue("resultType");
			String sql = select.getText();
			Mapper mapper = new Mapper();
			mapper.setQuerySql(sql); //sql语句有了
			mapper.setResultType(resultType);//返回值类型
			//key: user.getAll  value:当前封装好的mapper对象
			map.put(namespace + "."+id, mapper);
		}
		
		return map;
	}
	
}
