package org.vaadin.spring.tutorial

import com.vaadin.annotations.Theme
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewDisplay
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.spring.annotation.SpringViewDisplay
import com.vaadin.ui.Button
import com.vaadin.ui.Component
import com.vaadin.ui.CssLayout
import com.vaadin.ui.Panel
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.themes.ValoTheme

@Theme("valo")
@SpringUI
@SpringViewDisplay
class MyUI : UI(), ViewDisplay {
    private var springViewDisplay: Panel? = null
    override fun init(request: VaadinRequest) {
        val root = VerticalLayout()
        root.setSizeFull()
        content = root
        val navigationBar = CssLayout()
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP)
        navigationBar.addComponent(createNavigationButton("UI Scoped View",
                UIScopedView.VIEW_NAME))
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME))
        root.addComponent(navigationBar)
        springViewDisplay = Panel()
        springViewDisplay!!.setSizeFull()
        root.addComponent(springViewDisplay)
        root.setExpandRatio(springViewDisplay, 1.0f)
    }

    private fun createNavigationButton(caption: String,
                                       viewName: String): Button {
        val button = Button(caption)
        button.addStyleName(ValoTheme.BUTTON_SMALL)
        // If you didn't choose Java 8 when creating the project, convert this
// to an anonymous listener class
        button.addClickListener { event: Button.ClickEvent? -> ui.navigator.navigateTo(viewName) }
        return button
    }

    override fun showView(view: View) {
        springViewDisplay!!.content = view as Component
    }
}