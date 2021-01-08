<%@ page import="com.cw.bean.Student" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式获取不同类型数据</title>
</head>
<body>
<%-- TODO 1.获取基本数据类型--%>
-----------获取基本数据类型数据---------------------<br/>
<%pageContext.setAttribute("num", 10);%>
基本数据类型:${num}<br>

<%-- TODO 2.获取自定义对象类型--%>
-----------获取对象数据---------------------<br/>
<%
    Student stu = new Student("张三", 23);
    // TODO EL表达式中没有空指针异常
    //stu=null;
    pageContext.setAttribute("stu", stu);
%>
<%--相当于调用此行代码<%=pageContext.findAttribute("u")--%>
自定义对象:${stu}===============输出的是内存地址<br/>
<%-- stu.username实现原理:stu.getName() --%>
学生姓名:${stu.username}<br>
学生年龄:${stu.age}<br>

<%-- TODO 3.获取数组类型--%>
-----------获取数组数据---------------------<br/>
<%
    String[] arr = {"hello", "world"};
    pageContext.setAttribute("arr", arr);
%>
数组:${arr}<br>
0索引元素:${arr[0]}<br>
1索引元素:${arr[1]}<br>
<%--TODO EL表达式中没有索引越界异常--%>
${arr[2]}===========如果超过了数组的下标，则什么都不显示<br/>
${arr["1"]}=========会自动为我们转换成下标<br/>
${arr['1']}<br>
<%-- TODO EL表达式中没有字符串拼接--%>
0索引拼接1索引的元素:${arr[0]}+${arr[1]}<br>


<%-- TODO 4.获取List集合--%>
-----------获取List集合数据-----------------<br/>
<%
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    pageContext.setAttribute("list", list);
%>
List集合:${list}<br>
0索引元素:${list[0]}<br>
1索引元素:${list[1]}<br>

<%--TODO 5.获取Map集合--%>
-----------获取Map集合数据------------------<br/>
<%
    HashMap<String, Student> map = new HashMap<>();
    map.put("class01", new Student("张三", 23));
    map.put("class02", new Student("李四", 18));
    pageContext.setAttribute("map", map);
%>
Map集合:${map}<br>
<%--获取map的value，是通过get(Key) --%>
第一个学生对像:${map.class01}<br>
第一个学生对象的姓名:${map.class01.username}<br>
第一个学生对象的姓名:${map["class01"].username}
</body>
</html>
