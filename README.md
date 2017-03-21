设计模式
设计模式 1
1. 创 建 型 3
1.1. 类 4
1.1.1. Factory Method 4
1.2. 对象 8
1.2.1. Abstract Factory 8
1.2.2. B u i l d e r 11
1.2.3. P r o t o t y p e 15
1.2.4. S i n g l e t o n 20
1.3. 创建型模式的讨论 27
2. 结 构 型 27
2.1. 类 27
2.1.1. A d a p t e r (类) 27
2.2. 对象 33
2.2.1. A d a p t e r (对象) 34
2.2.2. B r i d g e 39
2.2.3. C o m p o s i t e 45
2.2.4. D e c o r a t o r 54
2.2.5. F a c a d e 60
2.2.6. P r o x y 66
2.2.7. F l y w e i g h t 72
2.3. 结构型模式的讨论 78
2.3.1. Adapter与Bridge 79
2.3.2. Composite、Decorator与Proxy 79
3. 行 为 型 80
3.1. 类 81
3.1.1. I n t e r p r e t e r 81
3.1.2. Template Method 82
3.2. 对象 82
3.2.1. Chain of Responsibility 82
3.2.2. C o m m a n d 83
3.2.3. I t e r a t o r 84
3.2.4. M e d i a t o r 84
3.2.5. M e m e n t o 85
3.2.6. O b s e r v e r 85
3.2.7. S t a t e 86
3.2.8. S t r a t e g y 87
3.2.9. Vi s i t o r 87
4. 如何选择和使用设计模式 88
4.1. 如何选择设计模式 88
4.1.1. 考虑设计模式是怎样解决设计问题的 88
4.1.2. 浏览模式的意图部分 98
4.1.3. 研究模式怎样互相关联 99
4.1.4. 研究目的相似的模式 99
4.1.5. 检查重新设计的原因 99
4.1.6. 考虑你的设计中哪些是可变的 99
4.2. 怎样使用设计模式 100
4.2.1. 大致浏览一遍模式 100
4.2.2. 回头研究结构部分、参与者部分和协作部分 100
4.2.3. 看代码示例部分，看看这个模式代码形式的具体例子 100
4.2.4. 选择模式参与者的名字，使它们在应用上下文中有意义 100
4.2.5. 定义类 100
4.2.6. 定义模式中专用于应用的操作名称 100
4.2.7. 实现执行模式中责任和协作的操作 100
 
 
创建型类模式将对象的部分创建工作延迟到子类，创建型对象模式则将它延迟到另一个对象中.
创 建 型
在这些模式中有两个不断出现的主旋律。第一，它们都将关于该系统使用哪些具体的类
的信息封装起来。第二，它们隐藏了这些类的实例是如何被创建和放在一起的。整个系统关
于这些对象所知道的是由抽象类所定义的接口。因此，创建型模式在什么被创建，谁创建它，
它是怎样被创建的，以及何时创建这些方面给予你很大的灵活性。它们允许你用结构和功能
差别很大的“产品”对象配置一个系统。配置可以是静态的（即在编译时指定），也可以是动
态的（在运行时）。
1.	类
1.	Factory Method
意 图
定义一个用于创建对象的接口，让子类决定实例化哪一个类。 Factory Method使一个类的实例化延迟到其子类
别 名
虚构造器（Virtual Constructor）
动 机
框架使用抽象类定义和维护对象之间的关系。这些对象的创建通常也由框架负责
适用性
当一个类不知道它所必须创建的对象的类的时候。
当一个类希望由它的子类来指定它所创建的对象的时候
当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候
结 构
 
参与者
P r o d u c t
定义工厂方法所创建的对象的接口
C o n c r e t e P r o d u c t
实现P r o d u c t接口
C r e a t o r
声明工厂方法，该方法返回一个 P r o d u c t类型的对象。C r e a t o r也可以定义一个工厂方法的缺省实现，它返回一个缺省的 C o n c r e t e P r o d u c t对象
可以调用工厂方法以创建一个P r o d u c t对象
C o n c r e t e C r e a t o r
重定义工厂方法以返回一个C o n c r e t e P r o d u c t实例
协 作
Creator依赖于它的子类来定义工厂方法，所以它返回一个适当的 C o n c r e t e P r o d u c t实例
效 果
工厂方法的一个潜在缺点在于客户可能仅仅为了创建一个特定的 C o n c r e t e P r o d u c t对象，就不得不创建C r e a t o r的子类。当C r e a t o r子类不必需时，客户现在必然要处理类演化的其他方面；但是当客户无论如何必须创建 C r e a t o r的子类时，创建子类也是可行的。
为子类提供挂钩（h o o k）
连接平行的类层次
实 现
主要有两种不同的情况
C r e a t o r类是一个抽象类并且不提供它所声明的工厂方法的实现。
C r e a t o r是一个具体的类而且为工厂方法提供一个缺省的实现。
用一个独立的操作创建对象，这样子类才能重定义它们的创建方式
参数化工厂方法
特定语言的变化和问题
使用模板以避免创建子类
命名约定
代码示例
 
public class StaticFactoryMethod {
static Sender mailSenderFactory(){
return new MailSender();
}
static Sender smsSenderFactory(){
return new SmsSender();
}
}
public class Cilent {
public static void main(String[] args) {
Sender mailSender = StaticFactoryMethod.mailSenderFactory();
Sender smsSender = StaticFactoryMethod.smsSenderFactory();
mailSender.send();
smsSender.send();
}
}
相关模式
Abstract Factory（3 . 1）经常用工厂方法来实现。
工厂方法通常在Template Methods（5 . 1 0）中被调用。
P r o t o t y p e s（3 . 4）不需要创建C r e a t o r的子类。但是，它们通常要求一个针对 P r o d u c t类的I n i t i a l i z e操作。C r e a t o r使用I n i t i a l i z e来初始化对象。而Factory Method不需要这样的操作。
1.	对象
1.	Abstract Factory
ABSTRACT FACTORY（抽象工厂） — 对象创建型模式
意 图
提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类
别 名
K i t
动 机
适用性
一个系统要独立于它的产品的创建、组合和表示时
一个系统要由多个产品系列中的一个来配置时
当你要强调一系列相关的产品对象的设计以便进行联合使用时
当你提供一个产品类库，而只想显示它们的接口而不是实现时
结 构
参与者
A b s t r a c t F a c t o r y
声明一个创建抽象产品对象的操作接口
声明一个创建抽象产品对象的操作接口
C o n c r e t e F a c t o r y
实现创建具体产品对象的操作
实现创建具体产品对象的操作
A b s t r a c t P r o d u c t
为一类产品对象声明一个接口
为一类产品对象声明一个接口
C o n c r e t e P r o d u c t
定义一个将被相应的具体工厂创建的产品对象
实现A b s t r a c t P r o d u c t接口
C l i e n t
仅使用由A b s t r a c t F a c t o r y和A b s t r a c t P r o d u c t类声明的接口
协 作
通常在运行时刻创建一个C o n c r e t e F a c t r o y类的实例。这一具体的工厂创建具有特定实现的产品对象。为创建不同的产品对象，客户应使用不同的具体工厂。
AbstractFactory将产品对象的创建延迟到它的C o n c r e t e F a c t o r y子类
效 果
它分离了具体的类
它使得易于交换产品系列
它有利于产品的一致性
难以支持新种类的产品
实 现
将工厂作为单件
一个应用中一般每个产品系列只需一个 C o n c r e t e F a c t o r y的实例。因此工厂通常最好实现为一个S i n g l e t o n
创建产品
定义可扩展的工厂
代码示例
public abstract class Client {
public static void main(String[] args) {
Sender mailSender = new SendMailFactory().product();
Sender smsSender = new SendSmsFactory().product();
mailSender.send();
smsSender.send();
}
}
public class MailSender implements Sender {
public void send() {
System.out.println("this is a mailSender!");
}
}
public interface Provider {
Sender product();
}
public interface Provider {
Sender product();
}
public class SendMailFactory implements Provider {
public Sender product() {
return new MailSender();
}
}
public class SendSmsFactory implements Provider{
public Sender product() {
return new SmsSender();
}
}
public class SmsSender implements Sender {
public void send() {
System.out.println("this is a SmsSender");
}
}
B u i l d e r
意图
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
动机
适用性
当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时
当构造过程必须允许被构造的对象有不同的表示时
结 构
 
参与者
B u i l d e r
为创建一个P r o d u c t对象的各个部件指定抽象接口
C o n c r e t e B u i l d e r
实现B u i l d e r的接口以构造和装配该产品的各个部件
定义并明确它所创建的表示
提供一个检索产品的接口
Director
构造一个使用B u i l d e r接口的对象
P r o d u c t
表示被构造的复杂对象
包含定义组成部件的类，包括将这些部件装配成最终产品的接口
协作
客户创建D i r e c t o r对象，并用它所想要的B u i l d e r对象进行配置
一旦产品部件被生成，导向器就会通知生成器
生成器处理导向器的请求，并将部件添加到该产品中
客户从生成器中检索产品
效果
它使你可以改变一个产品的内部表示
它将构造代码和表示代码分开
它使你可对构造过程进行更精细的控制
实现
装配和构造接口
为什么产品没有抽象类
在B u i l d e r中却省的方法为空
代码示例
 
