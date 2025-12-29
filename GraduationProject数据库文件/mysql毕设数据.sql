CREATE DATABASE  IF NOT EXISTS `graduation_project` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `graduation_project`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: graduation_project
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `question_knowledge` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `question` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `answer_a` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `answer_b` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `answer_c` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `answer_d` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `right_answer` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `analysis` varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'运算符','已知 int a = 5, b = 3;，表达式 (a++ > 6) && (++b < 5) 的结果是？','true','false','编译错误','运行时异常','B','a++ 先取值后自增，a++ > 6 即 5 > 6 为 false。\n逻辑与 && 具有短路特性，左侧为 false 时右侧不再执行，最终结果为 false。'),(2,'运算符','已知代码：\nint i = 5;\nint j = i++ + ++i;\nSystem.out.println(j);\n输出结果是？','10','11','12','13','C','i++ 是后缀自增，先取值（5），再自增（i 变为 6）。\n++i 是前缀自增，先自增（i 变为 7），再取值（7）。\n表达式等价于 5 + 7 = 12，因此输出 12。'),(3,'运算符','已知代码：\nString s1 = \"hello\";\nString s2 = new String(\"hello\");\nSystem.out.println(s1 == s2);\nSystem.out.println(s1.equals(s2));\n输出结果是？','true 和 true','false 和 false','true 和 false','false 和 true','D','== 比较引用地址：s1 指向字符串常量池，s2 是堆中的新对象，地址不同，故第一行输出 false。\nequals() 比较内容：两者字符串内容相同，故第二行输出 true。'),(4,'判断和循环','关于if语句的条件判断，以下正确的是：','if (a == b)','if (a = b)','if (a = b == c)','if (a => b)','A','A 正确，使用==进行相等比较。\nB 错误，=是赋值运算符，条件表达式需返回布尔值，此处会导致编译错误（除非a和b是布尔类型）。\nC 错误，赋值表达式优先级低于比较运算符，需加括号(a = (b == c))，但语义可能不符合预期。\nD 错误，Java 中无=>运算符，大于等于应为>=。'),(5,'判断和循环','执行以下for循环，循环体执行次数是：\nfor (int i = 0; i <= 5; i++) {\n    // 循环体\n}','5 次','6 次','7 次','无限次','B','初始值i=0，终止条件i<=5，满足条件时执行循环体。\ni依次取0,1,2,3,4,5，共6 次。'),(6,'判断和循环','执行以下循环，控制台输出的i值是：\nfor (int i = 0; i < 5; i++) {\n    if (i == 3) {\n        break;\n    }\n    System.out.print(i + \" \");\n}','0 1 2 3','0 1 2 3 4','0 1 2','无输出','C','当i=3时，break语句跳出整个循环，循环体仅执行i=0,1,2三次。\n输出结果为0 1 2。'),(7,'数组','下列哪个是 Java 中数组的正确声明方式？','int arr[10];','int[] arr = new int;','int[] arr = new int[5];','int arr[] = new int();','C','A 错误，Java 中数组声明不能直接在变量名后加长度（如arr[10]）。\nB 错误，new int未指定数组长度，需改为new int[N]。\nC 正确，声明并初始化长度为 5 的 int 数组。\nD 错误，数组初始化应使用new int[N]，圆括号()用于构造方法，此处语法错误。'),(8,'数组','关于数组的静态初始化，正确的是：','int[] arr = {1, 2, 3};','int[] arr = new {1, 2, 3};','int[] arr = new int[3]{1, 2, 3};','int[] arr = new int[]{1, 2, 3};','D','A 是简化的静态初始化（省略new），语法正确，但需注意仅能在声明时使用。\nB 错误，new后不能直接接大括号，需指定类型或省略长度。\nC 错误，new int[3]{...}语法错误，指定长度时不能同时使用静态初始化。\nD 正确，完整的静态初始化格式：new 类型[]{元素列表}，无需指定长度。'),(9,'数组','如何获取数组int[] arr = new int[5];的长度？','arr.length()','arr.length','length(arr)','arr.size()','B','数组的长度通过length属性获取（非方法），因此 A 错误（length()是方法调用）。\nB 正确，arr.length直接返回数组长度（此处为 5）。\nC 错误，Java 中无length(arr)这种函数调用方式。\nD 错误，size()是集合（如 ArrayList）的方法，数组无此属性。'),(10,'基础概念','下列哪项是正确的 Java 多行注释格式？','// 注释内容','/* 注释内容 */','<!-- 注释内容 -->','/** 注释内容 */','B','A 是单行注释（//）；\nB 是多行注释（/* */）；\nC 是 HTML 注释，非 Java 语法；\nD 是文档注释（/** */），用于生成 API 文档。'),(11,'基础概念','Java 关键字是否区分大小写？','不区分，例如Public和public等价','区分，例如Public不是关键字，public是关键字','部分区分，取决于上下文','以上都不对','B','Java 是大小写敏感的语言，关键字必须严格小写（如public、class），大写形式（如Public）不是关键字，可作为标识符。'),(12,'基础概念','下列变量声明中，正确的是：','int a; a = 10;','float b = 10.0;','double c; c = 10;','long d = 10000000000;','A','B 错误：10.0是double类型，赋值给float需加f后缀（如10.0f）。\nC 正确：int可自动转型为double，赋值合法。\nD 错误：10000000000超出int范围，但作为long需加L后缀（如10000000000L）。\nA 正确：先声明int a，再赋值a=10，符合语法。'),(41,'方法','下列关于静态方法（static method）的描述，错误的是？','静态方法可以通过类名直接调用，无需创建对象','静态方法中不能使用this关键字','静态方法可以访问类的非静态成员变量','静态方法不能被非静态方法覆盖（Override）','C','静态方法属于类，而非实例，因此：\nA 正确：如Math.sqrt(2)直接通过类名调用。\nB 正确：this指向当前实例，静态方法不依赖实例，无法使用this。\nC 错误：非静态成员变量属于实例，静态方法无法访问未实例化的对象成员。\nD 正确：重写发生在子类与父类之间，且需通过实例调用，静态方法属于类，不存在重写概念（子类可定义同名静态方法，但属于隐藏父类方法，而非重写）。'),(42,'方法','以下代码的输出结果是？\npublic class MethodTest {\n    public static void main(String[] args) {\n        int num = 10;\n        String str = \"hello\";\n        change(num, str);\n        System.out.println(num + \", \" + str);\n    }\n    \n    static void change(int n, String s) {\n        n = 20;\n        s = \"world\";\n    }\n}','10, hello','20, world','10, world','20, hello','A','Java 的参数传递是值传递：\n基本类型（如 int）传递的是值的副本，方法内修改不影响原变量，故num仍为 10。\n引用类型（如 String）传递的是引用的副本，但 String 是不可变类，s = \"world\"会创建新对象，原str的引用不变，故仍为 \"hello\"。'),(43,'方法','关于构造方法的描述，正确的是？','构造方法必须有返回值类型，且返回类型为 void','一个类中若没有显式定义构造方法，编译器会自动生成无参构造方法','构造方法不能被重载','构造方法可以被private修饰，但无法创建实例','B','A 错误，构造方法没有返回值类型（包括 void）；\nB 正确，若类中无构造方法，编译器自动生成公共无参构造方法（若类被private修饰则生成对应修饰符的构造方法）；\nC 错误，构造方法可通过参数不同实现重载；\nD 错误，private构造方法允许创建实例，但仅能在类内部通过new创建（如单例模式）。'),(44,'方法引用','以下哪个选项是正确的静态方法引用？','Math::random()','Math::random','new Math()::random','Math.random::','B','静态方法引用的格式为 类名::静态方法名，无需括号。\nA 错误，因为方法引用不需要括号；\nC 错误，Math 是工具类，构造器私有且无实例方法；\nD 错误，格式顺序颠倒。'),(45,'方法引用','已知对象 StringBuilder sb = new StringBuilder()，以下哪个选项是正确的实例方法引用？','StringBuilder::append','sb::append()','sb::append','append::sb','C','实例方法引用的格式为 对象实例::实例方法名，无需括号。\nA 错误，这是类名引用实例方法，需通过对象实例引用；\nB 错误，方法引用不需要括号；\nD 错误，格式顺序颠倒。'),(46,'方法引用','以下哪个方法引用可以等价于 Lambda 表达式 () -> new ArrayList<>()？','ArrayList::new','ArrayList::add','new ArrayList()::new','ArrayList::get','A','构造器引用的格式为 类名::new，用于创建对象实例。\nB 和 D 错误，引用的是普通方法而非构造器；\nC 错误，构造器引用无需先创建对象。'),(47,'方法','以下关于 Java 方法的定义，正确的是？','public void myMethod();','void myMethod() { return 1; }','public static int myMethod() { return 0; }','private myMethod() { System.out.println(\"Hello\"); }','C','A 错误：方法定义需包含方法体（即使为空），正确写法应为public void myMethod() {}。\nB 错误：void类型方法不能返回值（return 1会报错）。\nC 正确：public static为修饰符，int为返回类型，方法体return 0符合规范。\nD 错误：缺少返回类型，正确写法应为private void myMethod() {...}。'),(48,'面向对象','以下哪个关键字用于创建对象？','class','new','public','static','B','new关键字用于实例化对象，例如Person p = new Person();。\nclass用于定义类，public是访问修饰符，static用于修饰类成员（静态变量 / 方法）。'),(49,'面向对象进阶','关于抽象类与接口的区别，以下说法正确的是：','抽象类可以有构造方法，接口不能有构造方法','抽象类和接口都可以有非抽象方法（Java 8 后）','一个类只能继承一个抽象类，但可以实现多个接口','以上说法都正确','D','A：抽象类可以有构造方法（用于子类初始化），接口不能有构造方法。\nB：Java 8 后，接口可通过default和static定义非抽象方法；抽象类一直支持非抽象方法。\nC：Java 单继承限制（一个类只能继承一个直接父类），但可实现多个接口。'),(50,'字符串','以下关于 Java 字符串的说法，正确的是？','字符串是基本数据类型','字符串使用char[]存储内容','String类是不可变类（Immutable）','字符串拼接只能用+运算符','C','A 错误：字符串是引用数据类型，而非基本类型（基本类型包括int、char等）。\nB 错误：Java 9 及以后，字符串内部使用byte[]存储（节省内存），早期版本使用char[]。\nC 正确：String类的不可变性指其内容和长度不可修改，任何修改操作（如substring）都会生成新字符串。\nD 错误：字符串拼接还可以用StringBuilder或StringBuffer的append()方法，效率更高。'),(51,'集合','以下哪个选项正确创建了一个存储整数的 ArrayList？','ArrayList<int> list = new ArrayList<int>();','ArrayList<Integer> list = new ArrayList<Integer>();','ArrayList list = new ArrayList<int>();','ArrayList<int> list = new ArrayList();','B','在 Java 中，ArrayList 是泛型类，需要使用包装类（如Integer）而非基本数据类型（如int）指定元素类型，因此 A、D 错误。\nC 选项未指定泛型类型，会被视为ArrayList<Object>，但不符合 “存储整数” 的需求，因此 B 正确。'),(52,'集合进阶-单列集合','以下哪个接口是 Java 单列集合的顶层接口？','List','Set','Collection','Map','C','在 Java 集合框架中，Collection 是单列集合的顶层接口，定义了单列集合的通用操作（如添加、删除、遍历等）。\nList 和 Set 是 Collection 的子接口，分别表示有序可重复集合和无序不可重复集合。\nMap 是双列集合的顶层接口，存储键值对，不属于单列集合体系。'),(53,'集合进阶-双列集合','以下哪个接口是 Java 中双列集合的顶层接口？','List','Set','Map','Collection','C','双列集合用于存储键值对（Key-Value）数据，Map接口是双列集合的顶层接口，例如HashMap、TreeMap等实现类。\nList和Set属于单列集合（Collection接口的子接口），只能存储单个元素；Collection是单列集合的顶层接口。'),(54,'Stream流','以下哪个方法用于合并多个 Stream？','concat()','merge()','join()','union()','A','答案：concat()\nStream.concat(stream1, stream2)用于合并两个流，返回一个新流。\n其他选项（如merge、join、union）并非 Stream 的标准合并方法。'),(55,'异常','关于 Java 异常处理机制，以下说法正确的是：','try块后必须紧跟catch块，不能单独使用','finally块中的代码无论是否发生异常都会执行','一个try块只能对应一个catch块','throw关键字用于捕获异常','B','A 错误：try块后可以跟catch或finally，但不能单独存在（如try-finally结构合法）。\nB 正确：finally块用于释放资源，无论是否捕获异常都会执行（除非 JVM 提前终止）。\nC 错误：一个try块可以对应多个catch块，用于捕获不同类型的异常。\nD 错误：throw用于主动抛出异常，catch用于捕获异常。');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `user_password` varchar(45) COLLATE utf8mb3_unicode_ci NOT NULL,
  `user_nickname` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `user_job` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `user_create_time` datetime DEFAULT NULL,
  `user_update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('000','000','管理员1','管理员',NULL,NULL),('001','001','学生姓名1','学生',NULL,NULL),('111','111','学生姓名2','学生','2025-03-06 21:00:56','2025-05-31 20:58:07'),('123','123','学生姓名3','学生','2025-03-06 21:14:16','2025-04-14 21:49:50');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_questions_accuracy`
