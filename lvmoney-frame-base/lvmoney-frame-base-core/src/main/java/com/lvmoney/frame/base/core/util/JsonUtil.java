package com.lvmoney.frame.base.core.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.fge.jackson.JsonLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

/**
 * @describe：
 * @author: lvmoney /四川******科技有限公司
 * @version:v1.0 2018年9月30日 上午8:51:33
 */
public class JsonUtil {
    /**
     * 把java对象转化成json string
     *
     * @param t:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:07
     */
    public static <T> String t2JsonString(T t) {
        return JSON.toJSONString(t);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
        OBJECT_MAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    /**
     * json 转 JsonNode
     *
     * @param jsonString:
     * @throws
     * @return: com.fasterxml.jackson.databind.JsonNode
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:07
     */
    public static JsonNode loadJsonObject(String jsonString) {
        try {
            return JsonLoader.fromString(jsonString);
        } catch (IOException e) {
            LOGGER.error("json 转 JsonNode 报错:{}", e);
            return null;
        }
    }

    /**
     * 对象序列化
     *
     * @param object:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:07
     */
    public static <T> String serialize(T object) {
        StringWriter write = new StringWriter();

        try {
            OBJECT_MAPPER.writeValue(write, object);
        } catch (JsonGenerationException var3) {
            LOGGER.error("JsonGenerationException when serialize object to json", var3);
        } catch (JsonMappingException var4) {
            LOGGER.error("JsonMappingException when serialize object to json", var4);
        } catch (IOException var5) {
            LOGGER.error("IOException when serialize object to json", var5);
        }

        return write.toString();
    }

    /**
     * 判断list是否包含某个list
     *
     * @param src:
     * @param dst:
     * @throws
     * @return: java.util.List<java.lang.Boolean>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:08
     */
    public static List<Boolean> strictCheckExistence(List<String> src, List<String> dst) {
        List<Boolean> result = new ArrayList();
        int index = 0;

        for (int i = 0; i < src.size(); ++i) {
            if (((String) src.get(i)).equalsIgnoreCase((String) dst.get(index))) {
                result.add(true);
                ++index;
            } else {
                result.add(false);
            }
        }

        return result;
    }

    /**
     * 是不是json串
     *
     * @param json:
     * @throws
     * @return: boolean
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:09
     */
    public static boolean isValidFromToJson(String json) {
        if (StringUtils.isEmpty(json)) {
            LOGGER.error("input json param is null.");
            return false;
        } else {
            JsonNode jsonObject = null;

            jsonObject = loadJsonObject(json);

            return jsonObject.has("$from");
        }
    }

    /**
     * 添加tag 给json
     *
     * @param json:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:10
     */
    public static String addTagFromToJson(String json) {
        JsonNode jsonObject;
        jsonObject = loadJsonObject(json);
        if (!jsonObject.has("$from")) {
            ((ObjectNode) jsonObject).put("$from", "toJson");
        }

        return jsonObject.toString();
    }

    /**
     * 删除json串的tag
     *
     * @param json:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:10
     */
    public static String removeTagFromToJson(String json) {
        JsonNode jsonObject;
        jsonObject = loadJsonObject(json);
        if (jsonObject.has("$from")) {
            ((ObjectNode) jsonObject).remove("$from");
        }

        return jsonObject.toString();
    }

    /**
     * list 转 list<BitInteger>
     *
     * @param list:
     * @param size:
     * @throws
     * @return: java.util.List<java.math.BigInteger>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:11
     */
    public static List<BigInteger> listToListBigInteger(List<BigInteger> list, int size) {
        List<BigInteger> bigIntegerList = new ArrayList();
        Iterator var3 = list.iterator();

        while (var3.hasNext()) {
            BigInteger bs = (BigInteger) var3.next();
            bigIntegerList.add(bs);
        }

        List<BigInteger> addList = new ArrayList();
        if (bigIntegerList.size() < size) {
            for (int i = 0; i < size - bigIntegerList.size(); ++i) {
                addList.add(BigInteger.ZERO);
            }

            bigIntegerList.addAll(addList);
        }

        return bigIntegerList;
    }

    /**
     * 是不是json
     *
     * @param json:
     * @throws
     * @return: boolean
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:11
     */
    public static boolean isValidJsonStr(String json) {
        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            try {
                ObjectMapper mapper = new ObjectMapper();
                mapper.readTree(json);
                return true;
            } catch (IOException var2) {
                return false;
            }
        }
    }

