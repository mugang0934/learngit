<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">   
<html>  
  <head>  
    <%@ include file="/public/head.jspf" %>  
    <script type="text/javascript">  
        $(function(){  
            $('#dg').datagrid({     
                //请求数据的url地址，后面会改成请求我们自己的url  
                url:'category_listQueryJoinAccount.action',  
                loadMsg:'Loading......',  
                queryParams:{type:''},//参数  
                //width:300,  
                 fitColumns:true,  
                striped:true,  
                nowrap:true,  
                singleSelect:true,  
                pagination:true,  
                rowStyler: function(index,row){  
                    console.info("index" + index + "," + row)  
                    if(index % 2 == 0) {  
                        return 'background-color:#fff;';  
                    } else {  
                        return 'background-color:#ff0;';  
                    }  
                      
                },        
                frozenColumns:[[  
                    {field:'checkbox',checkbox:true},  
                    {field:'id',title:'编号',width:200}    //这里的field字段要和json数据中的一样               
                ]],  
                columns:[[                       
                    {field:'type',title:'类别名称',width:100, //字段type  
                        formatter: function(value,row,index){  
                            return "<span title=" +　value + ">" + value + "</span>";  
                        }  
                    },      
                    {field:'hot',title:'热卖',width:100,  //字段hot  
                        formatter: function(value,row,index){  
                            if(value) { //如果是hot，该值为true，value是boolean型变量  
                                return "<input type='checkbox' checked='checked' disabled='true'"; //勾选  
                            } else {  
                                return "<input type='checkbox' disable='true'"; //不勾选  
                            }  
                        }  
                    },  
                    {field:'account.login',title:'所属管理员',width:200, //account.login管理员登录名  
                        formatter: function(value,row,index){  
                            if(row.account != null && row.account.login != null) {  
                                return row.account.login; //如果登录名不为空，显示登录名  
                            } else {  
                                return "此类别没有管理员";  
                            }  
                    }     
                    }  
                ]]      
            });   
        });  
    </script>  
  </head>  
    
  <body>  
    <table id="dg"></table>  
  </body>  
</html>  