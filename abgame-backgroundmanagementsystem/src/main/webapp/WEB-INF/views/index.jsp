<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href=" <%=basePath%>">
    <title>AB游戏后台管理系统</title>
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/icon.css">
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<style>
    a {
        text-decoration: none;
    }
</style>
<body class="easyui-layout">
<div class="easyui-layout" style="width:100%;height:100%">
    <div data-options="region:'north'" style="height:10%">
        <div style="float: left;width: 200px;margin-top: 20px;margin-left: 20px;font-size: 30px">游戏管理中心</div>
        <div style="float: right;width: 200px;margin-top: 30px;font-size: 15px">
            <span>${sessionScope.entity.nickname}</span> <a href="#">官网</a> <a href="#">改密</a> <a href="#">退出</a>
        </div>
    </div>
    <div data-options="region:'west',split:true" title="AB游戏后台管理系统" style="width: 200px;">
        <ul id="tree"></ul>
    </div>
    <div id="tabsMenu" class="easyui-menu" style="width:120px;">
        <div name="close">关闭</div>
        <div name="Other">关闭其他</div>
        <div name="All">关闭所有</div>
    </div>
    <div data-options="region:'center',title:'位置'">
        <div class="easyui-tabs" fit="true" border="false" id="tabs">
            <div title="首页">
                <%for (int i = 1; i <= 6; i++) { %>
                <h<%=i%> align="center">欢迎访问AB游戏后台管理系统！</h<%=i%>>
                <%} %>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    $(function () {
        //动态菜单数据
        var treeData = [{
                text: "权限管理",
                iconCls: "icon-large-smartart",
                state: "closed",
                children: [{
                    text: "部门权限",
                    iconCls: "icon-edit",
                    state: "",
                    attributes: {
                        url: "http://www.baidu.com"
                    }
                }, {
                    text: "后台权限",
                    iconCls: "icon-edit",
                    attributes: {
                        url: "http://www.baidu.com"
                    }
                }]
            },
                {
                    text: "统计查询",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "综合数据",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "后台权限",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "实时在线",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "平台充值",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }]
                }, {
                    text: "日志查询",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "游戏日志",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "管理日志",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "道具日志（暂无）",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "会员日志（暂无）",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }]
                }, {
                    text: "排行查询",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "充值排行",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "财富排行",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "贡献度",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }]
                }, {
                    text: "运行工具",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "渠道运营数据",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "平台配置操作",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "大客户维护",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "金币流水-用户统计",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "元宝流水-用户统计",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }]
                }, {
                    text: "GM管理",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "用户信息",
                        iconCls: "icon-edit",
                        attributes: {
                            url: "userinfo/gmmanager.action"
                        }
                    }, {
                        text: "GM工具",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "邮件发送",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }, {
                        text: "跑马灯",
                        iconCls: "icon-edit",
                        attributes: {
                            url: ""
                        }
                    }]
                }, {
                    text: "代理后台",
                    iconCls: "icon-large-smartart",
                    state: "closed",
                    children: [{
                        text: "用户管理",
                        state: "",
                        children: [{
                            text: "用户列表",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户在线状态",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户游戏记录",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户充值记录",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户转账记录",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户输赢记录",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "用户财富日志",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }]
                    }, {
                        text: "代理管理",
                        state: "",
                        children: [{
                            text: "代理推广员",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "游戏流水统计",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "异地登录玩家",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "代理结算记录",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }]
                    }, {
                        text: "我的代理",
                        state: "",
                        children: [{
                            text: "我的推广信息",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "我的推广结算",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "我的二级代理（暂无）",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }, {
                            text: "我的三级代理（暂无）",
                            iconCls: "icon-edit",
                            attributes: {
                                url: ""
                            }
                        }]

                    }]
                }
            ]
        ;

        //实例化树形菜单
        $("#tree").tree({
            data: treeData,
            lines: true,
            onClick: function (node) {
                if (node.attributes) {
                    Open(node.text, node.attributes.url);
                }
            }
        });

        //在右边center区域打开菜单，新增tab
        function Open(text, url) {
            var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';

            if ($("#tabs").tabs('exists', text)) {
                $('#tabs').tabs('select', text);
            } else {
                $('#tabs').tabs('add', {
                    title: text,
                    closable: true,
                    content: content
                });
            }
        }

        //绑定tabs的右键菜单
        $("#tabs").tabs({
            onContextMenu: function (e, title) {
                e.preventDefault();
                $('#tabsMenu').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                }).data("tabTitle", title);
            }
        });

        //实例化menu的onClick事件
        $("#tabsMenu").menu({
            onClick: function (item) {
                CloseTab(this, item.name);
            }
        });

        //几个关闭事件的实现
        function CloseTab(menu, type) {
            var curTabTitle = $(menu).data("tabTitle");
            var tabs = $("#tabs");

            if (type === "close") {
                tabs.tabs("close", curTabTitle);
                return;
            }

            var allTabs = tabs.tabs("tabs");
            var closeTabsTitle = [];

            $.each(allTabs, function () {
                var opt = $(this).panel("options");
                if (opt.closable && opt.title != curTabTitle && type === "Other") {
                    closeTabsTitle.push(opt.title);
                } else if (opt.closable && type === "All") {
                    closeTabsTitle.push(opt.title);
                }
            });

            for (var i = 0; i < closeTabsTitle.length; i++) {
                tabs.tabs("close", closeTabsTitle[i]);
            }
        }
    });
</script>
</html>
