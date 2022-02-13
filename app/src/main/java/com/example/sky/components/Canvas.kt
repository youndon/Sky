package com.example.sky.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion.DefaultBlendMode

private interface Canvas {
    @Composable fun canv() {
        Canvas (modifier = Modifier){
            this.center
            this.drawContext
            this.layoutDirection
            this.size
            this.drawArc(
                color = Color.Gray,
                startAngle = 1f,
                sweepAngle = 1f,
                useCenter = true,
                topLeft = Offset.Zero,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix()),
                blendMode = DefaultBlendMode
            )
            this.drawCircle(
                color = Color.Gray,
                radius = size.minDimension / 2.0f,
                center = this.center,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix()),
                blendMode = DefaultBlendMode
            )
            this.drawImage(
                image = ImageBitmap(0,0),
                topLeft = Offset.Zero,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.colorMatrix(ColorMatrix()),
                blendMode = DefaultBlendMode
            )
            this.drawLine(
                color = Color.Gray,
                start = Offset(1f,1f),
                end = Offset(1f,1f),
                strokeWidth = Stroke.HairlineWidth,
                cap = Stroke.DefaultCap,
                pathEffect = PathEffect.cornerPathEffect(1f),
                // cornerPathEffect(), dashPathEffect(), chainPathEffect(), stampedPathEffect()
                alpha = 1.0f,
                colorFilter = ColorFilter.lighting(Color.Black, Color.Green),
                blendMode = DefaultBlendMode
            )
            this.drawOval(
                color = Color.Gray,
                topLeft = Offset.Zero,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.drawPath(
                path = Path(),
                color = Color.Gray,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.drawPoints(
                points = listOf(),
                pointMode = PointMode.Lines,
                // Lines, Points, Polygon
                color = Color.Gray,
                strokeWidth = Stroke.HairlineWidth,
                cap = StrokeCap.Butt,
                pathEffect = PathEffect.cornerPathEffect(1f),
                alpha = 1.0f,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.drawRect(
                color = Color.Gray,
                topLeft = Offset.Zero,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.drawRoundRect(
                color = Color.Gray,
                topLeft = Offset.Zero,
                cornerRadius = CornerRadius.Zero,
                style = Fill,
                alpha = 1.0f,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.drawOutline(
                outline = Outline.Rectangle(Rect.Zero),
                color = Color.Gray,
                alpha = 1.0f,
                style = Fill,
                colorFilter = ColorFilter.tint(Color.Black),
                blendMode = DefaultBlendMode
            )
            this.clipPath(
                path = Path(),
                clipOp = ClipOp.Intersect,
            ) {
            }
            this.clipRect(
                left = 0.0f,
                top = 0.0f,
                right = size.width,
                bottom = size.height,
                clipOp = ClipOp.Intersect
            ) {
            }
            this.drawIntoCanvas {
            }
            this.inset {
            }
            this.rotate(
                degrees = 1f,
                pivot = center,
            ) {
            }
            this.rotateRad(
                radians = 1f,
                pivot = center,
            ) {
            }
            this.scale(
                scale = 1f,
                pivot = center,
            ) {
            }
            this.translate {  }
            this.withTransform({
            }){
            }
        }
    }
}