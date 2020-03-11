package com.uchuang.gamereport.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import stone.dal.ext.filer.FileResolver;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/multi-part")
@Api(value = "/api/multi-part", description = "FileController")
public class FileController {

  @Autowired
  private FileResolver fileResolver;

  private static Logger s_logger = LoggerFactory.getLogger(FileController.class);

  @RequestMapping(value = "/{category}", method = RequestMethod.POST)
  @ApiOperation(httpMethod = "POST", value = "Upload File", notes = "Upload File")
  public Response upload(@RequestBody MultipartFile file,
      @ApiParam(value = "category") @PathVariable("category") String category) throws IOException {
    String uuid = fileResolver.resolve(file.getInputStream(), category);
    return new Response(file.getOriginalFilename(), uuid);
  }

  @RequestMapping(value = "/download/{category}/{uuid}", method = RequestMethod.GET)
  public void getFile(HttpServletResponse response,
      @PathVariable("uuid") String uuid, @PathVariable("category") String category) throws IOException {
    OutputStream out = null;
    try {
      out = response.getOutputStream();
      response.setHeader("Content-disposition", "attachment;fileId=" + uuid);
      InputStream fis = fileResolver.getInputStream(uuid, category);
      byte[] dataBytes = new byte[1024];
      int nread = 0;
      while ((nread = fis.read(dataBytes)) != -1) {
        out.write(dataBytes, 0, nread);
      }
      out.flush();
    } finally {
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          s_logger.error(e.getMessage());
        }
      }
    }
  }

  public static class Response {
    private String name;

    private String uuid;

    Response(String name, String uuid) {
      this.name = name;
      this.uuid = uuid;
    }

    public String getName() {
      return name;
    }

    public String getUuid() {
      return uuid;
    }
  }
}