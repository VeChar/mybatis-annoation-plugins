package com.github.whujack.model;

import java.util.List;

/**
 * @author Created By LiJie at 2018/3/19
 */
public class Interface {
    private String packageName;
    private List<String> importPackage;
    private String name;
    private List<String> methodList;
    private Clazz sqlProvider;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("package " + packageName + ";\n\n");
        for (int i = 0; importPackage != null && i < importPackage.size(); i++) {
            builder.append("\nimport " + importPackage.get(i) + ";");
        }
        builder.append("\n");
        builder.append("\npublic interface " + name + "{\n");
        for (int i = 0; methodList != null && i < methodList.size(); i++) {
            builder.append("\n\t" + methodList.get(i));
        }
        builder.append("\n");
        if (sqlProvider != null) {
            builder.append("\n");
            String classStr = sqlProvider.toString();
            builder.append(classStr.replaceAll("\n", "\n\t"));
        }
        builder.append("\n}");

        return builder.toString();
    }

    public String getPackageName() {
        return packageName;
    }

    public Interface setPackageName(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public List<String> getImportPackage() {
        return importPackage;
    }

    public Interface setImportPackage(List<String> importPackage) {
        this.importPackage = importPackage;
        return this;
    }

    public String getName() {
        return name;
    }

    public Interface setName(String name) {
        this.name = name;
        return this;
    }

    public List<String> getMethodList() {
        return methodList;
    }

    public Interface setMethodList(List<String> methodList) {
        this.methodList = methodList;
        return this;
    }

    public Clazz getSqlProvider() {
        return sqlProvider;
    }

    public Interface setSqlProvider(Clazz sqlProvider) {
        this.sqlProvider = sqlProvider;
        return this;
    }
}
