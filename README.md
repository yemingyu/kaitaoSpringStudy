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
* Spring IoC容器注入依赖资源主要有以下基本实现方式：
     * 构造器注入：就是容器实例化Bean时注入那些依赖，通过在在Bean定义中指定构造器参数进行注入依赖，包括实例工厂方法参数注入依赖，但静态工厂方法参数不允许注入依赖；
     * setter注入：通过setter方法进行注入依赖；
     * 方法注入：能通过配置方式替换掉Bean方法，也就是通过配置改变Bean方法 功能。
* 静态工厂方法实例时，工厂方法一定要是static的(底层应该是调用类名.method)
* 实例Bean工厂方法实例时，工厂方法就不需要是static的(底层应该时根据Bean创建实例对象，然后调用method)
* setter的string和int类型注入不同
	* <property name="message" value="Hello World!"/>  (注意此处“value”中指定的全是字符串，由Spring容器将此字符串转换成属性所需要的类型，如果转换出错，将抛出相应的异常。Spring容器目前能对各种基本类型把配置的String参数转换为需要的类型。例如Spring类型转换系统对于boolean类型进行了容错处理，除了可以使用“true/false”标准的Java值进行注入，还能使用“yes/no”、“on/off”、“1/0”来代表“真/假”)
	* <property name="index"><value>10</value></property>
	* setter注入需要遵循 JavaBean getter/setter 方法命名约定
* setter注入bean
* setter注入Bean ID是使用idref，相当于bean的一个属性id，被设置了一个常量值
* <ref>用来注入其他bean
* 配置NavigationB时注意要确保比如array字段不为空值，这就需要或者在代码中赋值如“NavigationC[] array = new NavigationC[1];”，或者通过配置文件注入如“<list></list>”注入一个不包含条目的列表
* Properties 继承于 Hashtable.表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
* ref local、ref bean、ref parent，开始时弄不清楚ref local和bean的区别，最后发现local是找id的，可以提前暴露问题，local查当前xml，bean查所有，顺序没有查到，但实验结果是先查了当前的，然后才找了parent的
* 自动配置 byName byType no constructor
* 依赖检查 none、simple、object、all
* 方法注入 如果要替换createPrinter()方法的返回值就使用查找方法注入(被注入的函数不执行)；如果想完全替换sayHello()方法体就使用方法替换注入
	* 方法注入主要用于处理“singleton”作用域的Bean需要其他作用域的Bean时，采用Spring查找方法注入方式无需修改任何代码即能获取需要的其他作用域的Bean。
* Spring 容器看作 beans，在 XML 配置文件中 beans 的 auto-wire 属性设置为 byName。然后，它尝试将它的属性与配置文件中定义为相同名称的 beans 进行匹配和连接。如果找到匹配项，它将注入这些 beans，否则，它将抛出异常。
* singleton
	* 指“singleton”作用域的Bean只会在每个Spring IoC容器中存在一个实例，而且其完整生命周期完全由Spring容器管理。对于所有获取该Bean的操作Spring容器将只返回同一个Bean。
	* 在Spring容器中如果没指定作用域默认就是“singleton”，配置方式通过scope属性配置
* prototype 每次返回新的
* Spring中是用注册表的方式实现singleton和ptototype，保持无侵入式设计
* 惰性初始化问题：加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生。静态内部类的加载过程：静态内部类的加载不需要依附外部类，在使用时才加载。不过在加载静态内部类的过程中也会加载外部类
##### 第四章
* InputStreamSource、Resource
* 访问jar包下的文件可能有坑
* 遇到资源加载问题时再复习
##### 第五章
* spring表达式
	* 1）创建解析器：SpEL使用ExpressionParser接口表示解析器，提供SpelExpressionParser默认实现；
	* 2）解析表达式：使用ExpressionParser的parseExpression来解析相应的表达式为Expression对象。
	* 3）构造上下文：准备比如变量定义等等表达式需要的上下文数据。
	* 4）求值：通过Expression接口的getValue方法根据上下文获得表达式值。
##### 第六章
* AOP
	* 用于横切关注点的分离和织入横切关注点到系统；比如上边提到的日志等等；
完善OOP；
	* 降低组件和模块之间的耦合性；
	* 使系统容易扩展；
	* 而且由于关注点分离从而可以获得组件的更好复用.
* AOP要引好库，缺失的去maven下载
