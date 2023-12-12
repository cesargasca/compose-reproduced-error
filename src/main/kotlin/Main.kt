import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.Dimension

// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

fun main() = application {

    Window(onCloseRequest = ::exitApplication, resizable = false, title = "reproducedError") {
        setMinSize()

    }

}

fun FrameWindowScope.setMinSize() {
    window.minimumSize = Dimension(500 , 500)
}