--

DROP TABLE IF EXISTS `users_questions_accuracy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_questions_accuracy` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `knowledge` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `accuracy` int DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_questions_accuracy`
--

LOCK TABLES `users_questions_accuracy` WRITE;
/*!40000 ALTER TABLE `users_questions_accuracy` DISABLE KEYS */;
INSERT INTO `users_questions_accuracy` VALUES (1,'111','运算符',50,'2025-05-15 14:28:50'),(2,'111','运算符',60,'2025-05-15 14:30:09'),(3,'111','运算符',80,'2025-05-15 14:30:26'),(4,'111','判断和循环',60,'2025-05-15 19:00:48'),(5,'111','数组',50,'2025-05-15 19:14:58'),(6,'111','数组',30,'2025-05-15 20:37:05'),(8,'111','运算符',33,'2025-05-15 21:04:04'),(9,'111','运算符',33,'2025-05-15 21:10:33'),(10,'111','运算符',100,'2025-05-15 21:16:33'),(11,'111','运算符',100,'2025-05-15 21:20:22'),(12,'111','运算符',67,'2025-05-15 21:20:29'),(13,'111','运算符',33,'2025-05-15 21:20:40'),(14,'111','运算符',67,'2025-05-15 21:20:55'),(15,'111','运算符',100,'2025-05-15 21:21:03'),(16,'111','判断和循环',100,'2025-05-15 21:21:56'),(17,'111','判断和循环',67,'2025-05-15 21:22:12'),(18,'111','数组',0,'2025-05-15 21:25:21'),(19,'111','数组',100,'2025-05-15 21:25:54'),(20,'111','数组',0,'2025-05-15 21:27:13'),(21,'111','数组',0,'2025-05-15 21:27:56'),(22,'111','数组',100,'2025-05-15 21:28:01'),(23,'111','运算符',33,'2025-05-15 21:28:08'),(24,'111','基础概念',67,'2025-05-15 21:42:58'),(25,'111','基础概念',33,'2025-05-15 21:58:49'),(26,'111','基础概念',33,'2025-05-15 21:58:59'),(27,'111','基础概念',33,'2025-05-15 22:00:28'),(28,'111','基础概念',33,'2025-05-15 22:01:24'),(29,'111','基础概念',33,'2025-05-15 22:01:41'),(30,'111','基础概念',33,'2025-05-15 22:02:37'),(31,'111','运算符',0,'2025-05-15 22:02:51'),(32,'111','运算符',0,'2025-05-15 22:03:25'),(33,'111','运算符',0,'2025-05-15 22:04:44'),(34,'111','基础概念',33,'2025-05-15 22:04:58'),(35,'111','运算符',0,'2025-05-15 22:06:30'),(36,'111','运算符',33,'2025-05-15 22:06:49'),(37,'111','基础概念',67,'2025-05-15 22:06:58'),(38,'111','基础概念',67,'2025-05-15 22:07:03'),(39,'111','基础概念',33,'2025-05-15 22:09:33'),(40,'111','基础概念',0,'2025-05-16 20:18:11'),(41,'111','基础概念',67,'2025-05-16 20:18:23'),(42,'111','数组',0,'2025-05-18 22:23:55'),(43,'111','数组',67,'2025-05-18 22:24:43'),(44,'111','判断和循环',100,'2025-05-18 22:25:39'),(45,'111','基础概念',33,'2025-05-18 22:34:32'),(46,'111','基础概念',33,'2025-05-18 22:35:44'),(47,'111','基础概念',33,'2025-05-18 22:36:01'),(48,'111','判断和循环',33,'2025-05-22 15:47:00'),(49,'111','数组',0,'2025-05-22 16:08:39'),(50,'111','数组',0,'2025-05-22 16:10:43'),(51,'111','数组',100,'2025-05-22 16:10:55'),(52,'111','数组',33,'2025-05-22 16:20:03'),(53,'111','运算符',0,'2025-05-22 16:20:50'),(54,'111','运算符',100,'2025-05-22 16:21:09'),(55,'111','数组',33,'2025-05-22 16:43:39'),(56,'111','数组',67,'2025-05-22 16:43:49'),(57,'111','方法',50,'2025-06-11 17:50:56'),(58,'111','方法',25,'2025-06-11 22:05:14'),(59,'111','方法',75,'2025-06-11 22:05:44'),(60,'111','方法',25,'2025-06-11 22:06:34'),(61,'111','方法',50,'2025-06-11 22:06:50'),(62,'111','基础概念',33,'2025-06-11 22:07:04'),(63,'111','基础概念',67,'2025-06-11 22:07:14'),(64,'111','基础概念',67,'2025-06-11 22:07:39'),(65,'111','基础概念',67,'2025-06-11 22:07:46'),(66,'111','基础概念',67,'2025-06-11 22:07:52'),(67,'111','基础概念',33,'2025-06-11 22:08:02');
/*!40000 ALTER TABLE `users_questions_accuracy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_record`
--

DROP TABLE IF EXISTS `users_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `video_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `video_knowledge` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `video_bv` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `video_p` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `video_cover` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_video` (`user_id`,`video_name`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_record`
--

LOCK TABLES `users_record` WRITE;
/*!40000 ALTER TABLE `users_record` DISABLE KEYS */;
INSERT INTO `users_record` VALUES (59,'111','判断和循环-06-switch的扩展知识点和练习','判断和循环','BV17F411T7Ao','44','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:54:09','2025-05-13 21:14:53'),(61,'111','Java基础概念-05-变量-使用方式和注意事项','基础概念','BV17F411T7Ao','20','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:19','2025-05-29 21:05:32'),(62,'111','数组-08-数组练习4-打乱数据','数组','BV17F411T7Ao','61','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:21','2025-05-11 19:56:21'),(63,'111','方法-08-方法练习-拷贝数组','方法','BV17F411T7Ao','70','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:24','2025-05-11 19:56:24'),(64,'111','Java基础概念-09-定义变量的三个练习','基础概念','BV17F411T7Ao','24','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:26','2025-05-29 21:05:13'),(65,'111','Java基础概念-01-02-注释和关键字','基础概念','BV17F411T7Ao','17','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:42','2025-06-11 21:45:25'),(66,'111','Java基础概念-11-键盘录入','基础概念','BV17F411T7Ao','26','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-11 19:56:44','2025-05-26 21:23:45'),(72,'111','数组-04-数组的动态初始化和常见问题','数组','BV17F411T7Ao','57','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:17:14','2025-05-13 22:45:25'),(80,'111','Java基础概念-03-字面量','基础概念','BV17F411T7Ao','18','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:45:25','2025-05-13 21:45:25'),(82,'111','Java基础概念-07-计算机中的数据存储','基础概念','BV17F411T7Ao','22','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:45:29','2025-05-13 21:45:29'),(83,'111','Java基础概念-10-标识符','基础概念','BV17F411T7Ao','25','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:45:30','2025-06-10 14:28:31'),(86,'111','数组-05-数组练习1-求最值','数组','BV17F411T7Ao','58','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:46:31','2025-05-13 21:48:36'),(88,'111','运算符-01-03-算术运算符详解和综合练习','运算符','BV17F411T7Ao','30','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:46:38','2025-05-31 21:36:39'),(89,'111','判断和循环-10-两道力扣算法题和do...while循环','判断和循环','BV17F411T7Ao','48','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:46:42','2025-05-13 21:46:42'),(92,'111','方法-04-带返回值方法的定义和调用','方法','BV17F411T7Ao','66','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:48:39','2025-05-13 21:48:39'),(93,'111','方法-06-方法的重载','方法','BV17F411T7Ao','68','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 21:48:43','2025-05-13 21:48:43'),(96,'111','方法-07-方法的三个练习：遍历求最大值和判断是否存在','方法','BV17F411T7Ao','69','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:19:15','2025-05-13 22:42:09'),(97,'111','字符串-10-StringBuilder的基本操作','字符串','BV17F411T7Ao','105','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:33:09','2025-05-13 22:33:09'),(99,'111','面向对象-06-标准的javabean类','面向对象','BV17F411T7Ao','86','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:36:26','2025-05-13 22:36:26'),(100,'111','判断和循环-01-流程控制语句-顺序结构','判断和循环','BV17F411T7Ao','39','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:36:46','2025-06-06 13:42:35'),(102,'111','运算符-12-多学一招原码反码补码','运算符','BV17F411T7Ao','38','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:37:58','2025-05-13 22:37:58'),(104,'111','方法-03-带参数的方法定义和调用','方法','BV17F411T7Ao','65','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:41:51','2025-05-13 22:41:51'),(105,'111','面向对象-09-this的内存原理','面向对象','BV17F411T7Ao','89','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:41:57','2025-05-13 22:41:57'),(107,'111','判断和循环-08-for循环练习-累加思想和统计思想','判断和循环','BV17F411T7Ao','46','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:42:24','2025-05-13 22:42:24'),(109,'111','字符串-15-后续练习思路分析','字符串','BV17F411T7Ao','110','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:46:21','2025-05-13 22:46:21'),(110,'111','集合进阶07-LinkedList和迭代器的源码分析','集合进阶-单列集合','BV17F411T7Ao','191','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:46:27','2025-05-13 22:46:27'),(111,'111','面向对象-08-基本数据类型和引用数据类型','面向对象','BV17F411T7Ao','88','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:50:13','2025-05-13 22:50:13'),(112,'111','判断和循环-05-switch语句和练习','判断和循环','BV17F411T7Ao','43','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-13 22:52:27','2025-05-13 22:52:27'),(113,'111','集合进阶-02-Map集合常用的API','集合进阶-双列集合','BV1yW4y1Y7Ms','3','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-05-14 20:11:48','2025-05-14 20:11:48'),(114,'111','集合进阶-22-综合练习2-带有概率的随机点名','集合进阶-双列集合','BV1yW4y1Y7Ms','23','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-05-14 20:17:40','2025-05-14 20:17:40'),(115,'111','集合进阶-01-双列集合的特点','集合进阶-双列集合','BV1yW4y1Y7Ms','2','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-05-14 20:39:48','2025-05-14 20:39:48'),(116,'111','异常-11-自定义异常','异常','BV1yW4y1Y7Ms','62','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-05-14 21:33:43','2025-05-14 21:33:43'),(118,'111','方法-01-什么是方法？','方法','BV17F411T7Ao','63','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-22 21:45:44','2025-05-22 21:45:44'),(122,'111','Java基础概念-04-变量-基本用法','基础概念','BV17F411T7Ao','19','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-05-29 21:05:30','2025-05-29 21:05:30'),(126,'111','判断和循环-02-if第一种格式和注意事项加练习','判断和循环','BV17F411T7Ao','40','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-06 13:43:50','2025-06-06 14:16:16'),(127,'111','判断和循环-03-if的第二种格式和练习','判断和循环','BV17F411T7Ao','41','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-06 13:43:51','2025-06-06 13:43:51'),(128,'111','判断和循环-04-if的第三种格式','判断和循环','BV17F411T7Ao','42','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-06 13:43:54','2025-06-06 13:43:54'),(133,'111','ArrayList-01-集合的基本使用','集合','BV17F411T7Ao','111','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-10 17:48:29','2025-06-12 21:51:07'),(134,'111','Stream流-02-Stream流的思想和获取Stream流','Stream流','BV1yW4y1Y7Ms','36','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-06-10 18:21:58','2025-06-10 18:21:58'),(135,'111','方法引用-05-引用构造方法','方法引用','BV1yW4y1Y7Ms','47','http://i0.hdslb.com/bfs/archive/0b4c1020d3afc73472726526644956b6bf067376.jpg','2025-06-10 18:27:32','2025-06-10 18:27:32'),(136,'111','ArrayList-02-集合练习-添加字符串和整数并遍历','集合','BV17F411T7Ao','112','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-10 19:17:12','2025-06-10 19:17:12'),(137,'111','ArrayList-03-集合练习-添加学生对象并遍历的两个练习','集合','BV17F411T7Ao','113','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-10 19:23:51','2025-06-10 19:23:51'),(138,'111','Java基础概念-08-数据类型','基础概念','BV17F411T7Ao','23','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-11 21:44:35','2025-06-11 21:44:35'),(140,'111','ArrayList-04-集合练习-查找用户是否存在','集合','BV17F411T7Ao','114','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-11 21:54:24','2025-06-11 21:54:24'),(145,'111','Java基础概念-06-变量练习-计算公交车的人数','基础概念','BV17F411T7Ao','21','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-06-12 22:01:39','2025-06-12 22:01:39'),(146,'123','ArrayList-01-集合的基本使用','集合','BV17F411T7Ao','111','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-11-12 20:49:55','2025-11-12 20:49:55'),(147,'001','ArrayList-01-集合的基本使用','集合','BV17F411T7Ao','111','http://i1.hdslb.com/bfs/archive/3ea248b484f595fcf33c7a96b7b9ad753c7b745d.jpg','2025-11-12 20:51:30','2025-11-12 20:51:30');
/*!40000 ALTER TABLE `users_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-24 15:49:47
