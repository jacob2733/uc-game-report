package com.uchuang.gamereport.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.uchuang.gamereport.jpa.Report;
import com.uchuang.gamereport.repo.ReportRepository;


@RestController
@RequestMapping("/api/repo/report")
@Api(value = "/api/repo/report",description="ReportController")
public class ReportController {
  @Autowired
  private ReportRepository repository;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ApiOperation(httpMethod="GET",value="Query Report")
    public @ResponseBody Report findByPk(@ApiParam(value = "id") @PathVariable("id") String id){
      return repository.findByPk(id);
    }

    @RequestMapping(value="/get-all",method=RequestMethod.GET)
    @ApiOperation(httpMethod="GET",value="Query Report")
    public @ResponseBody java.util.Collection<Report> findAll(){
        return repository.findAll();
    }

    @Transactional
    @RequestMapping(value="",method=RequestMethod.POST)
    @ApiOperation(httpMethod="POST",value="Create Report")
    public @ResponseBody String create(@RequestBody Report entity){
      return repository.create(entity);
    }

    @Transactional
    @RequestMapping(value="",method=RequestMethod.PUT)
    @ApiOperation(httpMethod="PUT",value="Update Report")
    public void update(@RequestBody Report entity){
      repository.update(entity);
    }

    @Transactional
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    @ApiOperation(httpMethod="DELETE",value="Delete Report")
    public void delete(@ApiParam(value = "id") @PathVariable("id") String id){
      repository.delByPk(id);
    }

}
