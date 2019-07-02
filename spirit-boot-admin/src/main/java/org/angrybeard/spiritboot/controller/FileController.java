package org.angrybeard.spiritboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritboot.dto.BaseResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by angry_beary on 2019/7/2.
 */
@Slf4j
@RestController
public class FileController {

    private static final String IMG_PATH = "/Users/angry_beary/projects/myProjects/2019/spirit-boot/spirit-boot-admin/src/main/resources/static/images/";

    @PostMapping("/upload")
    @ResponseBody
    public BaseResponse<String> uploadFile(@RequestParam("zg_img") MultipartFile file, HttpServletRequest request) {
        String name = request.getParameter("name");
        log.info(name);
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("上传文件名：{};文件后缀：{}", fileName, suffixName);
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(IMG_PATH + fileName);
        try {
            file.transferTo(dest);
            return BaseResponse.success(fileName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return BaseResponse.error("上传失败");
    }
}
