<%--suppress ALL --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href=" <%=basePath%>">
    <base target="center"/>
    <title>AB游戏后台管理系统</title>
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/icon.css">
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
<div class="easyui-layout" style="width:100%;height:100%">
    <div data-options="region:'north'" style="height:10%">
        <div style="float: left;width: 200px;margin-top: 20px;margin-left: 20px;font-size: 30px">游戏管理中心</div>
        <div style="float: right;width: 200px;margin-top: 30px;font-size: 15px">
            <span>昵称</span> <a href="#">官网</a> <a href="#">改密</a> <a href="#">退出</a>
        </div>
    </div>
    <div data-options="region:'west',split:true" title="AB游戏后台管理系统" style="width: 200px;">
        <div class="easyui-accordion" data-options="fit:true,border:false">
            <div title="模块管理" data-options="selected:true">
                <div style="margin: 5px">
                    <ul class="tree easyui-tree" data-options="animate:true,lines:true">
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>权限管理</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>部门权限</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>后台权限</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>统计查询</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>综合数据</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>注册用户</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>实时在线</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>平台充值</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>日志查询</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>游戏日志</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>管理日志</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>道具日志（暂无）</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>会员日志（暂无）</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>排行查询</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>充值排行</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>财富排行</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>贡献度</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>运行工具</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>渠道运营数据</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>平台配置操作</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>大客户维护</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>金币流水-用户统计</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>元宝流水-用户统计</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>GM管理</span>
                            <ul>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span onclick="addTab('用户信息','http://www.baidu.com')">用户信息</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>GM工具</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>邮件发送</span>
                                </li>
                                <li data-options="iconCls:'icon-pencil'">
                                    <span>跑马灯</span>
                                </li>
                            </ul>
                        </li>
                        <li data-options="iconCls:'icon-large-smartart'">
                            <span>代理后台</span>
                            <ul>
                                <li data-options="state:'closed',iconCls:'icon-joystick'">
                                    <span>用户管理</span>
                                    <ul>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户列表</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户在线状态</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户游戏记录</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户充值记录</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户转账记录</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户输赢记录</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>用户财富日志</span>
                                        </li>
                                    </ul>
                                </li>
                                <li data-options="state:'closed',iconCls:'icon-joystick'">
                                    <span>代理管理</span>
                                    <ul>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>代理推广员</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>游戏流水统计</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>异地登录玩家</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>代理结算记录</span>
                                        </li>
                                    </ul>
                                </li>
                                <li data-options="state:'closed',iconCls:'icon-joystick'">
                                    <span>我的代理</span>
                                    <ul>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>我的推广信息</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>我的推广结算</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>我的二级代理（暂无）</span>
                                        </li>
                                        <li data-options="iconCls:'icon-joystick_add'">
                                            <span>我的三级代理（暂无）</span>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div data-options="region:'center',title:'位置'">
        <div id="tabs" class="easyui-tabs" data-options="tools:'#tab-tools',fit:true,border:false">
            <div title="主页" style="padding: 10px;"></div>
        </div>
    </div>
    <script type="text/javascript">
        //创建tab
        function addTab(title, url) {
            if ($('#tabs').tabs('exists', title)) {
                $('#tabs').tabs('select', title);
            } else {
                var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
                $('#tabs').tabs('add', {
                    title: title,
                    content: content,
                    closable: true
                });
            }
        }
    </script>
</div>
</body>
</html>
