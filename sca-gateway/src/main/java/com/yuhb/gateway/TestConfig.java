package com.yuhb.gateway;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;

/**
 * Created by yu.hb on 2020-01-10
 */
@ConfigurationProperties(prefix = "test")
public class TestConfig {

    private Integer age;

    private String name;

    private Map<String,Object> metadata;

    private List<MyList> list;




    public static class MyList{
        private String name;
        private Integer age;

        private SList secendList;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public SList getSecendList() {
            return secendList;
        }

        public void setSecendList(SList secendList) {
            this.secendList = secendList;
        }

        @Override
        public String toString() {
            return "MyList{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public static class SList {
            private String sName;
            private Integer sAge;

            public String getsName() {
                return sName;
            }

            public void setsName(String sName) {
                this.sName = sName;
            }

            public Integer getsAge() {
                return sAge;
            }

            public void setsAge(Integer sAge) {
                this.sAge = sAge;
            }
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<MyList> getList() {
        return list;
    }

    public void setList(List<MyList> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", metadata=" + metadata +
                ", list=" + list +
                '}';
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"test\" : {\n" +
                "        \"name\" : \"test\",\n" +
                "        \"list\" : [\n" +
                "            {\n" +
                "                \"name\" :\"listname\",\n" +
                "                \"age\":1\n" +
                "            },\n" +
                "            {\n" +
                "                \"name\" :\"listname2\",\n" +
                "                \"age\":2\n" +
                "            }\n" +
                "        ],\n" +
                "        \"metadata\" : {\n" +
                "            \"intKey\" : 123,\n" +
                "            \"booleanKey\" : true\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Yaml yaml = new Yaml();
        Iterable<Object> objects = yaml.loadAll(json);
        for (Object o: objects) {
            System.out.println(o);
        }
    }
}
