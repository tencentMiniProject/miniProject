package com.controller;

/**
 * Created by william on 2017/7/12.
 */
import com.service.MessageService;
import com.util.JsonUtils;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/messageInterface")
public class MessageController {
    @Autowired
    MessageService messageService;

    @ResponseBody
    @RequestMapping(value="/getMessage",produces = "application/json; charset=utf-8")
    public String getMessage(HttpSession session,String username) {
        return messageService.getMessage(username);
    }

    @ResponseBody
    @RequestMapping(value = "/markReadMessage",produces = "application/json; charset=utf-8")
    public void markReadMessage(HttpSession session, int id){
        messageService.markReadMessage(id);
    }
}
