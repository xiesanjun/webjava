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
    <title>用户信息</title>
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/default/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.4/themes/icon.css">
    <script type="text/javascript" src="js/jquery-easyui-1.4/demo/demo.css"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/plugins/jquery.datagrid.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="esayui-layout">
<div data-options="region:'north'" style="height:100px">
    <div style="margin:20px 20px;">
        用户ID：<input id="userid" name="id" style="width:100px">
        <input type="button" class="easyui-linkbutton" onclick="" value="查询"
               style="width:100px;margin-left: 500px">
    </div>
    <div style="margin:20px 20px;">时间范围：<input id="startime" name="startime" class="easyui-datetimebox"> -- <input
            id="endtime" name="endtime" class="easyui-datetimebox"><a href="#"
                                                                      style="margin-left: 300px">导出图表</a></div>
    <div data-options="region:'south',split:true" style="height: 600px;">
        <table class="easyui-datagrid" id="mytb"></table>
    </div>
    <script type="text/javascript">
        $('#mytb').datagrid({
            fitColumns: true,
            autoRowHeight: true,
            border: false,
            striped: true,
            method: "post",
            idField: "id",
            singleSelect: true,
            checkOnSelect: true,
            selectOnCheck: true,
            url: 'userinfo/userinfo.action',
            fitcolumns: true,
            pagination: true,
            fit: true,
            pageSize: 20,
            rownumbers: true,
            remoteSort: true,
            sortOrder: "asc",
            columns: [[
                {field: 'id', title: '用户ID', width: 80, hidden: false},
                {field: 'nickname', title: '昵称', width: 150},
                {field: 'registrationtime', title: '注册时间', width: 100},
                {field: 'registrationip', title: '注册ip', width: 100},
                {field: 'attribution', title: '归属地', width: 100},
                {field: 'system', title: '系统', width: 100},
                {field: 'operator', title: '运营商', width: 100},
                {
                    field: 'onlinestatus', title: '在线状态', width: 100, formatter: function (value, row, index) {
                    switch (row.onlinestatus) {
                        case 0: {
                            return "在线";
                            break;
                        }
                        case 1: {
                            return "离线";
                            break;
                        }
                    }
                }
                },
                {
                    field: 'accountstatus', title: '账号状态', width: 100, formatter: function (value, row, index) {
                    switch (row.accountstatus) {
                        case 0: {
                            return "正常";
                            break;
                        }
                        case 1: {
                            return "封禁";
                            break;
                        }
                    }
                }
                },
                {field: 'lastlogintime', title: '最后一次登陆时间', width: 100},
                {field: 'rechargetime', title: '充值时间', width: 100},
                {field: 'rechargeamount', title: '充值金额', width: 100},
                {field: 'rechargetimes', title: '充值次数', width: 100},
                {field: 'rechargemethod', title: '充值方式', width: 100},
                {field: 'exchangetimes', title: '兑换次数', width: 100},
                {field: 'exchangeingots', title: '兑换元宝', width: 100},
                {field: 'gameroom', title: '游戏房间/输赢金币', width: 100},
                {field: 'accountremainingingots', title: '账号剩余元宝', width: 100},
                {field: 'accountremaininggold', title: '账号剩余金币', width: 100},
                {field: 'saferemaininggold', title: '保险箱剩余金币', width: 100},
                {field: 'saferemainingingot', title: '保险箱剩余元宝', width: 100}
            ]]
        });
    </script>
</body>
</html>