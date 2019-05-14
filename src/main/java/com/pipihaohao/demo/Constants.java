package com.pipihaohao.demo;

/**
 * @Auther: xfh
 * @Date: 2019/5/14
 * @Description:
 */
public interface Constants {
    String LOGIN_USER = "user";
    String LOGIN_USER_DATASCOPE = "dataScope";
    String ZERO_FILL_TEMPLATE = "%04d";
    String DEFAULT_PASSWORD = "Wangxin@888";

    //资源加载到redis的key
    String ALL_LIST_KEY = "shanhaiguan_all_list";
    String MENU_LIST_KEY = "shanhaiguan_menu_list";
    String API_LIST_KEY = "shanhaiguan_api_list";
    //分页的默认值
    Integer PAGE_NUMBER = 1;
    Integer PAGE_SIZE = 15;

    String ORGANIZATION_PREFIX = "ORG101";
    String ROLE_PREFIX = "GW0303";
    String REDIS_USERLOGIN = "USER:USERLOGIN:";

    String ACTIVITI_PARAM_KEY = "activiti_param_list";

    //告警
    Integer ZERO_NUMBER = 0;// 是否被拒绝未知
    Integer ONE_NUMBER = 1;// 没有被拒绝
    Integer TWO_NUMBER = 2;// 被拒绝

    String EMPTY_STRING = "";

    String TITLE = "用户权限系统告警";

    String NOTICE_IP ="172.21.12.225";
}
