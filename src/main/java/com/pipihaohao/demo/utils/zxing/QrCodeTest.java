package com.pipihaohao.demo.utils.zxing;

/**
 * @description:
 * @author: xfh
 * @create: 2019-07-01 11:26
 **/

public class QrCodeTest {

    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        /*String text = "致橡树\n" +
                "\n" +
                "作者：舒婷\n" +
                "\n" +
                "我如果爱你——\n" +
                "绝不像攀援的凌霄花，\n" +
                "借你的高枝炫耀自己；\n" +
                "我如果爱你——\n" +
                "绝不学痴情的鸟儿，\n" +
                "为绿荫重复单调的歌曲；\n" +
                "也不止像泉源，\n" +
                "常年送来清凉的慰藉；\n" +
                "也不止像险峰，\n" +
                "增加你的高度，衬托你的威仪。\n" +
                "甚至日光，\n" +
                "甚至春雨。\n" +
                "\n" +
                "不，这些都还不够！\n" +
                "我必须是你近旁的一株木棉，\n" +
                "作为树的形象和你站在一起。\n" +
                "根，紧握在地下；\n" +
                "叶，相触在云里。\n" +
                "每一阵风过，\n" +
                "我们都互相致意，\n" +
                "但没有人，\n" +
                "听懂我们的言语。\n" +
                "你有你的铜枝铁干，\n" +
                "像刀，像剑，也像戟；\n" +
                "我有我红硕的花朵，\n" +
                "像沉重的叹息，\n" +
                "又像英勇的火炬。\n" +
                "\n" +
                "我们分担寒潮、风雷、霹雳；\n" +
                "我们共享雾霭、流岚、虹霓。\n" +
                "仿佛永远分离，\n" +
                "却又终身相依。\n" +
                "这才是伟大的爱情，\n" +
                "坚贞就在这里：\n" +
                "爱——\n" +
                "不仅爱你伟岸的身躯，\n" +
                "也爱你坚持的位置，\n" +
                "足下的土地。";*/
        String text = "https://www.baidu.com/";
        // 嵌入二维码的图片路径
        String imgPath = "/Users/renren/Documents/bamboo.jpeg";
        // 生成的二维码的路径及名称
        String destPath = "/Users/renren/Documents/bambooQR1.png";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }

}
