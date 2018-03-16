package edu.whu.factory;

import com.alibaba.fastjson.JSON;
import edu.whu.model.Configuration;
import edu.whu.model.Table;
import edu.whu.model.TableConfiguration;
import edu.whu.syntax.SQLAnalyze;
import edu.whu.utils.DBUtils;
import edu.whu.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @author Created By LiJie at 2018/3/16
 */
public class TableFactory implements AbstractFactory<Table> {
    private Logger logger = LoggerFactory.getLogger(TableFactory.class);
    private TableConfiguration tableConfiguration;
    private Configuration configuration;

    private static final String CREATED_TABLE_SQL = "SHOW CREATE TABLE #{}";

    public TableFactory(TableConfiguration tableConfiguration, Configuration configuration) {
        this.tableConfiguration = tableConfiguration;
        this.configuration = configuration;
    }


    @Override
    public Table produce() {
        Table table = new Table();
        table.setTableConfiguration(tableConfiguration);
        table.setName(tableConfiguration.getName());
        ResultSet resultSet = DBUtils.execute(configuration, StringUtils.replace(CREATED_TABLE_SQL, table.getName()));
        try {
            while (resultSet.next()) {
                String sql = resultSet.getString("Create Table");
                table.setTable(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}