    /**
     * 复制对象
     *
     * @param obj:
     * @throws
     * @return: T
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:11
     */
    public static <T extends Serializable> T clone(T obj) {
        Serializable clonedObj = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (Serializable) ois.readObject();
            ois.close();
        } catch (Exception var6) {
            LOGGER.error("clone object has error.", var6);
        }

        return (T) clonedObj;
    }

    /**
     * 反序列化
     *
     * @param json:
     * @param clazz:
     * @throws
     * @return: T
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:12
     */
    public static <T> T deserialize(String json, Class<T> clazz) {
        Object object = null;

        try {
            if (isValidFromToJson(json)) {
                LOGGER.error("this jsonString is converted by toJson(), please use fromJson() to deserialize it");
                return null;
            } else {
                object = OBJECT_MAPPER.readValue(json, TypeFactory.rawClass(clazz));
                return (T) object;
            }
        } catch (JsonParseException var4) {
            LOGGER.error("JsonParseException when deserialize json to object", var4);
            return null;
        } catch (JsonMappingException var5) {
            LOGGER.error("JsonMappingException when deserialize json to object", var5);
            return null;
        } catch (IOException var6) {
            LOGGER.error("IOException when deserialize json to object", var6);
            return null;
        }
    }

    /**
     * json 转 list
     *
     * @param json:
     * @param clazz:
     * @throws
     * @return: java.util.List<T>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:13
     */
    public static <T> List<T> deserializeToList(String json, Class<T> clazz) {
        List object = null;

        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, new Class[]{TypeFactory.rawClass(clazz)});
            object = (List) OBJECT_MAPPER.readValue(json, javaType);
        } catch (JsonParseException var4) {
            LOGGER.error("JsonParseException when serialize object to json", var4);
            return null;
        } catch (JsonMappingException var5) {
            LOGGER.error("JsonMappingException when serialize object to json", var5);
            return null;
        } catch (IOException var6) {
            LOGGER.error("IOException when serialize object to json", var6);
        }

        return object;
    }

    /**
     * map 转 json
     *
     * @param map:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:13
     */
    public static String mapToCompactJson(Map<String, Object> map) {
        try {
            return OBJECT_MAPPER.readTree(serialize(map)).toString();
        } catch (JsonProcessingException e) {
            LOGGER.error("map 转 json 报错:{}", e);
            return null;
        }
    }

    /**
     * stringMap 转json
     *
     * @param map:
     * @throws
     * @return: java.lang.String
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:14
     */
    public static String stringMapToCompactJson(Map<String, String> map) {
        try {
            return OBJECT_MAPPER.readTree(serialize(map)).toString();
        } catch (JsonProcessingException e) {
            LOGGER.error("string map 转 json 报错:{}", e);
            return null;
        }
    }

    /**
     * 实体转map
     *
     * @param object:
     * @throws
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:14
     */
    public static Map<String, Object> objToMap(Object object) {
        JsonNode jsonNode = null;
        try {
            jsonNode = OBJECT_MAPPER.readTree(serialize(object));
        } catch (JsonProcessingException e) {
            LOGGER.error("对象转map报错:{}", e);
        }
        return (HashMap) OBJECT_MAPPER.convertValue(jsonNode, HashMap.class);
    }

    /**
     * map 转实体
     *
     * @param map:
     * @param clazz:
     * @throws
     * @return: T
     * @author: lvmoney /XXXXXX科技有限公司
     * @date: 2021/6/30 9:15
     */
    public static <T> T mapToObj(Map<String, Object> map, Class<T> clazz) {
        T pojo = OBJECT_MAPPER.convertValue(map, clazz);
        return pojo;
    }

}

