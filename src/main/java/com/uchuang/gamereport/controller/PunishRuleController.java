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
import com.uchuang.gamereport.jpa.PunishRule;
import com.uchuang.gamereport.repo.PunishRuleRepository;


@RestController
@RequestMapping("/api/repo/punish-rule")
@Api(value = "/api/repo/punish-rule",description="PunishRuleController")
public class PunishRuleController {
  @Autowired
  private PunishRuleRepository repository;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    @ApiOperation(httpMethod="GET",value="Query PunishRule")
    public @ResponseBody PunishRule findByPk(@ApiParam(value = "id") @PathVariable("id") String id){
      return repository.findByPk(id);
    }

    @RequestMapping(value="/get-all",method=RequestMethod.GET)
    @ApiOperation(httpMethod="GET",value="Query PunishRule")
    public @ResponseBody java.util.Collection<PunishRule> findAll(){
        return repository.findAll();
    }

    @Transactional
    @RequestMapping(value="",method=RequestMethod.POST)
    @ApiOperation(httpMethod="POST",value="Create PunishRule")
    public @ResponseBody String create(@RequestBody PunishRule entity){
      return repository.create(entity);
    }

    @Transactional
    @RequestMapping(value="",method=RequestMethod.PUT)
    @ApiOperation(httpMethod="PUT",value="Update PunishRule")
    public void update(@RequestBody PunishRule entity){
      repository.update(entity);
    }

    @Transactional
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    @ApiOperation(httpMethod="DELETE",value="Delete PunishRule")
    public void delete(@ApiParam(value = "id") @PathVariable("id") String id){
      repository.delByPk(id);
    }

}