public class Builder {
private List<Sender> senders = new ArrayList<Sender>();
List<Sender> productMailSender(int count){
for (int i = 0; i < count; i++) {
senders.add(new MailSender());
}
return senders;
}
List<Sender> productSmsSender(int count){
for (int i = 0; i < count; i++) {
senders.add(new SmsSender());
}
return senders;
}
public class Cilent {
public static void main(String[] args) {
Builder builder = new Builder();
List<Sender> senders = builder.productMailSender(3);
for (Sender sender : senders) {
sender.send();
}
}
}
相关模式
Abstract Factory（3 . 1）与B u i l d e r相似，因为它也可以创建复杂对象。主要的区别是
B u i l d e r模式着重于一步步构造一个复杂对象。而 Abstract Factory着重于多个系列的产品对象
（简单的或是复杂的）。B u i l d e r在最后的一步返回产品，而对于 Abstract Factory来说，产品是
立即返回的。
C o m p o s i t e（4 . 3）通常是用B u i l d e r生成的
P r o t o t y p e
意 图
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象
别 名
动 机
适用性
当一个系统应该独立于它的产品创建、构成和表示时
当要实例化的类是在运行时刻指定时
为了避免创建一个与产品类层次平行的工厂类层次时
当一个类的实例只能有几个不同状态组合中的一种时
结 构
参与者
P r o t o t y p e
声明一个克隆自身的接口
C o n c r e t e P r o t o t y p e
实现一个克隆自身的操作
C l i e n t
让一个原型克隆自身从而创建一个新的对象
协 作
客户请求一个原型克隆自身
效 果
P r o t o t y p e有许多和Abstract Factory（3 . 1）和B u i l d e r（3 . 2）一样的效果：它对客户隐藏了具体的产品类，因此减少了客户知道的名字的数目。此外，这些模式使客户无需改变即可使用与特定应用相关的类。
运行时刻增加和删除产品
P r o t o t y p e允许只通过客户注册原型实例就可以将一个新的
具体产品类并入系统。它比其他创建型模式更为灵活，因为客户可以在运行时刻建立和删除
原型。
改变值以指定新对象
高度动态的系统允许你通过对象复合定义新的行为 — 例如，通
过为一个对象变量指定值 — 并且不定义新的类。你通过实例化已有类并且将这些实例注册
为客户对象的原型，就可以有效定义新类别的对象。客户可以将职责代理给原型，从而表现
出新的行为。这种设计使得用户无需编程即可定义新“类”。实际上，克隆一个原型类似于实例化一个
类。P r o t o t y p e模式可以极大的减少系统所需要的类的数目。在我们的音乐编辑器中，一个
G r a p h i c To o l类可以创建无数种音乐对象。
改变结构以指定新对象
许多应用由部件和子部件来创建对象。例如电路设计编辑器
就是由子电路来构造电路的 。为方便起见，这样的应用通常允许你实例化复杂的、用户定
义的结构，比方说，一次又一次的重复使用一个特定的子电路。
P r o t o t y p e模式也支持这一点。我们仅需将这个子电路作为一个原型增加到可用的电路元
素选择板中。只要复合电路对象将 C l o n e实现为一个深拷贝（deep copy），具有不同结构的电
路就可以是原型了。
减少子类的构造
Factory Method（3 . 3）经常产生一个与产品类层次平行的 C r e a t o r类
层次。P r o t o t y p e模式使得你克隆一个原型而不是请求一个工厂方法去产生一个新的对象。因
此你根本不需要 C r e a t o r类层次。这一优点主要适用于像 C + +这样不将类作为一级类对象的语
言。像S m a l l t a l k和Objective C这样的语言从中获益较少，因为你总是可以用一个类对象作为
生成者。在这些语言中，类对象已经起到原型一样的作用了。
用类动态配置应用
一些运行时刻环境允许你动态将类装载到应用中。在像 C + +这样的
语言中，P r o t o t y p e模式是利用这种功能的关键。
一个希望创建动态载入类的实例的应用不能静态引用类的构造器。而应该由运行环境在
载入时自动创建每个类的实例，并用原型管理器来注册这个实例（参见实现一节）。这样应用
就可以向原型管理器请求新装载的类的实例，这些类原本并没有和程序相连接。 E T + +应用框
架[ W G M 8 8 ]有一个运行系统就是使用这一方案的。
是每一个P r o t o t y p e的子类都必须实现C l o n e操作
P r o t o t y p e的主要缺陷是每一个P r o t o t y p e的子类都必须实现C l o n e操作，这可能很困难。例
如，当所考虑的类已经存在时就难以新增 C l o n e操作。当内部包括一些不支持拷贝或有循环引
用的对象时，实现克隆可能也会很困难的。
实 现
当一个系统中原型数目不固定时（也就是说，它们可以动态创
建和销毁），要保持一个可用原型的注册表。客户不会自己来管理原型，但会在注册表中存储
和检索原型。客户在克隆一个原型前会向注册表请求该原型。我们称这个注册表为原型管理
器（prototype manager）。
原型管理器是一个关联存储器（ associative store），它返回一个与给定关键字相匹配的原
型。它有一些操作可以用来通过关键字注册原型和解除注册。客户可以在运行时更改甚或浏
览这个注册表。这使得客户无需编写代码就可以扩展并得到系统清单。
使用一个原型管理器
实现克隆操作
P r o t o t y p e模式最困难的部分在于正确实现 C l o n e操作。当对象结构包含
循环引用时，这尤为棘手。
大多数语言都对克隆对象提供了一些支持。例如， S m a l l t a l k提供了一个c o p y的实现，它
被所有O b j e c t的子类所继承。C + +提供了一个拷贝构造器。但这些设施并不能解决“浅拷贝和
深拷贝”问题[ G R 8 3 ]。也就是说，克隆一个对象是依次克隆它的实例变量呢，或者还是由克
隆对象和原对象共享这些变量？
浅拷贝简单并且通常也足够了，它是 S m a l l t a l k所缺省提供的。C + +中的缺省拷贝构造器实
现按成员拷贝，这意味着在拷贝的和原来的对象之间是共享指针的。但克隆一个结构复杂的
原型通常需要深拷贝，因为复制对象和原对象必须相互独立。因此你必须保证克隆对象的构
件也是对原型的构件的克隆。克隆迫使你决定如果所有东西都被共享了该怎么办。
如果系统中的对象提供了 S a v e和L o a d操作，那么你只需通过保存对象和立刻载入对象，
就可以为C l o n e操作提供一个缺省实现。 S a v e操作将该对象保存在内存缓冲区中，而 L o a d则通
过从该缓冲区中重构这个对象来创建一个复本。
初始化克隆对象
当一些客户对克隆对象已经相当满意时，另一些客户将会希望使用
他们所选择的一些值来初始化该对象的一些或是所有的内部状态。一般来说不可能在 C l o n e操
作中传递这些值，因为这些值的数目由于原型的类的不同而会有所不同。一些原型可能需要
多个初始化参数，另一些可能什么也不要。在 C l o n e操作中传递参数会破坏克隆接口的统一
性。
可能会这样，原型的类已经为（重）设定一些关键的状态值定义好了操作。如果这样的
话，客户在克隆后马上就可以使用这些操作。否则，你就可能不得不引入一个 I n i t i a l i z e操作
（参见代码示例一节），该操作使用初始化参数并据此设定克隆对象的内部状态。注意深拷贝
C l o n e操作 — 一些复制在你重新初始化它们之前可能必须要被删除掉（删除可以显式地做也
可以在I n i t i a l i z e内部做）。
代码示例
public class Prototype implements Cloneable,Serializable{
private static final long serialVersionUID = 1L;
private String string;
private SerializableObject serializableObject;
public Object clone() throws CloneNotSupportedException {
return (Prototype)super.clone();
}
public Object deepClone() throws IOException, ClassNotFoundException {
ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
objectOutputStream.writeObject(this);
ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
return objectInputStream.readObject();
}
public String getString() {
return string;
}
public Prototype setString(String string) {
this.string = string;
return this;
}
public SerializableObject getSerializableObject() {
return serializableObject;
}
public Prototype setSerializableObject(SerializableObject serializableObject) {
this.serializableObject = serializableObject;
return this;
}
}
相关模式
大量使用C o m p o s i t e（4 . 3）和D e c o r a t o r（4 . 4）模式的设计通常也可从 P r o t o t y p e模式处获益。
子主题
P r o t o t y p e和Abstract Factory（3 . 1）模式在某种方面是相互竞争的。但是它们也可以一起使用。 Abstract Factory可以存储一个被克隆的原型的集合，并且返回产品对象。
S i n g l e t o n
意 图
保证一个类仅有一个实例，并提供一个访问它的全局访问点。
别 名
动 机
对一些类来说，只有一个实例是很重要的。
适用性
当类只能有一个实例而且客户可以从一个众所周知的访问点访问它时。
当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时。
结 构
 
参与者
S i n g l e t o n
定义一个 I n s t a n c e操作，允许客户访问它的唯一实例。 I n s t a n c e是一个类操作（即S m a l l t a l k中的一个类方法和C + +中的一个静态成员函数）。
可能负责创建它自己的唯一实例。
协 作
客户只能通过S i n g l e t o n的I n s t a n c e操作访问一个S i n g l e t o n的实例。
效 果
因为S i n g l e t o n类封装它的唯一实例，所以它可以严格的控制客户怎样以及何时访问它。
对唯一实例的受控访问
缩小名空间
S i n g l e t o n模式是对全局变量的一种改进。它避免了那些存储唯一实例的
全局变量污染名空间。
允许对操作和表示的精化
S i n g l e t o n类可以有子类，而且用这个扩展类的实例来配置
一个应用是很容易的。你可以用你所需要的类的实例在运行时刻配置应用。
允许可变数目的实例
这个模式使得你易于改变你的想法，并允许 S i n g l e t o n类的多个
实例。此外，你可以用相同的方法来控制应用所使用的实例的数目。只有允许访问 S i n g l e t o n
实例的操作需要改变。
比类操作更灵活
另一种封装单件功能的方式是使用类操作（即 C + +中的静态成员函数
或者是S m a l l t a l k中的类方法）。但这两种语言技术都难以改变设计以允许一个类有多个实例。
此外，C + +中的静态成员函数不是虚函数，因此子类不能多态的重定义它们。
实 现
S i n g l e t o n模式使得这个唯一实例是类的一般实例，但该类被写
成只有一个实例能被创建。做到这一点的一个常用方法是将创建这个实例的操作隐藏在一个
类操作（即一个静态成员函数或者是一个类方法）后面，由它保证只有一个实例被创建。这
个操作可以访问保存唯一实例的变量，而且它可以保证这个变量在返回值之前用这个唯一实
例初始化。这种方法保证了单件在它的首次使用前被创建和使用。
保证一个唯一的实例
创建S i n g l e t o n类的子类
主要问题与其说是定义子类不如说是建立它的唯一实例，这
样客户就可以使用它。事实上，指向单件实例的变量必须用子类的实例进行初始化。最简单
的技术是在S i n g l e t o n的I n s t a n c e操作中决定你想使用的是哪一个单件。代码示例一节中的一个
例子说明了如何用环境变量实现这一技术。
代码示例
首先我们写一个简单的单例类：
[java] view plaincopy
public class Singleton {
/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
private static Singleton instance = null;
/* 私有构造方法，防止被实例化 */
private Singleton() {
}
/* 静态工程方法，创建实例 */
public static Singleton getInstance() {
if (instance == null) {
instance = new Singleton();
}
return instance;
}
/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
public Object readResolve() {
return instance;
}
}
这个类可以满足基本要求，但是，像这样毫无线程安全保护的类，如果我们把它放入多线程的环境下，肯定就会出现问题了，如何解决？我们首先会想到对getInstance方法加synchronized关键字，如下：
[java] view plaincopy
public static synchronized Singleton getInstance() {
if (instance == null) {
instance = new Singleton();
}
return instance;
}
但是，synchronized关键字锁住的是这个对象，这样的用法，在性能上会有所下降，因为每次调用getInstance()，都要对对象上锁，事实上，只有在第一次创建对象的时候需要加锁，之后就不需要了，所以，这个地方需要改进。我们改成下面这个：
[java] view plaincopy
public static Singleton getInstance() {
if (instance == null) {
synchronized (instance) {
if (instance == null) {
instance = new Singleton();
}
}
}
return instance;
}
似乎解决了之前提到的问题，将synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，并创 建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的，看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也 就是说instance = new Singleton();语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间， 然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了，我们以A、B两个线程为例：
a>A、B线程同时进入了第一个if判断
b>A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
c>由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
d>B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
e>此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
所以程序还是有可能发生错误，其实程序在运行过程是很复杂的，从这点我们就可以看出，尤其是在写多线程环境下的程序更有难度，有挑战性。我们对该程序做进一步优化：
[java] view plaincopy
private static class SingletonFactory{
private static Singleton instance = new Singleton();
}
public static Singleton getInstance(){
return SingletonFactory.instance;
}
实际情况是，单例模式使用内部类来维护单例的实现，JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。这样当我们第一次调用 getInstance的时候，JVM能够帮我们保证instance只被创建一次，并且会保证把赋值给instance的内存初始化完毕，这样我们就不 用担心上面的问题。同时该方法也只会在第一次调用的时候使用互斥机制，这样就解决了低性能问题。这样我们暂时总结一个完美的单例模式：
[java] view plaincopy
public class Singleton {
/* 私有构造方法，防止被实例化 */
private Singleton() {
}
/* 此处使用一个内部类来维护单例 */
private static class SingletonFactory {
private static Singleton instance = new Singleton();
}
/* 获取实例 */
public static Singleton getInstance() {
return SingletonFactory.instance;
}
/* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
public Object readResolve() {
return getInstance();
}
}
其实说它完美，也不一定，如果在构造函数中抛出异常，实例将永远得不到创建，也会出错。所以说，十分完美的东西是没有的，我们只能根据实际情况，选择最适 合自己应用场景的实现方法。也有人这样实现：因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加 synchronized关键字，也是可以的：
[java] view plaincopy
public class SingletonTest {
private static SingletonTest instance = null;
private SingletonTest() {
}
private static synchronized void syncInit() {
if (instance == null) {
instance = new SingletonTest();
}
}
public static SingletonTest getInstance() {
if (instance == null) {
syncInit();
}
return instance;
}
}
考虑性能的话，整个程序只需创建一次实例，所以性能也不会有什么影响。
补充：采用"影子实例"的办法为单例对象的属性同步更新
[java] view plaincopy
public class SingletonTest {
private static SingletonTest instance = null;
private Vector properties = null;
public Vector getProperties() {
return properties;
}
private SingletonTest() {
}
private static synchronized void syncInit() {
if (instance == null) {
instance = new SingletonTest();
}
}
public static SingletonTest getInstance() {
if (instance == null) {
syncInit();
}
return instance;
}
public void updateProperties() {
SingletonTest shadow = new SingletonTest();
properties = shadow.getProperties();
}
}
相关模式
很多模式可以使用 S i n g l e t o n模式实现。参见 Abstract Factory（3 . 1）、B u i l d e r（3 . 2），和P r o t o t y p e（3 . 4）。
创建型模式的讨论
1.	结 构 型
1.	类
1.	A d a p t e r (类)
意 图
将一个类的接口转换成客户希望的另外一个接口。 A d a p t e r模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
子主题
别 名
包装器 Wr a p p e r。
动 机
有时，为复用而设计的工具箱类不能够被复用的原因仅仅是因为它的接口与专业应用领域所需要的接口不匹配。
适用性
你想使用一个已经存在的类，而它的接口不符合你的需求。
你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作
（仅适用于对象A d a p t e r）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器可以适配它的父类接口。
结 构
类适配器
 
对象适配器
 
参与者
Ta r g e t
定义C l i e n t使用的与特定领域相关的接口。
C l i e n t
与符合Ta rg e t接口的对象协同
A d a p t e e
定义一个已经存在的接口，这个接口需要适配。
A d a p t e r
对A d a p t e e的接口与Ta rg e t接口进行适配
协 作
Client在A d a p t e r实例上调用一些操作。接着适配器调用 A d a p t e e的操作实现这个请求。
效 果
对象适配器
允许一个A d a p t e r与多个A d a p t e e — 即A d a p t e e本身以及它的所有子类（如果有子类的话）—同时工作。A d a p t e r也可以一次给所有的A d a p t e e添加功能。
使得重定义A d a p t e e的行为比较困难。这就需要生成 A d a p t e e的子类并且使得A d a p t e r引用这个子类而不是引用A d a p t e e本身
类适配器
用一个具体的A d a p t e r类对A d a p t e e和Ta rg e t进行匹配。结果是当我们想要匹配一个类以及所有它的子类时，类A d a p t e r将不能胜任工作。
使得A d a p t e r可以重定义A d a p t e e的部分行为，因为A d a p t e r是A d a p t e e的一个子类。
仅仅引入了一个对象，并不需要额外的指针以间接得到 a d a p t e e。
使用A d a p t e r模式时需要考虑的其他一些因素有：
Adapter的匹配程度
对A d a p t e e的接口与Ta rg e t的接口进行匹配的工作量各个A d a p t e r可
能不一样。工作范围可能是，从简单的接口转换(例如改变操作名 )到支持完全不同的操作集
合。A d a p t e r的工作量取决于Ta rg e t接口与A d a p t e e接口的相似程度。
可插入的Adapter
当其他的类使用一个类时，如果所需的假定条件越少，这个类就更
具可复用性。如果将接口匹配构建为一个类，就不需要假定对其他的类可见的是一个相同的
接口。也就是说，接口匹配使得我们可以将自己的类加入到一些现有的系统中去，而这些系
统对这个类的接口可能会有所不同。 O b j e c t - Wo r k / S m a l l t a l k [ P a r 9 0 ]使用pluggable adapter一词
描述那些具有内部接口适配的类。
使用双向适配器提供透明操作
使用适配器的一个潜在问题是，它们不对所有的客户
都透明。被适配的对象不再兼容 A d a p t e e的接口，因此并不是所有 A d a p t e e对象可以被使用的
地方它都可以被使用。双向适配器提供了这样的透明性。在两个不同的客户需要用不同的方
式查看同一个对象时，双向适配器尤其有用。
实 现
使用C + +实现适配器类
可插入的适配器
使用抽象操作
使用代理对象
参数化的适配器
代码示例
类
public class Source {
public void method1() {
System.out.println("this is original method!");
}
}
public interface Targetable {
/* 与原类中的方法相同 */
public void method1();
/* 新类的方法 */
public void method2();
}
public class Adapter extends Source implements Targetable {
@Override
public void method2() {
System.out.println("this is the targetable method!");
}
}
Adapter类继承Source类，实现Targetable接口，下面是测试类：
public class AdapterTest {
public static void main(String[] args) {
Targetable target = new Adapter();
target.method1();
target.method2();
}
}
相关模式
B r i d g e目的是将接口部分和实现部分分离，从而对它们可以较为容易也相对独立的加以改变。而 A d a p t e r则意味着改变一个已有对象的接口。
D e c o r a t o r ( 4 . 4 )模式增强了其他对象的功能而同时又不改变它的接口。因此 d e c o r a t o r对应用程序的透明性比适配器要好。结果是 d e c o r a t o r支持递归组合，而纯粹使用适配器是不可能实现这一点的。
模式P r o x y ( 4 . 7 )在不改变它的接口的条件下，为另一个对象定义了一个代理。
对象
结构型模式涉及到如何组合类和对象以获得更大的结构。结构型类模式采用继承机制来
组合接口或实现。一个简单的例子是采用多重继承方法将两个以上的类组合成一个类，结果
这个类包含了所有父类的性质。这一模式尤其有助于多个独立开发的类库协同工作。另外一
个例子是类形式的A d a p t e r ( 4 . 1 )模式。一般来说，适配器使得一个接口 ( a d a p t e e的接口)与其他
接口兼容，从而给出了多个不同接口的统一抽象。为此，类适配器对一个 a d a p t e e类进行私有
继承。这样，适配器就可以用a d a p t e e的接口表示它的接口。
结构型对象模式不是对接口和实现进行组合，而是描述了如何对一些对象进行组合，从
而实现新功能的一些方法。因为可以在运行时刻改变对象组合关系，所以对象组合方式具有
更大的灵活性，而这种机制用静态类组合是不可能实现的。
Composite (4.3) 模式是结构型对象模式的一个实例。它描述了如何构造一个类层次式结
构，这一结构由两种类型的对象（基元对象和组合对象）所对应的类构成 . 其中的组合对象使
得你可以组合基元对象以及其他的组合对象，从而形成任意复杂的结构。在 Proxy (4.7) 模式
中，p r o x y对象作为其他对象的一个方便的替代或占位符。它的使用可以有多种形式。例如它
可以在局部空间中代表一个远程地址空间中的对象，也可以表示一个要求被加载的较大的对
象，还可以用来保护对敏感对象的访问。 P r o x y模式还提供了对对象的一些特有性质的一定程
度上的间接访问，从而它可以限制、增强或修改这些性质。
F l y w e i g h t ( 4 . 6 )模式为了共享对象定义了一个结构。至少有两个原因要求对象共享：效率
和一致性。F l y w e i g h t的对象共享机制主要强调对象的空间效率。使用很多对象的应用必需考
虑每一个对象的开销。使用对象共享而不是进行对象复制，可以节省大量的空间资源。但是
仅当这些对象没有定义与上下文相关的状态时，它们才可以被共享。 F l y w e i g h t的对象没有这
样的状态。任何执行任务时需要的其他一些信息仅当需要时才传递过去。由于不存在与上下
文相关的状态，因此F l y w e i g h t对象可以被自由地共享。
如果说F l y w e i g h t模式说明了如何生成很多较小的对象，那么 F a c a d e ( 4 . 5 )模式则描述了如
何用单个对象表示整个子系统。模式中的 f a c a d e用来表示一组对象，f a c a d e的职责是将消息转
发给它所表示的对象。 B r i d g e ( 4 . 2 )模式将对象的抽象和其实现分离，从而可以独立地改变它
们。
D e c o r a t o r ( 4 . 4 )模式描述了如何动态地为对象添加职责。 D e c o r a t o r模式是一种结构型模式。
这一模式采用递归方式组合对象，从而允许你添加任意多的对象职责。例如，一个包含用户
界面组件的D e c o r a t o r对象可以将边框或阴影这样的装饰添加到该组件中，或者它可以将窗口
滚动和缩放这样的功能添加的组件中。我们可以将一个 D e c o r a t o r对象嵌套在另外一个对象中
就可以很简单地增加两个装饰，添加其他的装饰也是如此。因此，每个 D e c o r a t o r对象必须与
其组件的接口兼容并且保证将消息传递给它。 D e c o r a t o r模式在转发一条信息之前或之后都可
以完成它的工作（比如绘制组件的边框）。
A d a p t e r (对象)
意 图
将一个类的接口转换成客户希望的另外一个接口。 A d a p t e r模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
子主题
别 名
包装器 Wr a p p e r。
动 机
有时，为复用而设计的工具箱类不能够被复用的原因仅仅是因为它的接口与专业应用领域所需要的接口不匹配。
适用性
你想使用一个已经存在的类，而它的接口不符合你的需求。
你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类（即那些接口可能不一定兼容的类）协同工作
（仅适用于对象A d a p t e r）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器可以适配它的父类接口。
结 构
类适配器
 
对象适配器
 
参与者
Ta r g e t
定义C l i e n t使用的与特定领域相关的接口。
C l i e n t
与符合Ta rg e t接口的对象协同
A d a p t e e
定义一个已经存在的接口，这个接口需要适配。
A d a p t e r
对A d a p t e e的接口与Ta rg e t接口进行适配
协 作
Client在A d a p t e r实例上调用一些操作。接着适配器调用 A d a p t e e的操作实现这个请求。
效 果
对象适配器
允许一个A d a p t e r与多个A d a p t e e — 即A d a p t e e本身以及它的所有子类（如果有子类的话）—同时工作。A d a p t e r也可以一次给所有的A d a p t e e添加功能。
使得重定义A d a p t e e的行为比较困难。这就需要生成 A d a p t e e的子类并且使得A d a p t e r引用这个子类而不是引用A d a p t e e本身
类适配器
用一个具体的A d a p t e r类对A d a p t e e和Ta rg e t进行匹配。结果是当我们想要匹配一个类以及所有它的子类时，类A d a p t e r将不能胜任工作。
使得A d a p t e r可以重定义A d a p t e e的部分行为，因为A d a p t e r是A d a p t e e的一个子类。
仅仅引入了一个对象，并不需要额外的指针以间接得到 a d a p t e e。
使用A d a p t e r模式时需要考虑的其他一些因素有：
Adapter的匹配程度
对A d a p t e e的接口与Ta rg e t的接口进行匹配的工作量各个A d a p t e r可
能不一样。工作范围可能是，从简单的接口转换(例如改变操作名 )到支持完全不同的操作集
合。A d a p t e r的工作量取决于Ta rg e t接口与A d a p t e e接口的相似程度。
可插入的Adapter
当其他的类使用一个类时，如果所需的假定条件越少，这个类就更
具可复用性。如果将接口匹配构建为一个类，就不需要假定对其他的类可见的是一个相同的
接口。也就是说，接口匹配使得我们可以将自己的类加入到一些现有的系统中去，而这些系
统对这个类的接口可能会有所不同。 O b j e c t - Wo r k / S m a l l t a l k [ P a r 9 0 ]使用pluggable adapter一词
描述那些具有内部接口适配的类。
使用双向适配器提供透明操作
使用适配器的一个潜在问题是，它们不对所有的客户
都透明。被适配的对象不再兼容 A d a p t e e的接口，因此并不是所有 A d a p t e e对象可以被使用的
地方它都可以被使用。双向适配器提供了这样的透明性。在两个不同的客户需要用不同的方
式查看同一个对象时，双向适配器尤其有用。
实 现
使用C + +实现适配器类
可插入的适配器
使用抽象操作
使用代理对象
参数化的适配器
代码示例
类
public class Source {
public void method1() {
System.out.println("this is original method!");
}
}
public interface Targetable {
/* 与原类中的方法相同 */
public void method1();
/* 新类的方法 */
public void method2();
}
public class Adapter extends Source implements Targetable {
@Override
public void method2() {
System.out.println("this is the targetable method!");
}
}
Adapter类继承Source类，实现Targetable接口，下面是测试类：
public class AdapterTest {
public static void main(String[] args) {
Targetable target = new Adapter();
target.method1();
target.method2();
}
}
相关模式
B r i d g e目的是将接口部分和实现部分分离，从而对它们可以较为容易也相对独立的加以改变。而 A d a p t e r则意味着改变一个已有对象的接口。
D e c o r a t o r ( 4 . 4 )模式增强了其他对象的功能而同时又不改变它的接口。因此 d e c o r a t o r对应用程序的透明性比适配器要好。结果是 d e c o r a t o r支持递归组合，而纯粹使用适配器是不可能实现这一点的。
模式P r o x y ( 4 . 7 )在不改变它的接口的条件下，为另一个对象定义了一个代理。
B r i d g e
意 图
将抽象部分与它的实现部分分离，使它们都可以独立地变化。
别 名
H a n d l e / B o d y
动 机
当一个抽象可能有多个实现时，通常用继承来协调它们。抽象类定义对该抽象的接口，而具体的子类则用不同方式加以实现。但是此方法有时不够灵活。继承机制将抽象部分与它的实现部分固定在一起，使得难以对抽象部分和实现部分独立地进行修改、扩充和重用。
适用性
你不希望在抽象和它的实现部分之间有一个固定的绑定关系。例如这种情况可能是因为，在程序运行时刻实现部分应可以被选择或者切换。
类的抽象以及它的实现都应该可以通过生成子类的方法加以扩充。这时 B r i d g e模式使你可以对不同的抽象接口和实现部分进行组合，并分别对它们进行扩充。
对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译。
（C + +）你想对客户完全隐藏抽象的实现部分。在 C + +中，类的表示在类接口中是可见的。
。
正如在意图一节的第一个类图中所示的那样，有许多类要生成。这样一种类层次结构说明你必须将一个对象分解成两个部分。 R u m b a u g h称这种类层次结构为“嵌套的普化”（nested generalizations）
你想在多个对象间共享实现（可能使用引用计数），但同时要求客户并不知道这一点。一个简单的例子便是C o p l i e n的S t r i n g类[ C o p 9 2 ]，在这个类中多个对象可以共享同一个字符串表示（S t r i n g R e p）。
结 构
 
参与者
Abstraction
定义抽象类的接口。
维护一个指向I m p l e m e n t o r类型对象的指针
RefinedAbstraction
扩充由A b s t r a c t i o n定义的接口
Implementor
定义实现类的接口，该接口不一定要与 A b s t r a c t i o n的接口完全一致；事实上这两个接口可以完全不同。一般来讲， I m p l e m e n t o r接口仅提供基本操作，而 A b s t r a c t i o n则定义了基于这些基本操作的较高层次的操作。
ConcreteImplementor
实现I m p l e m e n t o r接口并定义它的具体实现
协 作
Abstraction将c l i e n t的请求转发给它的I m p l e m e n t o r对象
效 果
分离接口及其实现部分
一个实现未必不变地绑定在一个接口上。抽象类的实现可以
在运行时刻进行配置，一个对象甚至可以在运行时刻改变它的实现。
将A b s t r a c t i o n与I m p l e m e n t o r分离有助于降低对实现部分编译时刻的依赖性，当改变一个
实现类时，并不需要重新编译 A b s t r a c t i o n类和它的客户程序。为了保证一个类库的不同版本
之间的二进制兼容性，一定要有这个性质。
另外，接口与实现分离有助于分层，从而产生更好的结构化系统，系统的高层部分仅需
知道A b s t r a c t i o n和I m p l e m e n t o r即可。
提高可扩充性
你可以独立地对A b s t r a c t i o n和I m p l e m e n t o r层次结构进行扩充。
实现细节对客户透明
你可以对客户隐藏实现细节，例如共享 I m p l e m e n t o r对象以及相
应的引用计数机制（如果有的话）。
实 现
仅有一个Implementor
在仅有一个实现的时候，没有必要创建一个抽象的 I m p l e m e n t o r
类。这是B r i d g e模式的退化情况；在 A b s t r a c t i o n与I m p l e m e n t o r之间有一种一对一的关系。尽
管如此，当你希望改变一个类的实现不会影响已有的客户程序时，模式的分离机制还是非常
有用的 — 也就是说，不必重新编译它们，仅需重新连接即可。
C a r o l a n [ C a r 8 9 ]用“常露齿嘻笑的猫”（Cheshire Cat）描述这一分离机制。在 C + +中，
I m p l e m e n t o r类的类接口可以在一个私有的头文件中定义，这个文件不提供给客户。这样你就
对客户彻底隐藏了一个类的实现部分。
创建正确的I m p l e m e n t o r对象
当存在多个I m p l e m e n t o r类的时候，你应该用何种方法，
在何时何处确定创建哪一个I m p l e m e n t o r类呢？
如果A b s t r a c t i o n知道所有的C o n c r e t e I m p l e m e n t o r类，它就可以在它的构造器中对其中的
一个类进行实例化，它可以通过传递给构造器的参数确定实例化哪一个类。例如，如果一个c o l l e c t i o n类支持多重实现，就可以根据 c o l l e c t i o n的大小决定实例化哪一个类。链表的实现可
以用于较小的c o l l e c t i o n类，而h a s h表则可用于较大的c o l l e c t i o n类。
另外一种方法是首先选择一个缺省的实现，然后根据需要改变这个实现。例如，如果一
个c o l l e c t i o n的大小超出了一定的阈值时，它将会切换它的实现，使之更适用于表目较多的
c o l l e c t i o n。
也可以代理给另一个对象，由它一次决定。在 Wi n d o w / Wi n d o w I m p的例子中，我们可以
引入一个f a c t o r y对象（参见Abstract Factory(3.1)），该对象的唯一职责就是封装系统平台的细
节。这个对象知道应该为所用的平台创建何种类型的 Wi n d o w I m p对象；Wi n d o w仅需向它请求
一个Wi n d o w I m p，而它会返回正确类型的Wi n d o w I m p对象。这种方法的优点是 Abstraction 类
不和任何一个I m p l e m e n t o r类直接耦合。
共享I m p l e m e n t o r对象
采用多重继承机制
代码示例
view plaincopy
public interface Sourceable {
public void method();
}
分别定义两个实现类：
[java] view plaincopy
public class SourceSub1 implements Sourceable {
@Override
public void method() {
System.out.println("this is the first sub!");
}
}
[java] view plaincopy
public class SourceSub2 implements Sourceable {
@Override
public void method() {
System.out.println("this is the second sub!");
}
}
定义一个桥，持有Sourceable的一个实例：
[java] view plaincopy
public abstract class Bridge {
private Sourceable source;
public void method(){
source.method();
}
public Sourceable getSource() {
return source;
}
public void setSource(Sourceable source) {
this.source = source;
}
}
[java] view plaincopy
public class MyBridge extends Bridge {
public void method(){
getSource().method();
}
}
测试类：
[java] view plaincopy
public class BridgeTest {
public static void main(String[] args) {
Bridge bridge = new MyBridge();
/*调用第一个对象*/
Sourceable source1 = new SourceSub1();
bridge.setSource(source1);
bridge.method();
/*调用第二个对象*/
Sourceable source2 = new SourceSub2();
bridge.setSource(source2);
bridge.method();
}
}
相关模式
Abstract Factory(3.1) 模式可以用来创建和配置一个特定的 B r i d g e模式。
Adapter(4.1) 模式用来帮助无关的类协同工作，它通常在系统设计完成后才会被使用然
而，B r i d g e模式则是在系统开始时就被使用，它使得抽象接口和实现部分可以独立进行改变。
C o m p o s i t e
意 图
将对象组合成树形结构以表示“部分 -整体”的层次结构。C o m p o s i t e使得用户对单个对象和组合对象的使用具有一致性。
别 名
动 机
适用性
你想表示对象的部分-整体层次结构。
你希望用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象
结 构
子主题 1
 
子主题 2
 
参与者
Component
为组合中的对象声明接口。
在适当的情况下，实现所有类共有接口的缺省行为。
声明一个接口用于访问和管理C o m p o n e n t的子组件。
(可选)在递归结构中定义一个接口，用于访问一个父部件，并在合适的情况下实现它。
Leaf
在组合中表示叶节点对象，叶节点没有子节点。
在组合中定义图元对象的行为。
Composite
定义有子部件的那些部件的行为。
存储子部件。
在C o m p o n e n t接口中实现与子部件有关的操作。
Client
通过C o m p o n e n t接口操纵组合部件的对象。
协 作
用户使用C o m p o n e n t类接口与组合结构中的对象进行交互。如果接收者是一个叶节点 ,则直接处理请求。如果接收者是 Composite, 它通常将请求发送给它的子部件，在转发请求之前与/或之后可能执行一些辅助操作。
效 果
定义了包含基本对象和组合对象的类层次结构
基本对象可以被组合成更复杂的组合对
象，而这个组合对象又可以被组合，这样不断的递归下去。客户代码中，任何用到基本
对象的地方都可以使用组合对象。
简化客户代码
客户可以一致地使用组合结构和单个对象。通常用户不知道 (也不关心)
处理的是一个叶节点还是一个组合组件。这就简化了客户代码 , 因为在定义组合的那些
类中不需要写一些充斥着选择语句的函数。
使得更容易增加新类型的组件
新定义的C o m p o s i t e或L e a f子类自动地与已有的结构和客
户代码一起工作，客户程序不需因新的 C o m p o n e n t类而改变。
使你的设计变得更加一般化
容易增加新组件也会产生一些问题，那就是很难限制组合
中的组件。有时你希望一个组合只能有某些特定的组件。使用 C o m p o s i t e时，你不能依
赖类型系统施加这些约束，而必须在运行时刻进行检查。
实 现
实现C o m p o s i t e模式时需要考虑以下几个问题
显式的父部件引用
保持从子部件到父部件的引用能简化组合结构的遍历和管理。父部
件引用可以简化结构的上移和组件的删除，同时父部件引用也支持 Chain of Responsibility(5.2)
模式。
通常在C o m p o n e n t类中定义父部件引用。 L e a f和C o m p o s i t e类可以继承这个引用以及管理
这个引用的那些操作。对于父部件引用，必须维护一个不变式，即一个组合的所有子节点以这个组合为父节点，
而反之该组合以这些节点为子节点。保证这一点最容易的办法是，仅当在一个组合中增加或
删除一个组件时，才改变这个组件的父部件。如果能在 C o m p o s i t e类的Add 和R e m o v e操作中
实现这种方法，那么所有的子类都可以继承这一方法，并且将自动维护这一不变式。
共享组件
共享组件是很有用的，比如它可以减少对存贮的需求。但是当一个组件只
有一个父部件时，很难共享组件。
一个可行的解决办法是为子部件存贮多个父部件，但当一个请求在结构中向上传递时，
这种方法会导致多义性。 F l y w e i g h t ( 4 . 6 )模式讨论了如何修改设计以避免将父部件存贮在一起
的方法。如果子部件可以将一些状态 (或是所有的状态)存储在外部，从而不需要向父部件发送
请求，那么这种方法是可行的。
最大化C o m p o n e n t接口
C o m p o s i t e模式的目的之一是使得用户不知道他们正在使用的
具体的Leaf 和C o m p o s i t e类。为了达到这一目的，C o m p o s i t e类应为Leaf 和C o m p o s i t e类尽可能
多定义一些公共操作。 C o m p o s i t e类通常为这些操作提供缺省的实现，而 Leaf 和C o m p o s i t e子
类可以对它们进行重定义。
然而，这个目标有时可能会与类层次结构设计原则相冲突，该原则规定：一个类只能定
义那些对它的子类有意义的操作。有许多C o m p o n e n t所支持的操作对L e a f类似乎没有什么意义，
那么C o m p o n e n t怎样为它们提供一个缺省的操作呢？
有时一点创造性可以使得一个看起来仅对 C o m p o s i t e才有意义的操作，将它移入
C o m p o n e n t类中，就会对所有的 C o m p o n e n t都适用。例如，访问子节点的接口是 C o m p o s i t e类
的一个基本组成部分，但对 L e a f类来说并不必要。但是如果我们把一个 L e a f看成一个没有子
节点的Component, 就可以为在C o m p o n e n t类中定义一个缺省的操作，用于对子节点进行访问，
这个缺省的操作不返回任何一个子节点。Leaf 类可以使用缺省的实现，而C o m p o s i t e类则会重
新实现这个操作以返回它们的子类。
管理子部件的操作比较复杂，我们将在下一项中予以讨论。
声明管理子部件的操作
虽然C o m p o s i t e类实现了Add 和R e m o v e操作用于管理子部件，
但在C o m p o s i t e模式中一个重要的问题是：在 C o m p o s i t e类层次结构中哪一些类声明这些操作。
我们是应该在C o m p o n e n t中声明这些操作，并使这些操作对 L e a f类有意义呢，还是只应该在
C o m p o s i t e和它的子类中声明并定义这些操作呢？
这需要在安全性和透明性之间做出权衡选择。
• 在类层次结构的根部定义子节点管理接口的方法具有良好的透明性，因为你可以一致地
使用所有的组件，但是这一方法是以安全性为代价的，因为客户有可能会做一些无意义
的事情，例如在Leaf 中增加和删除对象等。
• 在C o m p o s i t e类中定义管理子部件的方法具有良好的安全性，因为在象 C + +这样的静态
类型语言中，在编译时任何从Leaf 中增加或删除对象的尝试都将被发现。但是这又损失
了透明性，因为Leaf 和C o m p o s i t e具有不同的接口。
在这一模式中，相对于安全性，我们比较强调透明性。如果你选择了安全性，有时你可
能会丢失类型信息，并且不得不将一个组件转换成一个组合。这样的类型转换必定不是类型
安全的。
Component是否应该实现一个C o m p o n e n t列表
你可能希望在C o m p o n e n t类中将子节点
集合定义为一个实例变量，而这个 C o m p o n e n t类中也声明了一些操作对子节点进行访问和管理。但是在基类中存放子类指针，对叶节点来说会导致空间浪费，因为叶节点根本没有子节
点。只有当该结构中子类数目相对较少时，才值得使用这种方法。
子部件排序
许多设计指定了C o m p o s i t e的子部件顺序。在前面的 G r a p h i c s例子中，排
序可能表示了从前至后的顺序。如果 C o m p o s i t e表示语法分析树， C o m p o s i t e子部件的顺序必
须反映程序结构，而组合语句就是这样一些 C o m p o s i t e的实例。
如果需要考虑子节点的顺序时，必须仔细地设计对子节点的访问和管理接口，以便管理
子节点序列。I t e r a t o r模式( 5 . 4 )可以在这方面给予一些定的指导。
使用高速缓冲存贮改善性能
如果你需要对组合进行频繁的遍历或查找， C o m p o s i t e类
可以缓冲存储对它的子节点进行遍历或查找的相关信息。 C o m p o s i t e可以缓冲存储实际结果或
者仅仅是一些用于缩短遍历或查询长度的信息。例如，动机一节的例子中 P i c t u r e类能高速缓
冲存贮其子部件的边界框，在绘图或选择期间，当子部件在当前窗口中不可见时，这个边界
框使得P i c t u r e不需要再进行绘图或选择。
一个组件发生变化时，它的父部件原先缓冲存贮的信息也变得无效。在组件知道其父部
件时，这种方法最为有效。因此，如果你使用高速缓冲存贮，你需要定义一个接口来通知组
合组件它们所缓冲存贮的信息无效。
应该由谁删除Component
在没有垃圾回收机制的语言中，当一个 C o m p o s i t e被销毁时，
通常最好由C o m p o s i t e负责删除其子节点。但有一种情况除外，即 L e a f对象不会改变，因此可
以被共享。
存贮组件最好用哪一种数据结构
C o m p o s i t e可使用多种数据结构存贮它们的子节点，
包括连接列表、树、数组和 h a s h表。数据结构的选择取决于效率。事实上，使用通用数据结
构根本没有必要。有时对每个子节点， C o m p o s i t e都有一个变量与之对应，这就要求
C o m p o s i t e的每个子类都要实现自己的管理接口。参见 I n t e r p r e t e r ( 5 . 3 )模式中的例子。
代码示例
public class TreeNode {
private String name;
private TreeNode parent;
private Vector<TreeNode> children = new Vector<TreeNode>();
public TreeNode(String name){
this.name = name;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public TreeNode getParent() {
return parent;
}
public void setParent(TreeNode parent) {
this.parent = parent;
}
//添加孩子节点
public void add(TreeNode node){
children.add(node);
}
//删除孩子节点
public void remove(TreeNode node){
children.remove(node);
}
//取得孩子节点
public Enumeration<TreeNode> getChildren(){
return children.elements();
}
}
[java] view plaincopy
public class Tree {
TreeNode root = null;
public Tree(String name) {
root = new TreeNode(name);
}
public static void main(String[] args) {
Tree tree = new Tree("A");
TreeNode nodeB = new TreeNode("B");
TreeNode nodeC = new TreeNode("C");
nodeB.add(nodeC);
tree.root.add(nodeB);
System.out.println("build the tree finished!");
}
}
相关模式
通常部件-父部件连接用于Responsibility of Chain(5.1)模式
D e c o r a t o r（4 . 4）模式经常与C o m p o s i t e模式一起使用。
当装饰和组合一起使用时，它们
通常有一个公共的父类。因此装饰必须支持具有 A d d、R e m o v e和GetChild 操作的C o m p o n e n t接口。
F l y w e i g h t ( 4 . 6 )让你共享组件，但不再能引用他们的父部件。
I t e r t o r ( 5 . 4 )可用来遍历C o m p o s i t e。
Vi s i t o r ( 5 . 11 )将本来应该分布在C o m p o s i t e和L e a f类中的操作和行为局部化。
D e c o r a t o r
意 图
动态地给一个对象添加一些额外的职责。就增加功能来说， Decorator模式相比生成子类更为灵活。
别 名
包装器Wr a p p e r
动 机
有时我们希望给某个对象而不是整个类添加一些功能。
适用性
在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
处理那些可以撤消的职责。
当不能采用生成子类的方法进行扩充时。
可能有大量独立的扩展，为支持每一种组合将产生大量的子类，使得子类数目呈爆炸性增长。
是因为类定义被隐藏，或类定义不能用于生成子类。
结 构
 
参与者
Component
定义一个对象接口，可以给这些对象动态地添加职责
C o n c r e t e C o m p o n e n t
定义一个对象，可以给这个对象添加一些职责
D e c o r a t o r
维持一个指向C o m p o n e n t对象的指针，并定义一个与C o m p o n e n t接口一致的接口。
C o n c r e t e D e c o r a t o r
向组件添加职责
协 作
D e c o r a t o r将请求转发给它的C o m p o n e n t对象，并有可能在转发请求前后执行一些附加的动作
效 果
优点
比静态继承更灵活
与对象的静态继承（多重继承）相比， D e c o r a t o r模式提供了更加
灵活的向对象添加职责的方式。可以用添加和分离的方法，用装饰在运行时刻增加和删除职
责。相比之下，继承机制要求为每个添加的职责创建一个新的子类（例如， B o r d e r S c r o l l a b l e
Te x t Vi e w, BorderedTe x t Vi e w）。这会产生许多新的类，并且会增加系统的复杂度。此外，为一
个特定的C o m p o n e n t类提供多个不同的 D e c o r a t o r类，这就使得你可以对一些职责进行混合和
匹配。
使用D e c o r a t o r模式可以很容易地重复添加一个特性，例如在 Te x t Vi e w上添加双边框时，
仅需将添加两个B o r d e r D e c o r a t o r即可。而两次继承B o r d e r类则极容易出错的。
避免在层次结构高层的类有太多的特征
D e c o r a t o r模式提供了一种“即用即付”的方
法来添加职责。它并不试图在一个复杂的可定制的类中支持所有可预见的特征，相反，你可
以定义一个简单的类，并且用 D e c o r a t o r类给它逐渐地添加功能。可以从简单的部件组合出复
杂的功能。这样，应用程序不必为不需要的特征付出代价。同时也更易于不依赖于 D e c o r a t o r
所扩展（甚至是不可预知的扩展）的类而独立地定义新类型的 D e c o r a t o r。扩展一个复杂类的
时候，很可能会暴露与添加的职责无关的细节。
Decorator与它的C o m p o n e n t不一样
D e c o r a t o r是一个透明的包装。如果我们从对象标
识的观点出发，一个被装饰了的组件与这个组件是有差别的，因此，使用装饰时不应该依赖
对象标识。
缺点
有许多小对象
采用D e c o r a t o r模式进行系统设计往往会产生许多看上去类似的小对象，
这些对象仅仅在他们相互连接的方式上有所不同，而不是它们的类或是它们的属性值有所不
同。尽管对于那些了解这些系统的人来说，很容易对它们进行定制，但是很难学习这些系统，
排错也很困难。
实 现
接口的一致性
省略抽象的D e c o r a t o r类
保持C o m p o n e n t类的简单性
改变对象外壳与改变对象内核
代码示例
顾名思义，装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例，关系图如下：
Source类是被装饰类，Decorator类是一个装饰类，可以为Source类动态的添加一些功能，代码如下：
[java] view plaincopy
public interface Sourceable {  
    public void method();  
}  
[java] view plaincopy
public class Source implements Sourceable {  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
}  
[java] view plaincopy
public class Decorator implements Sourceable {  
    private Sourceable source;  
    public Decorator(Sourceable source){  
        super();  
        this.source = source;  
    }  
    @Override  
    public void method() {  
        System.out.println("before decorator!");  
        source.method();  
        System.out.println("after decorator!");  
    }  
}  
测试类：
[java] view plaincopy
public class DecoratorTest {  
    public static void main(String[] args) {  
        Sourceable source = new Source();  
        Sourceable obj = new Decorator(source);  
        obj.method();  
    }  
}  
输出：
before decorator!
the original method!
after decorator!
装饰器模式的应用场景：
1、需要扩展一个类的功能。
2、动态的为一个对象增加功能，而且还能动态撤销。（继承不能做到这一点，继承的功能是静态的，不能动态增删。）
缺点：产生过多相似的对象，不易排错！
 
相关模式
A d a p t e r ( 4 . 1 )模式：D e c o r a t o r模式不同于A d a p t e r模式，因为装饰仅改变对象的职责而不改变它的接口；而适配器将给对象一个全新的接口。
C o m p o s i t e ( 4 . 3 )模式：可以将装饰视为一个退化的、仅有一个组件的组合。然而，装饰仅给对象添加一些额外的职责 — 它的目的不在于对象聚集。
S t r a t e g y ( 5 . 9 )模式：用一个装饰你可以改变对象的外表；而 S t r a t e g y模式使得你可以改变对象的内核。这是改变对象的两种途径。
F a c a d e
意 图
为子系统中的一组接口提供一个一致的界面， F a c a d e模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
别 名
动 机
将一个系统划分成为若干个子系统有利于降低系统的复杂性。
适用性
当你要为一个复杂子系统提供一个简单接口时。
子系统往往因为不断演化而变得越来越
复杂。大多数模式使用时都会产生更多更小的类。这使得子系统更具可重用性，也更容
易对子系统进行定制，但这也给那些不需要定制子系统的用户带来一些使用上的困难。
F a c a d e可以提供一个简单的缺省视图，这一视图对大多数用户来说已经足够，而那些需
要更多的可定制性的用户可以越过 f a c a d e层。
客户程序与抽象类的实现部分之间存在着很大的依赖性。
引入 f a c a d e将这个子系统与客
户以及其他的子系统分离，可以提高子系统的独立性和可移植性。
当你需要构建一个层次结构的子系统时，使用 f a c a d e模式定义子系统中每层的入口点。
如果子系统之间是相互依赖的，你可以让它们仅通过 f a c a d e进行通讯，从而简化了它们
之间的依赖关系。
结 构
 
参与者
F a c a d e
知道哪些子系统类负责处理请求。
将客户的请求代理给适当的子系统对象。
Subsystem classes
实现子系统的功能。
处理由F a c a d e对象指派的任务。
没有f a c a d e的任何相关信息；即没有指向f a c a d e的指针。
协 作
客户程序通过发送请求给 F a c a d e的方式与子系统通讯，F a c a d e将这些消息转发给适当的子系统对象。尽管是子系统中的有关对象在做实际工作，但 F a c a d e模式本身也必须将它的接口转换成子系统的接口。
使用F a c a d e的客户程序不需要直接访问子系统对象。
效 果
它对客户屏蔽子系统组件，因而减少了客户处理的对象的数目并使得子系统使用起来更加方便。
它实现了子系统与客户之间的松耦合关系，而子系统内部的功能组件往往是紧耦合的。
松耦合关系使得子系统的组件变化不会影响到它的客户。 F a c a d e模式有助于建立层次结构系
统，也有助于对对象之间的依赖关系分层。 F a c a d e模式可以消除复杂的循环依赖关系。这一
点在客户程序与子系统是分别实现的时候尤为重要。
在大型软件系统中降低编译依赖性至关重要。在子系统类改变时，希望尽量减少重编译
工作以节省时间。用 F a c a d e可以降低编译依赖性，限制重要系统中较小的变化所需的重编译
工作。F a c a d e模式同样也有利于简化系统在不同平台之间的移植过程，因为编译一个子系统
一般不需要编译所有其他的子系统。
如果应用需要，它并不限制它们使用子系统类。
因此你可以在系统易用性和通用性之
间加以选择。
实 现
降低客户-子系统之间的耦合度
用抽象类实现F a c a d e而它的具体子类对应于不同的子
系统实现，这可以进一步降低客户与子系统的耦合度。这样，客户就可以通过抽象的 F a c a d e
类接口与子系统通讯。这种抽象耦合关系使得客户不知道它使用的是子系统的哪一个实现。
除生成子类的方法以外，另一种方法是用不同的子系统对象配置 F a c a d e对象。为定制
f a c a d e，仅需对它的子系统对象（一个或多个）进行替换即可。
公共子系统类与私有子系统类
一个子系统与一个类的相似之处是，它们都有接口并
且它们都封装了一些东西 — 类封装了状态和操作，而子系统封装了一些类。考虑一个类的
公共和私有接口是有益的，我们也可以考虑子系统的公共和私有接口。
子系统的公共接口包含所有的客户程序可以访问的类；私有接口仅用于对子系统进行扩
充。当然，F a c a d e类是公共接口的一部分，但它不是唯一的部分，子系统的其他部分通常也
是公共的。例如，编译子系统中的 P a r s e r类和S c a n n e r类就是公共接口的一部分。
私有化子系统类确实有用，但是很少有面向对象的编程语言支持这一点。 C + +和S m a l l t a l k
语言仅在传统意义下为类提供了一个全局名空间。然而，最近 C + +标准化委员会在C + +语言中
增加了一些名字空间[ S t r 9 4 ]，这些名字空间使得你可以仅暴露公共子系统类。
代码示例
外观模式（Facade）
外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口，看下类图：（我们以一个计算机的启动过程为例）
我们先看下实现类：
[java] view plaincopy
public class CPU {  
    public void startup(){  
        System.out.println("cpu startup!");  
    }  
    public void shutdown(){  
        System.out.println("cpu shutdown!");  
    }  
}  
[java] view plaincopy
public class Memory {  
    public void startup(){  
        System.out.println("memory startup!");  
    }  
    public void shutdown(){  
        System.out.println("memory shutdown!");  
    }  
}  
[java] view plaincopy
public class Disk {  
    public void startup(){  
        System.out.println("disk startup!");  
    }  
    public void shutdown(){  
        System.out.println("disk shutdown!");  
    }  
}  
[java] view plaincopy
public class Computer {  
    private CPU cpu;  
    private Memory memory;  
    private Disk disk;  
    public Computer(){  
        cpu = new CPU();  
        memory = new Memory();  
        disk = new Disk();  
    }  
    public void startup(){  
        System.out.println("start the computer!");  
        cpu.startup();  
        memory.startup();  
        disk.startup();  
        System.out.println("start computer finished!");  
    }  
    public void shutdown(){  
        System.out.println("begin to close the computer!");  
        cpu.shutdown();  
        memory.shutdown();  
        disk.shutdown();  
        System.out.println("computer closed!");  
    }  
}  
User类如下：
[java] view plaincopy
public class User {  
    public static void main(String[] args) {  
        Computer computer = new Computer();  
        computer.startup();  
        computer.shutdown();  
    }  
}  
输出：
start the computer!
cpu startup!
memory startup!
disk startup!
start computer finished!
begin to close the computer!
cpu shutdown!
memory shutdown!
disk shutdown!
computer closed!
如果我们没有Computer类，那么，CPU、Memory、Disk他们之间将会相互持有实例，产生关系，这样会造成严重的依赖，修改一个类，可能会 带来其他类的修改，这不是我们想要看到的，有了Computer类，他们之间的关系被放在了Computer类里，这样就起到了解耦的作用，这，就是外观 模式！
相关模式
Abstract Factory (3.1)模式可以与F a c a d e模式一起使用以提供一个接口，这一接口可用来以一种子系统独立的方式创建子系统对象。 Abstract Factory也可以代替F a c a d e模式隐藏那些与平台相关的类。
Mediator (5.5) 模式与F a c a d e模式的相似之处是，它抽象了一些已有的类的功能。然而，M e d i a t o r的目的是对同事之间的任意通讯进行抽象，通常集中不属于任何单个对象的功能。M e d i a t o r的同事对象知道中介者并与它通信，而不是直接与其他同类对象通信。相对而言，F a c a d e模式仅对子系统对象的接口进行抽象，从而使它们更容易使用；它并不定义新功能，子系统也不知道f a c a d e的存在。
通常来讲，仅需要一个F a c a d e对象，因此F a c a d e对象通常属于Singleton (3.5)模式。
P r o x y
意 图
为其他对象提供一种代理以控制对这个对象的访问。
别 名
Surrogate
动 机
对一个对象进行访问控制的一个原因是为了只有在我们确实需要这个对象时才对它进行创建和初始化。
适用性
在需要用比较通用和复杂的对象指针代替简单的指针的时候，使用 P r o x y模式。下面是一
些可以使用P r o x y模式常见情况：
远 程 代 理 （ Remote Proxy） 为 一 个 对 象在 不 同 的 地 址 空间 提 供 局 部 代 表。
NEXTSTEP[Add94] 使用N X P r o x y类实现了这一目的。Coplien[Cop92] 称这种代理为“大使”
（A m b a s s a d o r）。
虚代理（Virtual Proxy）根据需要创建开销很大的对象。
在动机一节描述的 I m a g e P r o x y
就是这样一种代理的例子。
保护代理（Protection Proxy）控制对原始对象的访问。
保护代理用于对象应该有不同
的访问权限的时候。例如，在 C h o i c e s操作系统[ C I R M 9 3 ]中K e m e l P r o x i e s为操作系统对象提供
了访问保护。
智能指引（Smart Reference）取代了简单的指针，它在访问对象时执行一些附加操作。
它的典型用途包括：
• 对指向实际对象的引用计数，这样当该对象没有引用时，可以自动释放它 (也称为S m a r t
P o i n t e r s[ E d e 9 2 ] )。
• 当第一次引用一个持久对象时，将它装入内存。
• 在访问一个实际对象前，检查是否已经锁定了它，以确保其他对象不能改变它。
结 构
 
 
参与者
P r o x y
保存一个引用使得代理可以访问实体。若 R e a l S u b j e c t和S u b j e c t的接口相同，P r o x y会引用S u b j e c t
提供一个与S u b j e c t的接口相同的接口，这样代理就可以用来替代实体。
控制对实体的存取，并可能负责创建和删除它。
其他功能依赖于代理的类型：
Remote Pro x y负责对请求及其参数进行编码，并向不同地址空间中的实体发送已编码的请求。
Vi rtual Pro x y可以缓存实体的附加信息，以便延迟对它的访问。例如，动机一节中提到的I m a g e P r o x y缓存了图像实体的尺寸。
P rotection Pro x y检查调用者是否具有实现一个请求所必需的访问权限。
S u b j e c t
定义RealSubject 和P r o x y的共用接口，这样就在任何使用R e a l S u b j e c t的地方都可以使用P r o x y。
R e a l S u b j e c t
定义P r o x y所代表的实体。
协 作
代理根据其种类，在适当的时候向 R e a l S u b j e c t转发请求。
效 果
P r o x y模式在访问对象时引入了一定程度的间接性。根据代理的类型，附加的间接性有多
种用途：
P r o x y模式还可以对用户隐藏另一种称之为 c o p y - o n - w r i t e的优化方式，该优化与根据需要
创建对象有关。拷贝一个庞大而复杂的对象是一种开销很大的操作，如果这个拷贝根本没有
被修改，那么这些开销就没有必要。用代理延迟这一拷贝过程，我们可以保证只有当这个对
象被修改的时候才对它进行拷贝。
在实现C o p y - o n - w r i t e时必须对实体进行引用计数。拷贝代理仅会增加引用计数。只有当
用户请求一个修改该实体的操作时，代理才会真正的拷贝它。在这种情况下，代理还必须减
少实体的引用计数。当引用的数目为零时，这个实体将被删除。
C o p y - o n - Wr i t e可以大幅度的降低拷贝庞大实体时的开销。
Remote Proxy可以隐藏一个对象存在于不同地址空间的事实。
Virtual Proxy 可以进行最优化，例如根据要求创建对象。
Protection Proxies和Smart Reference都允许在访问一个对象时有一些附加的内务处理（Housekeeping task）。
实 现
代码示例
其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候回去找中介，为什么呢？因为你对该 地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，此处的代理就是这个意思。再如我们有的时候打官司，我们需要请律师，因为律师在法律方面有 专长，可以替我们进行操作，表达我们的想法。先来看看关系图：
根据上文的阐述，代理模式就比较容易的理解了，我们看下代码：
[java] view plaincopy
public interface Sourceable {  
    public void method();  
}  
[java] view plaincopy
public class Source implements Sourceable {  
    @Override  
    public void method() {  
        System.out.println("the original method!");  
    }  
}  
[java] view plaincopy
public class Proxy implements Sourceable {  
    private Source source;  
    public Proxy(){  
        super();  
        this.source = new Source();  
    }  
    @Override  
    public void method() {  
        before();  
        source.method();  
        atfer();  
    }  
    private void atfer() {  
        System.out.println("after proxy!");  
    }  
    private void before() {  
        System.out.println("before proxy!");  
    }  
}  
测试类：
[java] view plaincopy
public class ProxyTest {  
    public static void main(String[] args) {  
        Sourceable source = new Proxy();  
        source.method();  
    }  
}  
输出：
before proxy!
the original method!
after proxy!
代理模式的应用场景：
如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种办法：
1、修改原有的方法来适应。这样违反了“对扩展开放，对修改关闭”的原则。
2、就是采用一个代理类调用原有的方法，且对产生的结果进行控制。这种方法就是代理模式。
使用代理模式，可以将功能划分的更加清晰，有助于后期维护！
相关模式
A d a p t e r ( 4 . 1 )：适配器A d a p t e r为它所适配的对象提供了一个不同的接口。相反，代理提供了与它的实体相同的接口。然而，用于访问保护的代理可能会拒绝执行实体会执行的操作，因此，它的接口实际上可能只是实体接口的一个子集。
D e c o r a t o r ( 4 . 4 )：尽管 d e c o r a t o r的实现部分与代理相似，但 d e c o r a t o r的目的不一样。D e c o r a t o r为对象添加一个或多个功能，而代理则控制对对象的访问。
代理的实现与d e c o r a t o r的实现类似，但是在相似的程度上有所差别。 Protection Proxy的实现可能与d e c o r a t o r的实现差不多。另一方面， Remote Proxy不包含对实体的直接引用，而只是一个间接引用，如“主机 I D，主机上的局部地址。”Virtual Proxy开始的时候使用一个间接引用，例如一个文件名，但最终将获取并使用一个直接引用。
F l y w e i g h t
意 图
运用共享技术有效地支持大量细粒度的对象。
别 名
动 机
有些应用程序得益于在其整个设计过程中采用对象技术，但简单化的实现代价极大。
适用性
一个应用程序使用了大量的对象。
完全由于使用大量的对象，造成很大的存储开销。
对象的大多数状态都可变为外部状态。
如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象。
应用程序不依赖于对象标识。由于 F l y w e i g h t对象可以被共享，对于概念上明显有别的对象，标识测试将返回真值。
结 构
 
 
参与者
F l y w e i g h t
描述一个接口，通过这个接口f l y w e i g h t可以接受并作用于外部状态。
C o n c r e t e F l y w e i g h t
实 现 F l y w e i g h t 接 口 ， 并 为 内 部 状 态 （ 如 果 有 的 话 ） 增 加 存 储 空 间 。C o n c r e t e F l y w e i g h t对象必须是可共享的。它所存储的状态必须是内部的；即，它必须独立于C o n c r e t e F l y w e i g h t对象的场景。
U n s h a r e d C o n c r e t e F l y w e i g h t
并非所有的F l y w e i g h t子类都需要被共享。 F l y w e i g h t接口使共享成为可能，但它并不强制共享。在F l y w e i g h t对象结构的某些层次， U n s h a r e d C o n c r e t e F l y w e i g h t对象通常将C o n c r e t e F l y w e i g h t对象作为子节点（R o w和C o l u m n就是这样）。
F l y w e i g h t F a c t o r y
创建并管理f l y w e i g h t对象。
确保合理地共享f l y w e i g h t。当用户请求一个f l y w e i g h t时，F l y w e i g h t F a c t o r y对象提供一个已创建的实例或者创建一个（如果不存在的话）。
Client
维持一个对f l y w e i g h t的引用。
计算或存储一个（多个）f l y w e i g h t的外部状态。
协 作
f l y w e i g h t执行时所需的状态必定是内部的或外部的。
内部状态存储于 C o n c r e t e F l y w e i g h t对象之中；
外部对象则由 C l i e n t对象存储或计算
当用户调用 f l y w e i g h t对象的操作时，将该状态传递给它。
用户不应直接对C o n c r e t e F l y w e i g h t类进行实例化，而只能从 F l y w e i g h t F a c t o r y对象得到C o n c r e t e F l y w e i g h t对象，这可以保证对它们适当地进行共享。
效 果
使用F l y w e i g h t模式时，传输、查找和 /或计算外部状态都会产生运行时的开销，尤其当
f l y w e i g h t原先被存储为内部状态时。然而，空间上的节省抵消了这些开销。共享的 f l y w e i g h t
越多，空间节省也就越大。
存储节约由以下几个因素决定
共享的F l y w e i g h t越多，存储节约也就越多。节约量随着共享状态的增多而增大。当对象
使用大量的内部及外部状态，并且外部状态是计算出来的而非存储的时候，节约量将达到最
大。所以，可以用两种方法来节约存储：用共享减少内部状态的消耗，用计算时间换取对外
部状态的存储。
F l y w e i g h t模式经常和C o m p o s i t e（4 . 3）模式结合起来表示一个层次式结构，这一层次式
结构是一个共享叶节点的图。共享的结果是， F l y w e i g h t的叶节点不能存储指向父节点的指针。
而父节点的指针将传给 F l y w e i g h t作为它的外部状态的一部分。这对于该层次结构中对象之间
相互通讯的方式将产生很大的影响。
因为共享，实例总数减少的数目
对象内部状态的平均数目
外部状态是计算的还是存储的
实 现
删除外部状态
该模式的可用性在很大程度上取决于是否容易识别外部状态并将它从
共享对象中删除。如果不同种类的外部状态和共享前对象的数目相同的话，删除外部状态不
会降低存储消耗。理想的状况是，外部状态可以由一个单独的对象结构计算得到，且该结构
的存储要求非常小。
例如，在我们的文档编辑器中，我们可以用一个单独的结构存储排版布局信息，而不是
存储每一个字符对象的字体和类型信息，布局图保持了带有相同排版信息的字符的运行轨迹。
当某字符绘制自己的时候，作为绘图遍历的副作用它接收排版信息。因为通常文档使用的字
体和类型数量有限，将该信息作为外部信息来存储，要比内部存储高效得多。
管理共享对象
因为对象是共享的，用户不能直接对它进行实例化，因此 F l y w e i g h t -
F a c t o r y可以帮助用户查找某个特定的 F l y w e i g h t对象。F l y w e i g h t F a c t o r y对象经常使用关联存储
帮助用户查找感兴趣的F l y w e i g h t对象。例如，在这个文档编辑器一例中的F l y w e i g h t工厂就有一
个以字符代码为索引的F l y w e i g h t表。管理程序根据所给的代码返回相应的F l y w e i g h t，若不存在，
则创建一个F l y w e i g h t。
共享还意味着某种形式的引用计数和垃圾回收，这样当一个 F l y w e i g h t不再使用时，可以
回收它的存储空间。然而，当 F l y w e i g h t的数目固定而且很小的时候（例如，用于 A C S I I码的
F l y w e i g h t），这两种操作都不必要。在这种情况下， F l y w e i g h t完全可以永久保存。
代码示例
享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
FlyWeightFactory负责创建和管理享元单元，当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象，如果有，就返回已经存在 的对象，如果没有，则创建一个新对象，FlyWeight是超类。一提到共享池，我们很容易联想到Java里面的JDBC连接池，想想每个连接的特点，我 们不难总结出：适用于作共享的一些个对象，他们有一些共有的属性，就拿数据库连接池来说，url、driverClassName、username、 password及dbname，这些属性对于每个连接来说都是一样的，所以就适合用享元模式来处理，建一个工厂类，将上述类似属性作为内部数据，其它的 作为外部数据，在方法调用时，当做参数传进来，这样就节省了空间，减少了实例的数量。
看个例子：
看下数据库连接池的代码：
[java] view plaincopy
public class ConnectionPool {  
    private Vector<Connection> pool;  
    /*公有属性*/  
    private String url = "jdbc:mysql://localhost:3306/test";  
    private String username = "root";  
    private String password = "root";  
    private String driverClassName = "com.mysql.jdbc.Driver";  
    private int poolSize = 100;  
    private static ConnectionPool instance = null;  
    Connection conn = null;  
    /*构造方法，做一些初始化工作*/  
    private ConnectionPool() {  
        pool = new Vector<Connection>(poolSize);  
        for (int i = 0; i < poolSize; i++) {  
            try {  
                Class.forName(driverClassName);  
                conn = DriverManager.getConnection(url, username, password);  
                pool.add(conn);  
            } catch (ClassNotFoundException e) {  
                e.printStackTrace();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
    /* 返回连接到连接池 */  
    public synchronized void release() {  
        pool.add(conn);  
    }  
    /* 返回连接池中的一个数据库连接 */  
    public synchronized Connection getConnection() {  
        if (pool.size() > 0) {  
            Connection conn = pool.get(0);  
            pool.remove(conn);  
            return conn;  
        } else {  
            return null;  
        }  
    }  
}  
通过连接池的管理，实现了数据库连接的共享，不需要每一次都重新创建连接，节省了数据库重新创建的开销，提升了系统的性能！本章讲解了7种结构型模式，因为篇幅的问题，剩下的11种行为型模式，
本章是关于设计模式的最后一讲，会讲到第三种设计模式——行为型模式，共11种：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模 式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。这段时间一直在写关于设计模式的东西，终于写到一半了，写博文是个很费时间的东西，因为 我得为读者负责，不论是图还是代码还是表述，都希望能尽量写清楚，以便读者理解，我想不论是我还是读者，都希望看到高质量的博文出来，从我本人出发，我会 一直坚持下去，不断更新，源源动力来自于读者朋友们的不断支持，我会尽自己的努力，写好每一篇文章！希望大家能不断给出意见和建议，共同打造完美的博文！
先来张图，看看这11中模式的关系：
第一类：通过父类与子类的关系进行实现。第二类：两个类之间。第三类：类的状态。第四类：通过中间类
相关模式
F l y w e i g h t模式通常和C o m p o s i t e ( 4 . 3 )模式结合起来，用共享叶结点的有向无环图实现一个逻辑上的层次结构。
通常，最好用F l y w e i g h t实现S t a t e ( 5 . 8 )和S t r a t e g y ( 5 . 9 )对象。
结构型模式的讨论
你可能已经注意到了结构型模式之间的相似性，尤其是它们的参与者和协作之间的相似
性。这可能是因为结构型模式依赖于同一个很小的语言机制集合构造代码和对象：单继承和
多重继承机制用于基于类的模式，而对象组合机制用于对象式模式。但是这些相似性掩盖了
这些模式的不同意图。在本节中，我们将对比这些结构型模式，使你对它们各自的优点有所
了解。
Adapter与Bridge
A d a p t e r（4 . 1）模式和 B r i d g e（4 . 2）模式具有一些共同的特征。它们都给另一对象提供
了一定程度上的间接性，因而有利于系统的灵活性。它们都涉及到从自身以外的一个接口向
这个对象转发请求。
这些模式的不同之处主要在于它们各自的用途。 A d a p t e r模式主要是为了解决两个已有接
口之间不匹配的问题。它不考虑这些接口是怎样实现的，也不考虑它们各自可能会如何演化。
这种方式不需要对两个独立设计的类中的任一个进行重新设计，就能够使它们协同工作。另一方面，B r i d g e模式则对抽象接口与它的（可能是多个）实现部分进行桥接。虽然这一模式
允许你修改实现它的类，它仍然为用户提供了一个稳定的接口。 B r i d g e模式也会在系统演化
时适应新的实现。
由于这些不同点， A d a p t e r和B r i d g e模式通常被用于软件生命周期的不同阶段。当你发现
两个不兼容的类必须同时工作时，就有必要使用 A d a p t e r模式，其目的一般是为了避免代码重
复。此处耦合不可预见。相反， B r i d g e的使用者必须事先知道：一个抽象将有多个实现部分，
并且抽象和实现两者是独立演化的。 A d a p t e r模式在类已经设计好后实施；而B r i d g e模式在设
计类之前实施。这并不意味着A d a p t e r模式不如B r i d g e模式，只是因为它们针对了不同的问题。
你可能认为f a c a d e (参见F a c a d e ( 4 . 5 ) )是另外一组对象的适配器。但这种解释忽视了一个事
实：即 F a c a d e定义一个新的接口，而A d a p t e r则复用一个原有的接口。记住，适配器使两个已
有的接口协同工作，而不是定义一个全新的接口。
Composite、Decorator与Proxy
C o m p o s i t e ( 4 . 3 )模式和D e c o r a t o r ( 4 . 4 )模式具有类似的结构图，这说明它们都基于递归组合
来组织可变数目的对象。这一共同点可能会使你认为， d e c o r a t o r对象是一个退化的c o m p o s i t e，
但这一观点没有领会 D e c o r a t o r模式要点。相似点仅止于递归组合，同样，这是因为这两个模
式的目的不同。
Decorator 旨在使你能够不需要生成子类即可给对象添加职责。这就避免了静态实现所有
功能组合，从而导致子类急剧增加。 C o m p o s i t e则有不同的目的，它旨在构造类，使多个相关
的对象能够以统一的方式处理，而多重对象可以被当作一个对象来处理。它重点不在于修饰，
而在于表示。
尽管它们的目的截然不同，但却具有互补性。因此 Composite 和 D e c o r a t o r模式通常协同
使用。在使用这两种模式进行设计时，我们无需定义新的类，仅需将一些对象插接在一起即
可构建应用。这时系统中将会有一个抽象类，它有一些 c o m p o s i t e子类和d e c o r a t o r子类，还有
一些实现系统的基本构建模块。此时， composites 和d e c o r a t o r将拥有共同的接口。从
D e c o r a t o r模式的角度看，c o m p o s i t e是一个C o n c r e t e C o m p o n e n t。而从c o m p o s i t e模式的角度看，
d e c o r a t o r则是一个L e a f。当然，他们不一定要同时使用，正如我们所见，它们的目的有很大
的差别。
另一种与D e c o r a t o r模式结构相似的模式是 P r o x y ( 4 . 7 )。这两种模式都描述了怎样为对象提
供一定程度上的间接引用，proxy 和d e c o r a t o r对象的实现部分都保留了指向另一个对象的指针，
它们向这个对象发送请求。然而同样，它们具有不同的设计目的。
像D e c o r a t o r模式一样， Proxy 模式构成一个对象并为用户提供一致的接口。但与
D e c o r a t o r模式不同的是，Proxy 模式不能动态地添加或分离性质，它也不是为递归组合而设
计的。它的目的是，当直接访问一个实体不方便或不符合需要时，为这个实体提供一个替代
者，例如，实体在远程设备上，访问受到限制或者实体是持久存储的。
在P r o x y模式中，实体定义了关键功能，而 P r o x y提供（或拒绝）对它的访问。在
D e c o r a t o r模式中，组件仅提供了部分功能，而一个或多个 D e c o r a t o r负责完成其他功能。
D e c o r a t o r模式适用于编译时不能（至少不方便）确定对象的全部功能的情况。这种开放性使递归组合成为 D e c o r a t o r模式中一个必不可少的部分。而在 P r o x y模式中则不是这样，因为
P r o x y模式强调一种关系（P r o x y与它的实体之间的关系），这种关系可以静态的表达。
模式间的这些差异非常重要，因为它们针对了面向对象设计过程中一些特定的经常发生
问题的解决方法。但这并不意味着这些模式不能结合使用。可以设想有一个 p r o x y - d e c o r a t o r，
它可以给p r o x y添加功能，或是一个 d e c o r a t o r- p r o x y用来修饰一个远程对象。尽管这种混合可
能有用（我们手边还没有现成的例子），但它们可以分割成一些有用的模式。
行 为 型
行为模式涉及到算法和对象间职责的分配。行为模式不仅描述对象或类的模式，还描述
它们之间的通信模式。这些模式刻划了在运行时难以跟踪的复杂的控制流。它们将你的注意
力从控制流转移到对象间的联系方式上来。
行为类模式使用继承机制在类间分派行为。本章包括两个这样的模式。其中 Te m p l a t e
M e t h o d（5 . 1 0）较为简单和常用。模板方法是一个算法的抽象定义，它逐步地定义该算法，
每一步调用一个抽象操作或一个原语操作，子类定义抽象操作以具体实现该算法。另一种行
为类模式是I n t e r p r e t e r（5 . 3）。它将一个文法表示为一个类层次，并实现一个解释器作为这些
类的实例上的一个操作。
行为对象模式使用对象复合而不是继承。一些行为对象模式描述了一组对等的对象怎样
相互协作以完成其中任一个对象都无法单独完成的任务。这里一个重要的问题是对等的对象
如何互相了解对方。对等对象可以保持显式的对对方的引用，但那会增加它们的耦合度。在
极端情况下，每一个对象都要了解所有其他的对象。 M e d i a t o r（5 . 5）在对等对象间引入一个
m e d i a t o r对象以避免这种情况的出现。m e d i a t o r提供了松耦合所需的间接性。
Chain of Responsibility(5.1)提供更松的耦合。它让你通过一条候选对象链隐式的向一个对
象发送请求。根据运行时刻情况任一候选者都可以响应相应的请求。候选者的数目是任意的，
你可以在运行时刻决定哪些候选者参与到链中。
O b s e r v e r ( 5 . 7 )模式定义并保持对象间的依赖关系。典型的 O b s e r v e r的例子是Smalltalk 中的
模型/视图/控制器，其中一旦模型的状态发生变化，模型的所有视图都会得到通知。
其他的行为对象模式常将行为封装在一个对象中并将请求指派给它。 S t r a t e g y ( 5 . 9 )模式将
算法封装在对象中，这样可以方便地指定和改变一个对象所使用的算法。 C o m m a n d ( 5 . 2 )模式
将请求封装在对象中，这样它就可作为参数来传递，也可以被存储在历史列表里，或者以其
他方式使用。S t a t e ( 5 . 8 )模式封装一个对象的状态，使得当这个对象的状态对象变化时，该对
象可改变它的行为。Vi s i t o r ( 5 . 11 )封装分布于多个类之间的行为，而 I t e r a t o r ( 5 . 4 )则抽象了访问
和遍历一个集合中的对象的方式。
1.	类
1.	I n t e r p r e t e r
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
Template Method
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
1.	对象
1.	Chain of Responsibility
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
C o m m a n d
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
I t e r a t o r
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
M e d i a t o r
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
M e m e n t o
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
O b s e r v e r
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
S t a t e
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
S t r a t e g y
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
Vi s i t o r
意 图
别 名
动 机
适用性
结 构
参与者
协 作
效 果
实 现
代码示例
相关模式
1.	如何选择和使用设计模式
1.	如何选择设计模式
1.	考虑设计模式是怎样解决设计问题的
寻找合适的对象
面向对象程序由对象组成，对象包括数据和对数据进行操作的过程，过程通常称为方法或操作。对象在收到客户的请求(或消息)后，执行相应的操作。客户请求是使对象执行操作的唯一方法，操作又是对象改变内部数据的唯一方法。由于这些限制，对象的内部状态是被封装的，它不能被直接访问，它的表示对于对象外部是不可见的。面向对象设计最困难的部分是将系统分解成对象集合。因为要考虑许多因素：封装、粒度、依赖关系、灵活性、性能、演化、复用等等，它们都影响着系统的分解，并且这些因素通常还是互相冲突的。面向对象设计方法学支持许多设计方法。你可以写出一个问题描述，挑出名词和动词，进而创建相应的类和操作；或者，你可以关注于系统的协作和职责关系；或者，你可以对现实世界建模，再将分析时发现的对象转化至设计中。至于哪一种方法最好，并无定论。设计的许多对象来源于现实世界的分析模型。但是，设计结果所得到的类通常在现实世界中并不存在，有些是像数组之类的低层类，而另一些则层次较高。例如，Composite(4.3)模式引入了统一对待现实世界中并不存在的对象的抽象方法。严格反映当前现实世界的模型并不能产生也能反映将来世界的系统。设计中的抽象对于产生灵活的设计是至关重要的。设计模式帮你确定并不明显的抽象和描述这些抽象的对象。例如，描述过程或算法的对象现实中并不存在，但它们却是设计的关键部分。Strategy(5.9)模式描述了怎样实现可互换的算法族。State(5.8)模式将实体的每一个状态描述为一个对象。这些对象在分析阶段，甚至在设计阶段的早期都并不存在，后来为使设计更灵活、复用性更好才将它们发掘出来。决定对象的粒度
决定对象的粒度
对象在大小和数目上变化极大。它们能表示下自硬件或上自整个应用的任何事物。那么我们怎样决定一个对象应该是什么呢？设计模式很好地讲述了这个问题。Facade(4.5)模式描述了怎样用对象表示完整的子系统，Flyweight(4.6)模式描述了如何支持大量的最小粒度的对象。其他一些设计模式描述了将一个对象分解成许多小对象的特定方法。AbstractFactory(3.1)和Builder(3.2)产生那些专门负责生成其他对象的对象。Visitor(5.10)和Command(5.2)生成的对象专门负责实现对其他对象或对象组的请求。
指定对象接口
对象声明的每一个操作指定操作名、作为参数的对象和返回值，这就是所谓的操作的型构(signature)。对象操作所定义的所有操作型构的集合被称为该对象的接口(interface)。对象接口描述了该对象所能接受的全部请求的集合，任何匹配对象接口中型构的请求都可以发送给该对象。
类型(type)是用来标识特定接口的一个名字。如果一个对象接受“Window”接口所定义的所有操作请求，那么我们就说该对象具有“Window”类型。一个对象可以有许多类型，并且不同的对象可以共享同一个类型。对象接口的某部分可以用某个类型来刻画，而其他部分则可用其他类型刻画。两个类型相同的对象只需要共享它们的部分接口。接口可以包含其他接口作为子集。当一个类型的接口包含另一个类型的接口时，我们就说它是另一个类型的子
类型(subtype)，另一个类型称之为它的超类型(supertype)。我们常说子类型继承了它的超类型
的接口。
描述对象的实现
至此，我们很少提及到实际上怎么去定义一个对象。对象的实现
是由它的类决定的，类指定了对象的内部数据和表示，也定义了对象
所能完成的操作，如右图所示。
我们基于O M T的表示法，将类描述成一个矩形，其中的类名以黑
体表示的。操作在类名下面，以常规字体表示。类所定义的任何数据
都在操作的下面。类名与操作之间以及操作与数据之间用横线分割。
返回类型和实例变量类型是可选的，因为我们并未假设一定要用具有静态类型的实现语
言。
对象通过实例化类来创建，此对象被称为该类的实例。当实例化类时，要给对象的内部
数据(由实例变量组成)分配存储空间，并将操作与这些数据联系起来。对象的许多类似实例是
由实例化同一个类来创建的。
下图中的虚箭头线表示一个类实例化另一个类的对象，箭头指向被实例化的对象的类。
新的类可以由已存在的类通过类继承(class inheritance)来定义。当子类( s u b c l a s s )继承父类
(parent class)时，子类包含了父类定义的所有数据和操作。子类的实例对象包含所有子类和父
类定义的数据，且它们能完成子类和父类定义的所有操作。我们以竖线和三角表示子类关系，
如下图所示。
抽象类(abstract class)的主要目的是为它的子类定义公共接口。一个抽象类将把它的部分
或全部操作的实现延迟到子类中，因此，一个抽象类不能被实例化。在抽象类中定义却没有
实现的操作被称为抽象操作(abstract operation)。非抽象类称为具体类(concrete class)。
子类能够改进和重新定义它们父类的操作。更具体地说，类能够重定义( o v e r r i d e )父类定
义的操作，重定义使得子类能接管父类对请求的处理操作。类继承允许你只需简单的扩展其
他类就可以定义新类，从而可以很容易地定义具有相近功能的对象族。
抽象类的类名以斜体表示，以与具体类相区别。抽象操作也用斜体表示。图中可以包括
实现操作的伪代码，如果这样，则代码将出现在带有摺角的框中，并用虚线将该摺角框与代
码所实现的操作相连，图示如下。
混入类(mixin class)是给其他类提供可选择的接口或功能的类。它与抽象类一样不能实例
化。混入类要求多继承，图示如下。
类继承与接口继承的比较
理解对象的类( c l a s s )与对象的类型( t y p e )之间的差别非常重要。
一个对象的类定义了对象是怎样实现的，同时也定义了对象的内部状态和操作的实现。
但是对象的类型只与它的接口有关，接口即对象能响应的请求的集合。一个对象可以有多个
类型，不同类的对象可以有相同的类型。
当然，对象的类和类型是有紧密关系的。因为类定义了对象所能执行的操作，也定义了
对象的类型。当我们说一个对象是一个类的实例时，即指该对象支持类所定义的接口。
C + +和E i ff e l语言的类既指定对象的类型又指定对象的实现。 S m a l l t a l k程序不声明变量的
类型，所以编译器不检查赋给变量的对象类型是否是该变量的类型的子类型。发送消息时需
要检查消息接收者是否实现了该消息，但不检查接收者是否是某个特定类的实例。
理解类继承和接口继承(或子类型化)之间的差别也十分重要。类继承根据一个对象的实现
定义了另一个对象的实现。简而言之，它是代码和表示的共享机制。然而，接口继承 (或子类
型化)描述了一个对象什么时候能被用来替代另一个对象。
因为许多语言并不显式地区分这两个概念，所以容易被混淆。在 C + +和E i ff e l语言中，继
承既指接口的继承又指实现的继承。 C + +中接口继承的标准方法是公有继承一个含 (纯)虚成员
函数的类。C + +中纯接口继承接近于公有继承纯抽象类，纯实现继承或纯类继承接近于私有
继承。S m a l l t a l k中的继承只指实现继承。只要任何类的实例支持对变量值的操作，你就可以
将这些实例赋给变量。
尽管大部分程序设计语言并不区分接口继承和实现继承的差别，但使用中人们还是分别
对待它们的。S m a l l t a l k程序员通常将子类当作子类型 (尽管有一些熟知的例外情况 [ C o o 9 2 ] )，
C + +程序员通过抽象类所定义的类型来操纵对象。
很多设计模式依赖于这种差别。例如， Chain of Responsibility(5.1)模式中的对象必须有一
个公共的类型，但一般情况下它们不具有公共的实现。在 C o m p o s i t e ( 4 . 3 )模式中，构件定义了
一个公共的接口，但 C o m p o s i t e通常定义一个公共的实现。 C o m m a n d ( 5 . 2 )、O b s e r v e r ( 5 . 7 )、
S t a t e ( 5 . 8 )和S t r a t e g y ( 5 . 9 )通常纯粹作为接口的抽象类来实现。
对接口编程，而不是对实现编程
类继承是一个通过复用父类功能而扩展应用功能的基本机制。它允许你根据旧对象快速
定义新对象。它允许你从已存在的类中继承所需要的绝大部分功能，从而几乎无需任何代价
就可以获得新的实现。
然而，实现的复用只是成功的一半，继承所拥有的定义具有相同接口的对象族的能力也
是很重要的(通常可以从抽象类来继承)。为什么？因为多态依赖于这种能力。
当继承被恰当使用时，所有从抽象类导出的类将共享该抽象类的接口。这意味着子类仅
仅添加或重定义操作，而没有隐藏父类的操作。这时，所有的子类都能响应抽象类接口中的
请求，从而子类的类型都是抽象类的子类型。
只根据抽象类中定义的接口来操纵对象有以下两个好处：
客户无须知道他们使用对象的特定类型，只须对象有客户所期望的接口。
客户无须知道他们使用的对象是用什么类来实现的，他们只须知道定义接口的抽象类。
这将极大地减少子系统实现之间的相互依赖关系，也产生了可复用的面向对象设计的如
下原则：
针对接口编程，而不是针对实现编程。
不将变量声明为某个特定的具体类的实例对象，而是让它遵从抽象类所定义的接口。这
是本书设计模式的一个常见主题。
当你不得不在系统的某个地方实例化具体的类 (即指定一个特定的实现 )时，创建型模式
(Abstract Factory(3.1)，B u i l d e r ( 3 . 2 )，Factory Method(3.3)，P r o t o t y p e ( 3 . 4 )和S i n g l e t o n ( 3 . 5 ) )可
以帮你。通过抽象对象的创建过程，这些模式提供不同方式以在实例化时建立接口和实现的
透明连接。创建型模式确保你的系统是采用针对接口的方式书写的，而不是针对实现而书写
的。
运用复用机制
理解对象、接口、类和继承之类的概念对大多数人来说并不难，问题的关键在于如何运
用它们写出灵活的、可复用的软件。设计模式将告诉你怎样去做。
继承和组合的比较
面向对象系统中功能复用的两种最常用技术是类继承和对象组合(object composition)。正
如我们已解释过的，类继承允许你根据其他类的实现来定义一个类的实现。这种通过生成子
类的复用通常被称为白箱复用(white-box reuse)。术语“白箱”是相对可视性而言：在继承方
式中，父类的内部细节对子类可见。
对象组合是类继承之外的另一种复用选择。新的更复杂的功能可以通过组装或组合对象
来获得。对象组合要求被组合的对象具有良好定义的接口。这种复用风格被称为黑箱复用
(black-box reuse)，因为对象的内部细节是不可见的。对象只以“黑箱”的形式出现。
继承和组合各有优缺点。类继承是在编译时刻静态定义的，且可直接使用，因为程序设
计语言直接支持类继承。类继承可以较方便地改变被复用的实现。当一个子类重定义一些而
不是全部操作时，它也能影响它所继承的操作，只要在这些操作中调用了被重定义的操作。
但是类继承也有一些不足之处。首先，因为继承在编译时刻就定义了，所以无法在运行
时刻改变从父类继承的实现。更糟的是，父类通常至少定义了部分子类的具体表示。因为继
承对子类揭示了其父类的实现细节，所以继承常被认为“破坏了封装性” [ S n y 8 6 ]。子类中的
实现与它的父类有如此紧密的依赖关系，以至于父类实现中的任何变化必然会导致子类发生
变化。
当你需要复用子类时，实现上的依赖性就会产生一些问题。如果继承下来的实现不适合
解决新的问题，则父类必须重写或被其他更适合的类替换。这种依赖关系限制了灵活性并最
终限制了复用性。一个可用的解决方法就是只继承抽象类，因为抽象类通常提供较少的实现。
对象组合是通过获得对其他对象的引用而在运行时刻动态定义的。组合要求对象遵守彼
此的接口约定，进而要求更仔细地定义接口，而这些接口并不妨碍你将一个对象和其他对象
一起使用。这还会产生良好的结果：因为对象只能通过接口访问，所以我们并不破坏封装
性；只要类型一致，运行时刻还可以用一个对象来替代另一个对象；更进一步，因为对象的
实现是基于接口写的，所以实现上存在较少的依赖关系。
对象组合对系统设计还有另一个作用，即优先使用对象组合有助于你保持每个类被封装，
并被集中在单个任务上。这样类和类继承层次会保持较小规模，并且不太可能增长为不可控
制的庞然大物。另一方面，基于对象组合的设计会有更多的对象 (而有较少的类)，且系统的行
为将依赖于对象间的关系而不是被定义在某个类中。
这导出了我们的面向对象设计的第二个原则：
优先使用对象组合，而不是类继承。
理想情况下，你不应为获得复用而去创建新的构件。你应该能够只使用对象组合技术，
通过组装已有的构件就能获得你需要的功能。但是事实很少如此，因为可用构件的集合实际
上并不足够丰富。使用继承的复用使得创建新的构件要比组装旧的构件来得容易。这样，继
承和对象组合常一起使用。
然而，我们的经验表明：设计者往往过度使用了继承这种复用技术。但依赖于对象组合
技术的设计却有更好的复用性(或更简单)。你将会看到设计模式中一再使用对象组合技术。
委托
委托(d e l e g a t i o n)是一种组合方法，它使组合具有与继承同样的复用能力 [ L i e 8 6 , J Z 9 1 ]。在
委托方式下，有两个对象参与处理一个请求，接受请求的对象将操作委托给它的代理者
(d e l e g a t e)。这类似于子类将请求交给它的父类处理。使用继承时，被继承的操作总能引用接
受请求的对象，C + +中通过t h i s成员变量，S m a l l t a l k中则通过s e l f。委托方式为了得到同样的
效果，接受请求的对象将自己传给被委托者（代理人），使被委托的操作可以引用接受请求的
对象。
举例来说，我们可以在窗口类中保存一个矩形类的实例变量来代理矩形类的特定操作，
这样窗口类可以复用矩形类的操作，而不必像继承时那样定义成矩形类的子类。也就是说，
一个窗口拥有一个矩形，而不是一个窗口就是一个矩形。窗口现在必须显式的将请求转发给
它的矩形实例，而不是像以前它必须继承矩形的操作。
下面的图显示了窗口类将它的A r e a操作委托给一个矩形实例。
箭头线表示一个类对另一个类实例的引用关系。引用名是可选的，本例为“ r e c t a n g l e”。
委托的主要优点在于它便于运行时刻组合对象操作以及改变这些操作的组合方式。假定
矩形对象和圆对象有相同的类型，我们只需简单的用圆对象替换矩形对象，则得到的窗口就
是圆形的。
委托与那些通过对象组合以取得软件灵活性的技术一样，具有如下不足之处：动态的、
高度参数化的软件比静态软件更难于理解。还有运行低效问题，不过从长远来看人的低效才
是更主要的。只有当委托使设计比较简单而不是更复杂时，它才是好的选择。要给出一个能
确切告诉你什么时候可以使用委托的规则是很困难的。因为委托可以得到的效率是与上下文
有关的，并且还依赖于你的经验。委托最适用于符合特定程式的情形，即标准模式的情形。
有一些模式使用了委托，如 S t a t e ( 5 . 8 )、S t r a t e g y ( 5 . 9 )和Vi s i t o r ( 5 . 11 )。在S t a t e模式中，一
个对象将请求委托给一个描述当前状态的 S t a t e对象来处理。在S t r a t e g y模式中，一个对象将一
个特定的请求委托给一个描述请求执行策略的对象，一个对象只会有一个状态，但它对不同
的请求可以有许多策略。这两个模式的目的都是通过改变受托对象来改变委托对象的行为。
在Vi s i t o r中，对象结构的每个元素上的操作总是被委托到 Vi s i t o r对象。
其他模式则没有这么多 地用到委托。M e d i a t o r ( 5 . 5 )引进了一个中介其他对象间通信的对
象。有时，M e d i a t o r对象只是简单地将请求转发给其他对象；有时，它沿着指向自己的引用
来传递请求，使用真正意义的委托。 Chain of Responsibility(5.1)通过将请求沿着对象链传递
来处理请求，有时，这个请求本身带有一个接受请求对象的引用，这时该模式就使用了委托。
B r i d g e ( 4 . 2 )将实现和抽象分离开，如果抽象和一个特定实现非常匹配，那么这个实现可以代
理抽象的操作。
委托是对象组合的特例。它告诉你对象组合作为一个代码复用机制可以替代继承。
继承和参数化类型的比较
另一种功能复用技术(并非严格的面向对象技术 )是参数化类型(parameterized type)，也就
是类属( g e n e r i c ) ( A d a、E i ff e l )或模板( t e m p l a t e s ) ( C + + )。它允许你在定义一个类型时并不指定该
类型所用到的其他所有类型。未经指定的类型在使用时以参数形式提供。例如，一个列表类
能够以它所包含元素的类型来进行参数化。如果你想声明一个 I n t e g e r列表，只需将I n t e g e r类
型作为列表参数化类型的参数值；声明一个 S t r i n g列表，只需提供S t r i n g类型作为参数值。语
言的实现将会为各种元素类型创建相应的列表类模板的定制版本。
参数化类型给我们提供除了类继承和对象组合外的第三种方法来组合面向对象系统中的
行为。许多设计可以使用这三种技术中的任何一种来实现。实现一个以元素比较操作为可变
元的排序例程，可有如下方法：
通过子类实现该操作( Template Method(5.10)的一个应用)。
2 ) 实现为传给排序例程的对象的职责 ( S t r a t e g y ( 5 . 9 ) )。
作为C + +模板或A d a类属的参数，以指定元素比较操作的名称。
这些技术存在着极大的不同之处。对象组合技术允许你在运行时刻改变被组合的行为，
但是它存在间接性，比较低效。继承允许你提供操作的缺省实现，并通过子类重定义这些操
作。参数化类型允许你改变类所用到的类型。但是继承和参数化类型都不能在运行时刻改变。
哪一种方法最佳，取决于你设计和实现的约束条件。
本书没有一种模式是与参数化类型有关的，尽管我们在定制一个模式的 C + +实现时用到了
参数化类型。参数化类型在像 S m a l l t a l k那样的编译时刻不进行类型检查的语言中是完全不必
要的。
关联运行时刻和编译时刻的结构
一个面向对象程序运行时刻的结构通常与它的代码结构相差较大。代码结构在编译时刻
就被确定下来了，它由继承关系固定的类组成。而程序的运行时刻结构是由快速变化的通信
对象网络组成。事实上两个结构是彼此独立的，试图由一个去理解另一个就好像试图从静态
的动、植物分类去理解活生生的生态系统的动态性。反之亦然。
考虑对象聚合( a g g r e g a t i o n )和相识( a c q u a i n t a n c e )的差别以及它们在编译和运行时刻的表示
是多么的不同。聚合意味着一个对象拥有另一个对象或对另一个对象负责。一般我们称一个
对象包含另一个对象或者是另一个对象的一部分。聚合意味着聚合对象和其所有者具有相同
的生命周期。
相识意味着一个对象仅仅知道另一个对象。有时相识也被称为“关联”或“引用”关系。
相识的对象可能请求彼此的操作，但是它们不为对方负责。相识是一种比聚合要弱的关系，
它只标识了对象间较松散的耦合关系。
在下图中，普通的箭头线表示相识，尾部带有菱形的箭头线表示聚合：
聚合和相识很容易混淆，因为它们通常以相同的方法实现。 S m a l l t a l k中，所有变量都是
其他对象的引用，程序设计语言中两者并无区别。 C + +中，聚合可以通过定义表示真正实例
的成员变量来实现，但更通常的是将这些成员变量定义为实例指针或引用；相识也是以指针
或引用来实现。
从根本上讲，是聚合还是相识是由你的意图而不是由显式的语言机制决定的。尽管它们
之间的区别在编译时刻的结构中很难看出来，但这些区别还是很大的。聚合关系使用较少且
比相识关系更持久；而相识关系则出现频率较高，但有时只存在于一个操作期间，相识也更
具动态性，使得它在源代码中更难被辨别出来。
程序的运行时刻结构和编译时刻结构存在这么大的差别，很明显代码不可能揭示关于系
统如何工作的全部。系统的运行时刻结构更多地受到设计者的影响，而不是编程语言。对象
和它们的类型之间的关系必须更加仔细地设计，因为它们决定了运行时刻程序结构的好坏。
许多设计模式 (特别是那些属于对象范围的 )显式地记述了编译时刻和运行时刻结构的差
别。C o m p o s i t e ( 4 . 3 )和D e c o r a t o r ( 4 . 4 )对于构造复杂的运行时刻结构特别有用。 O b s e r v e r ( 5 . 7 )也
与运行时刻结构有关，但这些结构对于不了解该模式的人来说是很难理解的。 Chain of
R e s p o n s i b i l i t y ( 5 . 1 )也产生了继承所无法展现的通信模式。总之，只有理解了模式，你才能清
楚代码中的运行时刻结构。
设计应支持变化
获得最大限度复用的关键在于对新需求和已有需求发生变化时的预见性，要求你的系统
设计要能够相应地改进。
为了设计适应这种变化、且具有健壮性的系统，你必须考虑系统在它的生命周期内会发
生怎样的变化。一个不考虑系统变化的设计在将来就有可能需要重新设计。这些变化可能是
类的重新定义和实现，修改客户和重新测试。重新设计会影响软件系统的许多方面，并且未
曾料到的变化总是代价巨大的。
设计模式可以确保系统能以特定方式变化，从而帮助你避免重新设计系统。每一个设计
模式允许系统结构的某个方面的变化独立于其他方面，这样产生的系统对于某一种特殊变化
将更健壮。
下面阐述了一些导致重新设计的一般原因，以及解决这些问题的设计模式：
通过显式地指定一个类来创建对象 在创建对象时指定类名将使你受特定实现的约束
而不是特定接口的约束。这会使未来的变化更复杂。要避免这种情况，应该间接地创建对象。
设计模式：Abstract Factory(3.1)，Factory Method(3.3)，P r o t o t y p e ( 3 . 4 )。
对特殊操作的依赖 当你为请求指定一个特殊的操作时，完成该请求的方式就固定下
来了。为避免把请求代码写死，你将可以在编译时刻或运行时刻很方便地改变响应请求的方
法。
设计模式：Chain of Resposibility(5.1)，C o m m a n d ( 5 . 2 )。
对硬件和软件平台的依赖 外部的操作系统接口和应用编程接口 ( A P I )在不同的软硬件
平台上是不同的。依赖于特定平台的软件将很难移植到其他平台上，甚至都很难跟上本地平
台的更新。所以设计系统时限制其平台相关性就很重要了。
设计模式：Abstract Factory(3.1)，B r i d g e ( 4 . 2 )。
对对象表示或实现的依赖 知道对象怎样表示、保存、定位或实现的客户在对象发生
变化时可能也需要变化。对客户隐藏这些信息能阻止连锁变化。
设计模式：Abstract Factory(3.1)，B r i d g e ( 4 . 2 )，M e m e n t o ( 5 . 6 )，P r o x y ( 4 . 7 )
算法依赖 算法在开发和复用时常常被扩展、优化和替代。依赖于某个特定算法的对
象在算法发生变化时不得不变化。因此有可能发生变化的算法应该被孤立起来。
设计模式： B u i l d e r ( 3 . 2 )，I t e r a t o r ( 5 . 4 )，S t r a t e g y ( 5 . 9 )，Template Method(5.10)，
Vi s i t o r ( 5 . 11 )
紧耦合 紧耦合的类很难独立地被复用，因为它们是互相依赖的。紧耦合产生单块的
系统，要改变或删掉一个类，你必须理解和改变其他许多类。这样的系统是一个很难学习、
移植和维护的密集体。
松散耦合提高了一个类本身被复用的可能性，并且系统更易于学习、移植、修改和扩展。
设计模式使用抽象耦合和分层技术来提高系统的松散耦合性。
设计模式： Abstract Factory(3.1)，C o m m a n d ( 5 . 2 )，F a c a d e ( 4 . 5 )，M e d i a t o r ( 5 . 5 )，
Observer(5.7) ，Chain of Responsibility(5.1)。
通过生成子类来扩充功能 通常很难通过定义子类来定制对象。每一个新类都有固定
的实现开销(初始化、终止处理等)。定义子类还需要对父类有深入的了解。如，重定义一个操
作可能需要重定义其他操作。一个被重定义的操作可能需要调用继承下来的操作。并且子类
方法会导致类爆炸，因为即使对于一个简单的扩充，你也不得不引入许多新的子类。
一般的对象组合技术和具体的委托技术，是继承之外组合对象行为的另一种灵活方法。
新的功能可以通过以新的方式组合已有对象，而不是通过定义已存在类的子类的方式加到应
用中去。另一方面，过多使用对象组合会使设计难于理解。许多设计模式产生的设计中，你
可以定义一个子类，且将它的实例和已存在实例进行组合来引入定制的功能。
设计模式：B r i d g e ( 4 . 2 )，Chain of Responsibility(5.1)，C o m p o s i t e ( 4 . 3 )，D e c o r a t o r ( 4 . 4 )，
O b s e r v e r ( 5 . 7 )，S t r a t e g y ( 5 . 9 )。
不能方便地对类进行修改 有时你不得不改变一个难以修改的类。也许你需要源代码
而又没有(对于商业类库就有这种情况)，或者可能对类的任何改变会要求修改许多已存在的其
他子类。设计模式提供在这些情况下对类进行修改的方法。
设计模式：A d a p t e r ( 4 . 1 )，D e c o r a t o r ( 4 . 4 )，Vi s i t o r ( 5 . 11 )。
这些例子反映了使用设计模式有助于增强软件的灵活性。这种灵活性所具有的重要程度
取决于你将要建造的软件系统。让我们看一看设计模式在开发如下三类主要软件中所起的作
用：应用程序、工具箱和框架。
应用程序
如果你将要建造像文档编辑器或电子制表软件这样的应用程序 (Application Program)，那
么它的内部复用性、可维护性和可扩充性是要优先考虑的。内部复用性确保你不会做多余的
设计和实现。设计模式通过减少依赖性来提高内部复用性。松散耦合也增强了一类对象与其
他多个对象协作的可能性。例如，通过孤立和封装每一个操作，以消除对特定操作的依赖，可使在不同上下文中复用一个操作变得更简单。消除对算法和表示的依赖可达到同样的效果。
当设计模式被用来对系统分层和限制对平台的依赖性时，它们还会使一个应用更具可维
护性。通过显示怎样扩展类层次结构和怎样使用对象复用，它们可增强系统的易扩充性。同
时，耦合程度的降低也会增强可扩充性。如果一个类不过多地依赖其他类，扩充这个孤立的
类还是很容易的。
工具箱
一个应用经常会使用来自一个或多个被称为工具箱( To o l k i t )的预定义类库中的类。工具箱
是一组相关的、可复用的类的集合，这些类提供了通用的功能。工具箱的一个典型例子就是
列表、关联表单、堆栈等类的集合， C + +的I / O流库是另一个例子。工具箱并不强制应用采用
某个特定的设计，它们只是为你的应用提供功能上的帮助。工具箱强调的是代码复用，它们
是面向对象环境下的“子程序库”。
工具箱的设计比应用设计要难得多，因为它要求对许多应用是可用的和有效的。再者，
工具箱的设计者并不知道什么应用使用该工具箱及它们有什么特殊需求。这样，避免假设和
依赖就变得很重要，否则会限制工具箱的灵活性，进而影响它的适用性和效率。
框架
框架( F r a m e w o r k )是构成一类特定软件可复用设计的一组相互协作的类 [ D e u 8 9 , J F 8 8 ]。例
如，一个框架能帮助建立适合不同领域的图形编辑器，像艺术绘画、音乐作曲和机械
C A D [ V L 9 0 , J o h 9 2 ]。另一个框架也许能帮助你建立针对不同程序设计语言和目标机器的编译
器[ J M L 9 2 ]。而再一个也许能帮助你建立财务建模应用 [ B E 9 3 ]。你可以定义框架抽象类的应用
相关的子类，从而将一个框架定制为特定应用。
框架规定了你的应用的体系结构。它定义了整体结构，类和对象的分割，各部分的主要
责任，类和对象怎么协作，以及控制流程。框架预定义了这些设计参数，以便于应用设计者
或实现者能集中精力于应用本身的特定细节。框架记录了其应用领域的共同的设计决策。因
而框架更强调设计复用，尽管框架常包括具体的立即可用的子类。
这个层次的复用导致了应用和它所基于的软件之间的反向控制 (inversion of control)。当
你使用工具箱(或传统的子程序库)时，你需要写应用软件的主体并且调用你想复用的代码。而
当你使用框架时，你应该复用应用的主体，写主体调用的代码。你不得不以特定的名字和调
用约定来写操作地实现，但这会减少你需要做出的设计决策。
你不仅可以更快地建立应用，而且应用还具有相似的结构。它们很容易维护，且用户看
来也更一致。另一方面，你也失去了一些表现创造性的自由，因为许多设计决策无须你来作
出。
如果说应用程序难以设计，那么工具箱就更难了，而框架则是最难的。框架设计者必须
冒险决定一个要适应于该领域的所有应用的体系结构。任何对框架设计的实质性修改都会大
大降低框架所带来的好处，因为框架对应用的最主要贡献在于它所定义的体系结构。因此设
计的框架必须尽可能地灵活、可扩充。
更进一步讲，因为应用的设计如此依赖于框架，所以应用对框架接口的变化是极其敏感
的。当框架演化时，应用不得不随之演化。这使得松散耦合更加重要，否则框架的一个细微
变化都将引起强烈反应。
刚才讨论的主要设计问题对框架设计而言最具重要性。一个使用设计模式的框架比不用设计模式的框架更可能获得高层次的设计复用和代码复用。成熟的框架通常使用了多种设计
模式。设计模式有助于获得无须重新设计就可适用于多种应用的框架体系结构。
当框架和它所使用的设计模式一起写入文档时，我们可以得到另外一个好处 [ B J 9 4 ]。了解
设计模式的人能较快地洞悉框架。甚至不了解设计模式的人也可以从产生框架文档的结构中
受益。加强文档工作对于所有软件而言都是重要的，但对于框架其重要性显得尤为突出。学
会使用框架常常是一个必须克服很多困难的过程。设计模式虽然无法彻底克服这些困难，但
它通过对框架设计的主要元素做更显式的说明可以降低框架学习的难度。
因为模式和框架有些类似，人们常常对它们有怎样的区别和它们是否有区别感到疑惑。
它们最主要的不同在于如下三个方面：
设计模式比框架更抽象 框架能够用代码表示，而设计模式只有其实例才能表示为代
码。框架的威力在于它们能够使用程序设计语言写出来，它们不仅能被学习，也能被直接执
行和复用。而本书中的设计模式在每一次被复用时，都需要被实现。设计模式还解释了它的
意图、权衡和设计效果。
设计模式是比框架更小的体系结构元素 一个典型的框架包括了多个设计模式，而反
之决非如此。
框架比设计模式更加特例化 框架总是针对一个特定的应用领域。一个图形编辑器框
架可能被用于一个工厂模拟，但它不会被错认为是一个模拟框架。而本书收录的设计模式几
乎能被用于任何应用。当然比我们的模式更特殊的设计模式也是可能的 (如，分布式系统和并
发程序的设计模式)，尽管这些模式不会像框架那样描述应用的体系结构。
框架变得越来越普遍和重要。它们是面向对象系统获得最大复用的方式。较大的面向对
象应用将会由多层彼此合作的框架组成。应用的大部分设计和代码将来自于它所使用的框架
或受其影响。
浏览模式的意图部分
Abstract Factory( 3 . 1 )：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它
们具体的类。
A d a p t er ( 4 . 1 )：将一个类的接口转换成客户希望的另外一个接口。 A d a p t e r模式使得原本
由于接口不兼容而不能一起工作的那些类可以一起工作。
B r i d g e( 4 . 2 )：将抽象部分与它的实现部分分离，使它们都可以独立地变化。
B u i l d e r( 3 . 2 )：将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不
同的表示。
Chain of Responsibility( 5 . 1 )：为解除请求的发送者和接收者之间耦合，而使多个对象都
有机会处理这个请求。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象
处理它。
C o m m a n d( 5 . 2 )：将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数
化；对请求排队或记录请求日志，以及支持可取消的操作。
C o m p o s i t e( 4 . 3 )：将对象组合成树形结构以表示“部分 -整体”的层次结构。C o m p o s i t e使
得客户对单个对象和复合对象的使用具有一致性。
D e c o r a t o r( 4 . 4 )：动态地给一个对象添加一些额外的职责。就扩展功能而言， D e c o r a t o r模
式比生成子类方式更为灵活。
F a c a d e( 4 . 5 )：为子系统中的一组接口提供一个一致的界面， F a c a d e模式定义了一个高层
接口，这个接口使得这一子系统更加容易使用。
Factory Method( 3 . 3 )：定义一个用于创建对象的接口，让子类决定将哪一个类实例化。
Factory Method使一个类的实例化延迟到其子类。
F l y w e i g h t( 4 . 6 )：运用共享技术有效地支持大量细粒度的对象。
I n t e r p r e t e r( 5 . 3 )：给定一个语言, 定义它的文法的一种表示，并定义一个解释器 , 该解释
器使用该表示来解释语言中的句子。
I t e r a t o r( 5 . 4 )：提供一种方法顺序访问一个聚合对象中各个元素 , 而又不需暴露该对象的
内部表示。
M e d i a t o r( 5 . 5 )：用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式
地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
M e m e n t o( 5 . 6 )：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外
保存这个状态。这样以后就可将该对象恢复到保存的状态。
O b s e r v e r( 5 . 7 )：定义对象间的一种一对多的依赖关系 ,以便当一个对象的状态发生改变时 ,
所有依赖于它的对象都得到通知并自动刷新。
P r o t o t y p e( 3 . 4 )：用原型实例指定创建对象的种类，并且通过拷贝这个原型来创建新的对
象。
P r o x y( 4 . 7 )：为其他对象提供一个代理以控制对这个对象的访问。
S i n g l e t o n( 3 . 5 )：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
S t a t e( 5 . 8 )：允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它
所属的类。
S t r a t e g y (5 . 9 )：定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模
式使得算法的变化可独立于使用它的客户。
Template Method( 5 . 1 0 )：定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。
Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
Vi s i t o r( 5 . 11 )：表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元
素的类的前提下定义作用于这些元素的新操作。
1.	研究模式怎样互相关联
2.	研究目的相似的模式
3.	检查重新设计的原因
4.	考虑你的设计中哪些是可变的
这个方法与关注引起重新设计的原因刚好相反。它不是
考虑什么会迫使你的设计改变，而是考虑你想要什么变化却又不会引起重新设计。最主
要的一点是封装变化的概念，这是许多设计模式的主题。
目 的 设 计 模 式 可变的方面
创 建 Abstract Factory(3.1) 对产品对象家族
B u i l d e r ( 3 . 2 ) 对如何创建一个组合对象
Factory Method(3.3) 对被实例化的子类
P r o t o t y p e ( 3 . 4 ) 对被实例化的类
S i n g l e t o n ( 3 . 5 ) 对一个类的唯一实例
结构 A d a p t e r ( 4 . 1 ) 对对象的接口
B r i d g e ( 4 . 2 ) 对对象的实现
C o m p o s i t e ( 4 . 3 ) 对一个对象的结构和组成
D e c o r a t o r ( 4 . 4 ) 对对象的职责，不生成子类
F a c a d e ( 4 . 5 ) 对一个子系统的接口
F l y w e i g h t ( 4 . 6 ) 对对象的存储开销
P r o x y ( 4 . 7 ) 对如何访问一个对象；该对象的位置
行 为 Chain of Responsibility(5.1) 对满足一个请求的对象
C o m m a n d ( 5 . 2 ) 对何时、怎样满足一个请求
I n t e r p r e t e r ( 5 . 3 ) 对一个语言的文法及解释
I t e r a t o r ( 5 . 4 ) 对如何遍历、访问一个聚合的各元素
M e d i a t o r ( 5 . 5 ) 对对象间怎样交互、和谁交互
M e m e n t o ( 5 . 6 ) 对一个对象中哪些私有信息存放在该对象之外，以及在
对什么时候进行存储
O b s e r v e r ( 5 . 7 ) 对多个对象依赖于另外一个对象，而这些对象又如何保
持一致
S t a t e ( 5 . 8 ) 对对象的状态
S t r a t e g y ( 5 . 9 ) 对算法
Template Method(5.10) 对算法中的某些步骤
Vi s i t o r ( 5 . 11 ) 对某些可作用于一个（组）对象上的操作，但不修改这
些对象的类
1.	怎样使用设计模式
1.	大致浏览一遍模式
2.	回头研究结构部分、参与者部分和协作部分
3.	看代码示例部分，看看这个模式代码形式的具体例子
4.	选择模式参与者的名字，使它们在应用上下文中有意义
5.	定义类
6.	定义模式中专用于应用的操作名称
7.	实现执行模式中责任和协作的操作
