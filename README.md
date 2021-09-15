# 遇到问题

```
删除out目录 重新编译out目录里面没web目录下的文件  解决：选择Update classes and resources
```

# tomcat启动忽略项目名

> 修改 apache-tomcat-8.5.54\conf\server.xml

```xml
<Host name="localhost"  appBase="webapps" unpackWARs="true" autoDeploy="true">
		<!--<Context docBase="项目路径\项目名" path="" reloadable="false"/>-->
	<Context docBase="D:\apache-tomcat-8.5.54\webapps\hotel" path="" reloadable="false"/> 
    <Valve className="org.apache.catalina.valves.AccessLogValve" directory="logs"
               prefix="localhost_access_log" suffix=".txt"
               pattern="%h %l %u %t &quot;%r&quot; %s %b" />
</Host>
```

> ```xml
> <!--<Context docBase="项目路径\项目名" path="" reloadable="false"/>-->
> <Context docBase="D:\apache-tomcat-8.5.54\webapps\hotel" path="" reloadable="false"/>
> ```

# 配置工厂模式之后请求服务层后dao层为空

>原因 ：把每个模块的dao实现和service实现写在一起了

```properties
foodTypeDao=com.qf.java2105.lzj.dao.impl.FoodTypeDaoImpl
foodDao=com.qf.java2105.lzj.dao.impl.FoodDaoImpl

foodTypeService=com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl
foodService=com.qf.java2105.lzj.service.impl.FoodServiceImpl

```

>解决：把dao实现全部写在上面

```properties
foodDao=com.qf.java2105.lzj.dao.impl.FoodDaoImpl
foodTypeDao=com.qf.java2105.lzj.dao.impl.FoodTypeDaoImpl

foodService=com.qf.java2105.lzj.service.impl.FoodServiceImpl
foodTypeService=com.qf.java2105.lzj.service.impl.FoodTypeServiceImpl
frontService=com.qf.java2105.lzj.service.impl.FrontServiceImpl

```

#  项目中alert弹框不起作用

```java
return"<script>alert(" + foodTypeResultVO.getMessage() + ");</script>";
```

> ​	解决：加两个引号

```java
return"<script>alert('" + foodTypeResultVO.getMessage() + "');</script>";
```

# 弹框之后白屏没回到原来的页面

>解决：加上 window.location.href=地址;

```java
    return"<script>alert('" + MessageConstant.FOODTYPE_NAME_CANNOT_BE_EMPTY + "');" +
                "window.location.href=\"/foodType?method=search\";</script>";
```

