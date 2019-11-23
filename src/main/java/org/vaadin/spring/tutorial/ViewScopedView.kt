package org.vaadin.spring.tutorial

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.spring.annotation.SpringView
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout
import org.springframework.beans.factory.annotation.Autowired
import org.vaadin.spring.tutorial.ViewScopedView
import javax.annotation.PostConstruct

@SpringView(name = ViewScopedView.VIEW_NAME)
class ViewScopedView : VerticalLayout(), View {
    // A new instance will be created for every view instance created
    @Autowired
    private val viewGreeter: ViewGreeter? = null
    // The same instance will be used by all views of the UI
    @Autowired
    private val uiGreeter: Greeter? = null

    @PostConstruct
    fun init() {
        addComponent(Label("This is a view scoped view"))
        addComponent(Label(uiGreeter!!.sayHello()))
        addComponent(Label(viewGreeter!!.sayHello()))
    }

    override fun enter(event: ViewChangeEvent) { // This view is constructed in the init() method()
    }

    companion object {
        const val VIEW_NAME = "view"
    }
}