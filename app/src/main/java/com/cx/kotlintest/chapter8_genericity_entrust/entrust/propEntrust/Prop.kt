package com.cx.kotlintest.chapter8_genericity_entrust.entrust.propEntrust

import com.cx.kotlintest.chapter8_genericity_entrust.entrust.propEntrust.Entrust
import kotlin.reflect.KProperty

/**
 * 属性委托的具体实现类
 * 作者：一种标准的代码实现模板
 * */
class Prop {
    var propValue: Any? = null

    /**
     * 参数1：限定Prop类的委托功能可以在什么类中使用
     * 参数2：一个属性操作类，暂时用不着，但必须声明, <*>表示不知道、不关心泛型的具体类型，只为了编译通过；类似于java <?>
     * 返回值：可以改为任何类型
     * */
    operator fun getValue(myClass: Entrust, prop: KProperty<*>): Any? {
        return propValue
    }

    /**
     * 参数3的类型必须和getValue的返回值类型保持一致
     * */
    operator fun setValue(myClass: Entrust, prop: KProperty<*>, value: Any?) {
        propValue = value
    }
}