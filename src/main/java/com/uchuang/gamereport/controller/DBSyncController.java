package com.uchuang.gamereport.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import stone.dal.jdbc.api.StJdbcTemplate;
import stone.dal.jdbc.api.meta.ExecResult;
import stone.dal.jdbc.api.meta.SqlQueryMeta;
import stone.dal.tools.rdbms.impl.DBSync;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DBSyncController {

  @Autowired
  private DBSync dbSync;

  @Autowired
  private StJdbcTemplate stJdbcTemplate;

  @RequestMapping(value = "/db-tools/sync", method = RequestMethod.POST)
  public List<ExecResult> syncDb(@RequestBody Request request) {
    List<ExecResult> results = dbSync.syncDb(request.delta, request.dbInitPath);
    if (request.getEnv() != null) {
      String[] paths = StringUtils.split(request.dbInitPath, ".");
      results.addAll(dbSync.runScript(StringUtils.replace(request.dbInitPath, "." + paths[paths.length - 1],
          "-" + request.getEnv() + "." + paths[paths.length - 1])));
    }
    if (!request.delta) {
//      elasticSearchAdaptor.removeIndex("bank_transaction");
    }
    return results;
  }

  @RequestMapping(value = "/db-tools/sql", method = RequestMethod.POST)
  public String downloadSql(@RequestBody Request request) {
    List<String> results = request.delta ? new ArrayList<>() : dbSync.getDbInitScript();
    results.addAll(dbSync.getDbScript(request.delta));
    return StringUtils.join(results, ";\n") + ";";
  }

  @RequestMapping(value = "/db-tools/query", method = RequestMethod.GET)
  public List query(@RequestBody ExecRequest request) {
    return stJdbcTemplate.query(SqlQueryMeta.factory().sql(request.getSql()).build());
  }

  public static class ExecRequest {
    private String sql;

    public String getSql() {
      return sql;
    }

    public void setSql(String sql) {
      this.sql = sql;
    }
  }

  public static class Request {
    private String dbInitPath = "db-init.sql";

    private boolean delta = true;

    private String env;

    public String getEnv() {
      return env;
    }

    public void setEnv(String env) {
      this.env = env;
    }

    public boolean getDelta() {
      return delta;
    }

    public void setDelta(boolean delta) {
      this.delta = delta;
    }

    public String getDbInitPath() {
      return dbInitPath;
    }

    public void setDbInitPath(String dbInitPath) {
      this.dbInitPath = dbInitPath;
    }
  }
}
