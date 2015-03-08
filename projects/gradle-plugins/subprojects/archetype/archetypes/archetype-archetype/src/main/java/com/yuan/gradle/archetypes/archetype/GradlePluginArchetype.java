/**
 *
 */
package com.yuan.gradle.archetypes.archetype;


import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import com.yuan.gradle.gui.core.fields.Field;
import com.yuan.gradle.plugins.archetype.core.ArchetypeDescriptor;
import com.yuan.gradle.plugins.archetype.core.BasicArchetype;
import com.yuan.gradle.plugins.archetype.core.ProjectInfo;
import com.yuan.gradle.plugins.archetype.gui.AppFrame;
import com.yuan.gradle.plugins.archetype.utils.ValidateUtil;


/**
 * @author Yuanjy
 *
 */
public class GradlePluginArchetype extends BasicArchetype {
    private static final long serialVersionUID = 1L;
    private Field<JTextField> idField;
    //private Field<JTextField> nameField;
    private Field<JTextField> classField;

    public GradlePluginArchetype(AppFrame appFrame, ArchetypeDescriptor achetypeDescriptor) {
        super(appFrame, achetypeDescriptor);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.yuan.gradle.plugins.archetype.core.BasicArchetype#getArchetypeFields()
     */
    @Override
    protected List<Field<? extends Component>> getArchetypeFields() {
        List<Field<? extends Component>> fieldList = new ArrayList<Field<? extends Component>>();
        idField = createTextField("*插件ID：", "java");
        //nameField = createTextField("*插件名称：", "java");
        classField = createTextField("*实现类：", "com.yuan.gradle.plugins.java.JavaPlugin");
        fieldList.add(idField);
        //fieldList.add(nameField);
        fieldList.add(classField);
        return fieldList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.yuan.gradle.plugins.archetype.core.BasicArchetype#getArchetypeParams(com.yuan.gradle.plugins.archetype.core
     * .ProjectInfo)
     */
    @Override
    protected Map<String, Object> getArchetypeParams(ProjectInfo project) throws Exception {
        ValidateUtil.isEmptyString(idField.getField().getText(), "插件ID不能为空！");
        //ValidateUtil.isEmptyString(nameField.getField().getText(), "插件名称不能为空！");
        ValidateUtil.isEmptyString(classField.getField().getText(), "实现类不能为空！");

        Map<String, Object> archetypeParams = new HashMap<String, Object>();
        archetypeParams.put("pluginId", idField.getField().getText());
        //archetypeParams.put("pluginName", nameField.getField().getText());
        archetypeParams.put("implementationClass", classField.getField().getText());
        return archetypeParams;
    }
}
