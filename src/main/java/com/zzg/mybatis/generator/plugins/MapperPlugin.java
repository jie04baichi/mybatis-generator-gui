package com.zzg.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;

import java.util.List;

/**
 * Project: mybatis-generator-gui
 *
 * @author slankka on 2017/12/13.
 */
public class MapperPlugin extends PluginAdapter {

    private FullyQualifiedJavaType annotationMapper;
    private String annotation = "@Mapper";

    public MapperPlugin () {
        annotationMapper = new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper");
    }

    @Override
    public boolean validate(List<String> list) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {        
        interfaze.addImportedType(annotationMapper);
        interfaze.addAnnotation(annotation);
        return true;
    }
}
