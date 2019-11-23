package org.vaadin.spring.tutorial

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.spring.annotation.UIScope
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import org.springframework.beans.factory.annotation.Autowired
import javax.annotation.PostConstruct

// Pay attention to the order of annotations
@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
class UIScopedView : VerticalLayout(), View {
    @Autowired
    private val greeter: Greeter? = null

    @PostConstruct
    fun init() {
        addComponent(Label("This is a UI scoped view. Greeter says: "
                + greeter!!.sayHello()))
    }

    override fun enter(event: ViewChangeEvent) { // This view is constructed in the init() method()
    }

    companion object {
        const val VIEW_NAME = "ui"
    }
}