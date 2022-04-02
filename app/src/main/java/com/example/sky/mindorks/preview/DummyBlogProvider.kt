package com.mindorks.example.jetpack.compose.preview

import androidx.ui.tooling.preview.PreviewParameterProvider
import com.example.sky.mindorks.data.Blog

class DummyBlogProvider : PreviewParameterProvider<Blog> {
    override val values =
        sequenceOf(Blog("Learning Compose", "MindOrks"), Blog("Learning Android", "MindOrks"))
    override val count: Int = values.count()
}