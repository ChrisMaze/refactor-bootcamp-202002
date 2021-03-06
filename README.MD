# 重构线上练功房热身编程题
本项目为ThoughWorks内部【敏捷工程实践系列】之「重构」线上练功房热身编程题，涵盖两个小题目，一道是重点是关于`TDD`，一道重点关于`重构`，两道题业务复杂度相对简单，预估花费 0.5 ~ 1小时完成。

目的：1. 热身；2. 摸底

## 开发环境
 - JDK1.8
 - JUnit 5
 - Gradle 5.2.1


## 热身题目

### 1. 斐波那契数求值

#### 业务需求
设计一个程序，用于计算前50位斐波那契数值。

```
When 位数为1, when 求值, Then 返回1
When 位数为2, when 求值, Then 返回1
When 位数为3, when 求值, Then 返回2
When 位数为4, when 求值, Then 返回3
...
```

> Sample: 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ..., 12586269025L(50)


#### 练功要求
1. 针对上述场景，测试先行的方式，完成需求，测试用例至少覆盖5种场景。
2. 测试命名采用遵循`given，when，then`的方式，比如：`should_return_3_when_calculate_given_position_is_4`
3. 每通过一个测试做一次Commit，Commit信息需要清晰表达意图
4. 将测试代码放置在`src/test`下的`cc.xpbootcamp.warmup.fibonacci` package中
5. 将产品代码放置在`src/main`下的`cc.xpbootcamp.warmup.fibonacci` package中


### 2. 超市收银机
#### 背景
老王经营了一家超市，之前找了一个Vendor开发了一款简化版的超市收银机。收银机的功能很简单：在顾客结账时，需要打印订单信息。之前的Vendor已经开发出了可以用的代码。


收银机一直都很难用，收银员经常跟老王抱怨。老王由于勤快，把超市做大了，寻思着找个好的Vendor把软件优化一下，并继续开发一些新功能。他听说TW在软件交付方面很擅长，擅长交付高质量的软件，于是找到了TW。

TW工程师接收后，却发现代码存在神一般的命名和谜一般的逻辑，所以为了更好地继续下去，不得已停下来对已有代码进行重构。

此时，你正好在该项目担当重构大任的骨干，接下来请你完成这一轮重构，让代码从`可用`到`简洁可用`。


#### 练功要求
1. 重构前运行测试，确保测试是通过的
2. 每修改一处代码，运行测试，确保测试是通过的，并做一次Commit，Commit信息描述你认为的代码坏味道和重构手法
3. 产品代码位于`src/main`下的`cc.xpbootcamp.warmup.cashier`package中
4. 测试代码位于`src/test`下的`cc.xpbootcamp.warmup.cashier`package中
5. 不要修改测试代码
6. 尽自己所能，尽可能多的找出坏味道，并重构掉

#### 新的需求：
老王收到顾客反馈，希望对订单的收据进行改良，因为原始收据太难以辨识了。
于是老王调研了大超市的收据单，希望将收据改为新的格式进行显示。
此外，为答谢顾客，每逢周三，所有商品98折销售。

> TASKING
>
> 1. given a order, when I print receipt, then receipt should have a head  like this
>
>    >  ===== 老王超市，值得信赖 ====== 
>
> 2. given a order with a date. when I print receipt, then receipt should print this date,like this
>
>    > 2020年2月17日，星期一
>
> 3. given a order with  line items. when I print receipt, then receipt should print the product details, like this
>
>    > 巧克力, 21.50 x 2, 43.00
>    >
>    > 小白菜, 10.00 x 1, 10.00
>
> 4. given a order with line items and date. when I print receipt, then receipt should print the sales tax and total amount, like this
>
>    > 税额:   5.30
>    >
>    > 总价:   58.30
>
> 5. given a order with line items and date on wednesday. when I print receipt, then receipt should print discount, like this
>
>    > 折扣：1.17








## 补充
每个小伙伴将该项目fork自己的GitHub账号下

