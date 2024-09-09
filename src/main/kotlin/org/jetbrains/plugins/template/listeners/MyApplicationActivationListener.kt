package org.jetbrains.plugins.template.listeners

import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.IdeFrame

internal class MyApplicationActivationListener : ApplicationActivationListener {

    override fun applicationActivated(ideFrame: IdeFrame) {
        thisLogger().warn("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
        // Check if classes from module 'intellij.smart.update' are accessible.
        try {
            thisLogger().warn("Starting experiment")
            com.intellij.smartUpdate.VcsUpdateStep() // This class is from ${idea.home}/lib/modules/intellij.smart.update.jar.
            thisLogger().warn("VcsUpdateStep was accessed without issue")
        } catch (e: Throwable) {
            thisLogger().warn("Failed to access VcsUpdateStep")
            thisLogger().error(e)
        }
    }
}
