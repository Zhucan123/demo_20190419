###--------通用版的 Dockerfile--------###

#指定基础镜像，在其上进行定制
FROM java:8

#维护者信息
MAINTAINER zhucan <956103955@qq.com>

#这里的 /tmp 目录就会在运行时自动挂载为匿名卷，任何向 /tmp 中写入的信息都不会记录进容器存储层
VOLUME /tmp

#复制上下文目录下的target/XXX.jar 到容器里
COPY target/*.jar app.jar

#bash方式执行，使demo-1.0.0.jar可访问
#RUN新建立一层，在其上执行这些命令，执行结束后， commit 这一层的修改，构成新的镜像。
RUN bash -c "touch /app.jar"

#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime&& echo 'Asia/Shanghai' >/etc/timezone

#声明运行时容器提供服务端口，这只是一个声明，在运行时并不会因为这个声明应用就会开启这个端口的服务,需要注意防火墙是否开放了端口
EXPOSE 8080


#指定容器启动程序及参数   <ENTRYPOINT> "<CMD>"
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]