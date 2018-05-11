package com.robin.firstkotlinproject.ui.util

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.view.View

/**
 * Created by Robin Yang on 11/20/17.
 */

/**
 * inline解释:
 *
 * 调用一个方法是一个压栈和出栈的过程，调用方法时将栈针压入方法栈，然后执行方法体，方法结束时将栈针出栈，这个压栈和出栈的过程会耗费资源，这个过程中传递形参也会耗费资源
 * 写成函数有一个潜在的缺点：调用函数比求解等价表达式要慢得多。在大多数的机器上，调用函数都要做很多工作：调用前要先保存寄存器，并在返回时恢复，复制实参，程序还必须转向一个新位置执行
 * C++中支持内联函数，其目的是为了提高函数的执行效率，用关键字 inline 放在函数定义(注意是定义而非声明，下文继续讲到)的前面即可将函数指定为内联函数
 *
 *
 * reified解释:
 *
 * fun <T> myGenericFun(c: Class<T>)
 *
 * In the body of a generic function like myGenericFun, you can't access the type T because it's only available at compile time but erased at runtime.
 * Therefore, if you want to use the generic type as a normal class in the function body you need to explicitly pass the class as a parameter as shown in myGenericFun.
 * If you create an inline function with a reified T though, the type of T can be accessed even at runtime and thus you do not need to pass the Class<T> additionally.
 * You can work with T as if it was a normal class, e.g. you might want to check whether a variable is an instance of T, which you can easily do then: myVar is T.
 *
 * Such an inline function with reified type T looks as follows:
 * inline fun <reified T> myGenericFun()
 */
inline fun <reified T : Activity> Activity.navigate(id: String,
                                                    sharedView: View? = null,
                                                    transitionName: String? = null) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("id", id)

    var options: ActivityOptionsCompat? = null

    if (sharedView != null && transitionName != null) {
        options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, transitionName)
    }

    ActivityCompat.startActivity(this, intent, options?.toBundle())
}

fun Activity.getNavigationId(): String {
    val intent = intent
    return intent.getStringExtra("id")
}