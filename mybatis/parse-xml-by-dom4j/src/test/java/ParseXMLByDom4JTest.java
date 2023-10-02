import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @Author wataxi
 * @Date 2023/9/22 9:56
 * @Version 1.0
 */
public class ParseXMLByDom4JTest {

    @Test
    public void testParseSqlMapperXML() throws Exception {
        SAXReader reader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = reader.read(is);
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        String namespace = mapper.attributeValue("namespace");
        System.out.println(namespace);
        List<Element> elements = mapper.elements();
        elements.forEach(element -> {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String sql = element.getTextTrim();
            System.out.println("id:" + id + " resultType:" + resultType  + " sql:" + sql);
            String newSql = sql.replaceAll("#\\{[0-9A-Za-z_$]*}", "?");
            System.out.println("newSQL: " + newSql);
        });
    }

    @Test
    public void testParseXMLByDom4J() throws Exception {
        SAXReader reader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        Document document = reader.read(is);
        Element rootElement = document.getRootElement();
        String rootElementName = rootElement.getName();
        System.out.println(rootElementName);
        String xpath = "/configuration/environments";
        Element environments = (Element) document.selectSingleNode(xpath);
        String defaultEnvironmentId = environments.attributeValue("default");
        System.out.println(defaultEnvironmentId);
        xpath = "/configuration/environments/environment[@id='" + defaultEnvironmentId + "']";
        Element environment = (Element) document.selectSingleNode(xpath);
        Element transactionManager = (Element) environment.element("transactionManager");
        String transactionManagerType = transactionManager.attributeValue("type");
        System.out.println(transactionManagerType);
        Element dataSource = environment.element("dataSource");
        String dataSourceType = dataSource.attributeValue("type");
        System.out.println(dataSourceType);
        List<Element> propertyList = dataSource.elements("property");
        propertyList.forEach(element ->
                {
                    String name = element.attributeValue("name");
                    String value = element.attributeValue("value");
                    System.out.println(name + "=" + value);
                }
        );
        // 获取所有的mapper标签
        // 不想从根下开始获取，你想从任意位置开始，获取所有的某个标签，xpath该这样写
        xpath = "//mapper";
        List<Node> mapperNodes = document.selectNodes(xpath);
        mapperNodes.forEach(node -> {
            Element element = (Element) node;
            String resource = element.attributeValue("resource");
            System.out.println(resource);
        });

    }

}
