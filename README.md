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

