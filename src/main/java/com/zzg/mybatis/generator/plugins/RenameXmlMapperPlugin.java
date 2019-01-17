package com.zzg.mybatis.generator.plugins;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * @ClassName : RenameJavaMapperPlugin 
 * @Description : TODO
 * @author : pengjie
 * @email  : 627799251@qq.com
 * @version  
 * @Date ： 2019年1月17日 下午5:52:53
*/

public class RenameXmlMapperPlugin extends PluginAdapter {
    private String searchString = "Mapper$";
    private String replaceString = "Mapper";
    private Pattern pattern;
    
	@Override
	public boolean validate(List<String> warnings) {
        boolean valid = stringHasValue(searchString)
                && stringHasValue(replaceString);

        if (valid) {
            pattern = Pattern.compile(searchString);
        } else {
            if (!stringHasValue(searchString)) {
                warnings.add(getString("ValidationError.18", //$NON-NLS-1$
                        "RenameXmlMapperPlugin", //$NON-NLS-1$
                        "searchString")); //$NON-NLS-1$
            }
            if (!stringHasValue(replaceString)) {
                warnings.add(getString("ValidationError.18", //$NON-NLS-1$
                        "RenameXmlMapperPlugin", //$NON-NLS-1$
                        "replaceString")); //$NON-NLS-1$
            }
        }

        return valid;
    }

    @Override
    public void initialized(IntrospectedTable introspectedTable) {
        String oldType = introspectedTable.getMyBatis3XmlMapperFileName();
        Matcher matcher = pattern.matcher(oldType);
        oldType = matcher.replaceAll(replaceString);
        
        introspectedTable.setMyBatis3XmlMapperFileName(oldType);
    }
}
