package org.vaadin.spring.tutorial

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import javax.annotation.PostConstruct

@SpringView(name = DefaultView.VIEW_NAME)
class DefaultView : VerticalLayout(), View {
    @PostConstruct
    fun init() {
        addComponent(Label("This is the default view"))
    }

    override fun enter(event: ViewChangeEvent) { // This view is constructed in the init() method()
    }

    companion object {
        const val VIEW_NAME = ""
    }
}