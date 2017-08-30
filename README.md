#### 跟我学spring3
##### 第一章
* 访问权限未写时，默认包内访问权限
##### 第二章
* 控制反转，依赖注入
	* 容器创建和控制对象，可以将一个类注入到另一个类，这些类的获取都可以通过IOC容器来获取
	* 应用程序原本是老大，要获取什么资源都是主动出击，但是在IoC/DI思想中，应用程序就变成被动的了，被动的等待IoC容器来创建并注入它所需要的资源了
	* 由IoC容器帮对象找相应的依赖对象并注入，而不是由对象主动去找
	* “依赖注入”：是组件之间依赖关系由容器在运行期决定，形象的说，即由容器动态的将某个依赖关系注入到组件之中
	* 被注入对象依赖IoC容器配置依赖对象
* Ioc容器
	* IoC容器就是具有依赖注入功能的容器，IoC容器负责实例化、定位、配置应用程序中的对象及建立这些对象间的依赖。应用程序无需直接在代码中new相关的对象，应用程序由IoC容器进行组装。
* Bean
	* 由IoC容器管理的那些组成你应用程序的对象我们就叫它Bean， Bean就是由Spring容器初始化、装配及管理的对象，除此之外，bean就与应用程序中的其他对象没有什么区别了
	* BeanFactory提供了IoC容器最基本功能，而 ApplicationContext 则增加了更多支持企业级功能支持。ApplicationContext完全继承BeanFactory，因而BeanFactory所具有的语义也适用于ApplicationContext
	* ApplicationContext接口获取Bean方法简介：
		* Object getBean(String name) 根据名称返回一个Bean，客户端需要自己进行类型转换；
		* T getBean(String name, Class<T> requiredType) 根据名称和指定的类型返回一个Bean，客户端无需自己进行类型转换，如果类型转换失败，容器抛出异常；
		* T getBean(Class<T> requiredType) 根据指定的类型返回一个Bean，客户端无需自己进行类型转换，如果没有或有多于一个Bean存在容器将抛出异常；
		* Map<String, T> getBeansOfType(Class<T> type) 根据指定的类型返回一个键值为名字和值为Bean对象的 Map，如果没有Bean对象存在则返回空的Map。
* ioc和bean过程：
	* 准备配置文件
	* 客户端代码实例化IoC容器，并发起获取bean
	* 由IoC容器进行解析元数据：IoC容器的Bean Reader读取并解析配置文件，根据定义生成BeanDefinition，用来配置元数据对象，IoC容器根据BeanDefinition进行实例化、配置及组装Bean，最后返回给客户端代码
	* 也就是要什么Bean，ioc容器再去生成Bean
* 设计模式相当牛逼，松耦合，面向接口编程
	* 除了测试程序的代码外，也就是程序入口，所有代码都没有出现Spring任何组件，而且所有我们写的代码没有实现框架拥有的接口，因而能非常容易的替换掉Spring，是不是非入侵。
客户端代码完全面向接口编程，无需知道实现类，可以通过修改配置文件来更换接口实现，客户端代码不需要任何修改。是不是低耦合。
如果在开发初期没有真正的实现，我们可以模拟一个实现来测试，不耦合代码，是不是很方便测试。
Bean之间几乎没有依赖关系，是不是很容易重用。
* id、name、alias都不能相同
* 实例化Bean的方法：一、使用构造器实例化Bean  二、使用静态工厂方法实例化Bean  三、使用实例工厂方法实例化Bean
##### 第三章
* Bean的获取都是通过getBean("idxxx")
* 构造器注入配置：里面的配置可以byIndex、byType、byName
* 