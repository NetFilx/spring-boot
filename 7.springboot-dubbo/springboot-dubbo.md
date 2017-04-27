# springboot整合dubbo

运行环境：JDK 7 或 8，Maven 3.0+

技术栈：SpringBoot 1.5+、Dubbo 2.5+、ZooKeeper 3.3+

具体看工程吧，代码比较简单的。注释也写的清楚。

提几个点吧：

1. 这里用的是dubbo的最新版，虽然这个最新版距离我们已经有好多年了，用还是可以用，如果真的需要使用的话，可以引用dubbox这个东西，具体的操作就是引入git下dubbox，然后自己编译，而且有一个问题就是springboot没有整合dubbox的包，需要使用xml配置，但是找到了[替代方案](http://blog.csdn.net/wang_jingj/article/details/53452973)
2. 其实更加推荐是spring cloud东西是很新的，而且spring的生态圈也是很完整，一直在维护，但是缺点也是在于太新了，导致没有多少公司会用。接下来我也想要试试用spring cloud。
3. 刚开始我一直都不成功，后来发现原来是依赖包的问题，建议可以去maven的中央仓库先看看，不过要注意这个包的依赖（刚开始我依赖了一个依赖于spring-boot 1.3.5的包，但是工程中的springboot用的是1.5.2，这样就产生了冲突）。没有这个包的依赖就自己打包，自己引用依赖就行了。
4. 注意端口问题，provider和consumer的端口不要冲突了