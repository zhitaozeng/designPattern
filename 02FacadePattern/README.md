# **外观模式**

1.前言

外观模式在生活中比比皆是，比如组装电脑，一般就会有两种方案。

①客户自己去电子市场，将需要的配件都买回来，然后自己组装。这种需要客户对每个配件的功能都十分熟悉，还要懂得如何将各个配件组装成电脑。

②另一个方案，也是比较常用的一种方案，就是客户去电子市场，找一个专业的装机公司，把自己的要求提出来，然后由装机公司来负责组装电脑。这样价格虽然比自己组装要贵一点，但是不需要对组装电脑有很深入的了解。


2.问题描述

将上面的过程抽象一下，将电子市场看成是一个系统，而各个卖配件的公司就看出是一个个模块，于是就出现了这样一种情况：客户端为了完成某个功能，需要去调用到某个系统的多个模块，把它们称为A模块，B模块和C模块。对于客户端而言，不仅要知道A,B,C三个模块各自的功能，还要知道如何组合这三个模块，从而实现自己想要的功能，十分复杂。

3.模式定义

外观模式：为子系统的一组接口提供一个一致的界面。Facade模式定义了一个高层的接口，这个接口使得这以子系统更加容易使用。

4.示例程序

本实例程序为一个提供代码生成功能的子系统，在使用外观模式和不使用外观模式的调用区别
