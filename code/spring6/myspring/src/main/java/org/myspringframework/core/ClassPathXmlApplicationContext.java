package org.myspringframework.core;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = LoggerFactory.getLogger(ClassPathXmlApplicationContext.class);

    private Map<String, Object> singletonObjects = new HashMap<>();

    public ClassPathXmlApplicationContext() {
    }

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象
     *
     * @param configLocation spring配置文件的路径，文件应该放在类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析xml文件，创建Bean对象，存放到singletonObjects集合中。
            SAXReader reader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            Document document = reader.read(in);
            // 获取bean标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历bean标签
            nodes.forEach(node -> {
                try {
                    Element beanElement = (Element) node;
                    // 获取bean标签的id属性
                    String id = beanElement.attributeValue("id");
                    // 获取bean标签的class属性
                    String className = beanElement.attributeValue("class");
                    logger.info("beanName=" + id);
                    logger.info("beanClassName=" + className);
                    // 通过反射机制创建对象，将其提前放到Map集合中，提前曝光。
                    Class<?> clazz = Class.forName(className);
                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                    // 创建对象bean
                    Object bean = constructor.newInstance();
                    // 将bean曝光
                    singletonObjects.put(id, bean);
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            // 再次重新遍历bean标签，这一次主要是给对象的属性赋值
            nodes.forEach(node -> {
                try {
                    Element beanElement = (Element) node;
                    // 获取id
                    String id = beanElement.attributeValue("id");
                    // 获取className
                    String className = beanElement.attributeValue("class");
                    // 获取class
                    Class<?> clazz = Class.forName(className);
                    // 获取该bean标签的下的所有property标签
                    List<Element> properties = beanElement.elements("property");
                    properties.forEach(property -> {
                        try {
                            // 获取属性名
                            String propertyName = property.attributeValue("name");
                            logger.info("属性名：" + propertyName);
                            // 获取属性
                            Field field = clazz.getDeclaredField(propertyName);
                            // 获取set方法名
                            String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                            // 获取set方法
                            Method setMethod = clazz.getDeclaredMethod(setMethodName, field.getType());
                            // 获取set方法的参数值
                            String value = property.attributeValue("value");
                            String ref = property.attributeValue("ref");
                            // 调用set方法
                            if (value != null) {
                                // 简单类型
                                // 我们规定，只支持这些类型为简单类型：
                                // byte short int long float double boolean char
                                // Byte Short Integer Long Float Double Boolean Character String

                                // 给一个真值，用来传给set方法
                                Object actualValue = null;
                                // 获取属性类型名
                                String propertyTypeSimpleName = field.getType().getSimpleName();
                                switch (propertyTypeSimpleName) {
                                    case "byte","Byte" -> {
                                        actualValue = Byte.parseByte(value);
                                    }
                                    case "short","Short" -> {
                                        actualValue = Short.parseShort(value);
                                    }
                                    case "int","Integer" -> {
                                        actualValue = Integer.parseInt(value);
                                    }
                                    case "long", "Long" -> {
                                        actualValue = Long.parseLong(value);
                                    }
                                    case "float", "Float" -> {
                                        actualValue = Float.parseFloat(value);
                                    }
                                    case "double","Double" -> {
                                        actualValue = Double.parseDouble(value);
                                    }
                                    case "boolean","Boolean" -> {
                                        actualValue = Boolean.parseBoolean(value);
                                    }
                                    case "char" -> {
                                        actualValue = value.charAt(0);
                                    }
                                    case "Character","String" -> {
                                        actualValue = value;
                                    }
                                }
                                setMethod.invoke(singletonObjects.get(id), actualValue);
                            }
                            if (ref != null) {
                                // 非简单类型
                                setMethod.invoke(singletonObjects.get(id), singletonObjects.get(ref));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
