package com.zzg.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * Project: mybatis-generator-gui
 *
 * @author slankka on 2017/12/13.
 */
public class FastJsonPlugin extends PluginAdapter {

    private FullyQualifiedJavaType annotationJson;
    private FullyQualifiedJavaType propertyNamingStrategy;

    private String annotation = "@JSONType(naming=PropertyNamingStrategy.SnakeCase)";

    public FastJsonPlugin () {
        annotationJson = new FullyQualifiedJavaType("com.alibaba.fastjson.annotation.JSONType");
        propertyNamingStrategy = new FullyQualifiedJavaType("com.alibaba.fastjson.PropertyNamingStrategy");

    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    	//Model 注解
    	topLevelClass.addImportedType(annotationJson);
    	topLevelClass.addImportedType(propertyNamingStrategy);
    	topLevelClass.addAnnotation(annotation);    
    	
    	return true;    
    }
}
