# MinSystem

- 项目看成是一个大的系统，由各种子系统和其他的功能模块组成；这些子系统分工明确且相互独立，都是为了整个系统服务而存在。
- 每个子系统应该有唯一的标识(id)来分布，出现问题时程序员很快可以根据id找到对应的子系统；
- 每个子系统应该提供自己公有的接口(start/stop)和自己功能实现的独立接口；
- 每个子系统会提供自己的运行状态供外界查询；
- 每个子系统会提供异常处理的接口，一般实现是将自己的id加报错信息进行日志打印；
- 整个项目看成是一个圆，圆上的节点就是该项目的子系统，圆内的结构就是项目的各个功能模块.


### USE


allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



dependencies {
    implementation 'com.github.YcsGH:MinSystem:1.0.2'
}
