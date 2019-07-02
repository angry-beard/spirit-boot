package org.angrybeard.spiritboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by angry_beary on 2019/7/2.
 */
@Controller
public class TransferController {

    @RequestMapping(value = "uploadfile")
    public Object fileIndex() {
        return "upload";
    }
}
