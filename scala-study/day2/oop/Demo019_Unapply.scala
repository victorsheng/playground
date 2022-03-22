package day2.oop

/**
 * 作者： 光环大数据   马中华   https://blog.csdn.net/zhongqi2513
 * 时间： 2018/7/16 8:15
 *
 * 描述： 测试unapply方法
 */
object Demo019_Unapply {
    
    // 接收参数，返回对象， 一般用作工厂
    def apply(value: Double, unit: String): Currency = new Currency(value, unit)
    
    // 接收对象，返回参数， 一般用于模式匹配
    def unapply(currency: Currency): Option[(Double, String)] = {
        if (currency == null) {
            None
        }
        else {
            Some(currency.value, currency.unit)
        }
    }
}

class Currency(val value: Double, val unit: String) {}