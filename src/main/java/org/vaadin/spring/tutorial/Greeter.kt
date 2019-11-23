package org.vaadin.spring.tutorial

import com.vaadin.spring.annotation.SpringComponent
import com.vaadin.spring.annotation.UIScope

@SpringComponent
@UIScope
class Greeter {
    fun sayHello(): String {
        return "Hello from bean " + toString()
    }
}