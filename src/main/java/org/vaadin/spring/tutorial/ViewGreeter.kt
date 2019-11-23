package org.vaadin.spring.tutorial

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.ViewScope

@SpringComponent
@ViewScope
class ViewGreeter {
    fun sayHello(): String {
        return "Hello from a view scoped bean " + toString()
    }
}