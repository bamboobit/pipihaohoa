package com.pipihaohao.demo.controller;

import com.pipihaohao.demo.utils.zxing.QRCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @description: 二维码相关
 * @author: xfh
 * @create: 2019-07-02 11:26
 **/

@Api(value = "二维码相关", tags = "")
@RestController
@RequestMapping(value = {"/qrCode","/v1/qrCode"})
@Slf4j
public class QRCodeController {

    @ApiOperation(value = "生成二维码",notes = "")
    @PostMapping(value = "/getCode")
    public void getCode(@RequestParam String content){
        // 嵌入二维码的图片路径
        String imgPath = "/Users/renren/Documents/bamboo.jpeg";
        //生成二维码
        BufferedImage image = null;
        HttpServletResponse response = null;
        try {
            image = QRCodeUtil.createImage(content, imgPath, true);
            // 将内存中的图片通过流动形式输出到客户端
            response.setHeader("Content-Type", "image/jpeg");
            ImageIO.write(image, "jpg", response.getOutputStream());
        }catch (Exception e){}

    }
}
