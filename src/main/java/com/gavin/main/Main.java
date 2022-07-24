package com.gavin.main;

/**
 * Created by 17428 on 2022/6/4.
 */
public class Main {


    public static void main(String[] args) {

        String code = "#万能的帮助命令docker 命令 --help   #docker images --help#搜索镜像docker search 镜像  #docker search ubuntu#拉取镜像docker pull 镜像:版本 #docker pull ubuntu:18.04#查看本地所有镜像docker imagesdocker images -aq  #显示所有镜像的id #删除镜像docker rmi -f 镜像名/id  #-f强制删除镜像docker rmi -f $(docker images -aq)  #删除所有镜像#启动容器，可以使用 镜像名:版本号 启动，如果是最新版可以省略版本号；也可以使用 镜像iddocker run -i -t 镜像名:版本号 /bin/bash  docker run -i -t id /bin/bashdocker run -it --rm id /bin/bash  #添加 --rm参数 可以实现在退出容器后就删除容器（一般用于测试）参数说明：-i: 交互式操作。-t: 终端。ubuntu: ubuntu 镜像。/bin/bash：放在镜像名后的是命令，这里我们希望有个交互式 Shell，因此用的是 /bin/bash。要退出终端，直接输入 exit 这个命令会停止容器！可以使用 ctrl + p + q 组合键退出，不会退出容器#退出容器exit      #这个命令会停止容器！ctrl + p + q    #组合键退出，不会退出容器#查看当前运行的容器docker psdocker ps -a     #显示所有容器#启动一个已停止的容器docker start 容器id #通过docker ps -a可以查看#重启一个容器docker restart 容器id #停止容器docker stop 容器iddocker kill 容器id   #当使用 stop 无法正常停止的时候使用 kill#后台运行容器：-d 后台运行 --name 设定容器的别名docker run -i -t -d -p 外网端口:容器端口 --name 容器别名 镜像 /bin/bash  #docker run -i -t -d -p 6666:80 --name ubuntu-test ubuntu /bin/bash#在使用 -d 参数时，容器启动后会进入后台，此时想要进入容器，可以通过以下指令进入docker attach 容器id  #重新进入容器当前正在运行的命令终端，使用exit会停止容器！docker exec -i -t 容器id /bin/bash #进入容器并开启一个新的终端，使用exit不会停止容器（常用）#删除容器docker rm -f 容器别名/容器id  #docker rm -f test_ubuntu#拷贝容器文件到宿主机（复制文件）docker cp 容器id/容器id:容器内文件路径 要拷贝到的路径  #docker cp test-ubuntu:/home/test.txt /home#查看容器的cpu内存状态docker stats# 从容器创建一个新的镜像docker commit -a 作者 -m 说明信息 容器id 容器名称:版本号 #docker commit -a \"xiaoqiangclub\" -m \"this is a test!\" a404c6c174a2  mymysql:v1 OPTIONS说明：-a :提交镜像的作者；-c :使用Dockerfile指令来创建镜像；-m :提交时的说明文字；-p :在commit时，将容器暂停。";

        String[] split = code.split("#");

        for (int i = 0; i < split.length; i++) {
            System.out.println("#"+split[i]);
        }



    }

}
